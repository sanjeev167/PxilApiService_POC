/**
 * 
 */
package com.pxil.sec.filter;

import java.io.IOException;
import java.security.SignatureException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pxil.exception.InvalidJwtAuthenticationException;
import com.pxil.sec.jwt.JwtUtils;
import com.pxil.sec.service.UserInfoDetails;
import com.pxil.sec.service.UserInfoService;

/**
 * @author sanjeevkumar 
 * 03-Dec-2023 
 * 7:48:26 pm 
 * Objective: This class helps us to validate the generated jwt token
 */

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UserInfoService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
		
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String username = null;
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			username = jwtUtils.extractUsername(token);
			//System.out.println("username in token => "+username);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {			
			UserInfoDetails userInfoDetails = (UserInfoDetails) userDetailsService.loadUserByUsername(username);			
			try {
				if (jwtUtils.validateToken(token, userInfoDetails)) { 
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userInfoDetails,
							null, userInfoDetails.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);				
					doContextLoggingConfiguration(userInfoDetails);				
				}
			} catch (SignatureException e) {
				throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
			}
		}
		filterChain.doFilter(request, response);
	}

	/**
	 * @author sanjeevkumar 
	 * 24-Dec-2023 
	 * 1:48:26 pm 
	 * @param userInfoDetails
	 * Objective: 
	 */
	
	private void doContextLoggingConfiguration(UserInfoDetails userInfoDetails) {
	    String dateFormatUsed = "dd-MM-yyyy";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormatUsed);
		LocalDateTime now = LocalDateTime.now();
		String apiCallReceivedOn = dtf.format(now);		
		MDC.clear();
		//System.out.println("Sanjeev UserInfoDetails while MDC setting  => "+userInfoDetails.getUsername());
		MDC.put("logContextFolder", apiCallReceivedOn+"/"+userInfoDetails.getUserContext()+"/"+userInfoDetails.getUsername());		
	}
}// End of JwtAuthFilter
