/**
 * 
 */
package com.pxil.sec.model;

/**
 * @author sanjeevkumar 03-Dec-2023 4:06:22 pm Objective:
 */
public class ApiRoleModel extends BaseModel{
	
	private String roleName;	
	
	public ApiRoleModel() {
		super();		
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}// End of ApiRole
