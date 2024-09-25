/**
 * 
 */
package com.pxil.sec.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxil.sec.entities.ApiGroupRole;
import com.pxil.sec.model.ApiGroupRoleModel;
import com.pxil.sec.repo.ApiGroupRoleRepository;

/**
 * @author sanjeevkumar
 * 03-Dec-2023
 * 5:53:35 pm 
 * Objective: 
 */
@Service
public class ApiGroupRoleServiceImpl implements ApiGroupRoleService{
	
	@Autowired
	ApiGroupRoleRepository apiGroupRoleRepository;

	@Override
	public ApiGroupRole addApiGroupRole(ApiGroupRoleModel apiGroupRoleModel) {
		ApiGroupRole savedApiGroupRoleEntity = null;
		try {
			ApiGroupRole apiApiGroupRoleEntity = new ApiGroupRole();
			apiApiGroupRoleEntity.setApiRoleId(apiGroupRoleModel.getApiRoleId());
			apiApiGroupRoleEntity.setApiGroupId(apiGroupRoleModel.getApiGroupId());			
			apiApiGroupRoleEntity.setCreatedOn(new Date());
			// apiApiGroupRoleEntity.setCreatedBy(0);//Will be implemented latter. FK needs to be adjusted
			apiApiGroupRoleEntity.setActiveC("Y");
			savedApiGroupRoleEntity = apiGroupRoleRepository.save(apiApiGroupRoleEntity);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return savedApiGroupRoleEntity;
	}

	@Override
	public ApiGroupRole updateApiGroupRole(ApiGroupRoleModel apiGroupRoleModel) {
		ApiGroupRole apiGroupRoleEntityToBeUpdated = null;
		try {
			Optional<ApiGroupRole> apiGroupRoleEntityWrapper = apiGroupRoleRepository.findById(apiGroupRoleModel.getId());
			if (apiGroupRoleEntityWrapper.isPresent()) {
				apiGroupRoleEntityToBeUpdated = apiGroupRoleEntityWrapper.get();
				apiGroupRoleEntityToBeUpdated.setApiRoleId(apiGroupRoleModel.getApiRoleId());
				apiGroupRoleEntityToBeUpdated.setApiGroupId(apiGroupRoleModel.getApiGroupId());
				apiGroupRoleEntityToBeUpdated.setModifiedOn(new Date());
				// apiGroupRoleEntityToBeUpdated.setModifiedBy(0);//Will be implemented latter. FK needs to be adjusted
				apiGroupRoleEntityToBeUpdated.setActiveC(apiGroupRoleModel.getActiveC());
				apiGroupRoleRepository.save(apiGroupRoleEntityToBeUpdated);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiGroupRoleEntityToBeUpdated;
	}

	@Override
	public boolean deleteApiGroupRoleByRecordId(Integer recordId) {
		boolean isRecordDeleted = true;
		try {
			apiGroupRoleRepository.deleteById(recordId);
		} catch (Exception ex) {
			ex.printStackTrace();
			isRecordDeleted = false;
		}
		return isRecordDeleted;
	}

	@Override
	public ApiGroupRole getApiGroupRoleByRecordId(Integer recordId) {
		ApiGroupRole apiGroupRoleEntityFetched = null;
		try {
			Optional<ApiGroupRole> apiGroupRoleEntityWrapper = apiGroupRoleRepository.findById(recordId);
			if (apiGroupRoleEntityWrapper.isPresent())
				apiGroupRoleEntityFetched = apiGroupRoleEntityWrapper.get();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiGroupRoleEntityFetched;
	}

	@Override
	public List<ApiGroupRole> getAllApiGroupRoles() {
		List<ApiGroupRole> apiGroupRoleList = null;
		try {
			apiGroupRoleList = apiGroupRoleRepository.findAll();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiGroupRoleList;
	}

}//End of ApiGroupRoleServiceImpl
