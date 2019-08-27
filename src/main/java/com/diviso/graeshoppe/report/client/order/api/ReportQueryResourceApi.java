/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.diviso.graeshoppe.report.client.order.api;

import java.time.Instant;
import com.diviso.graeshoppe.report.client.order.model.Order;
import com.diviso.graeshoppe.report.client.order.model.OrderLine;
import com.diviso.graeshoppe.report.client.order.model.OrderMaster;
import com.diviso.graeshoppe.report.client.order.model.Reportsummary;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-08-27T15:03:55.787+05:30[Asia/Kolkata]")

@Api(value = "ReportQueryResource", description = "the ReportQueryResource API")
public interface ReportQueryResourceApi {

    @ApiOperation(value = "countAllOrdersByDateAndStoreId", nickname = "countAllOrdersByDateAndStoreIdUsingGET", notes = "", response = Long.class, tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Long.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/countAllOrder/{dateBegin}/{dateEnd}/{storeId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Long> countAllOrdersByDateAndStoreIdUsingGET(@ApiParam(value = "dateBegin",required=true) @PathVariable("dateBegin") Instant dateBegin,@ApiParam(value = "dateEnd",required=true) @PathVariable("dateEnd") Instant dateEnd,@ApiParam(value = "storeId",required=true) @PathVariable("storeId") String storeId);


    @ApiOperation(value = "countOrdersByStoreIdAndDeliveryType", nickname = "countOrdersByStoreIdAndDeliveryTypeUsingGET", notes = "", response = Integer.class, tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Integer.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/countOrdersByDeliveryType/{dateBegin}/{dateEnd}/{storeId}/{deliveryType}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Integer> countOrdersByStoreIdAndDeliveryTypeUsingGET(@ApiParam(value = "dateBegin",required=true) @PathVariable("dateBegin") Instant dateBegin,@ApiParam(value = "dateEnd",required=true) @PathVariable("dateEnd") Instant dateEnd,@ApiParam(value = "storeId",required=true) @PathVariable("storeId") String storeId,@ApiParam(value = "deliveryType") @Valid @RequestParam(value = "deliveryType", required = false) String deliveryType);


    @ApiOperation(value = "findAllPaymentRefByDeliveryType", nickname = "findAllPaymentRefByDeliveryTypeUsingGET", notes = "", response = String.class, responseContainer = "List", tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/findPayRefByDeliveryType/{dateBegin}/{dateEnd}/{storeId}/{deliveryType}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<String>> findAllPaymentRefByDeliveryTypeUsingGET(@ApiParam(value = "dateBegin",required=true) @PathVariable("dateBegin") Instant dateBegin,@ApiParam(value = "dateEnd",required=true) @PathVariable("dateEnd") Instant dateEnd,@ApiParam(value = "deliveryType",required=true) @PathVariable("deliveryType") String deliveryType,@ApiParam(value = "storeId",required=true) @PathVariable("storeId") String storeId);


    @ApiOperation(value = "findAllPaymentReferenceByDateAndStoreId", nickname = "findAllPaymentReferenceByDateAndStoreIdUsingGET", notes = "", response = String.class, responseContainer = "List", tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/findPaymentReference/{dateBegin}/{dateEnd}/{storeId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<String>> findAllPaymentReferenceByDateAndStoreIdUsingGET(@ApiParam(value = "dateBegin",required=true) @PathVariable("dateBegin") Instant dateBegin,@ApiParam(value = "dateEnd",required=true) @PathVariable("dateEnd") Instant dateEnd,@ApiParam(value = "storeId",required=true) @PathVariable("storeId") String storeId);


    @ApiOperation(value = "findOrderByOrderId", nickname = "findOrderByOrderIdUsingGET", notes = "", response = Order.class, tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Order.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/{orderId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Order> findOrderByOrderIdUsingGET(@ApiParam(value = "orderId",required=true) @PathVariable("orderId") String orderId);


    @ApiOperation(value = "findOrderByOrderIdandStatusName", nickname = "findOrderByOrderIdandStatusNameUsingGET", notes = "", response = Order.class, tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Order.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/orderid-status/{orderId}/{status}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Order> findOrderByOrderIdandStatusNameUsingGET(@ApiParam(value = "orderId",required=true) @PathVariable("orderId") String orderId,@ApiParam(value = "status",required=true) @PathVariable("status") String status);


    @ApiOperation(value = "findOrderCountByCustomerIdAndStatusName", nickname = "findOrderCountByCustomerIdAndStatusNameUsingGET", notes = "", response = Long.class, tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Long.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/count-by-customerid-status/{statusName}/{customerId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Long> findOrderCountByCustomerIdAndStatusNameUsingGET(@ApiParam(value = "customerId",required=true) @PathVariable("customerId") String customerId,@ApiParam(value = "statusName",required=true) @PathVariable("statusName") String statusName,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "findOrderCountByCustomerIdAndStoreId", nickname = "findOrderCountByCustomerIdAndStoreIdUsingGET", notes = "", response = Long.class, tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Long.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/count-by-customerid-statusid/{customerId}/{storeId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Long> findOrderCountByCustomerIdAndStoreIdUsingGET(@ApiParam(value = "customerId",required=true) @PathVariable("customerId") String customerId,@ApiParam(value = "storeId",required=true) @PathVariable("storeId") String storeId,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "findOrderCountByCustomerId", nickname = "findOrderCountByCustomerIdUsingGET", notes = "", response = Long.class, tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Long.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/count-by-customerid/{customerId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Long> findOrderCountByCustomerIdUsingGET(@ApiParam(value = "customerId",required=true) @PathVariable("customerId") String customerId,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "findOrderLinesByOrderId", nickname = "findOrderLinesByOrderIdUsingGET", notes = "", response = OrderLine.class, responseContainer = "List", tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = OrderLine.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/order-line/{orderId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<OrderLine>> findOrderLinesByOrderIdUsingGET(@ApiParam(value = "orderId",required=true) @PathVariable("orderId") String orderId);


    @ApiOperation(value = "getOrderByStoreIdAndCurrentDate", nickname = "getOrderByStoreIdAndCurrentDateUsingGET", notes = "", response = Reportsummary.class, tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Reportsummary.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/reportsummary/{storeId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Reportsummary> getOrderByStoreIdAndCurrentDateUsingGET(@ApiParam(value = "storeId",required=true) @PathVariable("storeId") String storeId);


    @ApiOperation(value = "getOrderCountByCustomerIdAndStatusName", nickname = "getOrderCountByCustomerIdAndStatusNameUsingGET", notes = "", response = Long.class, tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Long.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/count/{statusName}/{customerId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Long> getOrderCountByCustomerIdAndStatusNameUsingGET(@ApiParam(value = "customerId",required=true) @PathVariable("customerId") String customerId,@ApiParam(value = "statusName",required=true) @PathVariable("statusName") String statusName,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "getOrderMasterByOrderIdAndStatusName", nickname = "getOrderMasterByOrderIdAndStatusNameUsingGET", notes = "", response = OrderMaster.class, tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = OrderMaster.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/findOrder/{orderId}/{status}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<OrderMaster> getOrderMasterByOrderIdAndStatusNameUsingGET(@ApiParam(value = "orderId",required=true) @PathVariable("orderId") String orderId,@ApiParam(value = "status",required=true) @PathVariable("status") String status,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "getOrderMaster", nickname = "getOrderMasterUsingGET", notes = "", response = OrderMaster.class, tags={ "report-query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = OrderMaster.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/order/main-report/{orderId}/{statusName}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<OrderMaster> getOrderMasterUsingGET(@ApiParam(value = "orderId",required=true) @PathVariable("orderId") String orderId,@ApiParam(value = "statusName",required=true) @PathVariable("statusName") String statusName,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);

}
