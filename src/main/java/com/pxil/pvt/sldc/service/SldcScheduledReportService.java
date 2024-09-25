/**
 * 
 */
package com.pxil.pvt.sldc.service;

import java.text.ParseException;

import com.pxil.pvt.payload.SldcPayload;

/**
 * @author sanjeevkumar
 * 07-Jan-2024
 * 10:31:18 pm 
 * Objective : 
 */
public interface SldcScheduledReportService {
	
	//Don't remove inline declaration of ApiJsonInput. Both are coming from different packages and it is required for meeting the requirement
	public com.pxil.pvt.sldc.jpojo.idas.ApiJsonInput getSldcScheduledReportForIdas(SldcPayload SldcPayload)throws Exception;	
	public com.pxil.pvt.sldc.jpojo.rtm.ApiJsonInput getSldcScheduledReportForRtm(SldcPayload SldcPayload) throws Exception;	
	
}//End of SldcScheduledReportService
