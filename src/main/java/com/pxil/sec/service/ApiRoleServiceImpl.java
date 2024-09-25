/**
 * 
 */
package com.pxil.sec.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxil.sec.entities.ApiRole;
import com.pxil.sec.model.ApiRoleModel;
import com.pxil.sec.repo.ApiRoleRepository;

/**
 * @author sanjeevkumar 
 * 03-Dec-2023 
 * 4:10:52 pm 
 * Objective:
 */
@Service
public class ApiRoleServiceImpl implements ApiRoleService {

	@Autowired
	ApiRoleRepository apiRoleRepository;

	@Override
	public ApiRole addApiRole(ApiRoleModel apiRoleModel) {
		ApiRole savedApiRoleEntity = null;
		try {
			ApiRole apiRoleEntity = new ApiRole();
			apiRoleEntity.setRoleName(apiRoleModel.getRoleName());
			apiRoleEntity.setCreatedOn(new Date());
			// apiRoleEntity.setCreatedBy(0);//Will be implemented latter. FK needs to be adjusted
			apiRoleEntity.setActiveC(apiRoleModel.getActiveC());
			savedApiRoleEntity = apiRoleRepository.save(apiRoleEntity);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return savedApiRoleEntity;
	}

	@Override
	public ApiRole updateApiRole(ApiRoleModel apiRoleModel) {
		ApiRole apiRoleEntityToBeUpdated = null;
		try {
			Optional<ApiRole> apiRoleEntityWrapper = apiRoleRepository.findById(apiRoleModel.getId());
			if (apiRoleEntityWrapper.isPresent()) {
				apiRoleEntityToBeUpdated = apiRoleEntityWrapper.get();
				apiRoleEntityToBeUpdated.setRoleName(apiRoleModel.getRoleName());
				apiRoleEntityToBeUpdated.setModifiedOn(new Date());
				// apiRoleEntityToBeUpdated.setModifiedBy(0);//Will be implemented latter. FK needs to be adjusted				
				apiRoleRepository.save(apiRoleEntityToBeUpdated);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiRoleEntityToBeUpdated;
	}

	@Override
	public boolean deleteApiRoleByRecordId(Integer recordId) {
		boolean isRecordDeleted = true;
		try {
			apiRoleRepository.deleteById(recordId);
		} catch (Exception ex) {
			ex.printStackTrace();
			isRecordDeleted = false;
		}
		return isRecordDeleted;
	}

	@Override
	public ApiRole getApiRoleByRecordId(Integer recordId) {
		ApiRole apiRoleEntityFetched = null;
		try {
			Optional<ApiRole> apiRoleEntityWrapper = apiRoleRepository.findById(recordId);
			if (apiRoleEntityWrapper.isPresent())
				apiRoleEntityFetched = apiRoleEntityWrapper.get();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiRoleEntityFetched;
	}

	@Override
	public List<ApiRole> getAllApiRoles() {
		List<ApiRole> apiRoleList = null;
		try {
			apiRoleList = apiRoleRepository.findAll();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiRoleList;
	}

}// End of ApiRoleServiceImpl
