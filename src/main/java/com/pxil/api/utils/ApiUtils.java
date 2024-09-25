/**
 * 
 */
package com.pxil.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sanjeevkumar 21-Dec-2023 4:17:02 pm Objective :
 */
public class ApiUtils {
	protected String dateFormat = "dd-MM-yyyy";

	protected Date getJavaDateFromLocalDate(LocalDate localDate) {
		ZoneId defaultZoneId = ZoneId.systemDefault();// default time zone
		// local date + atStartOfDay() + default time zone + toInstant() = Date
		Date javaDate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		return javaDate;
	}

	protected List<Integer> getListOfInteger(String integerCommaSeparatedData) {
		List<Integer> convertedListOfInteger = Stream.of(integerCommaSeparatedData.split(",")).map(String::trim)
				.map(Integer::parseInt).collect(Collectors.toList());
		return convertedListOfInteger;
	}

	protected List<Double> getListOfDouble(String doubleCommaSeparatedData) {
		List<Double> convertedListOfDouble = null;
		if (doubleCommaSeparatedData != null && !doubleCommaSeparatedData.isEmpty()) {
			convertedListOfDouble = Stream.of(doubleCommaSeparatedData.split(",")).map(String::trim)
					.map(Double::parseDouble).collect(Collectors.toList());
		}
		return convertedListOfDouble;
	}

	public String getStrDateFromJavaDate(Date dateNow, String formatStyle) {
		// SimpleDateFormat dateformatJava = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateformatJava = new SimpleDateFormat(formatStyle);
		String date_to_string = dateformatJava.format(dateNow);
		return date_to_string;
	}

	protected String getStrDateFromLocalDate(LocalDate comingLocalDate, String formatStyle) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = comingLocalDate.format(dateTimeFormatter); // 17-02-2022
		return formattedDate;
	}

	public static Date getJavaDateFromStrigDate(String dateInString, String formatStyle) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(formatStyle);
		Date date = formatter.parse(dateInString);
		return date;
	}

	public static Date getJavaDateViaLocalDate(String dateInString, String formatStyle) {
		Date date =null;
		try {
		// default time zone
		ZoneId defaultZoneId = ZoneId.systemDefault();
		String dateInStringArr[] = dateInString.split("-");
		// creating the instance of LocalDate using the day, month, year info

		LocalDate localDate = LocalDate.of(Integer.parseInt(dateInStringArr[2]), Integer.parseInt(dateInStringArr[1]),
				Integer.parseInt(dateInStringArr[0]));

		// local date + atStartOfDay() + default time zone + toInstant() = Date
		 date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		// Displaying LocalDate and Date
		//System.out.println("LocalDate is: " + localDate);
		//System.out.println("Date is: " + date);
		return date;
		}catch(Exception ex ) {
			throw ex;
		}

		
	}

}// End of ApiUtils
