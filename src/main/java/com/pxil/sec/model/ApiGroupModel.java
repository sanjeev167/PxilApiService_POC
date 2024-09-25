/**
 * 
 */
package com.pxil.sec.model;

/**
 * @author sanjeevkumar
 * 03-Dec-2023
 * 4:47:00 pm 
 * Objective: 
 */
public class ApiGroupModel extends BaseModel{	
	 private String     groupName ;	 

	public ApiGroupModel() {
		super();		
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}	 
	 
}//End of ApiGroupModel
