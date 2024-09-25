/**
 * 
 */
package com.pxil.sec.ctrl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pxil.api.struct.ApiHead;
import com.pxil.api.struct.ApiRequest;
import com.pxil.api.struct.ApiResponse;
import com.pxil.sec.service.UserInfoDetails;
import com.pxil.sec.service.UserInfoService;

/**
 * @author sanjeevkumar 
 * 19-Dec-2023 
 * 12:28:47 pm 
 * Objective :
 */
public class ApiBaseCtrl {
	@Autowired
	private UserInfoService userDetailsService;
	protected String dateFormatUsed = "dd-MM-yyyy HH:mm:ss";
	protected ApiRequest apiReq = null;
	protected String contentTypeRsp;
	protected Integer httpStatus;
	protected String apiResMsg;
	protected String errorMsg;
	protected Object resObj = null;
	protected ApiResponse apiResponse = new ApiResponse();
	protected String gridNodeCode =null;
	protected String apiUser =null;
	
	protected ApiRequest makeApiMetaData() {
		Authentication auth = null;		 
		try {			
		auth = SecurityContextHolder.getContext().getAuthentication();			
		apiUser = auth.getName();	
		UserInfoDetails userInfoDetails = (UserInfoDetails) userDetailsService.loadUserByUsername(apiUser);
		gridNodeCode = userInfoDetails.getGridNodeCode();		
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		String contentTypeRcvd=request.getContentType();		
		String methodName=request.getMethod();
		String apiUrl=request.getRequestURI();
		// do something
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormatUsed);
		LocalDateTime now = LocalDateTime.now();
		String apiCallReceived = dtf.format(now);
		String apiCallResponded =  dtf.format(LocalDateTime.now());
		
		
	    apiReq = new ApiRequest( apiUrl,
	    		                methodName, 	    		                
	    		                contentTypeRcvd, 
	    		                contentTypeRsp, 
	    		                apiCallReceived,
	    		                apiCallResponded);
		}catch(Exception ex) {ex.printStackTrace();}
		return apiReq;
		
	}// End of makeApiMetaData
	
	protected ApiRequest makeApiMetaDataWhileLogin(String userName) {
			 
		try {				
		apiUser = userName;	
		UserInfoDetails userInfoDetails = (UserInfoDetails) userDetailsService.loadUserByUsername(apiUser);
		gridNodeCode = userInfoDetails.getGridNodeCode();		
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		String contentTypeRcvd=request.getContentType();		
		String methodName=request.getMethod();
		String apiUrl=request.getRequestURI();
		// do something
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormatUsed);
		LocalDateTime now = LocalDateTime.now();
		String apiCallReceived = dtf.format(now);
		String apiCallResponded =  dtf.format(LocalDateTime.now());
		
		
	    apiReq = new ApiRequest( apiUrl,
	    		                methodName, 	    		                
	    		                contentTypeRcvd, 
	    		                contentTypeRsp, 
	    		                apiCallReceived,
	    		                apiCallResponded);
		}catch(Exception ex) {ex.printStackTrace();}
		return apiReq;
		
	}// End of makeApiMetaData
	
	protected ApiResponse makeSuccessResponse(Object object, ApiRequest apiReq) {
		ApiResponse apiResponse = new ApiResponse();			
		ApiHead head = new ApiHead(LocalDateTime.now(), HttpStatus.OK, "Successful","200");			
		apiResponse.setMeta(apiReq);
		apiResponse.setBody(object); 
		apiResponse.setHead(head);
		return apiResponse;
	}

}// End of ApiBaseCtrl
