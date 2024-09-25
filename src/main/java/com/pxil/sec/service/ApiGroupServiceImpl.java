/**
 * 
 */
package com.pxil.sec.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxil.sec.entities.ApiGroup;
import com.pxil.sec.model.ApiGroupModel;
import com.pxil.sec.repo.ApiGroupRepository;

/**
 * @author sanjeevkumar 
 * 03-Dec-2023 
 * 4:58:43 pm 
 * Objective:
 */
@Service
public class ApiGroupServiceImpl implements ApiGroupService {

	@Autowired
	ApiGroupRepository apiGroupRepository;

	
	@Override
	public ApiGroup addApiGroup(ApiGroupModel apiGroupModel) {
		ApiGroup savedApiGroupEntity = null;
		try {
			ApiGroup apiGroupEntity = new ApiGroup();
			apiGroupEntity.setGroupName(apiGroupModel.getGroupName());
			apiGroupEntity.setCreatedOn(new Date());
			// apiGroupEntity.setCreatedBy(0);//Will be implemented latter. FK needs to be adjusted
			apiGroupEntity.setActiveC("Y");
			savedApiGroupEntity = apiGroupRepository.save(apiGroupEntity);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return savedApiGroupEntity;
	}
	

	@Override
	public ApiGroup updateApiGroup(ApiGroupModel apiGroupModel) {
		ApiGroup apiGroupEntityToBeUpdated = null;
		try {			
			Optional<ApiGroup> apiGroupEntityWrapper = apiGroupRepository.findById(apiGroupModel.getId());
			if (apiGroupEntityWrapper.isPresent()) {
				apiGroupEntityToBeUpdated = apiGroupEntityWrapper.get();
				apiGroupEntityToBeUpdated.setGroupName(apiGroupModel.getGroupName());
				apiGroupEntityToBeUpdated.setModifiedOn(new Date());
				// apiGroupEntityToBeUpdated.setModifiedBy(0);//Will be implemented latter. FK needs to be adjusted
				apiGroupEntityToBeUpdated.setActiveC(apiGroupModel.getActiveC());
				apiGroupRepository.save(apiGroupEntityToBeUpdated);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiGroupEntityToBeUpdated;
	}

	@Override
	public boolean deleteApiGroupByRecordId(Integer recordId) {
		boolean isRecordDeleted = true;
		try {
			apiGroupRepository.deleteById(recordId);
		} catch (Exception ex) {
			ex.printStackTrace();
			isRecordDeleted = false;
		}
		return isRecordDeleted;
	}

	@Override
	public ApiGroup getApiGroupByRecordId(Integer recordId) {
		ApiGroup apiGroupEntityFetched = null;
		try {
			Optional<ApiGroup> apiGroupEntityWrapper = apiGroupRepository.findById(recordId);
			if (apiGroupEntityWrapper.isPresent())
				apiGroupEntityFetched = apiGroupEntityWrapper.get();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiGroupEntityFetched;
	}

	@Override
	public List<ApiGroup> getAllApiGroups() {
		List<ApiGroup> apiGroupList = null;
		try {
			apiGroupList = apiGroupRepository.findAll();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiGroupList;
	}

}// End of ApiGroupServiceImpl
