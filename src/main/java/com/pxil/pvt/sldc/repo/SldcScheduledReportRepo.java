/**
 * 
 */
package com.pxil.pvt.sldc.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pxil.pvt.entities.ApiScheduleWithLossCommaSeparated;

/**
 * @author sanjeevkumar
 * 07-Jan-2024
 * 10:36:31 pm
 * Objective : 
 */
public interface SldcScheduledReportRepo extends JpaRepository<ApiScheduleWithLossCommaSeparated, Long>{	
	
	@Query(nativeQuery = true, value = "Select * from api_schedule_with_loss_comma_separated asws"
					                 + " where asws.delivery_to_date = :deliveryDate"
		                             + " and asws.product_code = :productCode"
		                             + " and asws.grid_node_code = :gridNodeCode"
		                             + " ORDER BY asws.delivery_to_date asc  ")	
	List<ApiScheduleWithLossCommaSeparated> getApiScheduleWithLossCommaSeparatedList(@Param("deliveryDate") Date deliveryDate,
												                                     @Param("productCode") String productCode,
												                                     @Param("gridNodeCode") String gridNodeCode);
		
	//Call this function first	
	@Query(nativeQuery = true, value = "SELECT api_sldc_insertion_updation_fn(:productCode,"
			                                                                   + ":deliveryStartDate,"
			                                                                   + ":deliveryEndDate,"
			                                                                   + ":gridNodeCode)")
	Integer callApiSldcInsertionUpdationFn(@Param("productCode") String productCode, 
			                               @Param("deliveryStartDate") java.sql.Date deliveryStartDate,
			                               @Param("deliveryEndDate") java.sql.Date deliveryEndDate,
			                               @Param("gridNodeCode") String gridNodeCode);
	
	
	
	
	
	
	//Call this function Second	
	@Query(nativeQuery = true, value = "SELECT api_sldc_comma_separated_fn(:productCode,"
																		            + ":deliveryStartDate,"
																		            + ":deliveryEndDate,"
																		            + ":gridNodeCode)")
	Integer callApiSldcCommaSeparatedFn(@Param("productCode") String productCode, 
							            @Param("deliveryStartDate") java.sql.Date deliveryStartDate,
							            @Param("deliveryEndDate") java.sql.Date deliveryEndDate,
							            @Param("gridNodeCode") String gridNodeCode);
	
}//End of SldcScheduledReportRepo
