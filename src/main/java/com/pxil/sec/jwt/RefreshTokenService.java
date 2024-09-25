/**
 * 
 */
package com.pxil.sec.jwt;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pxil.exception.TokenRefreshException;
import com.pxil.sec.entities.ApiRefreshToken;
import com.pxil.sec.repo.ApiUserRepository;
import com.pxil.sec.repo.RefreshTokenRepository;

/**
 * @author sanjeevkumar 
 * 16-Jan-2024 
 * 7:23:01 pm 2024 
 * Objective :
 */
@Service
public class RefreshTokenService {

	@Value("${pxil.api.jwtRefreshExpirationInMin}")
	private Long jwtRefreshExpirationInMin;

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	@Autowired
	private ApiUserRepository apiUserRepository;

	

	public ApiRefreshToken createRefreshToken(String username) {

		ApiRefreshToken refreshToken = new ApiRefreshToken();

		refreshToken.setUserId(apiUserRepository.findByName(username).get().getId());		
		Date javaDate = Date.from(Instant.now().plusMillis(jwtRefreshExpirationInMin*60000));

		refreshToken.setExpirydate(javaDate);

		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setCreatedOn(new Date());
		refreshToken = refreshTokenRepository.save(refreshToken);
		return refreshToken;
	}
	
	public Optional<ApiRefreshToken> findByRefreshToken(String token) {
		return refreshTokenRepository.findByRefreshToken(token);
	}

	public ApiRefreshToken verifyExpiration(ApiRefreshToken token) {
		Date currentDateTime = new Date();      
		if (token.getExpirydate().compareTo(currentDateTime) < 0) {
			refreshTokenRepository.delete(token);
			throw new TokenRefreshException(token.getRefreshToken(), "Refresh token is expired. Please make a new signin request");
		}

		return token;
	}	
}// End of RefreshTokenService
