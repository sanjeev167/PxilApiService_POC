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
import com.pxil.sec.entities.ApiRole;
import com.pxil.sec.model.ApiRoleModel;
import com.pxil.sec.service.ApiRoleService;

/**
 * @author sanjeevkumar 
 * 04-Dec-2023 
 * 1:47:54 am 
 * Objective:
 */
@RestController
@RequestMapping("/sec/v1")
public class ApiRoleController extends ApiBaseCtrl {

	@Autowired
	private ApiRoleService apiRoleService;

	@PostMapping(value = "/roles",produces="application/json",consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> addNewRole(@RequestBody ApiRoleModel apiRoleModel) {		
		ApiRole apiRole = apiRoleService.addApiRole(apiRoleModel);
		if(apiRole!=null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(apiRoleModel);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiRole,apiReq);		
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiRole is added.");
		}
	}

	@GetMapping(value = "/roles",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> getAllApiRoles() {		
		List<ApiRole> apiRoleList = apiRoleService.getAllApiRoles();
		if(apiRoleList!=null) {
			apiReq=makeApiMetaData();			
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiRoleList,apiReq);		
			return ResponseEntity.ok().body(apiResponse);
		}else {			
			throw new ResourceNotFoundException("No ApiRole is yet defined!");
		}
	}

	@GetMapping(value = "/roles/{id}",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> getApiRoleById(@PathVariable("id") Integer id) {
		ApiRole apiRole = apiRoleService.getApiRoleByRecordId(id);
		if(apiRole!=null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(id);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiRole,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiRole with id("+id+") is found.");
		} 
	}

	@DeleteMapping(value = "/roles/{id}",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> deleteApiRoleById(@PathVariable("id") Integer id) {
		boolean isDeleted = apiRoleService.deleteApiRoleByRecordId(id);
		if(isDeleted) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(id);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(true,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiRole with id("+id+") is found.");
		}
	}

	@PutMapping(value = "/roles",produces="application/json",consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> updateApiRole(@RequestBody ApiRoleModel apiRoleModel) {		
		ApiRole apiRole = apiRoleService.updateApiRole(apiRoleModel);
		if(apiRole!=null) {
			apiReq=makeApiMetaData();
			apiReq.setPayLoad(apiRoleModel);
			//Return response in a pre-defined format	       	
			apiResponse=makeSuccessResponse(apiRole,apiReq);
			return ResponseEntity.ok().body(apiResponse);
		}else {
			throw new ResourceNotFoundException("No ApiRole with id("+apiRoleModel.getId()+") is found.");
		} 
	}

}// End of ApiRoleController