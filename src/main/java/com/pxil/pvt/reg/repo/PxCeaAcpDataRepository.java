/**
 * 
 */
package com.pxil.pvt.reg.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pxil.pvt.entities.PxCeaAcpCommaSeparated;

/**
 * @author sanjeevkumar
 * 11-Dec-2023
 * 4:37:08 pm 
 * Objective : 
 */
public interface PxCeaAcpDataRepository extends JpaRepository<PxCeaAcpCommaSeparated, Long>{
	
	@Query(value = "from PxCeaAcpCommaSeparated pcad where pcad.date BETWEEN :startDate AND :endDate "			                                       
	                                                 + " and pcad.activeC = 'Y'"
                                                     + "  ORDER BY pcad.date asc  ")
	public List<PxCeaAcpCommaSeparated> getAllPxCeaAcpCommaSeparatedDataBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
	
	
	List<PxCeaAcpCommaSeparated> findByDateBetween(Date fromDate, Date toDate);

}//End of PxCeaAcpDataRepository
