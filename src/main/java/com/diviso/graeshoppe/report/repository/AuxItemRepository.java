package com.diviso.graeshoppe.report.repository;

import com.diviso.graeshoppe.report.domain.AuxItem;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AuxItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AuxItemRepository extends JpaRepository<AuxItem, Long> {

	List<AuxItem> findByOrderLine_id(Long id);
	
	Set<AuxItem> findByOrderLineId(Long id);

}
