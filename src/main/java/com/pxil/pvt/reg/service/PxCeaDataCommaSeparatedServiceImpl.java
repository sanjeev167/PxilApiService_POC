/**
 * 
 */
package com.pxil.pvt.reg.service;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pxil.api.utils.CeaReportEnum;

import java.time.DateTimeException;
import com.pxil.pvt.entities.PxCeaAcpCommaSeparated;
import com.pxil.pvt.entities.PxCeaDataCommaSeparated;
import com.pxil.pvt.reg.jpojo.AcpDam;
import com.pxil.pvt.reg.jpojo.AcpGdam;
import com.pxil.pvt.reg.jpojo.AcpHpdam;
import com.pxil.pvt.reg.jpojo.AcpRtm;
import com.pxil.pvt.reg.jpojo.ApiJsonInput;
import com.pxil.pvt.reg.jpojo.Pxil;
import com.pxil.pvt.reg.repo.PxCeaAcpDataRepository;
import com.pxil.pvt.reg.repo.PxCeaDataCommaSeparatedRepository;

/**
 * @author sanjeevkumar 
 * 05-Dec-2023 
 * 5:29:39 pm 
 * Objective :
 */

@Service
public class PxCeaDataCommaSeparatedServiceImpl extends PxCeaDataCommaSeparatedService {

	@Autowired
	PxCeaDataCommaSeparatedRepository pxCeaDataCommaSeparatedRepository;

	@Autowired
	PxCeaAcpDataRepository pxCeaAcpDataRepository;	
	
	@Value(value = "${pxil.api.validation.maxAllowedHistoryMonth}")
	private int maxAllowedHistoryMonth;
	
	@Override
	public ApiJsonInput getMonthHistory(Integer histMonthNo) {
		List<PxCeaAcpCommaSeparated> pxCeaAcpDataList = null;// Will be used for collecting ACP historical data
		List<PxCeaDataCommaSeparated> pxCeaDataCommaSeparatedList = null;
				
		ApiJsonInput apiJsonInputB4CeaCollection = null;
		ApiJsonInput apiJsonInputB4ApcCollection = null;
		ApiJsonInput finalApiJsonInputWithCeaAndApc = null;
		
		try {
		LocalDateTime localCurrentDate = LocalDateTime.now();
		LocalDateTime newLocalDate = LocalDateTime.now().withMonth(histMonthNo);//Initialized with actual history-month
		
		if(newLocalDate.isAfter(localCurrentDate)) {
			//Back localCurrentDate object by one year			
			localCurrentDate = localCurrentDate.minusYears(1);
		}else {
			//Do nothing
			;
		} 
		LocalDateTime localCurrentDateTime = localCurrentDate.withMonth(histMonthNo);//Initialized with month		
		YearMonth fromDateYearMonth = YearMonth.of(localCurrentDateTime.getYear(), localCurrentDateTime.getMonth());
		LocalDate localFromDate = fromDateYearMonth.atDay(1);
	
		YearMonth toDateYearMonth = YearMonth.of(localCurrentDateTime.getYear(), localCurrentDateTime.getMonth());
		LocalDate localToDate = toDateYearMonth.atEndOfMonth();		
		
		int noOfDaysInHistory = (int) ChronoUnit.DAYS.between(localFromDate, localToDate)+1;
		
		Date fromDate = getJavaDateFromLocalDate(localFromDate);
		Date toDate = getJavaDateFromLocalDate(localToDate);

		
			if (fromDate != null && toDate != null) {//None of the two dates should be null
				// Now, prepare CEA report data for ApiJsonInput
				pxCeaDataCommaSeparatedList = pxCeaDataCommaSeparatedRepository.getAllCeaDataBetweenDates(fromDate,toDate);				
				//pxCeaDataCommaSeparatedList = pxCeaDataCommaSeparatedRepository.findByDateBetween(fromDate, toDate);
				
				pxCeaAcpDataList = pxCeaAcpDataRepository.getAllPxCeaAcpCommaSeparatedDataBetweenDates(fromDate,toDate);				
				//pxCeaAcpDataList = pxCeaAcpDataRepository.findByDateBetween(fromDate, toDate);	
				
				if(!pxCeaDataCommaSeparatedList.isEmpty() || !pxCeaAcpDataList.isEmpty()) {//Both lists shouldn't be empty
				apiJsonInputB4CeaCollection = new ApiJsonInput();//This container will be used for preparing a final output json. 
				Pxil pxil = new Pxil();// This is the actual output container which hold successful output against a history-month. 
				pxil.setNoDays(noOfDaysInHistory);//Here, we are setting the no of days for which the historical data has been prepared..
				apiJsonInputB4CeaCollection.setPxil(pxil);//Now, basic thing has been stuffed into pxil object and it is set into final
				                                          //output json container, rest will be set while the calculation progresses.
				
				apiJsonInputB4ApcCollection=organizeCeaDataReportWise(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedList);
				// Now, prepare APS report data for ApiJsonInput
					finalApiJsonInputWithCeaAndApc = organizeAcpDataReportWise(localFromDate, localToDate, apiJsonInputB4ApcCollection, pxCeaAcpDataList);
				 }
			}
			//Now, before sending this pojo for Json generation, we will update the missing-day record with a dummy record with default values.
            //checkAndUpdateMissingDayRecords(localFromDate,localToDate, apiJsonInputWithCeaAndApc);
		} catch (DateTimeException ex) {			
			throw ex;
		}		
		catch (Exception ex) {
			System.out.println("Exception Name => "+ex.getClass());
			ex.printStackTrace();
			throw ex;
			
		}
		return finalApiJsonInputWithCeaAndApc;

	}// End of getMonthHistory

	
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */
   private ApiJsonInput organizeCeaDataReportWise(ApiJsonInput apiJsonInputB4CeaCollection,List<PxCeaDataCommaSeparated> pxCeaDataCommaSeparatedList) {

		String reportName = null;CeaReportEnum ceaReportEnum = null;	
		
		for (PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity : pxCeaDataCommaSeparatedList) {
			
			reportName = pxCeaDataCommaSeparatedEntity.getReportName();//Coming in the entity			
			if(reportName.equals("TAM_Daily")||   //TAM_Daily,//7 TAM_Weekly,//8 TAM_Monthly,//9 TAM_ADSS,//10
			   reportName.equals("TAM_Weekly")||
			   reportName.equals("TAM_Monthly")||
			   reportName.equals("TAM_ADSS")||
			   reportName.equals("GTAM_Solar_Daily")||   //GTAM_Solar_Daily,//11,GTAM_Solar_Weekly,//12,GTAM_Solar_Monthly,//13 GTAM_Solar_ADSS,//14
			   reportName.equals("GTAM_Solar_Weekly")||
			   reportName.equals("GTAM_Solar_Monthly")||
			   reportName.equals("GTAM_Solar_ADSS")||
			   reportName.equals("GTAM_Non_Solar_Daily")||//GTAM_Non_Solar_Daily,//15 GTAM_Non_Solar_Weekly,//16 GTAM_Non_Solar_Monthly,//17, GTAM_Non_Solar_ADSS
			   reportName.equals("GTAM_Non_Solar_Weekly")||
			   reportName.equals("GTAM_Non_Solar_Monthly")||
			   reportName.equals("GTAM_Non_Solar_ADSS")||
			   reportName.equals("GTAM_Hydro_Daily")||//GTAM_Hydro_Daily,//19 GTAM_Hydro_Weekly,//20 GTAM_Hydro_Monthly,//21 GTAM_Hydro_ADSS
			   reportName.equals("GTAM_Hydro_Weekly")||
			   reportName.equals("GTAM_Hydro_Monthly")||
			   reportName.equals("GTAM_Hydro_ADSS")||
			   reportName.equals("DAC")||
			   reportName.equals("INTRADAY"))
			  //Do nothing
				reportName=null;
			else {
				ceaReportEnum = CeaReportEnum.valueOf(reportName);//Taking out corresponding enum value
			}
			if(reportName!=null)
			switch (ceaReportEnum) {
			
			case DAM: // Case-1 => Checked and pass
				prepare_Dam_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;
				
			case RTM: // Case-2 => Checked and pass
				prepare_Rtm_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;
				
			case GDAM: // Case-3 => Checked and pass
				prepare_Gdam_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;
				
			case HPDAM: // Case-4 => Checked and pass
				prepare_Hpdam_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;		
				
		//-- INTRADAY has been split into 4	
				
			case Intraday_Conventional:// Case-5 => Not Checked
				prepare_Intraday_Conventional_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;	
				
			case Intraday_Solar:// Case-6 => Not Checked
				prepare_Intraday_Solar_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;		
				
			case Intraday_Non_Solar:// Case-7 => Not Checked
				prepare_Intraday_Non_Solar_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;			
				
			case Intraday_Hydro:// Case-8 => Not Checked
				prepare_Intraday_Hydro_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;	
				
		//-- DAC has been split into 4						
			case DAC_Conventional: // Case-9 => Not Checked
				prepare_DAC_Conventional_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;
				
			case DAC_Solar: // Case-10 => Not Checked
				prepare_DAC_Solar_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;
				
			case DAC_Non_Solar: // Case-11 => Not Checked
				prepare_DAC_Non_Solar_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;
				
			case DAC_Hydro: // Case-12 => Not Checked
				prepare_DAC_Hydro_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;
				
			//--Grouped into one				
			case TAM:// Case-13 => Not Checked
				prepare_TAM_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;		
				
			//--Grouped into one				
			case GTAM_Solar: // Case-14 => Not Checked
				prepare_GTAM_Solar_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;	
				
		   //--Grouped into one 
						
			case GTAM_Non_Solar: // Case-15 => Not Checked
				prepare_GTAM_Non_Solar_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;	
				
		   //--Grouped into one	
				
			case GTAM_Hydro: // Case-16 => Not Checked
				prepare_GTAM_Hydro_CeaData(apiJsonInputB4CeaCollection, pxCeaDataCommaSeparatedEntity);
				break;	
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + reportName);
			}
		} // End of for loop
				
		return apiJsonInputB4CeaCollection;
		
	}// End of organizeCommaSeparatedCeaDataReportWise

	/**
	 * @author sanjeevkumar 
	 * 12-Dec-2023 
	 * 2:41:39 pm 
	 * Objective :
	 * @param ceaDataEntityList
	 * @return
	 */
	private ApiJsonInput organizeAcpDataReportWise(LocalDate fromDate, LocalDate toDate, ApiJsonInput apiJsonInputB4ApcCollection, 
			                                       List<PxCeaAcpCommaSeparated> pxCeaAcpCommaSeparatedList) {

		ArrayList<PxCeaAcpCommaSeparated> acpDamRecordList = new ArrayList<PxCeaAcpCommaSeparated>();
		ArrayList<PxCeaAcpCommaSeparated> acpGdamRecordList = new ArrayList<PxCeaAcpCommaSeparated>();
		ArrayList<PxCeaAcpCommaSeparated> acpHpdamRecordList = new ArrayList<PxCeaAcpCommaSeparated>();
		ArrayList<PxCeaAcpCommaSeparated> acpRtmRecordList = new ArrayList<PxCeaAcpCommaSeparated>();
		
        //Start filtering Report_name wise
		for (PxCeaAcpCommaSeparated pxCeaAcpCommaSeparated : pxCeaAcpCommaSeparatedList) {
			if (pxCeaAcpCommaSeparated.getReportName().equals("ACP_DAM")) {
				acpDamRecordList.add(pxCeaAcpCommaSeparated);
			} else if (pxCeaAcpCommaSeparated.getReportName().equals("ACP_GDAM")) {
				acpGdamRecordList.add(pxCeaAcpCommaSeparated);
			} else if (pxCeaAcpCommaSeparated.getReportName().equals("ACP_HPDAM")) {
				acpHpdamRecordList.add(pxCeaAcpCommaSeparated);
			} else if (pxCeaAcpCommaSeparated.getReportName().equals("ACP_RTM")) {			
				acpRtmRecordList.add(pxCeaAcpCommaSeparated);
			}
		} // End of loop
	
		 //Start collecting region-wise data for each Report-Name and stuff them into final output json output container
		setRegionWiseCollectedList_ForAcpDam(prpareRegionWiseMcpCollection(fromDate, toDate, acpDamRecordList),apiJsonInputB4ApcCollection);
		
		setRegionWiseCollectedList_ForAcpGdam(prpareRegionWiseMcpCollection(fromDate, toDate, acpGdamRecordList), apiJsonInputB4ApcCollection);
		
		setRegionWiseCollectedList_ForAcpHpdam(prpareRegionWiseMcpCollection(fromDate, toDate, acpHpdamRecordList), apiJsonInputB4ApcCollection);
	
		setRegionWiseCollectedList_ForAcpRtm(prpareRegionWiseMcpCollection(fromDate, toDate, acpRtmRecordList),apiJsonInputB4ApcCollection);
      
		return apiJsonInputB4ApcCollection;
		
	}// End of organizeCeaDataReportWise
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	@SuppressWarnings("unchecked")
	private void setRegionWiseCollectedList_ForAcpRtm(List<Map<String, Object>> dateWiseRegionMcpCollection,ApiJsonInput apiJsonInput) {
		
		AcpRtm acpRtm = null;		
		
		for (Map<String, Object> dateWiseRegionMcp : dateWiseRegionMcpCollection) {
			if (dateWiseRegionMcp.get("date") != null) {
				acpRtm = new AcpRtm();	
				//System.out.println("Final collection of AcpRtm date-wise => "+(String)dateWiseRegionMcp.get("date"));
				acpRtm.setDate((String)dateWiseRegionMcp.get("date"));
				acpRtm.setA1((List<Double>) dateWiseRegionMcp.get("A1"));
				acpRtm.setA2((List<Double>) dateWiseRegionMcp.get("A2"));
				acpRtm.setE1((List<Double>) dateWiseRegionMcp.get("E1"));
				acpRtm.setE2((List<Double>) dateWiseRegionMcp.get("E2"));
				acpRtm.setN1((List<Double>) dateWiseRegionMcp.get("N1"));
				acpRtm.setN2((List<Double>) dateWiseRegionMcp.get("N2"));
				acpRtm.setN3((List<Double>) dateWiseRegionMcp.get("N3"));
				acpRtm.setS1((List<Double>) dateWiseRegionMcp.get("S1"));
				acpRtm.setS2((List<Double>) dateWiseRegionMcp.get("S2"));
				acpRtm.setS3((List<Double>) dateWiseRegionMcp.get("S3"));
				acpRtm.setW1((List<Double>) dateWiseRegionMcp.get("W1"));
				acpRtm.setW2((List<Double>) dateWiseRegionMcp.get("W2"));
				acpRtm.setW3((List<Double>) dateWiseRegionMcp.get("W3"));	
				//Include NR.SR,WR separately as they have been included while handling composite area
				acpRtm.setNR((List<Double>) dateWiseRegionMcp.get("NR"));
				acpRtm.setSR((List<Double>) dateWiseRegionMcp.get("SR"));
				acpRtm.setWR((List<Double>) dateWiseRegionMcp.get("WR"));
				apiJsonInput.getPxil().getAcpRtm().add(acpRtm);
			}
		}
		
	}
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	@SuppressWarnings("unchecked")
	private void setRegionWiseCollectedList_ForAcpHpdam(List<Map<String, Object>> dateWiseRegionMcpCollection,ApiJsonInput apiJsonInput) {
		AcpHpdam acpHpdam = null;
		for (Map<String, Object> dateWiseRegionMcp : dateWiseRegionMcpCollection) {			
			if (dateWiseRegionMcp.get("date") != null) {
				acpHpdam = new AcpHpdam();
				acpHpdam.setDate((String)dateWiseRegionMcp.get("date"));
				acpHpdam.setA1((List<Double>) dateWiseRegionMcp.get("A1"));
				acpHpdam.setA2((List<Double>) dateWiseRegionMcp.get("A2"));
				acpHpdam.setE1((List<Double>) dateWiseRegionMcp.get("E1"));
				acpHpdam.setE2((List<Double>) dateWiseRegionMcp.get("E2"));
				acpHpdam.setN1((List<Double>) dateWiseRegionMcp.get("N1"));
				acpHpdam.setN2((List<Double>) dateWiseRegionMcp.get("N2"));
				acpHpdam.setN3((List<Double>) dateWiseRegionMcp.get("N3"));
				acpHpdam.setS1((List<Double>) dateWiseRegionMcp.get("S1"));
				acpHpdam.setS2((List<Double>) dateWiseRegionMcp.get("S2"));
				acpHpdam.setS3((List<Double>) dateWiseRegionMcp.get("S3"));
				acpHpdam.setW1((List<Double>) dateWiseRegionMcp.get("W1"));
				acpHpdam.setW2((List<Double>) dateWiseRegionMcp.get("W2"));
				acpHpdam.setW3((List<Double>) dateWiseRegionMcp.get("W3"));
				//Include NR.SR,WR separately as they have been included while handling composite area			
				acpHpdam.setNR((List<Double>) dateWiseRegionMcp.get("NR"));
				acpHpdam.setSR((List<Double>) dateWiseRegionMcp.get("SR"));
				acpHpdam.setWR((List<Double>) dateWiseRegionMcp.get("WR"));
				apiJsonInput.getPxil().getAcpHpdam().add(acpHpdam);
			}
		}
	}
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	@SuppressWarnings("unchecked")
	private void setRegionWiseCollectedList_ForAcpGdam(List<Map<String, Object>> dateWiseRegionMcpCollection,ApiJsonInput apiJsonInput) {
		AcpGdam acpGdam = null;
		for (Map<String, Object> dateWiseRegionMcp : dateWiseRegionMcpCollection) {
			if (dateWiseRegionMcp.get("date") != null) {
				acpGdam=new AcpGdam();
				acpGdam.setDate((String)dateWiseRegionMcp.get("date"));
				acpGdam.setA1((List<Double>) dateWiseRegionMcp.get("A1"));
				acpGdam.setA2((List<Double>) dateWiseRegionMcp.get("A2"));
				acpGdam.setE1((List<Double>) dateWiseRegionMcp.get("E1"));
				acpGdam.setE2((List<Double>) dateWiseRegionMcp.get("E2"));
				acpGdam.setN1((List<Double>) dateWiseRegionMcp.get("N1"));
				acpGdam.setN2((List<Double>) dateWiseRegionMcp.get("N2"));
				acpGdam.setN3((List<Double>) dateWiseRegionMcp.get("N3"));
				acpGdam.setS1((List<Double>) dateWiseRegionMcp.get("S1"));
				acpGdam.setS2((List<Double>) dateWiseRegionMcp.get("S2"));
				acpGdam.setS3((List<Double>) dateWiseRegionMcp.get("S3"));
				acpGdam.setW1((List<Double>) dateWiseRegionMcp.get("W1"));
				acpGdam.setW2((List<Double>) dateWiseRegionMcp.get("W2"));
				acpGdam.setW3((List<Double>) dateWiseRegionMcp.get("W3"));
				//Include NR.SR,WR separately as they have been included while handling composite area
				acpGdam.setNR((List<Double>) dateWiseRegionMcp.get("NR"));
				acpGdam.setSR((List<Double>) dateWiseRegionMcp.get("SR"));
				acpGdam.setWR((List<Double>) dateWiseRegionMcp.get("WR"));
				apiJsonInput.getPxil().getAcpGdam().add(acpGdam);
			}
		}
	}
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	@SuppressWarnings("unchecked")
	private void setRegionWiseCollectedList_ForAcpDam(List<Map<String, Object>> dateWiseRegionMcpCollection,ApiJsonInput apiJsonInput) {
		AcpDam acpDam = null;		
		for (Map<String, Object> dateWiseRegionMcp : dateWiseRegionMcpCollection) {
			if (dateWiseRegionMcp.get("date") != null) {
				acpDam=new AcpDam();
				acpDam.setDate((String)dateWiseRegionMcp.get("date"));
				acpDam.setA1((List<Double>) dateWiseRegionMcp.get("A1"));
				acpDam.setA2((List<Double>) dateWiseRegionMcp.get("A2"));
				acpDam.setE1((List<Double>) dateWiseRegionMcp.get("E1"));
				acpDam.setE2((List<Double>) dateWiseRegionMcp.get("E2"));
				acpDam.setN1((List<Double>) dateWiseRegionMcp.get("N1"));
				acpDam.setN2((List<Double>) dateWiseRegionMcp.get("N2"));
				acpDam.setN3((List<Double>) dateWiseRegionMcp.get("N3"));
				acpDam.setS1((List<Double>) dateWiseRegionMcp.get("S1"));
				acpDam.setS2((List<Double>) dateWiseRegionMcp.get("S2"));
				acpDam.setS3((List<Double>) dateWiseRegionMcp.get("S3"));
				acpDam.setW1((List<Double>) dateWiseRegionMcp.get("W1"));
				acpDam.setW2((List<Double>) dateWiseRegionMcp.get("W2"));
				acpDam.setW3((List<Double>) dateWiseRegionMcp.get("W3"));	
				//Include NR.SR,WR separately as they have been included while handling composite area
				acpDam.setNR((List<Double>) dateWiseRegionMcp.get("NR"));
				acpDam.setSR((List<Double>) dateWiseRegionMcp.get("SR"));
				acpDam.setWR((List<Double>) dateWiseRegionMcp.get("WR"));
				apiJsonInput.getPxil().getAcpDam().add(acpDam);
			}
		}
	}
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	private List<Map<String, Object>> prpareRegionWiseMcpCollection(LocalDate fromDate, LocalDate toDate,ArrayList<PxCeaAcpCommaSeparated> pxCeaAcpCommaSeparatedList) {

		Map<String, Object> regionWiseMcpMap = null;
		String dateComingInEntity = null;
		String dateAvailableInLoop = null;	
		
		List<Map<String, Object>> dateWiseRegionMcpCollection = new ArrayList<Map<String, Object>>();
		
		for (LocalDate date = fromDate; date.isBefore(toDate) || date.equals(toDate); date = date.plusDays(1)) {
			dateAvailableInLoop=getStrDateFromLocalDate(date,dateFormatUsed);
			regionWiseMcpMap = new HashMap<String, Object>();					    
			for (PxCeaAcpCommaSeparated pxCeaAcpCommaSeparated : pxCeaAcpCommaSeparatedList) {	
				regionWiseMcpMap.put("date", dateAvailableInLoop);
				dateComingInEntity=getStrDateFromJavaDate(pxCeaAcpCommaSeparated.getDate(),dateFormatUsed);					
				if (dateComingInEntity.equals(dateAvailableInLoop)) {				
					if (pxCeaAcpCommaSeparated.getRegionCode().equals("AR")) {//AR=>A1,A2
						regionWiseMcpMap.put("A1", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));
						regionWiseMcpMap.put("A2", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));
					}
					 if (pxCeaAcpCommaSeparated.getRegionCode().equals("ER")) {//ER=>E1,E2
						regionWiseMcpMap.put("E1", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));	
						regionWiseMcpMap.put("E2", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));						
					} if (pxCeaAcpCommaSeparated.getRegionCode().equals("N1")) {
						regionWiseMcpMap.put("N1", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));
						
					} if (pxCeaAcpCommaSeparated.getRegionCode().equals("N2")) {
						regionWiseMcpMap.put("N2", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));	
						
					} if (pxCeaAcpCommaSeparated.getRegionCode().equals("N3")) {
						regionWiseMcpMap.put("N3", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));
						
					} if (pxCeaAcpCommaSeparated.getRegionCode().equals("S1")) {
						regionWiseMcpMap.put("S1", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));	
						
					} if (pxCeaAcpCommaSeparated.getRegionCode().equals("S2")) {
						regionWiseMcpMap.put("S2", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));	
						
					} if (pxCeaAcpCommaSeparated.getRegionCode().equals("S3")) {
						regionWiseMcpMap.put("S3", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));	
						
					} if (pxCeaAcpCommaSeparated.getRegionCode().equals("W1")) {
						regionWiseMcpMap.put("W1", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));
						
					} if (pxCeaAcpCommaSeparated.getRegionCode().equals("W2")) {
						regionWiseMcpMap.put("W2", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));
						
					} if (pxCeaAcpCommaSeparated.getRegionCode().equals("W3")) {
						regionWiseMcpMap.put("W3", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));			
					}
					//Include NR.SR,WR separately as they have been included while handling composite area
					if (pxCeaAcpCommaSeparated.getRegionCode().equals("NR")) {
						regionWiseMcpMap.put("NR", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));			
					}
					if (pxCeaAcpCommaSeparated.getRegionCode().equals("SR")) {
						regionWiseMcpMap.put("SR", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));			
					}
					if (pxCeaAcpCommaSeparated.getRegionCode().equals("WR")) {
						regionWiseMcpMap.put("WR", getListOfDouble(pxCeaAcpCommaSeparated.getMcp()));			
					}
				}//End of if	
				
			}//Inner for loop
			dateWiseRegionMcpCollection.add(regionWiseMcpMap);
		}//Date based for loop
		return dateWiseRegionMcpCollection;
	}
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	@SuppressWarnings({ "unused", "rawtypes" })
	private void setRegionWiseCollectedList(List<Map<String, Object>> dateWiseRegionMcpCollection, Object acpObject,ApiJsonInput apiJsonInput) throws ClassNotFoundException {
		Class classOfTheObject = acpObject.getClass();
		Method[] methods = classOfTheObject.getDeclaredMethods();

	}

}// End of PxCeaDataCommaSeparatedServiceImpl
