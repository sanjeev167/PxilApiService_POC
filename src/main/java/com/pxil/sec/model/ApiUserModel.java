/**
 * 
 */
package com.pxil.sec.model;

/**
 * @author sanjeevkumar 03-Dec-2023 12:52:00 pm Objective:
 */

public class ApiUserModel extends BaseModel{
	
	private String name;
	private String email;
	private String pwd;
	private String gridNodeCode = null;
	private String userContext;
		
	public ApiUserModel() {
		super();
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the gridNodeCode
	 */
	public String getGridNodeCode() {
		return gridNodeCode;
	}

	/**
	 * @param gridNodeCode the gridNodeCode to set
	 */
	public void setGridNodeCode(String gridNodeCode) {
		this.gridNodeCode = gridNodeCode;
	}

	/**
	 * @return the userContext
	 */
	public String getUserContext() {
		return userContext;
	}

	/**
	 * @param userContext the userContext to set
	 */
	public void setUserContext(String userContext) {
		this.userContext = userContext;
	}
	
	

		
}// End of ApiUserModel
