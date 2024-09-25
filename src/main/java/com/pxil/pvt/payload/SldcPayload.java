/**
 * 
 */
package com.pxil.pvt.payload;

import javax.validation.constraints.NotEmpty;

/**
 * @author sanjeevkumar
 * 07-Jan-2024
 * 11:04:56 pm
 * Objective : 
 */
public class SldcPayload {
	
	@NotEmpty(message = "Delivery-Date is mandatory")
	private String delDate;
	
	@NotEmpty( message = "Product-Code should not be null or empty.")
	private String productCode;	
	
	//No validation is required on this field as it is not coming from the front end
	private String gridNodeCode;
	private String apiUser;
	/**
	 * @return the delDate
	 */
	public String getDelDate() {
		return delDate;
	}
	/**
	 * @param delDate the delDate to set
	 */
	public void setDelDate(String delDate) {
		this.delDate = delDate;
	}
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
	 * @return the apiUser
	 */
	public String getApiUser() {
		return apiUser;
	}
	/**
	 * @param apiUser the apiUser to set
	 */
	public void setApiUser(String apiUser) {
		this.apiUser = apiUser;
	}
	
	
	
}//End of SldcIdasPayload
