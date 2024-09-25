/**
 * 
 */
package com.pxil.sec.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pxil.exception.InvalidJwtAuthenticationException;
import com.pxil.exception.ResourceNotFoundException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;

/**
 * @author sanjeevkumar 
 * 26-Dec-2023 
 * 11:16:18 pm 
 * Objective :
 */
@RestController
public class CustomErrorController extends AbstractErrorController {

	public CustomErrorController(ErrorAttributes errorAttributes) {
		super(errorAttributes);		
	}

	@RequestMapping("/error")
	public void handleError(HttpServletRequest request) throws Throwable {	
		
		if (request.getAttribute("javax.servlet.error.exception") != null) {
			
			Throwable t = (Throwable) request.getAttribute("javax.servlet.error.exception");
			
			throwThrowableAsACorrectException(t);			
			
		} else if ((Integer) request.getAttribute("javax.servlet.error.status_code") == 404) {
			
			throw new ResourceNotFoundException("Resource-URL-Not-Found");
		}
	}

	private void throwThrowableAsACorrectException(Throwable t) throws Throwable {

		if (t instanceof SignatureException) {

			SignatureException ex = ((SignatureException) t);
			throw new SignatureException(ex.getMessage());

		} else if (t instanceof InvalidJwtAuthenticationException) {

			throw new InvalidJwtAuthenticationException("Invalid Jwt Token");

		} else if (t instanceof ExpiredJwtException) {

			ExpiredJwtException ex = ((ExpiredJwtException) t);
			throw new ExpiredJwtException(ex.getHeader(), ex.getClaims(), ex.getMessage());

		} else if (t instanceof HTTPException) {
			AccessDeniedException ex = ((AccessDeniedException) t);
			
			if (((HTTPException) t).getStatusCode() == 401) {
				
				throw new AccessDeniedException(ex.getMessage());
				
			} else if (((HTTPException) t).getStatusCode() == 403) {
				
				throw new AccessDeniedException(ex.getMessage());
			}
		}
	}

}// End of CustomErrorController
