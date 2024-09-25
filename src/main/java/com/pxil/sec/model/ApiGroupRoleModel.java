/**
 * 
 */
package com.pxil.sec.model;

/**
 * @author sanjeevkumar
 * 03-Dec-2023
 * 5:49:36 pm 
 * Objective: 
 */
public class ApiGroupRoleModel extends BaseModel{
	
	 private Integer    apiGroupId ;
	 private Integer    apiRoleId ;
	 
	 
	 
	public ApiGroupRoleModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the apiGroupId
	 */
	public Integer getApiGroupId() {
		return apiGroupId;
	}
	/**
	 * @param apiGroupId the apiGroupId to set
	 */
	public void setApiGroupId(Integer apiGroupId) {
		this.apiGroupId = apiGroupId;
	}
	/**
	 * @return the apiRoleId
	 */
	public Integer getApiRoleId() {
		return apiRoleId;
	}
	/**
	 * @param apiRoleId the apiRoleId to set
	 */
	public void setApiRoleId(Integer apiRoleId) {
		this.apiRoleId = apiRoleId;
	}
	 
	 
}//End of ApiRoleGroupModel
