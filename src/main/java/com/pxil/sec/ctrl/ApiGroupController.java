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
import com.pxil.sec.entities.ApiGroup;
import com.pxil.sec.model.ApiGroupModel;
import com.pxil.sec.service.ApiGroupService;

/**
 * @author sanjeevkumar 
 * 04-Dec-2023 
 * 1:48:35 am 
 * Objective:
 */
@RestController
@RequestMapping("/sec/v1")
public class ApiGroupController extends ApiBaseCtrl {
	@Autowired
	private ApiGroupService apiGroupService;

	@PostMapping(value = "/groups",produces="application/json",consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> addNewGroup(@RequestBody ApiGroupModel apiGroupModel) {
		ApiGroup apiGroup = apiGroupService.addApiGroup(apiGroupModel);
		if(apiGroup!=null) {			
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(apiGroupModel);			
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiGroup,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No Group is added");
		}
	}

	@GetMapping(value = "/groups",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> getAllApiGroups() {
		List<ApiGroup> apiGroupList = apiGroupService.getAllApiGroups();
		if (apiGroupList != null) {
			apiReq=makeApiMetaData();						
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiGroupList,apiReq);		
			return ResponseEntity.ok().body(apiResponse);
		} else {
			throw new ResourceNotFoundException("No ApiGroup is yet defined!");
		}
	}

	@GetMapping(value = "/groups/{id}",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> getApiGroupById(@PathVariable("id") Integer id) {
		ApiGroup apiGroup = apiGroupService.getApiGroupByRecordId(id);
		if (apiGroup != null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(id);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiGroup,apiReq);		
			return ResponseEntity.ok().body(apiResponse);
		} else {
			throw new ResourceNotFoundException("No ApiGroup with id ("+id+") is found.");
		}
	}

	@DeleteMapping(value = "/groups/{id}",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> deleteApiGroupById(@PathVariable("id") Integer id) {
		boolean isDeleted = apiGroupService.deleteApiGroupByRecordId(id);
		if (isDeleted) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(id);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(true,apiReq);		
			return ResponseEntity.ok().body(apiResponse);			
		} else {
			throw new ResourceNotFoundException("No ApiGroup with id ("+id+") is found.");
		}
	}

	@PutMapping(value = "/groups",produces="application/json",consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> updateApiGroup(@RequestBody ApiGroupModel apiGroupModel) {
		
		ApiGroup apiGroup = apiGroupService.updateApiGroup(apiGroupModel);
		if (apiGroup != null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(apiGroupModel);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiGroup,apiReq);		
			return ResponseEntity.ok().body(apiResponse);
		} else {			
			throw new ResourceNotFoundException("No ApiGroup with id("+apiGroupModel.getId()+") is found.");
		}
	}

}// End of ApiGroupController
