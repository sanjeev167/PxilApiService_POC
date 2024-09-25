/**
 * 
 */
package com.pxil.pvt.reg.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pxil.pvt.entities.PxCeaDataCommaSeparated;

/**
 * @author sanjeevkumar
 * 05-Dec-2023
 * 5:30:47 pm 
 * Objective : 
 */
public interface PxCeaDataCommaSeparatedRepository extends JpaRepository<PxCeaDataCommaSeparated, Long>{
	
	@Query(value = "from PxCeaDataCommaSeparated pcdcs where pcdcs.date BETWEEN :startDate AND :endDate"
			                                          + " and pcdcs.activeC = 'Y'"
			                                          + "  ORDER BY pcdcs.date asc  ")
	public List<PxCeaDataCommaSeparated> getAllCeaDataBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);	
	List<PxCeaDataCommaSeparated> findByDateBetween(Date fromDate, Date toDate);

}//End of PxCeaDataCommaSeparatedRepository
