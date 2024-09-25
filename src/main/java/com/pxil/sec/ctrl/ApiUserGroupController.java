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
import com.pxil.sec.entities.ApiUserGroup;
import com.pxil.sec.model.ApiUserGroupModel;
import com.pxil.sec.service.ApiUserGroupService;

/**
 * @author sanjeevkumar 
 * 04-Dec-2023 
 * 1:51:32 am 
 * Objective:
 */
@RestController
@RequestMapping("/sec/v1")
public class ApiUserGroupController extends ApiBaseCtrl {

	@Autowired
	private ApiUserGroupService apiUserGroupService;

	@PostMapping(value = "/usergroups",produces="application/json",consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> addNewUserGroup(@RequestBody ApiUserGroupModel apiUserGroupModel) {
		ApiUserGroup apiUserGroup = apiUserGroupService.addApiUserGroup(apiUserGroupModel);
		if(apiUserGroup!=null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(apiUserGroupModel);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiUserGroup,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiUserGroup is added.");
		}
	}

	@GetMapping(value = "/usergroups/{id}",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> getApiUserGroupById(@PathVariable("id") Integer id) {
		ApiUserGroup apiUserGroup = apiUserGroupService.getApiUserGroupByRecordId(id);
		if(apiUserGroup!=null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(id);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiUserGroup,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiUserGroup with id("+id+") is found.");
		} 
	}

	@GetMapping(value = "/usergroups",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> getAllApiUserGroups() {
		List<ApiUserGroup> apiUserGroupList = apiUserGroupService.getAllApiUserGroups();
		if(apiUserGroupList!=null) {
			apiReq=makeApiMetaData();			
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiUserGroupList,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {			
			throw new ResourceNotFoundException("No ApiUserGroup is yet defined!");
		} 
	}

	@DeleteMapping(value = "/usergroups/{id}",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> deleteApiUserGroupById(@PathVariable("id") Integer id) {		
		boolean isDeleted = apiUserGroupService.deleteApiUserGroupByRecordId(id);
		if(isDeleted) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(id);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(true,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiUserGroup with id("+id+") is found.");
		}
	}

	@PutMapping(value = "/usergroups",produces="application/json",consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> updateApiUserGroup(@RequestBody ApiUserGroupModel apiUserGroupModel) {		
		ApiUserGroup apiUserGroup = apiUserGroupService.updateApiUserGroup(apiUserGroupModel);
		if(apiUserGroup!=null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(apiUserGroupModel);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiUserGroup,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiUserGroup with id("+apiUserGroupModel.getId()+") is found.");
		}		 
	}

}// End of ApiUserGroupController
