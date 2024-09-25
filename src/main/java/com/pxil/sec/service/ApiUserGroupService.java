/**
 * 
 */
package com.pxil.sec.service;

import java.util.List;

import com.pxil.sec.entities.ApiUserGroup;
import com.pxil.sec.model.ApiUserGroupModel;

/**
 * @author sanjeevkumar
 * 03-Dec-2023
 * 5:20:27 pm 
 * Objective: 
 */
public interface ApiUserGroupService {

	public ApiUserGroup addApiUserGroup(ApiUserGroupModel apiUserGroupModel);

	public ApiUserGroup updateApiUserGroup(ApiUserGroupModel apiUserGroupModel);

	public boolean deleteApiUserGroupByRecordId(Integer recordId);

	public ApiUserGroup getApiUserGroupByRecordId(Integer recordId);

	public List<ApiUserGroup> getAllApiUserGroups();
	
}//End of ApiUserGroupService
