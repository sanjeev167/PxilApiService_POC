/**
 * 
 */
package com.pxil.sec.service;

import java.util.List;

import com.pxil.sec.entities.ApiGroup;
import com.pxil.sec.model.ApiGroupModel;

/**
 * @author sanjeevkumar 
 * 03-Dec-2023 
 * 4:58:14 pm 
 * Objective:
 */
public interface ApiGroupService {

	public ApiGroup addApiGroup(ApiGroupModel apiGroupModel);

	public ApiGroup updateApiGroup(ApiGroupModel apiGroupModel);

	public boolean deleteApiGroupByRecordId(Integer recordId);

	public ApiGroup getApiGroupByRecordId(Integer recordId);

	public List<ApiGroup> getAllApiGroups();

}// End of ApiGroupService
