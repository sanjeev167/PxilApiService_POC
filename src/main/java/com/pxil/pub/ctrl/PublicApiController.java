/**
 * 
 */
package com.pxil.pub.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sanjeevkumar
 * 26-Dec-2023
 * 4:53:51 am 
 * Objective : 
 */
@RestController
@RequestMapping("/pub/v1")
public class PublicApiController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome! this endpoint is not secured";
	}

}//End of PublicApiController
