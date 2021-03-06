package com.diviso.graeshoppe.report.repository;

import com.diviso.graeshoppe.report.domain.ComboItem;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ComboItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ComboItemRepository extends JpaRepository<ComboItem, Long> {

	Set<ComboItem> findByOrderLineId(Long id);

}
