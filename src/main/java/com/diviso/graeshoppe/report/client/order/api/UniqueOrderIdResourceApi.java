/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.diviso.graeshoppe.report.client.order.api;

import com.diviso.graeshoppe.report.client.order.model.UniqueOrderIDDTO;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-31T16:48:59.190+05:30[Asia/Kolkata]")

@Api(value = "UniqueOrderIdResource", description = "the UniqueOrderIdResource API")
public interface UniqueOrderIdResourceApi {

    @ApiOperation(value = "createUniqueOrderID", nickname = "createUniqueOrderIDUsingPOST", notes = "", response = UniqueOrderIDDTO.class, tags={ "unique-order-id-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = UniqueOrderIDDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/unique-order-ids",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<UniqueOrderIDDTO> createUniqueOrderIDUsingPOST(@ApiParam(value = "uniqueOrderIDDTO" ,required=true )  @Valid @RequestBody UniqueOrderIDDTO uniqueOrderIDDTO);


    @ApiOperation(value = "deleteUniqueOrderID", nickname = "deleteUniqueOrderIDUsingDELETE", notes = "", tags={ "unique-order-id-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/api/unique-order-ids/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUniqueOrderIDUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "getAllUniqueOrderIDS", nickname = "getAllUniqueOrderIDSUsingGET", notes = "", response = UniqueOrderIDDTO.class, responseContainer = "List", tags={ "unique-order-id-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = UniqueOrderIDDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/unique-order-ids",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<UniqueOrderIDDTO>> getAllUniqueOrderIDSUsingGET(@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "getUniqueOrderID", nickname = "getUniqueOrderIDUsingGET", notes = "", response = UniqueOrderIDDTO.class, tags={ "unique-order-id-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = UniqueOrderIDDTO.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/unique-order-ids/{id}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<UniqueOrderIDDTO> getUniqueOrderIDUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "searchUniqueOrderIDS", nickname = "searchUniqueOrderIDSUsingGET", notes = "", response = UniqueOrderIDDTO.class, responseContainer = "List", tags={ "unique-order-id-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = UniqueOrderIDDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/_search/unique-order-ids",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<UniqueOrderIDDTO>> searchUniqueOrderIDSUsingGET(@NotNull @ApiParam(value = "query", required = true) @Valid @RequestParam(value = "query", required = true) String query,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "updateUniqueOrderID", nickname = "updateUniqueOrderIDUsingPUT", notes = "", response = UniqueOrderIDDTO.class, tags={ "unique-order-id-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = UniqueOrderIDDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/unique-order-ids",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<UniqueOrderIDDTO> updateUniqueOrderIDUsingPUT(@ApiParam(value = "uniqueOrderIDDTO" ,required=true )  @Valid @RequestBody UniqueOrderIDDTO uniqueOrderIDDTO);

}
