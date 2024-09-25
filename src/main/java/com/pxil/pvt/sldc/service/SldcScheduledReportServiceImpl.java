/**
 * 
 */
package com.pxil.pvt.sldc.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxil.api.utils.ApiUtils;
import com.pxil.pvt.entities.ApiScheduleWithLossCommaSeparated;
import com.pxil.pvt.payload.SldcPayload;
import com.pxil.pvt.sldc.jpojo.idas.Buy;
import com.pxil.pvt.sldc.jpojo.idas.Segment;
import com.pxil.pvt.sldc.jpojo.idas.Sell;
import com.pxil.pvt.sldc.repo.SldcScheduledReportRepo;

/**
 * @author sanjeevkumar 
 * 07-Jan-2024 
 * 10:35:04 pm 
 * Objective :
 */
@Service
public class SldcScheduledReportServiceImpl extends ApiUtils implements SldcScheduledReportService  {

	@Autowired
	SldcScheduledReportRepo sldcScheduledReportRepo;

	/**
	 * @author sanjeevkumar 
	 * 09-Jan-2024 
	 * 11:29:04 am 
	 * Objective : Don't remove in-line declaration of ApiJsonInput.
	 */
	@Override
	public com.pxil.pvt.sldc.jpojo.idas.ApiJsonInput getSldcScheduledReportForIdas(SldcPayload sldcPayload) throws Exception{
		com.pxil.pvt.sldc.jpojo.idas.ApiJsonInput idasApiJsonInput = null;
		List<ApiScheduleWithLossCommaSeparated> apiScheduleWithLossCommaSeparatedList = null;	
		try {
		Date delDate = ApiUtils.getJavaDateViaLocalDate(sldcPayload.getDelDate(), dateFormat);		
		java.sql.Date sqlDate = new java.sql.Date(delDate.getTime());		
		String productCode = sldcPayload.getProductCode();
		String gridNodeCodeOfSldcUser = sldcPayload.getGridNodeCode();		
		boolean isDataPreparationSuccessfull = startFunctionCallsForDataMaking(productCode,sqlDate,gridNodeCodeOfSldcUser);
		//System.out.println("IDAS isDataPreparationSuccessful = "+isDataPreparationSuccessfull);
		if(isDataPreparationSuccessfull)
		     apiScheduleWithLossCommaSeparatedList = sldcScheduledReportRepo.getApiScheduleWithLossCommaSeparatedList(sqlDate, productCode, gridNodeCodeOfSldcUser);
		else
			;//Do nothing. Let blank list to go 
		
		if(apiScheduleWithLossCommaSeparatedList != null) 
			 idasApiJsonInput = getApiJsonInputForIdas(apiScheduleWithLossCommaSeparatedList,sldcPayload);
		}catch(Exception ex) {
			throw ex;
		}
		    return idasApiJsonInput;
		
	}// End of getSldcScheduledReportForIdas

	/**
	 * @author sanjeevkumar 
	 * 09-Jan-2024 
	 * 11:29:04 am 
	 * Objective : Don't remove in-line declaration of ApiJsonInput.
	 */
	@Override
	public com.pxil.pvt.sldc.jpojo.rtm.ApiJsonInput getSldcScheduledReportForRtm(SldcPayload sldcPayload) throws Exception{
		com.pxil.pvt.sldc.jpojo.rtm.ApiJsonInput rtmApiJsonInput = null;   
		List<ApiScheduleWithLossCommaSeparated> apiScheduleWithLossCommaSeparatedList = null;
		try {
		Date delDate = ApiUtils.getJavaDateViaLocalDate(sldcPayload.getDelDate(), dateFormat);
		
		java.sql.Date sqlDate = new java.sql.Date(delDate.getTime());
		String productCode = sldcPayload.getProductCode();
		String gridNodeCodeOfSldcUser = sldcPayload.getGridNodeCode();
		boolean isDataPreparationSuccessfull = startFunctionCallsForDataMaking(productCode,sqlDate,gridNodeCodeOfSldcUser);
		//System.out.println("RTM isDataPreparationSuccessful = "+isDataPreparationSuccessfull);
		if(isDataPreparationSuccessfull)
		     apiScheduleWithLossCommaSeparatedList = sldcScheduledReportRepo.getApiScheduleWithLossCommaSeparatedList(sqlDate, productCode, gridNodeCodeOfSldcUser);
		else
			;//do nothing. Let it return null
		
		if(apiScheduleWithLossCommaSeparatedList!=null) 
		   rtmApiJsonInput = getApiJsonInputForRtm(apiScheduleWithLossCommaSeparatedList,sldcPayload);
		
		return rtmApiJsonInput;
		}catch(Exception ex) {
			throw ex;
		}
		
		

	}// End of getSldcScheduledReportForRtm
			
	private boolean startFunctionCallsForDataMaking(String productCode, java.sql.Date delDate, String gridNodeCodeOfSldcUser) {
		boolean isDataPreparationSuccessfull = true;
		try {
			Integer recordCountFn1 = sldcScheduledReportRepo.callApiSldcInsertionUpdationFn(productCode,delDate,delDate,gridNodeCodeOfSldcUser);
			//System.out.println(productCode+" recordCountFn1 = " + recordCountFn1);
			Integer recordCountFn2 = sldcScheduledReportRepo.callApiSldcCommaSeparatedFn(productCode,delDate,delDate,gridNodeCodeOfSldcUser);
			//System.out.println(productCode+" recordCountFn2 = "+recordCountFn2);
			if(recordCountFn2==0)
				isDataPreparationSuccessfull = false;
		}catch(Exception ex ) {
			ex.printStackTrace();
			isDataPreparationSuccessfull = false;
			}		
		return isDataPreparationSuccessfull;
	}

	/**
	 * @author sanjeevkumar
	 * 09-Jan-2024 
	 * 11:29:04 am 
	 * 
	 * Objective: Actual business logic of organizing records in the desired format of json
	 * will be written here and will be stuffed into the right structure of jpojos
	 * so that it could be handled well by response-entity at the controller level for generating json.
	 *
	 **/

	private com.pxil.pvt.sldc.jpojo.idas.ApiJsonInput getApiJsonInputForIdas(
	List<ApiScheduleWithLossCommaSeparated> dateWiseRecordsCollection_List,SldcPayload sldcPayload) {
		
		com.pxil.pvt.sldc.jpojo.idas.ApiJsonInput apiJsonInputForIdas= new com.pxil.pvt.sldc.jpojo.idas.ApiJsonInput();
		com.pxil.pvt.sldc.jpojo.idas.Pxil pxil = new com.pxil.pvt.sldc.jpojo.idas.Pxil();
		
		//API response basic-settings	
		pxil.setApiUser(sldcPayload.getApiUser());
		pxil.setUsersSldc(sldcPayload.getGridNodeCode());		
		pxil.setRequestedDeliveryDate(sldcPayload.getDelDate());
		pxil.setRequestDate((DateTimeFormatter.ofPattern(dateFormat+" HH:mm a")).format(LocalDateTime.now()));
		//Variables declaration	
		LinkedHashMap <String,List<ApiScheduleWithLossCommaSeparated>> dateBasedRecordsMap = null;
		LinkedHashMap <String,List<ApiScheduleWithLossCommaSeparated>> unitBasedRecordsMap = null;
		LinkedHashMap <String,List<ApiScheduleWithLossCommaSeparated>> segmentBasedRecordsMap = null;		
		String key = null;
		
		
		com.pxil.pvt.sldc.jpojo.idas.Unit unit = null;
		com.pxil.pvt.sldc.jpojo.idas.Segment segment = null;
		com.pxil.pvt.sldc.jpojo.idas.Segment segmentForAll = null;
		com.pxil.pvt.sldc.jpojo.idas.Buy buy = null;
		com.pxil.pvt.sldc.jpojo.idas.Sell sell = null;
		Iterator<String> dateBasedKeyIterator = null;
		Iterator<String> unitBasedKeyIterator = null;
		Iterator<String> segmentBasedKeyIterator = null;		
		List<ApiScheduleWithLossCommaSeparated> unitWiseRecordsCollection_List = null;
		
		List<ApiScheduleWithLossCommaSeparated>readySourceTypeRecordsCollection_List = null;
		List<com.pxil.pvt.sldc.jpojo.idas.Segment> readySegmentWiseRecordsCollection_List = null;
		List<com.pxil.pvt.sldc.jpojo.idas.Unit> readyUnitWiseRecordsCollection_List = null;
		
		com.pxil.pvt.sldc.jpojo.idas.Idas idas = null;
		com.pxil.pvt.sldc.jpojo.idas.Delivery dateWiseDeliveryObject = null;
		List<com.pxil.pvt.sldc.jpojo.idas.Delivery> dateWiseDeliveryObjectList = new ArrayList<com.pxil.pvt.sldc.jpojo.idas.Delivery>();
		boolean executeOnce = true;
		
		//Processing starts here
		dateBasedRecordsMap = getDateBasedRecordsMap(dateWiseRecordsCollection_List);
		
		if(dateBasedRecordsMap!=null)//Null check before calling an iterator
		   dateBasedKeyIterator = dateBasedRecordsMap.keySet().iterator();
		
		List<ApiScheduleWithLossCommaSeparated> perDateRecordsCollection_List = null;
		
		while (dateBasedKeyIterator != null && dateBasedKeyIterator.hasNext()) {
			
			dateWiseDeliveryObject = new com.pxil.pvt.sldc.jpojo.idas.Delivery();
			idas = new com.pxil.pvt.sldc.jpojo.idas.Idas();
	        key = dateBasedKeyIterator.next();	      
	        dateWiseDeliveryObject.setDeliveryDate(key);
	        perDateRecordsCollection_List = dateBasedRecordsMap.get(key);	       
	        unitBasedRecordsMap = getUnitBasedRecordMap(perDateRecordsCollection_List);
	        
	        if(unitBasedRecordsMap!=null)
	            unitBasedKeyIterator = unitBasedRecordsMap.keySet().iterator();
	        
	        readyUnitWiseRecordsCollection_List = new ArrayList<com.pxil.pvt.sldc.jpojo.idas.Unit>();
	        
	        while(unitBasedKeyIterator != null && unitBasedKeyIterator.hasNext()) {	
	        	
	        	unit = new com.pxil.pvt.sldc.jpojo.idas.Unit();
	        	key = unitBasedKeyIterator.next();	
	        	
	        	unitWiseRecordsCollection_List = unitBasedRecordsMap.get(key);
	        	
	        	segmentBasedRecordsMap = getSegmentWiseRecordMap(unitWiseRecordsCollection_List);
	        	
	        	
	        	 if(segmentBasedRecordsMap!=null)
	        	     segmentBasedKeyIterator = segmentBasedRecordsMap.keySet().iterator();
	        	 
	        	 readySegmentWiseRecordsCollection_List = new ArrayList<com.pxil.pvt.sldc.jpojo.idas.Segment>();
	        	 segmentForAll = new com.pxil.pvt.sldc.jpojo.idas.Segment();//Per unit
	        	 segmentForAll.setSourceType("ALL");
	        	 segmentForAll.setBuy(new com.pxil.pvt.sldc.jpojo.idas.Buy());
	        	 segmentForAll.setSell(new com.pxil.pvt.sldc.jpojo.idas.Sell());
	        	while(segmentBasedKeyIterator != null && segmentBasedKeyIterator.hasNext()) {     		
	        		
	        		 key = segmentBasedKeyIterator.next();	
	        		
	        		 if(segmentBasedRecordsMap!=null)
	        			 readySourceTypeRecordsCollection_List = segmentBasedRecordsMap.get(key);     		 
	        		  
	        		 executeOnce = true;
	        		 segment = new com.pxil.pvt.sldc.jpojo.idas.Segment();//Per loop one segment
	        		
	        		 for(ApiScheduleWithLossCommaSeparated readySourceTypeRecord : readySourceTypeRecordsCollection_List) {      			 
	        			        			 
	        			 if(executeOnce) {	 				
	        				segment.setSourceType(readySourceTypeRecord.getPowerSourceType());
	        				idas.setReginalEntityName(readySourceTypeRecord.getNodeDesc());
	        				idas.setReginalEntityCode(readySourceTypeRecord.getRegionalEntity());
	        				idas.setRegionalInjectionLossPer(readySourceTypeRecord.getRegionalinjectionlossper());
	        				idas.setRegionalWithdrawalLossPer(readySourceTypeRecord.getRegionalwithdrawallossper());
	        				idas.setStateInjectionLossPer(readySourceTypeRecord.getStateinjectionlossper());
	        				idas.setStateWithdrawalLossPer(readySourceTypeRecord.getStatewithdrawallossper());	        				
		        			
	        				unit.setUnitCode(readySourceTypeRecord.getUnitCode());
		 	        		unit.setUnitName(readySourceTypeRecord.getUnitName());
		 	        		unit.setPxCode(readySourceTypeRecord.getPxCode());      			
		        			executeOnce=false;
	        			 }	        			 
	        			
	        			 if(readySourceTypeRecord.getSide().equalsIgnoreCase("B")) {
	        				buy = new com.pxil.pvt.sldc.jpojo.idas.Buy(); 
	        				buy.setWithoutLoss(getListOfDouble(readySourceTypeRecord.getWithoutloss()));
	        				buy.setWithRegionLoss(getListOfDouble(readySourceTypeRecord.getWithregionloss()));
	        				buy.setWithSldcLoss(getListOfDouble(readySourceTypeRecord.getWithsldcloss()));
	        				segment.setBuy(buy);  
	        				collectBuyForAllSegments(segmentForAll,buy);	        				
	        			 }
	        			 else if(readySourceTypeRecord.getSide().equalsIgnoreCase("S")) {
	        				sell = new com.pxil.pvt.sldc.jpojo.idas.Sell(); 
	        				sell.setWithoutLoss(getListOfDouble(readySourceTypeRecord.getWithoutloss()));
	        				sell.setWithRegionLoss(getListOfDouble(readySourceTypeRecord.getWithregionloss()));
	        				sell.setWithSldcLoss(getListOfDouble(readySourceTypeRecord.getWithsldcloss()));
	        				segment.setSell(sell);	
	        				collectSellForAllSegments(segmentForAll,sell);
	        			 } 	        
	        			 
	        		 }//End of segment-for-loop
	        		 readySegmentWiseRecordsCollection_List.add(segment);        		         		 
	        	}//End of segment Iterator - While-loop	
	        	readySegmentWiseRecordsCollection_List.add(segmentForAll);  
	        	unit.setSegments(readySegmentWiseRecordsCollection_List);	
	        	readyUnitWiseRecordsCollection_List.add(unit);	        	
	        }//Unit based iteration ends here	
	        
	        idas.setUnits(readyUnitWiseRecordsCollection_List);
	        dateWiseDeliveryObject.setIdas(idas);	       
	        dateWiseDeliveryObjectList.add(dateWiseDeliveryObject); 
	        
	    }//Date based iteration ends here	
		
		pxil.setDelivery(dateWiseDeliveryObjectList);		
		apiJsonInputForIdas.setPxil(pxil);		
		return apiJsonInputForIdas;
	}// End of getApiJsonInputForIdas
	
	private void collectSellForAllSegments(Segment segmentForAll, Sell sell) {
		List<Double> existingWithoutLoss = segmentForAll.getSell().getWithoutLoss();
		segmentForAll.getSell().setWithoutLoss(addTwoDoubleLists(sell.getWithoutLoss(),existingWithoutLoss));
		
		List<Double> existingWithRegionLoss = segmentForAll.getSell().getWithRegionLoss();
		segmentForAll.getSell().setWithRegionLoss(addTwoDoubleLists(sell.getWithRegionLoss(),existingWithRegionLoss));
		
		List<Double> existingWithSldcLoss = segmentForAll.getSell().getWithSldcLoss();
		segmentForAll.getSell().setWithSldcLoss(addTwoDoubleLists(sell.getWithSldcLoss(),existingWithSldcLoss));	
		
	}//End of collectSellForAllSegments

	private void collectBuyForAllSegments(Segment segmentForAll, Buy buy) {
		
		List<Double> existingWithoutLoss = segmentForAll.getBuy().getWithoutLoss();
		segmentForAll.getBuy().setWithoutLoss(addTwoDoubleLists(buy.getWithoutLoss(),existingWithoutLoss));
		
		List<Double> existingWithRegionLoss = segmentForAll.getBuy().getWithRegionLoss();
		segmentForAll.getBuy().setWithRegionLoss(addTwoDoubleLists(buy.getWithRegionLoss(),existingWithRegionLoss));
		
		List<Double> existingWithSldcLoss = segmentForAll.getBuy().getWithSldcLoss();
		segmentForAll.getBuy().setWithSldcLoss(addTwoDoubleLists(buy.getWithSldcLoss(),existingWithSldcLoss));		
		
	}//End of collectBuyForAllSegments
	
	
	public List<Double> addTwoDoubleLists(List<Double> comingDoubleList, List<Double> existingDoubleList) {
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);		
	     Iterator<Double> comingDoubleListIterator = comingDoubleList.iterator();
	     Iterator<Double> existingDoubleListIterator = existingDoubleList.iterator();
	     List<Double> combinedDoubleList = new ArrayList<Double>(); 
	     Double intermediateCalculation;
	    while (comingDoubleListIterator.hasNext() && existingDoubleListIterator.hasNext()) {
	    	intermediateCalculation=comingDoubleListIterator.next() + existingDoubleListIterator.next();
	    	intermediateCalculation = Math.round(intermediateCalculation*10000)/10000.0d;//This will round off till four digits
	    	//intermediateCalculation = Double.valueOf(df.format(intermediateCalculation));//Will be used we need to take exact 4 digits after decimal  	    	
	    	combinedDoubleList.add(intermediateCalculation);
	    }	    
	    return combinedDoubleList;
	 }//End of addTwoDoubleLists

	private LinkedHashMap <String,List<ApiScheduleWithLossCommaSeparated>> getDateBasedRecordsMap(List<ApiScheduleWithLossCommaSeparated> dateWiseRecordsCollection_List) {
				
		LinkedHashMap <String,List<ApiScheduleWithLossCommaSeparated>> dateBasedRecordsMap = new LinkedHashMap <String,List<ApiScheduleWithLossCommaSeparated>>();
		List<ApiScheduleWithLossCommaSeparated> dateBasedRecordsGroupingList = null;		
		boolean startInitializing = true;
		String comingDateInRecord = null; String previousDateInRecord = null;
		//Do this sorting before processing
		dateWiseRecordsCollection_List.sort((o1, o2)
                -> o1.getDeliveryFromDate().compareTo(
                    o2.getDeliveryFromDate()));
		
		for( ApiScheduleWithLossCommaSeparated comingRecord :dateWiseRecordsCollection_List) {			
			comingDateInRecord = getStrDateFromJavaDate(comingRecord.getDeliveryFromDate(), dateFormat);			
			//When a record with date-change comes, this will execute. 		
			if(previousDateInRecord!=null && !previousDateInRecord.equals(comingDateInRecord)) {				
				dateBasedRecordsMap.put(previousDateInRecord, dateBasedRecordsGroupingList);
				startInitializing = true;
				}			
			if(startInitializing) {//This will execute whenever a record with new date comes first time
				dateBasedRecordsGroupingList =	 new ArrayList<ApiScheduleWithLossCommaSeparated>();				
				dateBasedRecordsGroupingList.add(comingRecord);				
				startInitializing = false;		
			}			
			//If dates are not changing, then the record must be collected in the dateBasedRecordsGrouping_List			
			if(previousDateInRecord!=null && previousDateInRecord.equals(comingDateInRecord)) {
				dateBasedRecordsGroupingList.add(comingRecord);				
			}			
			previousDateInRecord = comingDateInRecord;//Preserve the previousDateInRecord for comparing with new comingDateInRecord			
		}//End of for-loop
		
		//if the date of the last-record and immediate-previous-record are the same.
		if(previousDateInRecord!=null && previousDateInRecord.equals(comingDateInRecord))
			dateBasedRecordsMap.put(previousDateInRecord, dateBasedRecordsGroupingList);
		
		return dateBasedRecordsMap;
	}//End of getDateBasedRecordsMap
	
	private LinkedHashMap<String, List<ApiScheduleWithLossCommaSeparated>> getUnitBasedRecordMap(
			List<ApiScheduleWithLossCommaSeparated> perDateRecordsCollection_List) {
		
		LinkedHashMap <String,List<ApiScheduleWithLossCommaSeparated>> unitBasedRecordsMap = new LinkedHashMap <String,List<ApiScheduleWithLossCommaSeparated>>();
		List<ApiScheduleWithLossCommaSeparated> unitBasedRecordsGroupingList = null;		
		boolean startInitializing = true;
		String comingUnitInRecord = null; String previousUnitInRecord = null;
		//Do this sorting before processing
		perDateRecordsCollection_List.sort((o1, o2)
                -> o1.getUnitCode().compareTo(
                    o2.getUnitCode()));
		for( ApiScheduleWithLossCommaSeparated comingRecord :perDateRecordsCollection_List) {			
			comingUnitInRecord = comingRecord.getUnitCode();		
			//When a record with unit-change comes, this will execute. 		
			if(previousUnitInRecord!=null && !previousUnitInRecord.equals(comingUnitInRecord)) {				
				unitBasedRecordsMap.put(previousUnitInRecord, unitBasedRecordsGroupingList);
				//System.out.println("Unit"+previousUnitInRecord+" => "+unitBasedRecordsGroupingList.size());
				startInitializing = true;
				}			
			if(startInitializing) {//This will execute whenever a record with new unit comes first time
				unitBasedRecordsGroupingList =	 new ArrayList<ApiScheduleWithLossCommaSeparated>();				
				unitBasedRecordsGroupingList.add(comingRecord);				
				startInitializing = false;		
			}			
			//If units are not changing, then the record must be collected in the unitBasedRecordsGroupingList			
			if(previousUnitInRecord!=null && previousUnitInRecord.equals(comingUnitInRecord)) {
				unitBasedRecordsGroupingList.add(comingRecord);				
			}			
			previousUnitInRecord = comingUnitInRecord;//Preserve the previous unit for comparing with new record-unit			
		}//End of for-loop
		
		//if the unit of the last-record and immediate-previous-record are the same.
		if(previousUnitInRecord!=null && previousUnitInRecord.equals(comingUnitInRecord)) {
			unitBasedRecordsMap.put(previousUnitInRecord, unitBasedRecordsGroupingList);
			//System.out.println("Unit"+previousUnitInRecord+" => "+unitBasedRecordsGroupingList.size());
		}
		
		return unitBasedRecordsMap;
	}//End of getUnitBasedRecordMap

	private LinkedHashMap<String, List<ApiScheduleWithLossCommaSeparated>> getSegmentWiseRecordMap(
			List<ApiScheduleWithLossCommaSeparated> unitWiseRecordsCollection_List) {
		LinkedHashMap <String,List<ApiScheduleWithLossCommaSeparated>> powerSegmentBasedRecordsMap = new LinkedHashMap <String,List<ApiScheduleWithLossCommaSeparated>>();
		List<ApiScheduleWithLossCommaSeparated> powerSegmentBasedRecordsGroupingList = null;		
		boolean startInitializing = true;
		String comingPowerSegmentInRecord = null; String previousPowerSegmentInRecord = null;
		
		
		//Do this sorting before processing
		unitWiseRecordsCollection_List.sort((o1, o2)
                -> o1.getPowerSourceType().compareTo(
                    o2.getPowerSourceType()));
		
		for( ApiScheduleWithLossCommaSeparated comingRecord :unitWiseRecordsCollection_List) {	
			
			comingPowerSegmentInRecord = comingRecord.getPowerSourceType();	
			
			//When a record with power-segment-change comes, this will execute. 		
			if(previousPowerSegmentInRecord!=null && !previousPowerSegmentInRecord.equals(comingPowerSegmentInRecord)) {				
				powerSegmentBasedRecordsMap.put(previousPowerSegmentInRecord, powerSegmentBasedRecordsGroupingList);
				startInitializing = true;
				}			
			if(startInitializing) {//This will execute whenever a record with new power-segment comes first time
				powerSegmentBasedRecordsGroupingList =	 new ArrayList<ApiScheduleWithLossCommaSeparated>();				
				powerSegmentBasedRecordsGroupingList.add(comingRecord);				
				startInitializing = false;		
			}			
			//If power-segment are not changing, then the record must be collected in the powerSegmentBasedRecordsGroupingList			
			if(previousPowerSegmentInRecord!=null && previousPowerSegmentInRecord.equals(comingPowerSegmentInRecord)) {
				powerSegmentBasedRecordsGroupingList.add(comingRecord);				
			}			
			previousPowerSegmentInRecord = comingPowerSegmentInRecord;//Preserve the previous power-segment for comparing with new record-power-segment			
		}//End of for-loop
		
		//if the power-segment of the last-record and immediate-previous-record are the same.
		if(previousPowerSegmentInRecord!=null && previousPowerSegmentInRecord.equals(comingPowerSegmentInRecord))
			powerSegmentBasedRecordsMap.put(previousPowerSegmentInRecord, powerSegmentBasedRecordsGroupingList);
		
		
		return powerSegmentBasedRecordsMap;
	}//End of getSegmentWiseRecordMap
	

	private com.pxil.pvt.sldc.jpojo.rtm.ApiJsonInput getApiJsonInputForRtm(
			List<ApiScheduleWithLossCommaSeparated> dateWiseRecordsCollection_List,SldcPayload sldcPayload) {
		
		com.pxil.pvt.sldc.jpojo.rtm.ApiJsonInput apiJsonInputForRtm= new com.pxil.pvt.sldc.jpojo.rtm.ApiJsonInput();
		com.pxil.pvt.sldc.jpojo.rtm.Pxil pxil = new com.pxil.pvt.sldc.jpojo.rtm.Pxil();
		
		//API response basic-settings	
		pxil.setUser(sldcPayload.getApiUser());
		pxil.setSldc(sldcPayload.getGridNodeCode());		
		pxil.setDeliveryDate(sldcPayload.getDelDate());
		pxil.setRequestDate((DateTimeFormatter.ofPattern(dateFormat+" HH:mm a")).format(LocalDateTime.now()));
		//Variables declaration	
		LinkedHashMap <String,List<ApiScheduleWithLossCommaSeparated>> dateBasedRecordsMap = null;
		LinkedHashMap <String,List<ApiScheduleWithLossCommaSeparated>> unitBasedRecordsMap = null;			
		String key = null;		
		com.pxil.pvt.sldc.jpojo.rtm.Unit unit = null;		
		com.pxil.pvt.sldc.jpojo.rtm.Buy buy = null;
		com.pxil.pvt.sldc.jpojo.rtm.Sell sell = null;
		Iterator<String> dateBasedKeyIterator = null;
		Iterator<String> unitBasedKeyIterator = null;				
		List<ApiScheduleWithLossCommaSeparated> unitWiseRecordsCollection_List = null;		
		List<com.pxil.pvt.sldc.jpojo.rtm.Unit> readyUnitWiseRecordsCollection_List = null;
		
		com.pxil.pvt.sldc.jpojo.rtm.Rtm rtm = null;
		com.pxil.pvt.sldc.jpojo.rtm.Delivery dateWiseDeliveryObject = null;
		List<com.pxil.pvt.sldc.jpojo.rtm.Delivery> dateWiseDeliveryObjectList = new ArrayList<com.pxil.pvt.sldc.jpojo.rtm.Delivery>();
		boolean executeOnce = true;
		
		//Processing starts here
		dateBasedRecordsMap = getDateBasedRecordsMap(dateWiseRecordsCollection_List);
		
		if(dateBasedRecordsMap!=null)
		   dateBasedKeyIterator = dateBasedRecordsMap.keySet().iterator();
		
		List<ApiScheduleWithLossCommaSeparated> perDateRecordsCollection_List = null;
		
		while (dateBasedKeyIterator != null && dateBasedKeyIterator.hasNext()) {
			
			dateWiseDeliveryObject = new com.pxil.pvt.sldc.jpojo.rtm.Delivery();
			rtm = new com.pxil.pvt.sldc.jpojo.rtm.Rtm();
	        key = dateBasedKeyIterator.next();	      
	        dateWiseDeliveryObject.setDeliveryDate(key);
	        perDateRecordsCollection_List = dateBasedRecordsMap.get(key);	       
	        unitBasedRecordsMap = getUnitBasedRecordMap(perDateRecordsCollection_List);
	        
	        if(unitBasedRecordsMap!=null)
	            unitBasedKeyIterator = unitBasedRecordsMap.keySet().iterator();
	       
	       
	        readyUnitWiseRecordsCollection_List = new ArrayList<com.pxil.pvt.sldc.jpojo.rtm.Unit>();
	        while(unitBasedKeyIterator != null && unitBasedKeyIterator.hasNext()) {	     	
	        	key = unitBasedKeyIterator.next();		        	
	        	unitWiseRecordsCollection_List = unitBasedRecordsMap.get(key);	        		  
	        		 executeOnce = true;     		 
	        		 unit = new com.pxil.pvt.sldc.jpojo.rtm.Unit();
	        		 for(ApiScheduleWithLossCommaSeparated readySourceTypeRecord : unitWiseRecordsCollection_List) {     			        			 
	        			 if(executeOnce) {	        				
	        				rtm.setReginalEntityName(readySourceTypeRecord.getNodeDesc());
	        				rtm.setReginalEntityCode(readySourceTypeRecord.getRegionalEntity());
	        				rtm.setRegionalInjectionLossPer(readySourceTypeRecord.getRegionalinjectionlossper());
	        				rtm.setRegionalWithdrawalLossPer(readySourceTypeRecord.getRegionalwithdrawallossper());
	        				rtm.setStateInjectionLossPer(readySourceTypeRecord.getStateinjectionlossper());
	        				rtm.setStateWithdrawalLossPer(readySourceTypeRecord.getStatewithdrawallossper());	        				
		        			
	        				unit.setUnitCode(readySourceTypeRecord.getUnitCode());
		 	        		unit.setUnitName(readySourceTypeRecord.getUnitName());
		 	        		unit.setPxCode(readySourceTypeRecord.getPxCode());      			
		        			executeOnce=false;
	        			 }	        			 
	        			
	        			 if(readySourceTypeRecord.getSide().equalsIgnoreCase("B")) {
	        				buy = new com.pxil.pvt.sldc.jpojo.rtm.Buy(); 
	        				buy.setWithoutLoss(getListOfDouble(readySourceTypeRecord.getWithoutloss()));
	        				buy.setWithRegionLoss(getListOfDouble(readySourceTypeRecord.getWithregionloss()));
	        				buy.setWithSldcLoss(getListOfDouble(readySourceTypeRecord.getWithsldcloss()));
	        				unit.setBuy(buy);  				
	        			 }
	        			 else if(readySourceTypeRecord.getSide().equalsIgnoreCase("S")) {
	        				sell = new com.pxil.pvt.sldc.jpojo.rtm.Sell(); 
	        				sell.setWithoutLoss(getListOfDouble(readySourceTypeRecord.getWithoutloss()));
	        				sell.setWithRegionLoss(getListOfDouble(readySourceTypeRecord.getWithregionloss()));
	        				sell.setWithSldcLoss(getListOfDouble(readySourceTypeRecord.getWithsldcloss()));
	        				unit.setSell(sell);	        				
	        			 } 	        			
	        		 }//End of unit-for-loop 
	        		 readyUnitWiseRecordsCollection_List.add(unit);	
	        }//Unit based iteration ends here	
	        
	        rtm.setUnits(readyUnitWiseRecordsCollection_List);
	        dateWiseDeliveryObject.setRtm(rtm);	       
	        dateWiseDeliveryObjectList.add(dateWiseDeliveryObject); 
	        
	    }//Date based iteration ends here	
		
		pxil.setDelivery(dateWiseDeliveryObjectList);		
		apiJsonInputForRtm.setPxil(pxil);
		return apiJsonInputForRtm;
	}// End of getApiJsonInputForRtm

}// End of WbSldcScheduledIdasReportService
