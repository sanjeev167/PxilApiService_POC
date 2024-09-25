/**
 * 
 */
package com.pxil.sec.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pxil.sec.entities.ApiUser;
import com.pxil.sec.model.ApiUserModel;
import com.pxil.sec.repo.ApiUserRepository;

/**
 * @author sanjeevkumar 
 * 03-Dec-2023 
 * 12:40:24 pm 
 * Objective:
 */
@Service
public class ApiUserServiceImpl implements ApiUserService {

	@Autowired
	ApiUserRepository apiUserRepository;
	@Autowired
	private PasswordEncoder encoder;
	@Override
	public ApiUser addApiUser(ApiUserModel apiUserModel) {
		ApiUser savedApiUserEntity = null;
		try {
			ApiUser apiUserEntity = new ApiUser();
			apiUserEntity.setName(apiUserModel.getName());
			apiUserEntity.setEmail(apiUserModel.getEmail());
			apiUserEntity.setPwd(encoder.encode(apiUserModel.getPwd()));
			apiUserEntity.setGridNodeCode(apiUserModel.getGridNodeCode());
			apiUserEntity.setUserContext(apiUserModel.getUserContext());
			apiUserEntity.setCreatedOn(new Date());
			//apiUserEntity.setCreatedBy(0);//Will be implemented latter. FK needs to be adjusted
			apiUserEntity.setActiveC("Y");
			savedApiUserEntity = apiUserRepository.save(apiUserEntity);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return savedApiUserEntity;
	}

	@Override
	public ApiUser updateApiUser(ApiUserModel apiUserModel) {

		ApiUser apiUserEntityToBeUpdated = null;
		try {
			Optional<ApiUser> apiUserEntityWrapper = apiUserRepository.findById(apiUserModel.getId());
			if (apiUserEntityWrapper.isPresent()) {
				apiUserEntityToBeUpdated = apiUserEntityWrapper.get();
				apiUserEntityToBeUpdated.setName(apiUserModel.getName());
				apiUserEntityToBeUpdated.setEmail(apiUserModel.getEmail());				
				apiUserEntityToBeUpdated.setPwd(encoder.encode(apiUserModel.getPwd()));
				apiUserEntityToBeUpdated.setGridNodeCode(apiUserModel.getGridNodeCode());
				apiUserEntityToBeUpdated.setUserContext(apiUserModel.getUserContext());
				apiUserEntityToBeUpdated.setModifiedOn(new Date());
				//apiUserEntityToBeUpdated.setModifiedBy(0);//Will be implemented latter. FK needs to be adjusted				
				apiUserRepository.save(apiUserEntityToBeUpdated);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiUserEntityToBeUpdated;
	}

	@Override
	public boolean deleteApiUserByRecordId(Integer recordId) {
		boolean isRecordDeleted = true;
		try {
			apiUserRepository.deleteById(recordId);
		} catch (Exception ex) {
			ex.printStackTrace();
			isRecordDeleted = false;
		}
		return isRecordDeleted;
	}

	@Override
	public ApiUser getApiUserByRecordId(Integer recordId) {
		ApiUser apiUserEntityFetched = null;
		try {
			Optional<ApiUser> apiUserEntityWrapper = apiUserRepository.findById(recordId);
			if (apiUserEntityWrapper.isPresent())
				apiUserEntityFetched = apiUserEntityWrapper.get();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiUserEntityFetched;
	}

	@Override
	public List<ApiUser> getAllApiUsers() {
		List<ApiUser> apiUserList = null;
		try {
			apiUserList = apiUserRepository.findAll();			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiUserList;
	}

	
}// End of ApiUserServiceImpl
