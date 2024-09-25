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
import com.pxil.sec.entities.ApiGroupRole;
import com.pxil.sec.model.ApiGroupRoleModel;
import com.pxil.sec.service.ApiGroupRoleService;

/**
 * @author sanjeevkumar 
 * 04-Dec-2023 
 * 1:50:40 am 
 * Objective:
 */
@RestController
@RequestMapping("/sec/v1")
public class ApiGroupRoleController extends ApiBaseCtrl {

	@Autowired
	private ApiGroupRoleService apiGroupRoleService;

	@PostMapping(value = "/grouproles",produces="application/json",consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> addNewGroupRole(@RequestBody ApiGroupRoleModel apiGroupRoleModel) {
		ApiGroupRole apiGroupRole = apiGroupRoleService.addApiGroupRole(apiGroupRoleModel);
		if(apiGroupRole!=null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(apiGroupRoleModel);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiGroupRole,apiReq);		
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiGroupRole is added");
		}		
	}

	@GetMapping(value = "/grouproles",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> getAllApiGroupRoles() {
		List<ApiGroupRole> apiGroupRoleList = apiGroupRoleService.getAllApiGroupRoles();
		if(apiGroupRoleList!=null) {
			apiReq=makeApiMetaData();			
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiGroupRoleList,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiGroupRole is yet defined!");
		}		
		
	}

	@GetMapping(value = "/grouproles/{id}",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> getApiGroupRoleById(@PathVariable("id") Integer id) {
		ApiGroupRole apiGroupRole = apiGroupRoleService.getApiGroupRoleByRecordId(id);
		if(apiGroupRole!=null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(id);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiGroupRole,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiGroupRole with id ("+id+") is found.");
		}
	}

	@DeleteMapping(value = "/grouproles/{id}",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> deleteApiGroupRoleById(@PathVariable("id") Integer id) {
		boolean isDeleted = apiGroupRoleService.deleteApiGroupRoleByRecordId(id);
		if(isDeleted) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(id);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(true,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiGroupRole with id ("+id+") is found.");
		}
	}

	@PutMapping(value = "/grouproles",produces="application/json",consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> updateApiGroupRole(@RequestBody ApiGroupRoleModel apiGroupRoleModel) {
		ApiGroupRole apiGroupRole = apiGroupRoleService.updateApiGroupRole(apiGroupRoleModel);
		if(apiGroupRole!=null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(apiGroupRoleModel);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiGroupRole,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {			
			throw new ResourceNotFoundException("No ApiGroupRole with id("+apiGroupRoleModel.getId()+") is found.");
		}		
	}
}// End of ApiGroupRoleController
