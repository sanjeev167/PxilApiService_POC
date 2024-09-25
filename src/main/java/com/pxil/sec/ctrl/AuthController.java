/**
 * 
 */
package com.pxil.sec.ctrl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pxil.sec.entities.ApiRefreshToken;
import com.pxil.sec.jwt.JwtUtils;
import com.pxil.sec.jwt.RefreshTokenService;
import com.pxil.sec.model.AuthRequest;
import com.pxil.sec.model.JwtResponse;
import com.pxil.sec.model.RefreshTokenRequest;

/**
 * @author sanjeevkumar 
 * 03-Dec-2023 
 * 7:30:49 pm 
 * Objective:
 */

@RestController
@RequestMapping("/auth/v1")
public class AuthController extends ApiBaseCtrl {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	RefreshTokenService refreshTokenService;

	@PostMapping(value = "/login",produces="application/json",consumes = "application/json")
	public ResponseEntity<Object> AuthenticateAndGetToken(@Valid @RequestBody AuthRequest authRequest){	 
		try {			
		Authentication authentication = authenticationManager.authenticate(
				                   new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
		if(authentication.isAuthenticated()){			
			JwtResponse jwtResponse = new JwtResponse();		     	        
	        jwtResponse.setAccessToken(jwtUtils.GenerateToken(authentication.getName()));
	        jwtResponse.setRefreshToken((refreshTokenService.createRefreshToken(authentication.getName()).getRefreshToken()));	 
	        //Return response in a pre-defined format	  
	        apiReq = makeApiMetaDataWhileLogin(authentication.getName());
			apiReq.setPayLoad(authRequest);
			apiResponse=makeSuccessResponse(jwtResponse,apiReq);
			return ResponseEntity.ok().body(apiResponse);
	    } else {
	        throw new UsernameNotFoundException("invalid user request..!!");
	    }
		}catch(BadCredentialsException ex) {throw new BadCredentialsException("Invalid-Credential !");}
	}//End of AuthenticateAndGetToken
		
	@PostMapping(value = "/refreshToken",produces="application/json",consumes = "application/json")
	public ResponseEntity<Object> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
		
		Optional<ApiRefreshToken> apiRefreshTokenOptional = refreshTokenService.findByRefreshToken(refreshTokenRequest.getRefreshToken());
		JwtResponse jwtResponse;
		ApiRefreshToken apiRefreshToken;
		
		if(apiRefreshTokenOptional!=null) {
			apiRefreshToken = apiRefreshTokenOptional.get();			
			refreshTokenService.verifyExpiration(apiRefreshToken);			
			jwtResponse=new JwtResponse();
			jwtResponse.setAccessToken(jwtUtils.GenerateToken(apiRefreshToken.getApiUser().getName()));			 
			jwtResponse.setRefreshToken(refreshTokenRequest.getRefreshToken());	
			//Return response in a pre-defined format			
			apiReq = makeApiMetaDataWhileLogin(apiRefreshToken.getApiUser().getName());
			apiReq.setPayLoad(refreshTokenRequest);
			apiResponse=makeSuccessResponse(jwtResponse,apiReq);				        
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new RuntimeException("Refresh Token is not in DB..!!");
		}
	}//End of refreshToken	

}// End of AuthController
