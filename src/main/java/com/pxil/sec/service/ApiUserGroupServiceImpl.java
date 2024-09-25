/**
 * 
 */
package com.pxil.sec.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxil.sec.entities.ApiUserGroup;
import com.pxil.sec.model.ApiUserGroupModel;
import com.pxil.sec.repo.ApiUserGroupRepository;

/**
 * @author sanjeevkumar
 * 03-Dec-2023
 * 5:20:54 pm 
 * Objective: 
 */
@Service
public class ApiUserGroupServiceImpl implements ApiUserGroupService{

	@Autowired
	ApiUserGroupRepository apiUserGroupRepository;
	
	@Override
	public ApiUserGroup addApiUserGroup(ApiUserGroupModel apiUserGroupModel) {
		ApiUserGroup savedApiUserGroupEntity = null;
		try {
			ApiUserGroup apiUserGroupEntity = new ApiUserGroup();
			apiUserGroupEntity.setApiUserId(apiUserGroupModel.getApiUserId());
			apiUserGroupEntity.setApiGroupId(apiUserGroupModel.getApiGroupId());			
			apiUserGroupEntity.setCreatedOn(new Date());
			// apiUserGroupEntity.setCreatedBy(0);//Will be implemented latter. FK needs to be adjusted
			apiUserGroupEntity.setActiveC("Y");
			savedApiUserGroupEntity = apiUserGroupRepository.save(apiUserGroupEntity);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return savedApiUserGroupEntity;
	}

	@Override
	public ApiUserGroup updateApiUserGroup(ApiUserGroupModel apiUserGroupModel) {
		ApiUserGroup apiUserGroupEntityToBeUpdated = null;
		try {
			Optional<ApiUserGroup> apiUserGroupEntityWrapper = apiUserGroupRepository.findById(apiUserGroupModel.getId());
			if (apiUserGroupEntityWrapper.isPresent()) {
				apiUserGroupEntityToBeUpdated = apiUserGroupEntityWrapper.get();
				apiUserGroupEntityToBeUpdated.setApiUserId(apiUserGroupModel.getApiUserId());
				apiUserGroupEntityToBeUpdated.setApiGroupId(apiUserGroupModel.getApiGroupId());
				apiUserGroupEntityToBeUpdated.setModifiedOn(new Date());
				// apiUserGroupEntityToBeUpdated.setModifiedBy(0);//Will be implemented latter. FK needs to be adjusted
				apiUserGroupEntityToBeUpdated.setActiveC(apiUserGroupModel.getActiveC());
				apiUserGroupRepository.save(apiUserGroupEntityToBeUpdated);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiUserGroupEntityToBeUpdated;
	}

	@Override
	public boolean deleteApiUserGroupByRecordId(Integer recordId) {
		boolean isRecordDeleted = true;
		try {
			apiUserGroupRepository.deleteById(recordId);
		} catch (Exception ex) {
			ex.printStackTrace();
			isRecordDeleted = false;
		}
		return isRecordDeleted;
	}

	@Override
	public ApiUserGroup getApiUserGroupByRecordId(Integer recordId) {
		ApiUserGroup apiUserGroupEntityFetched = null;
		try {
			Optional<ApiUserGroup> apiUserGroupEntityWrapper = apiUserGroupRepository.findById(recordId);
			if (apiUserGroupEntityWrapper.isPresent())
				apiUserGroupEntityFetched = apiUserGroupEntityWrapper.get();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiUserGroupEntityFetched;
	}

	@Override
	public List<ApiUserGroup> getAllApiUserGroups() {
		List<ApiUserGroup> apiUserGroupList = null;
		try {
			apiUserGroupList = apiUserGroupRepository.findAll();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiUserGroupList;
	}

}//End of ApiUserGroupServiceImpl
