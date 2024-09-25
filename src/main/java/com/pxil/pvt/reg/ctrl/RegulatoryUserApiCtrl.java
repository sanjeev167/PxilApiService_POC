/**
 * 
 */
package com.pxil.pvt.reg.ctrl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pxil.api.utils.MonthEnum;
import com.pxil.exception.NotFoundInDBException;
import com.pxil.pvt.reg.service.PxCeaDataCommaSeparatedService;
import com.pxil.pvt.validation.MonthHistoryValidation;
import com.pxil.sec.ctrl.ApiBaseCtrl;

/**
 * @author sanjeevkumar 
 * 03-Dec-2023 
 * 10:21:13 pm 
 * Objective:
 */

@RestController
@RequestMapping("/pvt/v1/reg")
@Validated
public class RegulatoryUserApiCtrl extends ApiBaseCtrl{
	
	@Autowired
	PxCeaDataCommaSeparatedService regulatoryService;	
	
	@GetMapping(value = "/getMonthHist/{id}",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_REGULATORY')")
	public ResponseEntity<Object> getMonthHistory( @PathVariable("id")  @Valid @MonthHistoryValidation(historyMonth = 1) Integer historyMonth) {		
    	
		apiReq = makeApiMetaData();		
		MonthEnum monthEnum = MonthEnum.fromOrdinal(historyMonth - 1);
		apiReq.setPayLoad(monthEnum);
		resObj = regulatoryService.getMonthHistory(historyMonth);		
		if(resObj==null) {
			throw new NotFoundInDBException("Month-History with month-no :"+historyMonth+" Not Found!");			
		}else {
			 //Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(resObj,apiReq);		
			return ResponseEntity.ok().body(apiResponse);
		}	 
	}// End of getMonthHist

}// End of RegulatoryUserApiCtrl
