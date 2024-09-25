/**
 * 
 */
package com.pxil.api.utils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sanjeevkumar
 * 11-Dec-2023
 * 3:07:46 pm 
 * Objective : 
 */
public enum MonthEnum {
	
	//-----MONTH------
	
	January,//1
	February,//2
	March,//3
	April,//4
	May,//5
	Jun,//6
	July,//7
	August,//8
	September,//9
	October,//10
	November,//11
	December;//!2
	
	private static final Map<Integer, MonthEnum> lookup = new HashMap<Integer, MonthEnum>();

	  static {
	    int ordinal = 0;
	    for (MonthEnum month : EnumSet.allOf(MonthEnum.class)) {
	      lookup.put(ordinal, month);
	      ordinal+= 1;
	    }
	  }

	  public static MonthEnum fromOrdinal(int ordinal) {
	    return lookup.get(ordinal);
	  }
}//End of AcpReportEnum
