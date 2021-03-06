package com.diviso.graeshoppe.report.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.diviso.graeshoppe.report.domain.CancellationSummary;
import com.diviso.graeshoppe.report.domain.OrderMaster;
import com.diviso.graeshoppe.report.domain.ReportOrderModel;
import com.diviso.graeshoppe.report.domain.ReportSummary;

import net.sf.jasperreports.engine.JRException;
public interface QueryService {
		


	byte[] getReportSummaryAsPdf(String date, String storeId) throws JRException;

	/**
	 * @param orderNumber
	 * @return
	 */
	byte[] getReportWithAuxAndComboAsPdf(String orderNumber) throws JRException;
	
	ReportSummary createReportSummary(String date,String storeName);

	byte[] getSaleReportAsPdf(String storeidpcode)throws JRException;

	byte[] getAllOrdersByMethodOfOrderAsPdf(String fromDate, String toDate, String storeId, String methodOfOrder) throws JRException;

	byte[] getAllOrdersByPaymentStatusAsPdf(String fromDate,String toDate, String storeId, String paymentStatus) throws JRException;

	byte[] getAllOrdersByDateAndStoreNameAsPdf(String date, String storeId) throws JRException;

	byte[] getAllOrdersBetweenDatesAsPdf(String fromDate, String toDate) throws JRException;

	byte[] getOrderSummaryBetweenDatesAsPdf(String fromDate, String toDate , String storeId) throws JRException;

	byte[] getOrderSummaryByDateAndStoreNameAsPdf(String date, String storeId )throws JRException;

	byte[] getAllOrdersBetweenDatesAndStoreIdAsPdf(String fromDate, String toDate, String storeId)throws JRException;

	Page<OrderMaster> getOrdersViewByMethodOfOrder(String storeId, String fromDate,String toDate, String methodOfOrder, Pageable pageable);

	Page<OrderMaster> getOrdersViewByPaymentStatus(String storeId, String fromDate,String toDate, String paymentStatus, Pageable pageable);

	Page<OrderMaster> getOrdersViewBetweenDates(String fromDate, String toDate, Pageable pageable);

	Page<OrderMaster> getOrdersViewBetweenDatesAndStoreIdpcode(String fromDate, String toDate, String storeId,Pageable pageable);

	Page<OrderMaster> getOrdersViewBetweenDatesAndPaymentStatus(String fromDate, String toDate, String paymentStatus,
			Pageable pageable);

	Page<OrderMaster> getOrdersViewBetweenDatesAndMethodOfOrder(String fromDate, String toDate, String methodOfOrder,
			Pageable pageable);

	Page<OrderMaster> getOrdersViewBetweenDatesAndPaymentStatusAndMethodOfOrder(String fromDate, String toDate,
			String paymentStatus, String methodOfOrder, Pageable pageable);

	Page<OrderMaster> getOrdersViewBetweenDatesAndStoreIdpcodeAndPaymentStatusAndMethodOfOrder(String fromDate,
			String toDate, String storeId, String paymentStatus, String methodOfOrder, Pageable pageable);

	byte[] getAllOrdersBetweenDatesByPaymentStatusAsPdf(String fromDate, String toDate,  String paymentStatus)throws JRException;

	byte[] getAllOrdersBetweenDatesByMethodOfOrderAsPdf(String fromDate, String toDate, String methodOfOrder) throws JRException;

	byte[] getAllOrdersBetweenDatesByPaymentStatusAndMethodOfOrderAsPdf(String fromDate, String toDate,
			String paymentStatus, String methodOfOrder) throws JRException;

	byte[] getAllOrdersBetweenDatesByStoreIdAndPaymentStatusAndMethodOfOrderAsPdf(String fromDate, String toDate,
			String storeId, String paymentStatus, String methodOfOrder) throws JRException;

	
	byte[] getReportSummaryByDateOnlyAsPdf(String date) throws JRException;

	byte[] getDetailedOrderSummaryAsPdf(String date, String storeName) throws JRException;

	byte[] getCancellationSummaryAsPdf(String date, String storeName)throws JRException;

	CancellationSummary createCancellationReportSummaryView(String date, String storeName);

	Double findGrandTotalBetweenDateAndStoreName(String fromDate, String toDate, String storeName);

	ReportSummary createDetailedReportSummaryView(String fromDate, String toDate, String storeName);

	String getDocketHeaderView(String orderNumber);

	String getDocketContent(String orderNumber);

	String getDocketProduct(String orderNumber);

	String getDocketDiscountAndTotal(String orderNumber);

	String getDocketPaymentStatus(String orderNumber);

	String getDocketCustomerOrderDetails(String orderNumber);

	String getDocketCustomerDetails(String orderNumber);

	String getFooters(String orderNumber);

	String getAttentionForOrder(String orderNumber);

	String getOrderTimes(String orderNumber);

	

	//ReportSummary createReportSummaryBetweenTwoDates(String fromDate, String toDate);

	//List<OrderMaster> getOrdersViewByDateAndStoreIdpcode(String fromDate,String toDate, String storeId);


	/*OrderAggregator getOrderAggregator(String orderNumber);

	OrderMaster findOrderMasterByOrderNumber(String orderNumber);

	List<OrderLine> findOrderLineByOrderMaster(Long orderMasterId);

	List<ComboItem> findComboItemByOrderLine(Long orderLineId);

	List<AuxItem> findAuxItemByOrderLine(Long orderLineId);*/
	
	
	

	

}
