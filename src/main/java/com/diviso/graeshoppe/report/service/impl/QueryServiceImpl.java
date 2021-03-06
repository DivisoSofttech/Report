package com.diviso.graeshoppe.report.service.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.diviso.graeshoppe.report.client.payment.api.PaymentResourceApi;
import com.diviso.graeshoppe.report.client.payment.model.PaymentDTO;
import com.diviso.graeshoppe.report.service.dto.OrderMasterDTO;
import com.diviso.graeshoppe.report.service.mapper.CustomMapper;
import com.diviso.graeshoppe.report.domain.AuxItem;
import com.diviso.graeshoppe.report.domain.CancellationSummary;
import com.diviso.graeshoppe.report.domain.ComboItem;
import com.diviso.graeshoppe.report.domain.OrderLine;
import com.diviso.graeshoppe.report.domain.OrderMaster;
import com.diviso.graeshoppe.report.domain.ReportOrderModel;
import com.diviso.graeshoppe.report.domain.ReportSummary;
import com.diviso.graeshoppe.report.repository.AuxItemRepository;
import com.diviso.graeshoppe.report.repository.ComboItemRepository;
import com.diviso.graeshoppe.report.repository.OrderLineRepository;
import com.diviso.graeshoppe.report.repository.OrderMasterRepository;
import com.diviso.graeshoppe.report.service.QueryService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import com.diviso.graeshoppe.report.service.OrderMasterService;
@Service
@Transactional
public class QueryServiceImpl implements QueryService {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	OrderMasterService orderMasterService;
	
	@Autowired
	CustomMapper customMapper;

	@Autowired
	OrderMasterRepository orderMasterRepository;
	
	@Autowired
	OrderLineRepository orderLineRepository;
	
	@Autowired
	AuxItemRepository auxItemRepository;
	
	@Autowired
	ComboItemRepository comboItemRepository;
	
	private static List<ReportSummary> reportSummaryList = new ArrayList<ReportSummary>();
	
	/*private fina@Autowired
	OrderLineRepository orderLineRepository;l JestClient jestClient;
	private final JestElasticsearchTemplate elasticsearchTemplate;

	int i = 0;
	Long count = 0L;*/
	private final Logger log = LoggerFactory.getLogger(QueryServiceImpl.class);

	private static List<OrderMaster> orderMasterList = new ArrayList<OrderMaster>();


	@Autowired
	PaymentResourceApi paymentResourceApi;
	
	
	


	List<Long> findByPaymentType(String paymentType, List<String> paymentRefList) {
		List<Long> paymentIdList = new ArrayList<Long>();
		PaymentDTO payment = null;
		for (String payRef : paymentRefList) {
			payment = paymentResourceApi.getPaymentUsingGET(Long.parseLong(payRef)).getBody();
			if (payment.getPaymentType().equalsIgnoreCase(paymentType)) {
				paymentIdList.add(payment.getId());
			}

		}

		return paymentIdList;
	}

	/*@Override
	public OrderMaster findOrderMasterByOrderNumber(@PathVariable String orderNumber) {
	  
		StringQuery searchQuery = new StringQuery(termQuery("orderNumber.keyword", orderNumber).toString());
		return elasticsearchOperations.queryForObject(searchQuery, OrderMaster.class);
	  
	  }*/
	
	/*@Override
	public List<OrderLine> findOrderLineByOrderMaster(@PathVariable Long orderMasterId) {
		log.info("orderMaster Id is " + orderMasterId);
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("orderMaster.id", orderMasterId))
				.withIndices("reportorderline").build();
		return elasticsearchOperations.queryForList(searchQuery, OrderLine.class);
	  
	  }
	 
	@Override
	public List<ComboItem> findComboItemByOrderLine(@PathVariable Long orderLineId) {
		log.info("orderLine Id is " + orderLineId);
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("orderLine.id", orderLineId))
		.build();
		return elasticsearchOperations.queryForList(searchQuery, ComboItem.class);
	  
	  }
	*/
/*	@Override
	public List<AuxItem> findAuxItemByOrderLine(@PathVariable Long orderLineId) {
		log.info("orderLine Id is " + orderLineId);
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("orderLine.id", orderLineId))
		.build();
		return elasticsearchOperations.queryForList(searchQuery, AuxItem.class);
	  }
	
	@Override
	public OrderAggregator getOrderAggregator(String orderNumber) {

		OrderAggregator orderAggregator= new OrderAggregator();
		OrderMaster master=findOrderMasterByOrderNumber(orderNumber);
		orderAggregator.setOrderMaster(master);
		Set<OrderLine> orderLines=new HashSet<OrderLine>(findOrderLineByOrderMaster(master.getId()));
		orderAggregator.getOrderMaster().setOrderLines(orderLines);
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++"+orderAggregator.getOrderMaster());;
		
		
		for(OrderLine orderLine : orderAggregator.getOrderMaster().getOrderLines()) {
			
			List<ComboItem> combos=findComboItemByOrderLine(orderLine.getId());
			List<AuxItem> auxes=findAuxItemByOrderLine(orderLine.getId());
			orderLine.setComboItems(new HashSet<>(combos));
			orderLine.setAuxItems(new HashSet<>(auxes));
			
		}
		return orderAggregator;
	}*/
	
	/***
	 * @author neeraja
	 */
	

	@Override

	public byte[] getReportSummaryAsPdf(String date, String storeId) throws JRException {
		log.debug("<<<<<<<<<<<<<< getReportSummaryAsPdf >>>>>>>>>>{}{}",date,storeId);
		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/reportSummaryV1.jrxml");
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("date", date);
		parameters.put("store_idpcode", storeId);
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> exiting getReportSummaryAsPdf");
		return JasperExportManager.exportReportToPdf(jp);

	}

	/***
	 * @author neeraja
	 */
	public static List<ReportSummary> getReportSummaryList() {
		return reportSummaryList;
	}

	/***
	 * @author neeraja
	 */
	public static void setReportSummaryList(List<ReportSummary> reportSummaryList) {
		QueryServiceImpl.reportSummaryList = reportSummaryList;
	}
	
	/***
	 * @author neeraja
	 */
	@Override
	public byte[] getReportWithAuxAndComboAsPdf(String orderNumber) throws JRException {
		
		
		
		

		OrderMasterDTO orderMasterDto = orderMasterService.findOrderMasterByOrderNumber(orderNumber);
		
		JasperReport jr= null;
		
		
		  if (orderMasterDto.getMethodOfOrder().equalsIgnoreCase("delivery")) { jr =
		  JasperCompileManager.compileReport(
		  "src/main/resources/report/reportdeliveryv1.jrxml"); } else if
		  (orderMasterDto.getMethodOfOrder().equalsIgnoreCase("collection")) { jr =
		  JasperCompileManager.compileReport(
		  "src/main/resources/report/reportcollection.jrxml");
		  
		  }
		 
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("order_number", orderNumber);
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);

		/*JasperPrint jp =null;
		if (orderMasterDto.getMethodOfOrder().equalsIgnoreCase("delivery")) {
			jp = JasperFillManager.fillReport("src/main/resources/report/reportdelivery.jasper", parameters, conn);
		} else if (orderMasterDto.getMethodOfOrder().equalsIgnoreCase("collection")) {
			jp = JasperFillManager.fillReport("src/main/resources/report/reportcollection.jasper", parameters, conn);

		}*/
	
		return JasperExportManager.exportReportToPdf(jp);

	}

	
	
	/***
	 * @author neeraja
	 */
	
	@Override
	public byte[] getSaleReportAsPdf(String storeidpcode) throws JRException {
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("store_i_d_pcode", storeidpcode);
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport("src/main/resources/report/sale.jasper", parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
	}

	@Override
	public byte[] getAllOrdersByMethodOfOrderAsPdf(String fromDate, String toDate, String storeId, String methodOfOrder) throws JRException {
		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/orderbymethodoforder.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("from_date", fromDate);
		parameters.put("to_date", toDate);
		parameters.put("store_idpcode", storeId);
		parameters.put("method_of_order", methodOfOrder);
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
	
	}

	@Override
	public byte[] getAllOrdersByPaymentStatusAsPdf(String fromDate, String toDate, String storeId, String paymentStatus) throws JRException {
		
		
		System.out.println("********************************entering getAllOrdersByPaymentStatusAsPdf method qsimpl");

		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/ordersbypaymentstatus.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("from_date", fromDate);
		parameters.put("to_date", toDate);
		parameters.put("store_idpcode", storeId);
		parameters.put("payment_status", paymentStatus);
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
	}

	

	@Override
	public byte[] getAllOrdersByDateAndStoreNameAsPdf(String date, String storeId) throws JRException{
		
		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/ordersbydateandstorename.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("date", date);
		parameters.put("store_idpcode", storeId);
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
		
	}

	@Override
	public byte[] getAllOrdersBetweenDatesAsPdf(String fromDate, String toDate) throws JRException{
		
		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/ordersbetweendates.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("from_date", fromDate);
		parameters.put("to_date", toDate);
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
	}

	@Override
	public byte[] getOrderSummaryBetweenDatesAsPdf(String fromDate, String toDate, String storeId) throws JRException {


		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/ordersummarybetweendates.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("from_date", fromDate);
		parameters.put("to_date", toDate);
		parameters.put("store_idpcode", storeId);
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
	}

	@Override
	public byte[] getOrderSummaryByDateAndStoreNameAsPdf(String date, String storeId) throws JRException {
		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/ordersummaryadmin.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("date", date);
		parameters.put("store_idpcode", storeId);
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
	}

	@Override
	public byte[] getAllOrdersBetweenDatesAndStoreIdAsPdf(String fromDate, String toDate, String storeId )throws JRException {
		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/ordersbetweendatesandstorename.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("from_date", fromDate);
		parameters.put("to_date", toDate);
		parameters.put("store_idpcode", storeId);
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
	}
	
	
	/***
	 * @author neeraja
	 */
	@Override
	public ReportSummary createReportSummary(String date, String storeName) {
		Instant dateBegin = Instant.parse(date.toString() + "T00:00:00Z");
		Instant dateEnd = Instant.parse(date.toString() + "T23:59:59Z");
		ReportSummary reportSummary = new ReportSummary();
		List<OrderMaster> omList=null;
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+dateBegin+">>>>>>>>>"+dateEnd);
		
		reportSummary.setDate(LocalDate.parse(date));
		
		reportSummary.setStoreId(storeName);

	
		if(date!=null && storeName!=null) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> store id != null");
			omList= orderMasterRepository.findByOrderPlaceAtBetweenAndStoreIdpcode(dateBegin, dateEnd, storeName);
		
		}
		else if(date!=null && storeName==null) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> store id == null");
			omList=orderMasterRepository.findByOrderPlaceAtBetween(dateBegin, dateEnd);
		}
		Double sum=0.0;
		Long codOrdersCount=0l;
		Double codOrdersSum=0.0;
		Long cardOrdersCount=0l;
		Double cardOrdersSum=0.0;
		Long deliveryCount= 0l;
		Double deliveryOrdersSum=0.0;
		Long collectionCount=0l;
		Double collectionOrdersSum=0.0;
		
		
		
		for(OrderMaster om: omList) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> entering for loop");
			sum +=om.getTotalDue();
			if(om.getPaymentStatus().equals("ORDER NOT PAID")) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>  order not paid");
				codOrdersCount++;
				codOrdersSum += om.getTotalDue();
				
			}else if(om.getPaymentStatus().equals("ORDER PAID")) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> order paid");
				cardOrdersCount++;
				cardOrdersSum +=  om.getTotalDue();
			}
			
			
			if(om.getMethodOfOrder().equals("DELIVERY")) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>  delivery");
				deliveryCount++;
				deliveryOrdersSum += om.getTotalDue();
			}
			else if(om.getMethodOfOrder().equals("COLLECTION")){
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> collection");
				 collectionCount++;
				 collectionOrdersSum += om.getTotalDue();
			}
			System.out.println(om.getMethodOfOrder()+"1");
		}
		reportSummary.setTypeAllCount(omList.size());
		reportSummary.setTypeAllTotal(sum);
		reportSummary.setTypeCardCount(cardOrdersCount);
		reportSummary.setTypeCardTotal(cardOrdersSum);
		reportSummary.setTypeCashCount(codOrdersCount);
		reportSummary.setTypeCashTotal(codOrdersSum);
		reportSummary.setTypeDeliveryCount(deliveryCount);
		reportSummary.setTypeDeliveryTotal(deliveryOrdersSum);
		reportSummary.setTypeCollectionCount(collectionCount);
		reportSummary.setTypeCollectionTotal(collectionOrdersSum);
		
		return reportSummary;
	}
		/*
		 * reportSummary.setTypeAllCount(
		 * orderMasterRepository.countByOrderPlaceAtBetweenAndStoreName(dateBegin,
		 * dateEnd, storeName));
		 * reportSummary.setTypeAllTotal(orderMasterRepository.sumOfTotalDue(dateBegin,
		 * dateEnd, storeName)); reportSummary.setTypeDeliveryCount(
		 * orderMasterRepository.countByMethodOfOrderAndStoreName(dateBegin, dateEnd,
		 * storeName, "delivery")); reportSummary.setTypeCollectionCount(
		 * orderMasterRepository.countByMethodOfOrderAndStoreName(dateBegin, dateEnd,
		 * storeName, "collection")); reportSummary.setTypeDeliveryTotal(
		 * orderMasterRepository.sumOfTotalByOrderType(dateBegin, dateEnd, storeName,
		 * "delivery")); reportSummary.setTypeCollectionTotal(
		 * orderMasterRepository.sumOfTotalByOrderType(dateBegin, dateEnd, storeName,
		 * "collection")); reportSummary.setTypeCardCount(
		 * orderMasterRepository.countByPaymentStatusAndStoreName(dateBegin, dateEnd,
		 * storeName, "order paid")); reportSummary.setTypeCashCount(
		 * orderMasterRepository.countByPaymentStatusAndStoreName(dateBegin, dateEnd,
		 * storeName, "order not paid")); reportSummary.setTypeCardTotal(
		 * orderMasterRepository.sumOftotalByPaymentStatus(dateBegin, dateEnd,
		 * storeName, "order paid")); reportSummary.setTypeCashTotal(
		 * orderMasterRepository.sumOftotalByPaymentStatus(dateBegin, dateEnd,
		 * storeName, "order not paid"));
		 */
		
	

	
	
	
	/***
	 * @author neeraja
	 */
	public static List<OrderMaster> getOrderMasterList() {
		return orderMasterList;
	}

	/***
	 * @author neeraja
	 */
	public static void setOrderMasterList(List<OrderMaster> orderMasterList) {
		QueryServiceImpl.orderMasterList = orderMasterList;
	}
	

	@Override
	public Page<OrderMaster> getOrdersViewByMethodOfOrder(String storeIdpcode, String fromDate,String toDate, String methodOfOrder,Pageable pageable) {
		
		Instant dateBegin = Instant.parse(fromDate.toString() + "T00:00:00Z");
		Instant dateEnd = Instant.parse(toDate.toString() + "T23:59:59Z");
		return orderMasterRepository.findByOrderPlaceAtBetweenAndStoreIdpcodeAndMethodOfOrder(dateBegin, dateEnd,storeIdpcode, methodOfOrder, pageable);
		
		
	}

	@Override
	public Page<OrderMaster> getOrdersViewByPaymentStatus(String storeIdpcode, String fromDate, String toDate, String paymentStatus, Pageable pageable) {
		
		Instant dateBegin = Instant.parse(fromDate.toString() + "T00:00:00Z");
		Instant dateEnd = Instant.parse(toDate.toString() + "T23:59:59Z");
		return orderMasterRepository.findByOrderPlaceAtBetweenAndStoreIdpcodeAndPaymentStatus(dateBegin, dateEnd,storeIdpcode, paymentStatus, pageable);
		
		
	}

	@Override
	public Page<OrderMaster> getOrdersViewBetweenDates(String fromDate, String toDate, Pageable pageable) {
	
	
		Instant dateBegin = Instant.parse(fromDate.toString() + "T00:00:00Z");
		Instant dateEnd = Instant.parse(toDate.toString() + "T23:59:59Z");
		 return orderMasterRepository.findByOrderPlaceAtBetween(dateBegin, dateEnd, pageable);
		

		
	}

	@Override
	public Page<OrderMaster> getOrdersViewBetweenDatesAndStoreIdpcode(String fromDate, String toDate, String storeId, Pageable pageable) {
		
		Instant dateBegin = Instant.parse(fromDate.toString() + "T00:00:00Z");
		Instant dateEnd = Instant.parse(toDate.toString() + "T23:59:59Z");
		return orderMasterRepository.findByOrderPlaceAtBetweenAndStoreIdpcode(dateBegin, dateEnd,storeId, pageable);
		
		
	}

	@Override
	public Page<OrderMaster> getOrdersViewBetweenDatesAndPaymentStatus(String fromDate, String toDate,
			String paymentStatus, Pageable pageable) {
		System.out.println("service impl>>>>>>>>>"+fromDate+">>>>>>>>>>>>>>>>"+toDate+">>>>>>>>>>>"+paymentStatus);
		Instant dateBegin = Instant.parse(fromDate.toString() + "T00:00:00Z");
		Instant dateEnd = Instant.parse(toDate.toString() + "T23:59:59Z");
		return orderMasterRepository.findByOrderPlaceAtBetweenAndPaymentStatus(dateBegin, dateEnd,paymentStatus,  pageable);
		
	}
	
	@Override
	public Page<OrderMaster> getOrdersViewBetweenDatesAndMethodOfOrder(String fromDate, String toDate,
			String methodOfOrder, Pageable pageable) {
		

		Instant dateBegin = Instant.parse(fromDate.toString() + "T00:00:00Z");
		Instant dateEnd = Instant.parse(toDate.toString() + "T23:59:59Z");
		return orderMasterRepository.findByOrderPlaceAtBetweenAndMethodOfOrder(dateBegin, dateEnd,methodOfOrder,  pageable);
		
	}

	@Override
	public Page<OrderMaster> getOrdersViewBetweenDatesAndPaymentStatusAndMethodOfOrder(String fromDate, String toDate,
			String paymentStatus, String methodOfOrder, Pageable pageable) {
		
		Instant dateBegin = Instant.parse(fromDate.toString() + "T00:00:00Z");
		Instant dateEnd = Instant.parse(toDate.toString() + "T23:59:59Z");
		return orderMasterRepository.findByOrderPlaceAtBetweenAndPaymentStatusAndMethodOfOrder(dateBegin, dateEnd,paymentStatus, methodOfOrder,  pageable);
	}

	@Override
	public Page<OrderMaster> getOrdersViewBetweenDatesAndStoreIdpcodeAndPaymentStatusAndMethodOfOrder(String fromDate,
			String toDate, String storeIdpcode, String paymentStatus, String methodOfOrder, Pageable pageable) {
		
		
		Instant dateBegin = Instant.parse(fromDate.toString() + "T00:00:00Z");
		Instant dateEnd = Instant.parse(toDate.toString() + "T23:59:59Z");
		return orderMasterRepository.findByOrderPlaceAtBetweenAndStoreIdpcodeAndPaymentStatusAndMethodOfOrder(dateBegin, dateEnd, storeIdpcode,paymentStatus, methodOfOrder,  pageable);
	
	}

	@Override
	public byte[] getAllOrdersBetweenDatesByPaymentStatusAsPdf(String fromDate, String toDate,
			String paymentStatus) throws JRException {
		

		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/ordersByDateAndPaymentStatusOnly.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("from_date", fromDate);
		parameters.put("to_date", toDate);
		parameters.put("payment_status", paymentStatus);
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
	}

	@Override
	public byte[] getAllOrdersBetweenDatesByMethodOfOrderAsPdf(String fromDate, String toDate,
			String methodOfOrder) throws JRException {
				JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/OrdersByDateAndMethodOfOrderOnly.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("from_date", fromDate);
		parameters.put("to_date", toDate);
		parameters.put("method_of_order", methodOfOrder);
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
	}

	@Override
	public byte[] getAllOrdersBetweenDatesByPaymentStatusAndMethodOfOrderAsPdf(String fromDate, String toDate,
			String paymentStatus, String methodOfOrder) throws JRException{
		
		System.out.println("entering getAllOrdersBetweenDatesByPaymentStatusAndMethodOfOrderAsPdf method");
		
		
		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/ordersByDateAndPaymentAndMethod.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("from_date", fromDate);
		parameters.put("to_date", toDate);
		parameters.put("payment_status", paymentStatus);
		parameters.put("method_of_order", methodOfOrder);
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
		
	}

	@Override
	public byte[] getAllOrdersBetweenDatesByStoreIdAndPaymentStatusAndMethodOfOrderAsPdf(String fromDate,
			String toDate, String storeId, String paymentStatus, String methodOfOrder) throws JRException {
		
		System.out.println("/////////////////////////////////// entering getAllOrdersBetweenDatesByStoreIdAndPaymentStatusAndMethodOfOrderAsPdf  qsimpl");
		
		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/ordersByDateAndStoreIdAndPaymentAndMethod.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("from_date", fromDate);
		parameters.put("to_date", toDate);
		parameters.put("store_id", storeId);
		parameters.put("payment_status", paymentStatus);
		parameters.put("method_of_order", methodOfOrder);
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
		
	}

	@Override
	public byte[] getReportSummaryByDateOnlyAsPdf(String date) throws JRException {
		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/reportSummaryByDateOnly.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("date", date);
		
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
	}

	@Override
	public byte[] getDetailedOrderSummaryAsPdf(String date, String storeName) throws JRException {
		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/detailedOrderSummary1.jrxml");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("date", date);
		parameters.put("store_idpcode", storeName);
		
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
	}

	@Override
	public byte[] getCancellationSummaryAsPdf(String date, String storeName) throws JRException {
		
		JasperReport jr = JasperCompileManager.compileReport("src/main/resources/report/cancellationReport.jrxml");
		 System.out.println(">>>>>>>>>>>>>>>>>>>> cancellationSummary impl"+date+">>>>>>>>>>"+storeName);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("date", date);
		parameters.put("store_idpcode", storeName);
		
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
		return JasperExportManager.exportReportToPdf(jp);
	}

	@Override
	public CancellationSummary createCancellationReportSummaryView(String date, String storeName) {
		Instant dateBegin = Instant.parse(date.toString() + "T00:00:00Z");
		Instant dateEnd = Instant.parse(date.toString() + "T23:59:59Z");
		CancellationSummary cancellationSummary = new CancellationSummary();
		
		cancellationSummary.setDate(LocalDate.parse(date));
		
		cancellationSummary.setStoreId(storeName);

	
		
		List<OrderMaster> omList= orderMasterRepository.findByOrderPlaceAtBetweenAndStoreIdpcode(dateBegin, dateEnd, storeName);
	
		Double sum=0.0;
		Long allCardCount=0l;
		Double allCardTotal=0.0;
		Double allRefundAmount=0.0;
		Long deliveryCardCount=0l;
		Double deliveryCardTotal=0.0;
		Double deliveryRefundAmount=0.0;
		Long collectionCardCount= 0l;
		Double collectionCardTotal=0.0;
		Double collectionRefundAmount=0.0;
		
		
		
		for(OrderMaster om: omList) {
			
			sum +=om.getTotalDue();
			if(om.getPaymentStatus().equals("ORDER PAID")&& om.getCancellationRef()!=null) {
				allCardCount++;
				allCardTotal += om.getTotalDue();
				allRefundAmount += om.getRefundedAmount();
			}
			
			
			if(om.getMethodOfOrder().equals("DELIVERY") && om.getPaymentStatus().equals("ORDER PAID") && om.getCancellationRef() != null) {
				deliveryCardCount++;
				deliveryCardTotal += om.getTotalDue();
				deliveryRefundAmount += om.getRefundedAmount();
			}
			
			if(om.getMethodOfOrder().equals("COLLECTION" )&& om.getPaymentStatus().equals("ORDER PAID") && om.getCancellationRef() != null){
				 collectionCardCount++;
				 collectionCardTotal += om.getTotalDue();
				 collectionRefundAmount += om.getRefundedAmount();
			}
			System.out.println(om.getMethodOfOrder()+"1");
		}
		
		cancellationSummary.setAllCardCount(allCardCount);
		cancellationSummary.setAllCardTotal(allCardTotal);
		cancellationSummary.setAllRefundAmount(allRefundAmount);
		cancellationSummary.setCollectionCardCount(collectionCardCount);
		cancellationSummary.setCollectionCardTotal(collectionCardTotal);
		cancellationSummary.setCollectionRefundAmount(collectionRefundAmount);
		cancellationSummary.setDeliveryCardCount(deliveryCardCount);
		cancellationSummary.setDeliveryCardTotal(deliveryCardTotal);
		cancellationSummary.setDeliveryRefundAmount(deliveryRefundAmount);

		
		
		return cancellationSummary;

	}

	@Override
	public Double findGrandTotalBetweenDateAndStoreName(String fromDate, String toDate, String storeName) {
		
		
			Instant dateBegin = Instant.parse(fromDate.toString() + "T00:00:00Z");
			Instant dateEnd = Instant.parse(toDate.toString() + "T23:59:59Z");

			List<OrderMaster> omList= orderMasterRepository.findByOrderPlaceAtBetweenAndStoreIdpcode(dateBegin, dateEnd, storeName);
		
			Double sum=0.0;
			

			for(OrderMaster om: omList) {
				sum +=om.getTotalDue();
			}
			return sum;
	}

	@Override
	public ReportSummary createDetailedReportSummaryView(String fromDate, String toDate, String storeName) {
	
		Instant dateBegin = Instant.parse(fromDate.toString() + "T00:00:00Z");
		Instant dateEnd = Instant.parse(toDate.toString() + "T23:59:59Z");
		ReportSummary reportSummary = new ReportSummary();
		List<OrderMaster> omList=null;
		reportSummary.setDate(LocalDate.parse(fromDate));
		
		reportSummary.setStoreId(storeName);

	
		if(fromDate!=null && toDate!=null && storeName!=null) {
			omList= orderMasterRepository.findByOrderPlaceAtBetweenAndStoreIdpcode(dateBegin, dateEnd, storeName);
		
		}
		else if(fromDate!=null && toDate!=null &&  storeName==null) {
			omList=orderMasterRepository.findByOrderPlaceAtBetween(dateBegin, dateEnd);
		}
		Double sum=0.0;
		Long codOrdersCount=0l;
		Double codOrdersSum=0.0;
		Long cardOrdersCount=0l;
		Double cardOrdersSum=0.0;
		Long deliveryCount= 0l;
		Double deliveryOrdersSum=0.0;
		Long collectionCount=0l;
		Double collectionOrdersSum=0.0;
		
		
		
		for(OrderMaster om: omList) {
			
			sum +=om.getTotalDue();
			if(om.getPaymentStatus().equals("ORDER NOT PAID")) {
				codOrdersCount++;
				codOrdersSum += om.getTotalDue();
				
			}else if(om.getPaymentStatus().equals("ORDER PAID")) {
				cardOrdersCount++;
				cardOrdersSum +=  om.getTotalDue();
			}
			
			
			if(om.getMethodOfOrder().equals("DELIVERY")) {
				deliveryCount++;
				deliveryOrdersSum += om.getTotalDue();
			}
			else if(om.getMethodOfOrder().equals("COLLECTION")){
				 collectionCount++;
				 collectionOrdersSum += om.getTotalDue();
			}
			System.out.println(om.getMethodOfOrder()+"1");
		}
		reportSummary.setTypeAllCount(omList.size());
		reportSummary.setTypeAllTotal(sum);
		reportSummary.setTypeCardCount(cardOrdersCount);
		reportSummary.setTypeCardTotal(cardOrdersSum);
		reportSummary.setTypeCashCount(codOrdersCount);
		reportSummary.setTypeCashTotal(codOrdersSum);
		reportSummary.setTypeDeliveryCount(deliveryCount);
		reportSummary.setTypeDeliveryTotal(deliveryOrdersSum);
		reportSummary.setTypeCollectionCount(collectionCount);
		reportSummary.setTypeCollectionTotal(collectionOrdersSum);
		
		reportSummary.setCollectionCard(orderMasterRepository.findByOrderPlaceAtBetweenAndStoreIdpcodeAndMethodOfOrderAndPaymentStatus(dateBegin, dateEnd, storeName, "COLLECTION", "CARD"));
		reportSummary.setCollectionCash(orderMasterRepository.findByOrderPlaceAtBetweenAndStoreIdpcodeAndMethodOfOrderAndPaymentStatus(dateBegin, dateEnd, storeName, "COLLECTION", "CASH"));
		reportSummary.setDeliveryCard(orderMasterRepository.findByOrderPlaceAtBetweenAndStoreIdpcodeAndMethodOfOrderAndPaymentStatus(dateBegin, dateEnd, storeName, "DELIVERY", "CARD"));
		reportSummary.setDeliveryCash(orderMasterRepository.findByOrderPlaceAtBetweenAndStoreIdpcodeAndMethodOfOrderAndPaymentStatus(dateBegin, dateEnd, storeName, "DELIVERY", "CASH"));
		return reportSummary;
	}

	@Override
	public String getDocketHeaderView(String orderNumber) {
//		Optional<Object> om= orderMasterRepository.findByOrderNumber(orderNumber).map(customMapper::toEntity);
		OrderMaster om= orderMasterRepository.findByOrderNumber(orderNumber).get();

		System.out.println("converted data"+customMapper.toEntity(om).getHeaders());
		return customMapper.toEntity(om).getHeaders();
		
	}

	@Override
	public String getDocketContent(String orderNumber) {
		OrderMaster om= orderMasterRepository.findByOrderNumber(orderNumber).get();
		return customMapper.toEntity(om).getContent();
	}

	@Override
	public String getDocketProduct(String orderNumber) {
		OrderMaster om= orderMasterRepository.findByOrderNumber(orderNumber).get();
		Set<OrderLine> ol=orderLineRepository.findByOrderMasterId(om.getId());
		om.setOrderLines(ol);
		
		for(OrderLine ol1:ol) {	
		Set<AuxItem> ai=auxItemRepository.findByOrderLineId(ol1.getId());
		ol1.setAuxItems(ai);
		Set<ComboItem> ci= comboItemRepository.findByOrderLineId(ol1.getId());
		ol1.setComboItems(ci);
		}
		
		return customMapper.toEntity(om).getProducts();
		
	}

	@Override
	public String getDocketDiscountAndTotal(String orderNumber) {
		OrderMaster om= orderMasterRepository.findByOrderNumber(orderNumber).get();
		return customMapper.toEntity(om).getDiscountAndTotal();
	}

	@Override
	public String getDocketPaymentStatus(String orderNumber) {
		OrderMaster om= orderMasterRepository.findByOrderNumber(orderNumber).get();
		return customMapper.toEntity(om).getPaymentStatusForDocket();
	}

	@Override
	public String getDocketCustomerOrderDetails(String orderNumber) {
		OrderMaster om= orderMasterRepository.findByOrderNumber(orderNumber).get();
		return customMapper.toEntity(om).getCustomerOrderDetails();
	}

	@Override
	public String getDocketCustomerDetails(String orderNumber) {
		OrderMaster om= orderMasterRepository.findByOrderNumber(orderNumber).get();
		return customMapper.toEntity(om).getCustomerDetails();
	}

	@Override
	public String getFooters(String orderNumber) {
		OrderMaster om= orderMasterRepository.findByOrderNumber(orderNumber).get();
		return customMapper.toEntity(om).getFooter();
	}

	@Override
	public String getAttentionForOrder(String orderNumber) {
		OrderMaster om= orderMasterRepository.findByOrderNumber(orderNumber).get();
		return customMapper.toEntity(om).getAttentionForFirstOrder();
	}

	@Override
	public String getOrderTimes(String orderNumber) {
		OrderMaster om= orderMasterRepository.findByOrderNumber(orderNumber).get();
		return customMapper.toEntity(om).getOrderTimes();
	}
	


	
	/*public ReportSummary createReportSummaryBetweenTwoDates(String fromDate, String toDate) {
	
		Instant dateBegin = Instant.parse(fromDate.toString() + "T00:00:00Z");
		Instant dateEnd = Instant.parse(toDate.toString() + "T23:59:59Z");
		ReportSummary reportSummary = new ReportSummary();
		reportSummary.setFromDate(LocalDate.parse(fromDate));
		reportSummary.setToDate(LocalDate.parse(toDate));

		reportSummary.setTypeAllCount(
				orderMasterRepository.countByOrderPlaceAtBetween(dateBegin, dateEnd));
		reportSummary.setTypeAllTotal(orderMasterRepository.sumOfTotalDue(dateBegin, dateEnd));
		reportSummary.setTypeDeliveryCount(
				orderMasterRepository.countByMethodOfOrder(dateBegin, dateEnd, "delivery"));
		reportSummary.setTypeCollectionCount(
				orderMasterRepository.countByMethodOfOrder(dateBegin, dateEnd, "collection"));
		reportSummary.setTypeDeliveryTotal(
				orderMasterRepository.sumOfTotalByOrderType(dateBegin, dateEnd, "delivery"));
		reportSummary.setTypeCollectionTotal(
				orderMasterRepository.sumOfTotalByOrderType(dateBegin, dateEnd, "collection"));
		reportSummary.setTypeCardCount(
				orderMasterRepository.countByPaymentStatus(dateBegin, dateEnd, "order paid"));
		reportSummary.setTypeCashCount(
				orderMasterRepository.countByPaymentStatus(dateBegin, dateEnd, "order not paid"));
		reportSummary.setTypeCardTotal(
				orderMasterRepository.sumOftotalByPaymentStatus(dateBegin, dateEnd, "order paid"));
		reportSummary.setTypeCashTotal(
				orderMasterRepository.sumOftotalByPaymentStatus(dateBegin, dateEnd, "order not paid"));

		return reportSummary;
		
		
	}*/

	/*
	 * @Override public List<OrderMaster> getOrdersViewByDateAndStoreIdpcode(String
	 * fromDate,String toDate, String storeId) {
	 * 
	 * Instant dateBegin = Instant.parse(fromDate.toString() + "T00:00:00Z");
	 * Instant dateEnd = Instant.parse(toDate.toString() + "T23:59:59Z");
	 * setOrderMasterList(orderMasterRepository.
	 * findByOrderPlaceAtBetweenAndStoreIdpcode(dateBegin, dateEnd,storeId));
	 * 
	 * return getOrderMasterList();
	 * 
	 * }
	 */
	
	
}
