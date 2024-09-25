/**
 * 
 */
package com.pxil.db.config;

/**
 * @author sanjeevkumar
 * 29-Nov-2023
 * 11:50:26 am 
 * Objective: 
 */
public class ApiJpaConstants {
	
	//Persistence unit 
    public static final String API_SERVICE_JPA_UNIT ="ApiService";
   
	
	//Define all the entities package names here.
    public static final String[] API_SERVICE_PKG_ENTITIES_ARRAY=new String[] {  "com.pxil.pvt.entities",
    		                                                                     "com.pxil.sec.entities" };    
    
  //Define all the repositories package names here.    
    public static final String PKG_SEC_REPO = "com.pxil.sec.repo";
    public static final String PKG_PVT_REGUL_REPO = "com.pxil.pvt.reg.repo";
    public static final String PKG_PUB_REGUL_REPO = "com.pxil.pub.repo";
    public static final String PKG_PVT_SLDC_REPO = "com.pxil.pvt.sldc.repo"; 
    
    
}//End of ApiJpaConstants
