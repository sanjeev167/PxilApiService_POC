/**
 * 
 */
package com.pxil.sec.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pxil.sec.entities.ApiRefreshToken;

/**
 * @author sanjeevkumar
 * 16-Jan-2024
 * 12:41:24 pm 
 * Objective : 
 */


public interface RefreshTokenRepository extends JpaRepository<ApiRefreshToken, Long>{
	
	Optional<ApiRefreshToken> findByRefreshToken(String token);

}//End of RefreshTokenRepository
