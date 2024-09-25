/**
 * 
 */
package com.pxil.exception;

import org.springframework.http.ResponseEntity;

import com.pxil.api.struct.ApiError;

/**
 * @author sanjeevkumar
 * 17-Dec-2023
 * 1:49:46 am 
 * Objective : 
 */
public class ResponseEntityBuilder {

	public static ResponseEntity<Object> build(ApiError apiError) {
	      return new ResponseEntity<>(apiError, apiError.getHead().getHttpStatus());
	}
}//End of ResponseEntityBuilder 
