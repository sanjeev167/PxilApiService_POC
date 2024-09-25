/**
 * 
 */
package com.pxil.sec.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pxil.exception.ResourceNotFoundException;
import com.pxil.sec.entities.ApiUser;
import com.pxil.sec.model.ApiUserModel;
import com.pxil.sec.service.ApiUserService;

/**
 * @author sanjeevkumar 
 * 04-Dec-2023 
 * 1:46:04 am 
 * Objective:
 */
@RestController
@RequestMapping("/sec/v1")
public class ApiUserController extends ApiBaseCtrl {
	@Autowired
	private ApiUserService apiUserService;

	@PostMapping(value = "/users",produces="application/json",consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> addNewUser(@RequestBody ApiUserModel apiUserModel) {
		ApiUser apiUser = apiUserService.addApiUser(apiUserModel);
		if(apiUser!=null) {
			apiReq=makeApiMetaData();			
			apiReq.setPayLoad(apiUserModel);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiUser,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiUser is added.");
		}
	}

	@GetMapping(value = "/users/{id}",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> getApiUserById(@PathVariable("id") Integer id) {
		ApiUser apiUser = apiUserService.getApiUserByRecordId(id);
		if(apiUser!=null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(id);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiUser,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiUser with id("+id+") is found.");
		}
	}

	@GetMapping(value = "/users",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> getAllApiUsers() {
		List<ApiUser> apiUserList = apiUserService.getAllApiUsers();
		if(apiUserList!=null) {
			apiReq=makeApiMetaData();			
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiUserList,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {			
			throw new ResourceNotFoundException("No ApiUser is yet defined!");
		}		 
	}

	@DeleteMapping(value = "/users/{id}",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> deleteApiUserById(@PathVariable("id") Integer id) {
		boolean isDeleted = apiUserService.deleteApiUserByRecordId(id);
		if(isDeleted) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(id);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(true,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiUser with id("+id+") is found.");
		}
	}

	@PutMapping(value = "/users",produces="application/json",consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> updateApiUser(@RequestBody ApiUserModel apiUserModel) {
		
		ApiUser apiUser = apiUserService.updateApiUser(apiUserModel);
		if(apiUser!=null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(apiUserModel);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiUser,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiUser with id("+apiUserModel.getId()+") is found.");
		}		 
	}

}// End of ApiUserController
