
package com.pxil.pvt.reg.service;

import com.pxil.pvt.entities.PxCeaDataCommaSeparated;
import com.pxil.pvt.reg.jpojo.ApiJsonInput;
import com.pxil.pvt.reg.jpojo.DACConventional;
import com.pxil.pvt.reg.jpojo.DACHydro;
import com.pxil.pvt.reg.jpojo.DACNonSolar;
import com.pxil.pvt.reg.jpojo.DACSolar;
import com.pxil.pvt.reg.jpojo.Dac;
import com.pxil.pvt.reg.jpojo.Dam;
import com.pxil.pvt.reg.jpojo.GTAMHydro;
import com.pxil.pvt.reg.jpojo.GTAMHydroADS;
import com.pxil.pvt.reg.jpojo.GTAMHydroDaily;
import com.pxil.pvt.reg.jpojo.GTAMHydroMonthly;
import com.pxil.pvt.reg.jpojo.GTAMHydroWeekly;
import com.pxil.pvt.reg.jpojo.GTAMNonSolar;
import com.pxil.pvt.reg.jpojo.GTAMNonSolarADS;
import com.pxil.pvt.reg.jpojo.GTAMNonSolarDaily;
import com.pxil.pvt.reg.jpojo.GTAMNonSolarMonthly;
import com.pxil.pvt.reg.jpojo.GTAMNonSolarWeekly;
import com.pxil.pvt.reg.jpojo.GTAMSolar;
import com.pxil.pvt.reg.jpojo.GTAMSolarADS;
import com.pxil.pvt.reg.jpojo.GTAMSolarDaily;
import com.pxil.pvt.reg.jpojo.GTAMSolarMonthly;
import com.pxil.pvt.reg.jpojo.GTAMSolarWeekly;
import com.pxil.pvt.reg.jpojo.Gdam;
import com.pxil.pvt.reg.jpojo.Hpdam;
import com.pxil.pvt.reg.jpojo.Intraday;
import com.pxil.pvt.reg.jpojo.IntradayConventional;
import com.pxil.pvt.reg.jpojo.IntradayHydro;
import com.pxil.pvt.reg.jpojo.IntradayNonSolar;
import com.pxil.pvt.reg.jpojo.IntradaySolar;
import com.pxil.pvt.reg.jpojo.Rtm;
import com.pxil.pvt.reg.jpojo.TAMDaily;
import com.pxil.pvt.reg.jpojo.TAMMonthly;
import com.pxil.pvt.reg.jpojo.TAMWeekly;
import com.pxil.pvt.reg.jpojo.Tam;
import com.pxil.pvt.reg.jpojo.TamAds;

/**
 * @author sanjeevkumar 
 * 05-Dec-2023 
 * 5:27:25 pm 
 * Objective :
 */
public abstract class PxCeaDataCommaSeparatedService extends CheckAndUpdateMissingRecordService{
    
	public abstract ApiJsonInput getMonthHistory(Integer monthHist);//This is only abstract method that we will implement in the implementing class
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	Dac dac = null;
	protected void prepare_Dac_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		dac = new Dac();
		dac.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		dac.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		dac.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		dac.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		dac.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		dac.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		dac.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getDac().add(dac);
	}// End of prepare_Dac_CeaData
	
	DACConventional dAC_Conventional =null;
	protected void prepare_DAC_Conventional_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		dAC_Conventional = new DACConventional();
		dAC_Conventional.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		dAC_Conventional.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		dAC_Conventional.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		dAC_Conventional.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		dAC_Conventional.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		dAC_Conventional.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		dAC_Conventional.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getDACConventional().add(dAC_Conventional);
	}// End of prepare_DAC_Conventional_CeaData
	
	DACSolar dAC_Solar =null;
	protected void prepare_DAC_Solar_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		dAC_Solar = new DACSolar();
		dAC_Solar.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		dAC_Solar.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		dAC_Solar.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		dAC_Solar.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		dAC_Solar.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		dAC_Solar.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		dAC_Solar.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getDACSolar().add(dAC_Solar);
	}// End of prepare_DAC_Solar_CeaData
	
	
	DACNonSolar dAC_Non_Solar;
	protected void prepare_DAC_Non_Solar_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		dAC_Non_Solar = new DACNonSolar();
		dAC_Non_Solar.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		dAC_Non_Solar.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		dAC_Non_Solar.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		dAC_Non_Solar.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		dAC_Non_Solar.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		dAC_Non_Solar.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		dAC_Non_Solar.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getDACNonSolar().add(dAC_Non_Solar);
	}// End of prepare_DAC_Non_Solar_CeaData
	
	
	DACHydro dAC_Hydro;
	protected void prepare_DAC_Hydro_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		dAC_Hydro = new DACHydro();
		dAC_Hydro.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		dAC_Hydro.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		dAC_Hydro.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		dAC_Hydro.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		dAC_Hydro.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		dAC_Hydro.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		dAC_Hydro.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getDACHydro().add(dAC_Hydro);
	}// End of prepare_DAC_Hydro_CeaData
	
	
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	Rtm rtm = null;
	protected void prepare_Rtm_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
	    rtm = new Rtm();
		rtm.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		rtm.setPurchaseBid(getListOfDouble(pxCeaDataCommaSeparatedEntity.getPurchaseBid()));
		rtm.setSellBid(getListOfDouble(pxCeaDataCommaSeparatedEntity.getSellBid()));
		rtm.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		rtm.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		rtm.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		rtm.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		rtm.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		rtm.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getRtm().add(rtm);
	}// End of prepare_Rtm_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	Dam dam = null;
	protected void prepare_Dam_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
	    dam = new Dam();
		dam.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		dam.setPurchaseBid(getListOfDouble(pxCeaDataCommaSeparatedEntity.getPurchaseBid()));
		dam.setSellBid(getListOfDouble(pxCeaDataCommaSeparatedEntity.getSellBid()));
		dam.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		dam.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		dam.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		dam.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		dam.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		dam.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getDam().add(dam);
	}// End of prepare_Dam_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */
	
	GTAMHydro gTAM_Hydro = null;
	protected void prepare_GTAM_Hydro_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAM_Hydro = new GTAMHydro();
		gTAM_Hydro.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAM_Hydro.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAM_Hydro.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAM_Hydro.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAM_Hydro.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAM_Hydro.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAM_Hydro.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getGTAMHydro().add(gTAM_Hydro);
	}// End of prepare_GTAM_Hydro_CeaData
	
	
	
	GTAMHydroADS gTAMHydroADS = null;
	protected void prepare_GTAMHydroADS_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
	    gTAMHydroADS = new GTAMHydroADS();
		gTAMHydroADS.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAMHydroADS.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAMHydroADS.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAMHydroADS.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAMHydroADS.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAMHydroADS.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAMHydroADS.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getGTAMHydroADSS().add(gTAMHydroADS);
	}// End of prepare_GTAMHydroADS_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	GTAMHydroDaily gTAMHydroDaily = null;
	protected void prepare_GTAMHydroDaily_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
	    gTAMHydroDaily = new GTAMHydroDaily();
		gTAMHydroDaily.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAMHydroDaily.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAMHydroDaily.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAMHydroDaily.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAMHydroDaily.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAMHydroDaily.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAMHydroDaily.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getGTAMHydroDaily().add(gTAMHydroDaily);
	}// End of prepare_GTAMHydroDaily_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	GTAMHydroMonthly gTAMHydroMonthly = null;
	protected void prepare_GTAMHydroMonthly_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAMHydroMonthly = new GTAMHydroMonthly();
		gTAMHydroMonthly.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAMHydroMonthly.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAMHydroMonthly.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAMHydroMonthly.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAMHydroMonthly.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAMHydroMonthly.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAMHydroMonthly.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getGTAMHydroMonthly().add(gTAMHydroMonthly);
	}// End of prepare_GTAMHydroMonthly_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	GTAMHydroWeekly gTAMHydroWeekly = null;
	protected void prepare_GTAMHydroWeekly_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAMHydroWeekly = new GTAMHydroWeekly();
		gTAMHydroWeekly.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAMHydroWeekly.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAMHydroWeekly.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAMHydroWeekly.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAMHydroWeekly.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAMHydroWeekly.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAMHydroWeekly.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getGTAMHydroWeekly().add(gTAMHydroWeekly);
	}// End of prepare_GTAMHydroWeekly_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	GTAMNonSolarADS gTAMNonSolarADS = null;
	protected void prepare_GTAMNonSolarADS_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAMNonSolarADS = new GTAMNonSolarADS();
		gTAMNonSolarADS.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAMNonSolarADS.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAMNonSolarADS.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAMNonSolarADS.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAMNonSolarADS.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAMNonSolarADS.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAMNonSolarADS.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getGTAMNonSolarADSS().add(gTAMNonSolarADS);
	}// End of prepare_GTAMNonSolarADS_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	GTAMSolarADS gTAMSolarADS = null;
	protected void prepare_GTAMSolarADSS_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAMSolarADS = new GTAMSolarADS();
		gTAMSolarADS.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAMSolarADS.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAMSolarADS.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAMSolarADS.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAMSolarADS.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAMSolarADS.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAMSolarADS.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getGTAMSolarADSS().add(gTAMSolarADS);
	}// End of prepare_GTAMSolarADSS_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	
	
	
	GTAMNonSolar gTAM_Non_Solar = null;
	protected void prepare_GTAM_Non_Solar_CeaData(ApiJsonInput apiJsonInput,	PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAM_Non_Solar = new GTAMNonSolar();
		gTAM_Non_Solar.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAM_Non_Solar.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAM_Non_Solar.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAM_Non_Solar.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAM_Non_Solar.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAM_Non_Solar.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAM_Non_Solar.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getGTAMNonSolar().add(gTAM_Non_Solar);
	}// End of prepare_GTAM_Non_Solar_CeaData
	
	
	GTAMNonSolarDaily gTAMNonSolarDaily = null;
	protected void prepare_GTAMNonSolarDaily_CeaData(ApiJsonInput apiJsonInput,	PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAMNonSolarDaily = new GTAMNonSolarDaily();
		gTAMNonSolarDaily.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAMNonSolarDaily.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAMNonSolarDaily.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAMNonSolarDaily.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAMNonSolarDaily.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAMNonSolarDaily.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAMNonSolarDaily.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getGTAMNonSolarDaily().add(gTAMNonSolarDaily);
	}// End of prepare_GTAMNonSolarDaily_CeaData
	
	/** @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	GTAMNonSolarMonthly gTAMNonSolarMonthly = null;
	protected void prepare_GTAMNonSolarMonthly_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAMNonSolarMonthly = new GTAMNonSolarMonthly();
		gTAMNonSolarMonthly.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAMNonSolarMonthly.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAMNonSolarMonthly.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAMNonSolarMonthly.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAMNonSolarMonthly.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAMNonSolarMonthly.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAMNonSolarMonthly.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getGTAMNonSolarMonthly().add(gTAMNonSolarMonthly);
	}// End of prepare_GTAMNonSolarMonthly_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	GTAMNonSolarWeekly gTAMNonSolarWeekly = null;
	protected void prepare_GTAMNonSolarWeekly_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAMNonSolarWeekly = new GTAMNonSolarWeekly();
		gTAMNonSolarWeekly.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAMNonSolarWeekly.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAMNonSolarWeekly.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAMNonSolarWeekly.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAMNonSolarWeekly.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAMNonSolarWeekly.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAMNonSolarWeekly.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getGTAMNonSolarWeekly().add(gTAMNonSolarWeekly);
	}// End of prepare_GTAMNonSolarWeekly_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */
	
	GTAMSolar gTAM_Solar = null;
	protected void prepare_GTAM_Solar_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAM_Solar = new GTAMSolar();
		gTAM_Solar.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(),dateFormatUsed));		
		gTAM_Solar.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAM_Solar.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAM_Solar.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAM_Solar.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAM_Solar.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAM_Solar.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getGTAMSolar().add(gTAM_Solar);
	}// End of prepare_GTAM_Solar_CeaData
	
	GTAMSolarDaily gTAMSolarDaily = null;
	protected void prepare_GTAMSolarDaily_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAMSolarDaily = new GTAMSolarDaily();
		gTAMSolarDaily.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(),dateFormatUsed));		
		gTAMSolarDaily.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAMSolarDaily.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAMSolarDaily.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAMSolarDaily.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAMSolarDaily.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAMSolarDaily.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getGTAMSolarDaily().add(gTAMSolarDaily);
	}// End of prepare_GTAMSolarDaily_CeaData
		
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	GTAMSolarMonthly gTAMSolarMonthly =  null;
	protected void prepare_GTAMSolarMonthly_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAMSolarMonthly = new GTAMSolarMonthly();
		gTAMSolarMonthly.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAMSolarMonthly.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAMSolarMonthly.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAMSolarMonthly.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAMSolarMonthly.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAMSolarMonthly.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAMSolarMonthly.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getGTAMSolarMonthly().add(gTAMSolarMonthly);
	}// End of prepare_GTAMSolarMonthly_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	GTAMSolarWeekly gTAMSolarWeekly = null;
	protected void prepare_GTAMSolarWeekly_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gTAMSolarWeekly = new GTAMSolarWeekly();
		gTAMSolarWeekly.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));		
		gTAMSolarWeekly.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gTAMSolarWeekly.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gTAMSolarWeekly.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gTAMSolarWeekly.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		gTAMSolarWeekly.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gTAMSolarWeekly.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getGTAMSolarWeekly().add(gTAMSolarWeekly);
	}// End of prepare_GTAMSolarWeekly_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	Gdam gdam = null;
	protected void prepare_Gdam_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		gdam = new Gdam();
		gdam.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		gdam.setPurchaseBid(getListOfDouble(pxCeaDataCommaSeparatedEntity.getPurchaseBid()));
		gdam.setSellBid(getListOfDouble(pxCeaDataCommaSeparatedEntity.getSellBid()));
		gdam.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		gdam.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		gdam.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		gdam.setClearedVolumeNonSolar(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolumeNonSolar()));
		gdam.setClearedVolumeSolar(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolumeSolar()));
		gdam.setClearedVolumeHydro(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolumeHydro()));
		gdam.setClearedVolumeTotal(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));// Needs to be checked
		gdam.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		gdam.setFinalScheduleVolumeHydro(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolumeHydro()));
		gdam.setFinalScheduleVolumeNonSolar(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolumeNonsolar()));
		gdam.setFinalScheduleVolumeSolar(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolumeSolar()));
		gdam.setFinalScheduleVolumeTotal(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));// Needs to be checked
		apiJsonInput.getPxil().getGdam().add(gdam);
	}// End of prepare_Gdam_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	Hpdam hpdam = null;
	protected void prepare_Hpdam_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		hpdam = new Hpdam();
		hpdam.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		hpdam.setPurchaseBid(getListOfDouble(pxCeaDataCommaSeparatedEntity.getPurchaseBid()));
		hpdam.setSellBid(getListOfDouble(pxCeaDataCommaSeparatedEntity.getSellBid()));
		hpdam.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		hpdam.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		hpdam.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		hpdam.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		hpdam.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		hpdam.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getHpdam().add(hpdam);
	}// End of prepare_Hpdam_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	Intraday intraday = null;
	protected void prepare_Intraday_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {	
		intraday = new Intraday();
		intraday.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		intraday.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		intraday.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		intraday.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		intraday.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		intraday.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		intraday.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getIntraday().add(intraday);
	}// End of prepare_Intraday_CeaData
	
	
	/**
	 * @author sanjeevkumar
	 * @Date 05-01-2024
	 * @Time 15:50 p.m.
	 * 
	 * It has been added as a new one
	 * 
	 * @param apiJsonInput
	 * @param pxCeaDataCommaSeparatedEntity
	 */
	IntradayConventional intraday_Conventional =null;
	protected void prepare_Intraday_Conventional_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {	
		intraday_Conventional = new IntradayConventional();
		intraday_Conventional.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		intraday_Conventional.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		intraday_Conventional.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		intraday_Conventional.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		intraday_Conventional.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		intraday_Conventional.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		intraday_Conventional.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getIntradayConventional().add(intraday_Conventional);
	}// End of prepare_Intraday_Conventional_CeaData
	
	/**
	 * @author sanjeevkumar
	 * @Date 05-01-2024
	 * @Time 15:50 p.m.
	 * 
	 * It has been added as a new one
	 * 
	 * @param apiJsonInput
	 * @param pxCeaDataCommaSeparatedEntity
	 */
	IntradaySolar intraday_Solar=null;
	protected void prepare_Intraday_Solar_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {	
		intraday_Solar = new IntradaySolar();
		intraday_Solar.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		intraday_Solar.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		intraday_Solar.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		intraday_Solar.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		intraday_Solar.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		intraday_Solar.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		intraday_Solar.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getIntradaySolar().add(intraday_Solar);
	}// End of prepare_Intraday_Solar_CeaData
	
	/**
	 * @author sanjeevkumar
	 * @Date 05-01-2024
	 * @Time 15:50 p.m.
	 * 
	 * It has been added as a new one
	 * 
	 * @param apiJsonInput
	 * @param pxCeaDataCommaSeparatedEntity
	 */
	IntradayNonSolar intraday_Non_Solar = null;
	protected void prepare_Intraday_Non_Solar_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {	
		intraday_Non_Solar = new IntradayNonSolar();
		intraday_Non_Solar.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		intraday_Non_Solar.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		intraday_Non_Solar.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		intraday_Non_Solar.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		intraday_Non_Solar.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		intraday_Non_Solar.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		intraday_Non_Solar.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getIntradayNonSolar().add(intraday_Non_Solar);
	}// End of prepare_Intraday_Non_Solar_CeaData
	
	
	/**
	 * @author sanjeevkumar
	 * @Date 05-01-2024
	 * @Time 15:50 p.m.
	 * 
	 * It has been added as a new one
	 * 
	 * @param apiJsonInput
	 * @param pxCeaDataCommaSeparatedEntity
	 */
	IntradayHydro intraday_Hydro =null;
	protected void prepare_Intraday_Hydro_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {	
		intraday_Hydro = new IntradayHydro();
		intraday_Hydro.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		intraday_Hydro.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		intraday_Hydro.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		intraday_Hydro.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		intraday_Hydro.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		intraday_Hydro.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		intraday_Hydro.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getIntradayHydro().add(intraday_Hydro);
	}// End of prepare_Intraday_Hydro_CeaData
	
	Tam tAM = null;
	protected void prepare_TAM_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		tAM = new Tam();
		tAM.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		tAM.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		tAM.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		tAM.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		tAM.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		tAM.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		tAM.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		apiJsonInput.getPxil().getTam().add(tAM);
	}// End of prepare_TAM_CeaData
	
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	TAMMonthly tAMMonthly = null;
	protected void prepare_TAMMonthly_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		tAMMonthly = new TAMMonthly();
		tAMMonthly.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		tAMMonthly.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		tAMMonthly.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		tAMMonthly.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		tAMMonthly.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		tAMMonthly.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		tAMMonthly.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getTAMMonthly().add(tAMMonthly);
	}// End of prepare_TAMMonthly_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	TAMDaily tAMDaily = null;
	protected void prepare_TAMDaily_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		tAMDaily = new TAMDaily();
		tAMDaily.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		tAMDaily.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		tAMDaily.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		tAMDaily.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		tAMDaily.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		tAMDaily.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		tAMDaily.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getTAMDaily().add(tAMDaily);
	}// End of prepare_TAMDaily_CeaData
	
	
	
	
	
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	TAMWeekly tAMWeekly = null;
	protected void prepare_TAMWeekly_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		tAMWeekly = new TAMWeekly();
		tAMWeekly.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		tAMWeekly.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		tAMWeekly.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		tAMWeekly.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		tAMWeekly.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		tAMWeekly.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		tAMWeekly.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getTAMWeekly().add(tAMWeekly);
	}// End of prepare_TAMWeekly_CeaData
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param ceaDataEntityList
	 *  @return
	 */

	TamAds tamAds = null;
	protected void prepare_TamAds_CeaData(ApiJsonInput apiJsonInput,PxCeaDataCommaSeparated pxCeaDataCommaSeparatedEntity) {
		tamAds = new TamAds();
		tamAds.setDate(getStrDateFromJavaDate(pxCeaDataCommaSeparatedEntity.getDate(), dateFormatUsed));
		tamAds.setMcv(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcv()));
		tamAds.setMcp(getListOfDouble(pxCeaDataCommaSeparatedEntity.getMcp()));
		tamAds.setCongestion(getListOfDouble(pxCeaDataCommaSeparatedEntity.getCongestion()));
		tamAds.setClearedVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getClearedVolume()));
		tamAds.setRealTimeCurtailment(getListOfDouble(pxCeaDataCommaSeparatedEntity.getRealTimeCurtailment()));
		tamAds.setFinalScheduleVolume(getListOfDouble(pxCeaDataCommaSeparatedEntity.getFinalScheduledVolume()));
		//apiJsonInput.getPxil().getTamAdss().add(tamAds);
	}// End of prepare_TamAds_CeaData

}// End of PxCeaDataCommaSeparatedService
