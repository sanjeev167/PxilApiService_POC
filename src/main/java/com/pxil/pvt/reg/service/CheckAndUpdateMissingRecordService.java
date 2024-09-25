/**
 * 
 */
package com.pxil.pvt.reg.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.pxil.api.utils.ApiUtils;
import com.pxil.pvt.reg.jpojo.AcpDam;
import com.pxil.pvt.reg.jpojo.AcpGdam;
import com.pxil.pvt.reg.jpojo.AcpHpdam;
import com.pxil.pvt.reg.jpojo.AcpRtm;
import com.pxil.pvt.reg.jpojo.ApiJsonInput;
import com.pxil.pvt.reg.jpojo.Dac;
import com.pxil.pvt.reg.jpojo.Dam;
import com.pxil.pvt.reg.jpojo.GTAMHydroADS;
import com.pxil.pvt.reg.jpojo.GTAMHydroDaily;
import com.pxil.pvt.reg.jpojo.GTAMHydroMonthly;
import com.pxil.pvt.reg.jpojo.GTAMHydroWeekly;
import com.pxil.pvt.reg.jpojo.GTAMNonSolarADS;
import com.pxil.pvt.reg.jpojo.GTAMNonSolarDaily;
import com.pxil.pvt.reg.jpojo.GTAMNonSolarMonthly;
import com.pxil.pvt.reg.jpojo.GTAMNonSolarWeekly;
import com.pxil.pvt.reg.jpojo.GTAMSolarADS;
import com.pxil.pvt.reg.jpojo.GTAMSolarDaily;
import com.pxil.pvt.reg.jpojo.GTAMSolarMonthly;
import com.pxil.pvt.reg.jpojo.GTAMSolarWeekly;
import com.pxil.pvt.reg.jpojo.Gdam;
import com.pxil.pvt.reg.jpojo.Hpdam;
import com.pxil.pvt.reg.jpojo.Intraday;
import com.pxil.pvt.reg.jpojo.Rtm;
import com.pxil.pvt.reg.jpojo.TAMDaily;
import com.pxil.pvt.reg.jpojo.TAMMonthly;
import com.pxil.pvt.reg.jpojo.TAMWeekly;
import com.pxil.pvt.reg.jpojo.TamAds;

/**
 * @author sanjeevkumar 
 * 21-Dec-2023 
 * 3:35:28 pm 
 * Objective :
 */
public class CheckAndUpdateMissingRecordService extends ApiUtils{

	protected String dateFormatUsed = "dd-MM-yyyy";
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecords(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputWithCeaAndApc) {

		// #################################################################//
		// ######## checkAndUpdateMissingDayRecordsFor CEA items ###########//
		// #################################################################//

		checkAndUpdateMissingDayRecordsForDac(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [1]DAC
		checkAndUpdateMissingDayRecordsForDam(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [2]DAM
		checkAndUpdateMissingDayRecordsForGTAM_Hydro_ADSS(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [3]GTAM_Hydro_ADSS
		checkAndUpdateMissingDayRecordsForGTAM_Hydro_Daily(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [4]GTAM_Hydro_Daily
		checkAndUpdateMissingDayRecordsForGTAM_Hydro_Monthly(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [5]GTAM_Hydro_Monthly
		checkAndUpdateMissingDayRecordsForGTAM_Hydro_Weekly(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [6]GTAM_Hydro_Weekly

		checkAndUpdateMissingDayRecordsForGTAM_Non_Solar_ADSS(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [7]GTAM_Non_Solar_ADSS
		checkAndUpdateMissingDayRecordsForGTAM_Non_Solar_Daily(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [8]GTAM_Non_Solar_Daily
		checkAndUpdateMissingDayRecordsForGTAM_Non_Solar_Monthly(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [9]GTAM_Non_Solar_Monthly
		checkAndUpdateMissingDayRecordsForGTAM_Non_Solar_Weekly(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [10]GTAM_Non_Solar_Weekly

		checkAndUpdateMissingDayRecordsForGTAM_Solar_ADSS(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [11]GTAM_Solar_ADSS
		checkAndUpdateMissingDayRecordsForGTAM_Solar_Daily(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [12]GTAM_Solar_Daily
		checkAndUpdateMissingDayRecordsForGTAM_Solar_Monthly(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [13]GTAM_Solar_Monthly
		checkAndUpdateMissingDayRecordsForGTAM_Solar_Weekly(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [14]GTAM_Solar_Weekly

		checkAndUpdateMissingDayRecordsForGDAM(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [15]GDAM
		checkAndUpdateMissingDayRecordsForHPDAM(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [16]HPDAM
		checkAndUpdateMissingDayRecordsForINTRADAY(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [17]INTRADAY
		checkAndUpdateMissingDayRecordsForRTM(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [18]RTM

		checkAndUpdateMissingDayRecordsForTAM_Daily(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [19]TAM_Daily
		checkAndUpdateMissingDayRecordsForTAM_Monthly(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [20]TAM_Monthly
		checkAndUpdateMissingDayRecordsForTAM_Weekly(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [21]TAM_Weekly
		checkAndUpdateMissingDayRecordsForTAM_ADSS(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [22]TAM_ADSS

		// #################################################################//
		// ######## checkAndUpdateMissingDayRecordsFor ACP items ###########//
		// #################################################################//

		checkAndUpdateMissingDayRecordsForACP_DAM(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [23]ACP_DAM
		checkAndUpdateMissingDayRecordsForACP_GDAM(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [24]ACP_GDAM
		checkAndUpdateMissingDayRecordsForACP_HPDAM(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [25]ACP_HPDAM
		checkAndUpdateMissingDayRecordsForACP_RTM(localFromDate, localToDate, apiJsonInputWithCeaAndApc);// [26]ACP_RTM

	}
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForDac(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<Dac> dacList = null;//apiJsonInputsetCeaAndApc.getPxil().getDac(); It is not available in Pxil now
		System.out.println("dacList size =>" + dacList.size() + "  " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<Dac> dacListOP = new ArrayList<Dac>();
		Dac dac = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {

			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (Dac dacItem : dacList) {
				if (dacItem.getDate().equals(localDateAsString)) {
					dacListOP.add(dacItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				dac = new Dac();
				dac.setDate(localDateAsString);
				dacListOP.add(dac);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setDac(dacListOP);

	}// End of checkAndUpdateMissingDayRecordsForDac
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForDam(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<Dam> damList = apiJsonInputsetCeaAndApc.getPxil().getDam();
		// System.out.println("damList size =>" + damList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<Dam> damListOP = new ArrayList<Dam>();
		Dam dam = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {

			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (Dam damItem : damList) {
				if (damItem.getDate().equals(localDateAsString)) {
					damListOP.add(damItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				dam = new Dam();
				dam.setDate(localDateAsString);
				damListOP.add(dam);
			}
		} // End ofDate-based loop

		apiJsonInputsetCeaAndApc.getPxil().setDam(damListOP);

	}// End of checkAndUpdateMissingDayRecordsForDam
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGTAM_Hydro_ADSS(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<GTAMHydroADS> gTAMHydroADSList = null;//apiJsonInputsetCeaAndApc.getPxil().getGTAMHydroADSS();It is not available in Pxil now
		// System.out.println("gTAMHydroADSList size =>" + gTAMHydroADSList.size() + " "
		// + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<GTAMHydroADS> gTAMHydroADSListOP = new ArrayList<GTAMHydroADS>();
		GTAMHydroADS gTAMHydroADS = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {

			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (GTAMHydroADS gTAMHydroADSItem : gTAMHydroADSList) {
				if (gTAMHydroADSItem.getDate().equals(localDateAsString)) {
					gTAMHydroADSListOP.add(gTAMHydroADSItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gTAMHydroADS = new GTAMHydroADS();
				gTAMHydroADS.setDate(localDateAsString);
				gTAMHydroADSListOP.add(gTAMHydroADS);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setGTAMHydroADSS(gTAMHydroADSListOP);

	}// End of checkAndUpdateMissingDayRecordsForGTAM_Hydro_ADSS
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGTAM_Hydro_Daily(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<GTAMHydroDaily> gTAMHydroDailyList = null;//apiJsonInputsetCeaAndApc.getPxil().getGTAMHydroDaily();It is not available in Pxil now
		// System.out.println("gTAMHydroDailyList size =>" + gTAMHydroDailyList.size() +
		// " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<GTAMHydroDaily> gTAMHydroDailyListOP = new ArrayList<GTAMHydroDaily>();
		GTAMHydroDaily gTAMHydroDaily = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {

			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (GTAMHydroDaily gTAMHydroDailyItem : gTAMHydroDailyList) {
				if (gTAMHydroDailyItem.getDate().equals(localDateAsString)) {
					gTAMHydroDailyListOP.add(gTAMHydroDailyItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gTAMHydroDaily = new GTAMHydroDaily();
				gTAMHydroDaily.setDate(localDateAsString);
				gTAMHydroDailyListOP.add(gTAMHydroDaily);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setGTAMHydroDaily(gTAMHydroDailyListOP);

	}// End of checkAndUpdateMissingDayRecordsForGTAM_Hydro_Daily
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGTAM_Hydro_Monthly(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<GTAMHydroMonthly> gTAMHydroMonthlyList = null;//apiJsonInputsetCeaAndApc.getPxil().getGTAMHydroMonthly();It is not available in Pxil now
		// System.out.println("gTAMHydroMonthlyList size =>" +
		// gTAMHydroMonthlyList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<GTAMHydroMonthly> gTAMHydroMonthlyListOP = new ArrayList<GTAMHydroMonthly>();
		GTAMHydroMonthly gTAMHydroMonthly = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {

			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (GTAMHydroMonthly gTAMHydroMonthlyItem : gTAMHydroMonthlyList) {
				if (gTAMHydroMonthlyItem.getDate().equals(localDateAsString)) {
					gTAMHydroMonthlyListOP.add(gTAMHydroMonthlyItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gTAMHydroMonthly = new GTAMHydroMonthly();
				gTAMHydroMonthly.setDate(localDateAsString);
				gTAMHydroMonthlyListOP.add(gTAMHydroMonthly);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setGTAMHydroMonthly(gTAMHydroMonthlyListOP);

	}// End of checkAndUpdateMissingDayRecordsForGTAM_Hydro_Monthly
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGTAM_Hydro_Weekly(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<GTAMHydroWeekly> gTAMHydroWeeklyList = null;//apiJsonInputsetCeaAndApc.getPxil().getGTAMHydroWeekly();It is not available in Pxil now
		// System.out.println("gTAMHydroWeeklyList size =>" + gTAMHydroWeeklyList.size()
		// + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<GTAMHydroWeekly> gTAMHydroWeeklyListOP = new ArrayList<GTAMHydroWeekly>();
		GTAMHydroWeekly gTAMHydroWeekly = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {

			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (GTAMHydroWeekly gTAMHydroWeeklyItem : gTAMHydroWeeklyList) {
				if (gTAMHydroWeeklyItem.getDate().equals(localDateAsString)) {
					gTAMHydroWeeklyListOP.add(gTAMHydroWeeklyItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gTAMHydroWeekly = new GTAMHydroWeekly();
				gTAMHydroWeekly.setDate(localDateAsString);
				gTAMHydroWeeklyListOP.add(gTAMHydroWeekly);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setGTAMHydroWeekly(gTAMHydroWeeklyListOP);

	}// End of checkAndUpdateMissingDayRecordsForGTAM_Hydro_Weekly
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGTAM_Non_Solar_ADSS(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<GTAMNonSolarADS> gTAMNonSolarADSList = null;//apiJsonInputsetCeaAndApc.getPxil().getGTAMNonSolarADSS();
		// System.out.println("gTAMNonSolarADSList size =>" + gTAMNonSolarADSList.size()
		// + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<GTAMNonSolarADS> gTAMNonSolarADSListOP = new ArrayList<GTAMNonSolarADS>();
		GTAMNonSolarADS gTAMNonSolarADS = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {

			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (GTAMNonSolarADS gTAMNonSolarADSItem : gTAMNonSolarADSList) {
				if (gTAMNonSolarADSItem.getDate().equals(localDateAsString)) {
					gTAMNonSolarADSListOP.add(gTAMNonSolarADSItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gTAMNonSolarADS = new GTAMNonSolarADS();
				gTAMNonSolarADS.setDate(localDateAsString);
				gTAMNonSolarADSListOP.add(gTAMNonSolarADS);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setGTAMNonSolarADSS(gTAMNonSolarADSListOP);

	}// End of checkAndUpdateMissingDayRecordsForGTAM_Non_Solar_ADSS
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGTAM_Non_Solar_Daily(LocalDate localFromDate,
			LocalDate localToDate, ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<GTAMNonSolarDaily> gTAMNonSolarDailyList = null;//apiJsonInputsetCeaAndApc.getPxil().getGTAMNonSolarDaily();It is not available in Pxil now
		// System.out.println("gTAMNonSolarDailyList size =>" +
		// gTAMNonSolarDailyList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<GTAMNonSolarDaily> gTAMNonSolarDailyListOP = new ArrayList<GTAMNonSolarDaily>();
		GTAMNonSolarDaily gTAMNonSolarDaily = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {

			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (GTAMNonSolarDaily gTAMNonSolarDailyItem : gTAMNonSolarDailyList) {
				if (gTAMNonSolarDailyItem.getDate().equals(localDateAsString)) {
					gTAMNonSolarDailyListOP.add(gTAMNonSolarDailyItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gTAMNonSolarDaily = new GTAMNonSolarDaily();
				gTAMNonSolarDaily.setDate(localDateAsString);
				gTAMNonSolarDailyListOP.add(gTAMNonSolarDaily);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setGTAMNonSolarDaily(gTAMNonSolarDailyListOP);

	}// End of checkAndUpdateMissingDayRecordsForGTAM_Non_Solar_Daily
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGTAM_Non_Solar_Monthly(LocalDate localFromDate,
			LocalDate localToDate, ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<GTAMNonSolarMonthly> gTAMNonSolarMonthlyList = null;//apiJsonInputsetCeaAndApc.getPxil().getGTAMNonSolarMonthly();
		// System.out.println("gTAMNonSolarMonthlyList size =>" +
		// gTAMNonSolarMonthlyList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<GTAMNonSolarMonthly> gTAMNonSolarMonthlyListOP = new ArrayList<GTAMNonSolarMonthly>();
		GTAMNonSolarMonthly gTAMNonSolarMonthly = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (GTAMNonSolarMonthly gTAMNonSolarMonthlyItem : gTAMNonSolarMonthlyList) {
				if (gTAMNonSolarMonthlyItem.getDate().equals(localDateAsString)) {
					gTAMNonSolarMonthlyListOP.add(gTAMNonSolarMonthlyItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gTAMNonSolarMonthly = new GTAMNonSolarMonthly();
				gTAMNonSolarMonthly.setDate(localDateAsString);
				gTAMNonSolarMonthlyListOP.add(gTAMNonSolarMonthly);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setGTAMNonSolarMonthly(gTAMNonSolarMonthlyListOP);

	}// End of checkAndUpdateMissingDayRecordsForGTAM_Non_Solar_Monthly
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGTAM_Non_Solar_Weekly(LocalDate localFromDate,
			LocalDate localToDate, ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<GTAMNonSolarWeekly> gTAMNonSolarWeeklyList = null;//apiJsonInputsetCeaAndApc.getPxil().getGTAMNonSolarWeekly();
		// System.out.println("gTAMNonSolarMonthlyList size =>" +
		// gTAMNonSolarMonthlyList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<GTAMNonSolarWeekly> gTAMNonSolarWeeklyListOP = new ArrayList<GTAMNonSolarWeekly>();
		GTAMNonSolarWeekly gTAMNonSolarWeekly = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (GTAMNonSolarWeekly gTAMNonSolarWeeklyItem : gTAMNonSolarWeeklyList) {
				if (gTAMNonSolarWeeklyItem.getDate().equals(localDateAsString)) {
					gTAMNonSolarWeeklyListOP.add(gTAMNonSolarWeeklyItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gTAMNonSolarWeekly = new GTAMNonSolarWeekly();
				gTAMNonSolarWeekly.setDate(localDateAsString);
				gTAMNonSolarWeeklyListOP.add(gTAMNonSolarWeekly);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setGTAMNonSolarWeekly(gTAMNonSolarWeeklyListOP);

	}// End of checkAndUpdateMissingDayRecordsForGTAM_Non_Solar_Weekly
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGTAM_Solar_ADSS(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<GTAMSolarADS> gTAMSolarADSList = null;//apiJsonInputsetCeaAndApc.getPxil().getGTAMSolarADSS();
		// System.out.println("gTAMSolarDailyList size =>" + gTAMSolarDailyList.size() +
		// " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<GTAMSolarADS> gTAMSolarADSListOP = new ArrayList<GTAMSolarADS>();
		GTAMSolarADS gTAMSolarADS = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (GTAMSolarADS gTAMSolarADSItem : gTAMSolarADSList) {
				if (gTAMSolarADSItem.getDate().equals(localDateAsString)) {
					gTAMSolarADSListOP.add(gTAMSolarADSItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gTAMSolarADS = new GTAMSolarADS();
				gTAMSolarADS.setDate(localDateAsString);
				gTAMSolarADSListOP.add(gTAMSolarADS);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setGTAMSolarADSS(gTAMSolarADSListOP);

	}// End of checkAndUpdateMissingDayRecordsForGTAM_Solar_ADSS
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGTAM_Solar_Daily(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<GTAMSolarDaily> gTAMSolarDailyList = null;//apiJsonInputsetCeaAndApc.getPxil().getGTAMSolarDaily();
		// System.out.println("gTAMSolarDailyList size =>" + gTAMSolarDailyList.size() +
		// " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<GTAMSolarDaily> gTAMSolarDailyListOP = new ArrayList<GTAMSolarDaily>();
		GTAMSolarDaily gTAMSolarDaily = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (GTAMSolarDaily gTAMSolarDailyItem : gTAMSolarDailyList) {
				if (gTAMSolarDailyItem.getDate().equals(localDateAsString)) {
					gTAMSolarDailyListOP.add(gTAMSolarDailyItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gTAMSolarDaily = new GTAMSolarDaily();
				gTAMSolarDaily.setDate(localDateAsString);
				gTAMSolarDailyListOP.add(gTAMSolarDaily);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setGTAMSolarDaily(gTAMSolarDailyListOP);

	}// End of checkAndUpdateMissingDayRecordsForGTAM_Solar_Daily
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGTAM_Solar_Monthly(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<GTAMSolarMonthly> gTAMSolarMonthlyList = null;//apiJsonInputsetCeaAndApc.getPxil().getGTAMSolarMonthly();
		// System.out.println("gTAMSolarMonthlyList size =>" +
		// gTAMSolarMonthlyList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<GTAMSolarMonthly> gTAMSolarMonthlyListOP = new ArrayList<GTAMSolarMonthly>();
		GTAMSolarMonthly gTAMSolarMonthly = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (GTAMSolarMonthly gTAMSolarMonthlyItem : gTAMSolarMonthlyList) {
				if (gTAMSolarMonthlyItem.getDate().equals(localDateAsString)) {
					gTAMSolarMonthlyListOP.add(gTAMSolarMonthlyItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gTAMSolarMonthly = new GTAMSolarMonthly();
				gTAMSolarMonthly.setDate(localDateAsString);
				gTAMSolarMonthlyListOP.add(gTAMSolarMonthly);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setGTAMSolarMonthly(gTAMSolarMonthlyListOP);

	}// End of checkAndUpdateMissingDayRecordsForGTAM_Solar_Monthly
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGTAM_Solar_Weekly(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<GTAMSolarWeekly> gTAMSolarWeeklyList = null;//apiJsonInputsetCeaAndApc.getPxil().getGTAMSolarWeekly();
		// System.out.println("gTAMSolarMonthlyList size =>" +
		// gTAMSolarMonthlyList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<GTAMSolarWeekly> gTAMSolarWeeklyListOP = new ArrayList<GTAMSolarWeekly>();
		GTAMSolarWeekly gTAMSolarWeekly = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (GTAMSolarWeekly gTAMSolarWeeklyItem : gTAMSolarWeeklyList) {
				if (gTAMSolarWeeklyItem.getDate().equals(localDateAsString)) {
					gTAMSolarWeeklyListOP.add(gTAMSolarWeeklyItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gTAMSolarWeekly = new GTAMSolarWeekly();
				gTAMSolarWeekly.setDate(localDateAsString);
				gTAMSolarWeeklyListOP.add(gTAMSolarWeekly);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setGTAMSolarWeekly(gTAMSolarWeeklyListOP);

	}// End of checkAndUpdateMissingDayRecordsForGTAM_Solar_Weekly
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForGDAM(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<Gdam> gdamList = apiJsonInputsetCeaAndApc.getPxil().getGdam();
		// System.out.println("gdamList size =>" + gdamList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<Gdam> gdamListOP = new ArrayList<Gdam>();
		Gdam gdam = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (Gdam gdamItem : gdamList) {
				if (gdamItem.getDate().equals(localDateAsString)) {
					gdamListOP.add(gdamItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				gdam = new Gdam();
				gdam.setDate(localDateAsString);
				gdamListOP.add(gdam);
			}
		} // End ofDate-based loop

		apiJsonInputsetCeaAndApc.getPxil().setGdam(gdamListOP);

	}// End of checkAndUpdateMissingDayRecordsForGDAM
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForHPDAM(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<Hpdam> hpdamList = apiJsonInputsetCeaAndApc.getPxil().getHpdam();
		// System.out.println("hpdamList size =>" + hpdamList.size() + " " +
		// localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<Hpdam> hpdamListOP = new ArrayList<Hpdam>();
		Hpdam hpdam = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (Hpdam hpdamItem : hpdamList) {
				if (hpdamItem.getDate().equals(localDateAsString)) {
					hpdamListOP.add(hpdamItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				hpdam = new Hpdam();
				hpdam.setDate(localDateAsString);
				hpdamListOP.add(hpdam);
			}
		} // End ofDate-based loop

		apiJsonInputsetCeaAndApc.getPxil().setHpdam(hpdamListOP);

	}// End of checkAndUpdateMissingDayRecordsForHPDAM
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForINTRADAY(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<Intraday> intradayList = null;//apiJsonInputsetCeaAndApc.getPxil().getIntraday();
		// System.out.println("intradayList size =>" + intradayList.size() + " " +
		// localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<Intraday> intradayListOP = new ArrayList<Intraday>();
		Intraday intraday = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (Intraday intradayItem : intradayList) {
				if (intradayItem.getDate().equals(localDateAsString)) {
					intradayListOP.add(intradayItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				intraday = new Intraday();
				intraday.setDate(localDateAsString);
				intradayListOP.add(intraday);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setIntraday(intradayListOP);

	}// End of checkAndUpdateMissingDayRecordsForINTRADAY
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForTAM_Daily(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<TAMDaily> tAMDailyList = null;//apiJsonInputsetCeaAndApc.getPxil().getTAMDaily();
		// System.out.println("intradayList size =>" + intradayList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<TAMDaily> tAMDailyListOP = new ArrayList<TAMDaily>();
		TAMDaily tAMDaily = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (TAMDaily tAMDailyItem : tAMDailyList) {
				if (tAMDailyItem.getDate().equals(localDateAsString)) {
					tAMDailyListOP.add(tAMDailyItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				tAMDaily = new TAMDaily();
				tAMDaily.setDate(localDateAsString);
				tAMDailyListOP.add(tAMDaily);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setTAMDaily(tAMDailyListOP);

	}// End of checkAndUpdateMissingDayRecordsForTAM_Daily
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForTAM_Monthly(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<TAMMonthly> tAMMonthlyList = null;//apiJsonInputsetCeaAndApc.getPxil().getTAMMonthly();
		// System.out.println("tAMMonthlyList size =>" + tAMMonthlyList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<TAMMonthly> tAMMonthlyListOP = new ArrayList<TAMMonthly>();
		TAMMonthly tAMMonthly = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (TAMMonthly tAMMonthlyItem : tAMMonthlyList) {
				if (tAMMonthlyItem.getDate().equals(localDateAsString)) {
					tAMMonthlyListOP.add(tAMMonthlyItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				tAMMonthly = new TAMMonthly();
				tAMMonthly.setDate(localDateAsString);
				tAMMonthlyListOP.add(tAMMonthly);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setTAMMonthly(tAMMonthlyListOP);

	}// End of checkAndUpdateMissingDayRecordsForTAM_Monthly
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */

	protected void checkAndUpdateMissingDayRecordsForTAM_Weekly(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<TAMWeekly> tAMWeeklyList = null;//apiJsonInputsetCeaAndApc.getPxil().getTAMWeekly();
		// System.out.println("tAMWeeklyList size =>" + tAMWeeklyList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<TAMWeekly> tAMWeeklyListOP = new ArrayList<TAMWeekly>();
		TAMWeekly tAMWeekly = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (TAMWeekly tAMWeeklyItem : tAMWeeklyList) {
				if (tAMWeeklyItem.getDate().equals(localDateAsString)) {
					tAMWeeklyListOP.add(tAMWeeklyItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				tAMWeekly = new TAMWeekly();
				tAMWeekly.setDate(localDateAsString);
				tAMWeeklyListOP.add(tAMWeekly);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setTAMWeekly(tAMWeeklyListOP);

	}// End of checkAndUpdateMissingDayRecordsForTAM_Weekly
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */
	protected void checkAndUpdateMissingDayRecordsForTAM_ADSS(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<TamAds> tamAdsList = null;//apiJsonInputsetCeaAndApc.getPxil().getTamAdss();
		// System.out.println("tamAdsList size =>" + tamAdsList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<TamAds> tamAdsListOP = new ArrayList<TamAds>();
		TamAds tamAds = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (TamAds tamAdsItem : tamAdsList) {
				if (tamAdsItem.getDate().equals(localDateAsString)) {
					tamAdsListOP.add(tamAdsItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				tamAds = new TamAds();
				tamAds.setDate(localDateAsString);
				tamAdsListOP.add(tamAds);
			}
		} // End ofDate-based loop

		//apiJsonInputsetCeaAndApc.getPxil().setTamAdss(tamAdsListOP);

	}// End of checkAndUpdateMissingDayRecordsForTAM_ADSS
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */
	protected void checkAndUpdateMissingDayRecordsForRTM(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<Rtm> rtmList = apiJsonInputsetCeaAndApc.getPxil().getRtm();
		// System.out.println("rtmList size =>" + rtmList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<Rtm> rtmListOP = new ArrayList<Rtm>();
		Rtm rtm = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (Rtm rtmItem : rtmList) {
				if (rtmItem.getDate().equals(localDateAsString)) {
					rtmListOP.add(rtmItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				rtm = new Rtm();
				rtm.setDate(localDateAsString);
				rtmListOP.add(rtm);
			}
		} // End ofDate-based loop
		apiJsonInputsetCeaAndApc.getPxil().setRtm(rtmListOP);

	}// End of checkAndUpdateMissingDayRecordsForRTM
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */
	protected void checkAndUpdateMissingDayRecordsForACP_DAM(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<AcpDam> acpDamList = apiJsonInputsetCeaAndApc.getPxil().getAcpDam();
		// System.out.println("acpDamList size =>" + acpDamList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<AcpDam> acpDamListOP = new ArrayList<AcpDam>();
		AcpDam acpDam = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (AcpDam acpDamItem : acpDamList) {
				if (acpDamItem.getDate().equals(localDateAsString)) {
					acpDamListOP.add(acpDamItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				acpDam = new AcpDam();
				acpDam.setDate(localDateAsString);
				acpDamListOP.add(acpDam);
			}
		} // End ofDate-based loop
		apiJsonInputsetCeaAndApc.getPxil().setAcpDam(acpDamListOP);

	}// End of checkAndUpdateMissingDayRecordsForACP_DAM
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */
	protected void checkAndUpdateMissingDayRecordsForACP_GDAM(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<AcpGdam> acpGdamList = apiJsonInputsetCeaAndApc.getPxil().getAcpGdam();
		// System.out.println("acpGdamList size =>" + acpGdamList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<AcpGdam> acpGdamListOP = new ArrayList<AcpGdam>();
		AcpGdam acpGdam = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (AcpGdam acpGdamItem : acpGdamList) {
				if (acpGdamItem.getDate().equals(localDateAsString)) {
					acpGdamListOP.add(acpGdamItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				acpGdam = new AcpGdam();
				acpGdam.setDate(localDateAsString);
				acpGdamListOP.add(acpGdam);
			}
		} // End ofDate-based loop
		apiJsonInputsetCeaAndApc.getPxil().setAcpGdam(acpGdamListOP);

	}// End of checkAndUpdateMissingDayRecordsForACP_GDAM
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */
	protected void checkAndUpdateMissingDayRecordsForACP_HPDAM(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<AcpHpdam> acpHpdamList = null;//apiJsonInputsetCeaAndApc.getPxil().getAcpHpdam();
		// System.out.println("acpHpdamList size =>" + acpHpdamList.size() + " " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<AcpHpdam> acpHpdamListOP = new ArrayList<AcpHpdam>();
		AcpHpdam acpHpdam = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (AcpHpdam acpHpdamItem : acpHpdamList) {
				if (acpHpdamItem.getDate().equals(localDateAsString)) {
					acpHpdamListOP.add(acpHpdamItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				acpHpdam = new AcpHpdam();
				acpHpdam.setDate(localDateAsString);
				acpHpdamListOP.add(acpHpdam);
			}
		} // End ofDate-based loop
		//apiJsonInputsetCeaAndApc.getPxil().setAcpHpdam(acpHpdamListOP);

	}// End of checkAndUpdateMissingDayRecordsForACP_HPDAM
	/**
	 * @author sanjeevkumar 
     *  12-Dec-2023 
     *  2:41:39 pm 
     *  Objective :
	 *  @param 
	 *  @return
	 */
	protected void checkAndUpdateMissingDayRecordsForACP_RTM(LocalDate localFromDate, LocalDate localToDate,
			ApiJsonInput apiJsonInputsetCeaAndApc) {
		List<AcpRtm> acpRtmList = apiJsonInputsetCeaAndApc.getPxil().getAcpRtm();
		System.out.println("acpRtmList size =>" + acpRtmList.size() + "  " + localToDate);
		boolean recordOfThisDateIsFound = false;
		String localDateAsString = null;
		List<AcpRtm> acpRtmListOP = new ArrayList<AcpRtm>();
		AcpRtm acpRtm = null;
		for (LocalDate localDate = localFromDate; localDate.isBefore(localToDate)
				|| localDate.isEqual(localToDate); localDate = localDate.plusDays(1)) {
			localDateAsString = getStrDateFromLocalDate(localDate, dateFormatUsed);
			recordOfThisDateIsFound = false;
			for (AcpRtm acpRtmItem : acpRtmList) {
				if (acpRtmItem.getDate().equals(localDateAsString)) {
					acpRtmListOP.add(acpRtmItem);
					recordOfThisDateIsFound = true;
					break;
				}
			} // End of Inner loop
			if (!recordOfThisDateIsFound) {
				acpRtm = new AcpRtm();
				acpRtm.setDate(localDateAsString);
				acpRtmListOP.add(acpRtm);
			}
		} // End ofDate-based loop
		apiJsonInputsetCeaAndApc.getPxil().setAcpRtm(acpRtmListOP);

	}// End of checkAndUpdateMissingDayRecordsForACP_RTM

}// End of CheckAndUpdateMissingRecordService
