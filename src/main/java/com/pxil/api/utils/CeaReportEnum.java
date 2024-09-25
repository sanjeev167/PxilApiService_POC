/**
 * 
 */
package com.pxil.api.utils;

/**
 * @author sanjeevkumar
 * 10-Dec-2023
 * 12:34:15 am 
 * Objective : This CeaReportEnum will be used within a switch case where all the fetched CeaDataEntities will be organized as per CeaReportEnum in 
 * the corresponding list.
 */

public enum  CeaReportEnum {	
	
	//----------- DAS ----------
	DAM,//1
	RTM,//2
	GDAM,//3
	HPDAM,//4	
	
	//-- INTRADAY has been split into 4
	Intraday_Conventional,//5
	Intraday_Solar,//6
	Intraday_Non_Solar,//7
	Intraday_Hydro,//8	
	
	//-- DAC has been split into 4
	DAC_Conventional,//9
	DAC_Solar,//10
	DAC_Non_Solar,//11
	DAC_Hydro,//12	
	
	//--Grouped into one :-- TAM_Daily,//7 TAM_Weekly,//8 TAM_Monthly,//9 TAM_ADSS,//10
	TAM,//13	
	
	//--Grouped into one :-- GTAM_Solar_Daily,//11,GTAM_Solar_Weekly,//12,GTAM_Solar_Monthly,//13 GTAM_Solar_ADSS,//14
	GTAM_Solar,//14	
	
	//--Grouped into one :-- GTAM_Non_Solar_Daily,//15 GTAM_Non_Solar_Weekly,//16 GTAM_Non_Solar_Monthly,//17, GTAM_Non_Solar_ADSS,//18 ------------------
	GTAM_Non_Solar,//15	
	
	//--Grouped into one :-- GTAM_Hydro_Daily,//19 GTAM_Hydro_Weekly,//20 GTAM_Hydro_Monthly,//21 GTAM_Hydro_ADSS	//22
	GTAM_Hydro//16	
	
}//End of CeaReportEnum
