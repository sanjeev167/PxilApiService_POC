/**
 * 
 */
package com.pxil.pvt.sldc.ctrl;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pxil.exception.NotFoundInDBException;
import com.pxil.pvt.payload.SldcPayload;
import com.pxil.pvt.sldc.service.SldcScheduledReportService;
import com.pxil.sec.ctrl.ApiBaseCtrl;

/**
 * @author sanjeevkumar
 * 07-Jan-2024
 * 10:46:19 pm
 * Objective : 
 */

@RestController
@RequestMapping("/pvt/v1/sldc")
public class SldcScheduledReportCtr extends ApiBaseCtrl {
	
	private static final Logger logger = LoggerFactory.getLogger(SldcScheduledReportCtr.class);
	
	@Autowired
	SldcScheduledReportService sldcScheduledReportService;
	
	@PostMapping(value = "/getSldcScheduledReport",produces="application/json",consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SLDC')")
	public ResponseEntity<Object> getSldcScheduledReport( @Valid @RequestBody SldcPayload sldcPayload)  throws Exception {	
		resObj=null;
    	apiReq = makeApiMetaData();	
		apiReq.setPayLoad(sldcPayload);		
		sldcPayload.setGridNodeCode(gridNodeCode);
		sldcPayload.setApiUser(apiUser);
		
		if(sldcPayload.getProductCode().contains("RTM"))			
		    resObj = sldcScheduledReportService.getSldcScheduledReportForRtm(sldcPayload);		
		else			
			resObj = sldcScheduledReportService.getSldcScheduledReportForIdas(sldcPayload);
		
		if(resObj == null) {				
			throw new NotFoundInDBException("Resource-Not-Found-In-DB!");			
		}else {	
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(resObj,apiReq);					
			return ResponseEntity.ok().body(apiResponse);
		}		
	}// End of getSldcScheduledIdasReport

}//End of WbSldcScheduledIdasReportCtr
