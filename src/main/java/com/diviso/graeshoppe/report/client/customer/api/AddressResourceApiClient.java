package com.diviso.graeshoppe.report.client.customer.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.diviso.graeshoppe.report.client.customer.CustomerClientConfiguration;

@FeignClient(name="${customer.name:customer}", url="${customer.url:dev.ci1.divisosofttech.com:8088/}", configuration = CustomerClientConfiguration.class)
public interface AddressResourceApiClient extends AddressResourceApi {
}