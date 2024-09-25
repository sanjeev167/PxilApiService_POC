/**
 * 
 */
package com.pxil.sec.service;

import java.util.List;

import com.pxil.sec.entities.ApiRole;
import com.pxil.sec.model.ApiRoleModel;

/**
 * @author sanjeevkumar
 * 03-Dec-2023
 * 4:10:34 pm 
 * Objective: 
 */
public interface ApiRoleService {

	public ApiRole addApiRole(ApiRoleModel apiRoleModel);
	public ApiRole updateApiRole(ApiRoleModel apiRoleModel);
	public boolean deleteApiRoleByRecordId(Integer recordId);
	public ApiRole getApiRoleByRecordId(Integer recordId);
	public List<ApiRole> getAllApiRoles();
	
}//End of ApiRoleService
