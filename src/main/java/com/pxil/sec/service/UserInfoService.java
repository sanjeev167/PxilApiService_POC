/**
 * 
 */
package com.pxil.sec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pxil.sec.entities.ApiUser;
import com.pxil.sec.repo.ApiUserRepository;

/**
 * @author sanjeevkumar 
 * 03-Dec-2023 
 * 8:09:46 pm 
 * Objective: This service loads a coming user details. It loads using login id. Right now, it is using username as login id. 
 * It can be changed if the login id is different.
 */
@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	private ApiUserRepository apiUserRepository;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {       
		Optional<ApiUser> apiUser = apiUserRepository.findByName(username);          
		// Converting apiUser to UserDetails. UserInfoDetails is project specific implementation
		return apiUser.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException(username+" not found in database"));
	}	

}// End of UserInfoService
