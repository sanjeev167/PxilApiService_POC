/**
 * 
 */
package com.pxil.sec.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pxil.sec.entities.ApiUser;

/**
 * @author sanjeevkumar
 * 03-Dec-2023
 * 12:22:27 pm 
 * Objective: 
 */

public interface ApiUserRepository extends JpaRepository<ApiUser, Integer>{

	Optional<ApiUser> findByName(String username);	
}//End of ApiUserRepository
