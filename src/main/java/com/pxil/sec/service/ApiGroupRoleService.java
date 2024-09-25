/**
 * 
 */
package com.pxil.sec.service;

import java.util.List;

import com.pxil.sec.entities.ApiGroupRole;
import com.pxil.sec.model.ApiGroupRoleModel;

/**
 * @author sanjeevkumar
 * 03-Dec-2023
 * 5:53:12 pm 
 * Objective: 
 */
public interface ApiGroupRoleService {

	public ApiGroupRole addApiGroupRole(ApiGroupRoleModel apiGroupRoleModel);

	public ApiGroupRole updateApiGroupRole(ApiGroupRoleModel apiGroupRoleModel);

	public boolean deleteApiGroupRoleByRecordId(Integer recordId);

	public ApiGroupRole getApiGroupRoleByRecordId(Integer recordId);

	public List<ApiGroupRole> getAllApiGroupRoles();
}//End of ApiGroupRoleService
