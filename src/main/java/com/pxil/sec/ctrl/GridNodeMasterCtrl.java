/**
 * 
 */
package com.pxil.sec.ctrl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pxil.api.struct.ApiHead;
import com.pxil.exception.ResourceNotFoundException;
import com.pxil.sec.entities.ApiGroup;
import com.pxil.sec.service.ApiGroupService;

/**
 * @author sanjeevkumar
 * 08-Jan-2024
 * 2:39:01 pm
 * Objective : 
 */
@RestController
@RequestMapping("/sec/v1")
public class GridNodeMasterCtrl extends ApiBaseCtrl{
	@Autowired
	private ApiGroupService apiGroupService;
	
	@GetMapping(value = "/gridNodes",produces="application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER','ROLE_ADMIN')")
	public ResponseEntity<Object> getAllGridNodes() {
		List<ApiGroup> apiGroupList = apiGroupService.getAllApiGroups();
		if (apiGroupList != null) {
			apiResponse.setBody(apiGroupList);
			apiResponse.setMeta(makeApiMetaData());
			apiResponse.setHead(new ApiHead(LocalDateTime.now(), HttpStatus.OK, "Successful","200"));
			return ResponseEntity.ok().body(apiResponse);
		} else {
			throw new ResourceNotFoundException("No ApiGroup is yet defined!");
		}
	}

}//End of GridNodeMasterCtrl
