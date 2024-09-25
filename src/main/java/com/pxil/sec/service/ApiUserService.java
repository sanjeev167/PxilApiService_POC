/**
 * 
 */
package com.pxil.sec.service;

import java.util.List;

import com.pxil.sec.entities.ApiUser;
import com.pxil.sec.model.ApiUserModel;

/**
 * @author sanjeevkumar
 * 03-Dec-2023
 * 12:40:50 pm 
 * Objective: 
 */
public interface ApiUserService {
	
	public ApiUser addApiUser(ApiUserModel apiUserModel);
	public ApiUser updateApiUser(ApiUserModel apiUserModel);
	public boolean deleteApiUserByRecordId(Integer recordId);
	public ApiUser getApiUserByRecordId(Integer recordId);
	public List<ApiUser> getAllApiUsers();

}//End of ApiUserService
