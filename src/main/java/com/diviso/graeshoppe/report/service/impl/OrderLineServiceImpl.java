package com.diviso.graeshoppe.report.service.impl;

import com.diviso.graeshoppe.report.service.OrderLineService;
import com.diviso.graeshoppe.report.domain.OrderLine;
import com.diviso.graeshoppe.report.repository.OrderLineRepository;
import com.diviso.graeshoppe.report.repository.search.OrderLineSearchRepository;
import com.diviso.graeshoppe.report.service.dto.OrderLineDTO;
import com.diviso.graeshoppe.report.service.mapper.OrderLineMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link OrderLine}.
 */
@Service
@Transactional
public class OrderLineServiceImpl implements OrderLineService {

    private final Logger log = LoggerFactory.getLogger(OrderLineServiceImpl.class);

    private final OrderLineRepository orderLineRepository;

    private final OrderLineMapper orderLineMapper;

    private final OrderLineSearchRepository orderLineSearchRepository;

    public OrderLineServiceImpl(OrderLineRepository orderLineRepository, OrderLineMapper orderLineMapper, OrderLineSearchRepository orderLineSearchRepository) {
        this.orderLineRepository = orderLineRepository;
        this.orderLineMapper = orderLineMapper;
        this.orderLineSearchRepository = orderLineSearchRepository;
    }

    /**
     * Save a orderLine.
     *
     * @param orderLineDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public OrderLineDTO save(OrderLineDTO orderLineDTO) {
        log.debug("Request to save OrderLine : {}", orderLineDTO);
        OrderLine orderLine = orderLineMapper.toEntity(orderLineDTO);
        orderLine = orderLineRepository.save(orderLine);
        OrderLineDTO result = orderLineMapper.toDto(orderLine);
        orderLineSearchRepository.save(orderLine);
        updateToEs(result);
        return result;
    }

    /**
     * Get all the orderLines.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<OrderLineDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OrderLines");
        return orderLineRepository.findAll(pageable)
            .map(orderLineMapper::toDto);
    }


    /**
     * Get one orderLine by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<OrderLineDTO> findOne(Long id) {
        log.debug("Request to get OrderLine : {}", id);
        return orderLineRepository.findById(id)
            .map(orderLineMapper::toDto);
    }

    private void updateToEs(OrderLineDTO orderLineDTO) {
    	OrderLine orderLine = orderLineMapper.toEntity(orderLineDTO);
        orderLine = orderLineRepository.save(orderLine);
        orderLineSearchRepository.save(orderLine);
    }
    /**
     * Delete the orderLine by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete OrderLine : {}", id);
        orderLineRepository.deleteById(id);
        orderLineSearchRepository.deleteById(id);
    }

    /**
     * Search for the orderLine corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<OrderLineDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of OrderLines for query {}", query);
        return orderLineSearchRepository.search(queryStringQuery(query), pageable)
            .map(orderLineMapper::toDto);
    }
    
    @Override
	public List<OrderLine> findOrderLineByOrderNumber(String orderNumber) {
		log.debug("<<<<<<findByOrderLine_OrderMaster impl >>>>>>>>{}", orderNumber);
		/*
		 * List<OrderLine> orderLines = new ArrayList<>();
		 * 
		 * Optional<OrderMaster>
		 * orderMaster=orderMasterRepository.findByOrderNumber(orderNumber);
		 * 
		 * log.info("**********ordermaster{}",orderMaster.get().getId());
		 */
		List<OrderLine> orderLines=orderLineRepository.findByOrderMaster_OrderNumber(orderNumber);	
		for(OrderLine ol:orderLines) {
			log.info("***********{}",ol.getId());
		}
		
		return orderLines;
	}
}
