/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.diviso.graeshoppe.report.client.product.api;

import com.diviso.graeshoppe.report.client.product.model.StockCurrentDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-31T16:45:03.566+05:30[Asia/Kolkata]")

@Api(value = "StockCurrentResource", description = "the StockCurrentResource API")
public interface StockCurrentResourceApi {

    @ApiOperation(value = "createStockCurrent", nickname = "createStockCurrentUsingPOST", notes = "", response = StockCurrentDTO.class, tags={ "stock-current-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StockCurrentDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/stock-currents",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<StockCurrentDTO> createStockCurrentUsingPOST(@ApiParam(value = "stockCurrentDTO" ,required=true )  @Valid @RequestBody StockCurrentDTO stockCurrentDTO);


    @ApiOperation(value = "deleteStockCurrent", nickname = "deleteStockCurrentUsingDELETE", notes = "", tags={ "stock-current-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/api/stock-currents/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteStockCurrentUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "exportStockCurrentListAsPdf", nickname = "exportStockCurrentListAsPdfUsingGET", notes = "", response = byte[].class, tags={ "stock-current-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = byte[].class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/pdf/stockcurrent-report/{idpcode}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<byte[]> exportStockCurrentListAsPdfUsingGET(@ApiParam(value = "idpcode",required=true) @PathVariable("idpcode") String idpcode);


    @ApiOperation(value = "getAllStockCurrents", nickname = "getAllStockCurrentsUsingGET", notes = "", response = StockCurrentDTO.class, responseContainer = "List", tags={ "stock-current-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StockCurrentDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/stock-currents",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<StockCurrentDTO>> getAllStockCurrentsUsingGET(@ApiParam(value = "filter") @Valid @RequestParam(value = "filter", required = false) String filter,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "getStockCurrentByProductId", nickname = "getStockCurrentByProductIdUsingGET", notes = "", response = StockCurrentDTO.class, tags={ "stock-current-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StockCurrentDTO.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/stock-currents/product/{id}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<StockCurrentDTO> getStockCurrentByProductIdUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "getStockCurrent", nickname = "getStockCurrentUsingGET", notes = "", response = StockCurrentDTO.class, tags={ "stock-current-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StockCurrentDTO.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/stock-currents/{id}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<StockCurrentDTO> getStockCurrentUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "searchStockCurrents", nickname = "searchStockCurrentsUsingGET", notes = "", response = StockCurrentDTO.class, responseContainer = "List", tags={ "stock-current-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StockCurrentDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/_search/stock-currents",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<StockCurrentDTO>> searchStockCurrentsUsingGET(@NotNull @ApiParam(value = "query", required = true) @Valid @RequestParam(value = "query", required = true) String query,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "updateStockCurrent", nickname = "updateStockCurrentUsingPUT", notes = "", response = StockCurrentDTO.class, tags={ "stock-current-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StockCurrentDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/stock-currents",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<StockCurrentDTO> updateStockCurrentUsingPUT(@ApiParam(value = "stockCurrentDTO" ,required=true )  @Valid @RequestBody StockCurrentDTO stockCurrentDTO);

}
