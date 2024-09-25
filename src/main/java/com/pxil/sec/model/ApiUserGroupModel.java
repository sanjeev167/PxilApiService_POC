/**
 * 
 */
package com.pxil.sec.model;

/**
 * @author sanjeevkumar
 * 03-Dec-2023
 * 5:17:34 pm 
 * Objective: 
 */
public class ApiUserGroupModel extends BaseModel{

	 private Integer    apiUserId ;
	 private Integer    apiGroupId ;
	 
	 
	public ApiUserGroupModel() {
		super();		
	}
	/**
	 * @return the apiUserId
	 */
	public Integer getApiUserId() {
		return apiUserId;
	}
	/**
	 * @param apiUserId the apiUserId to set
	 */
	public void setApiUserId(Integer apiUserId) {
		this.apiUserId = apiUserId;
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
	 
	 
}//End of ApiUserGroupModel
