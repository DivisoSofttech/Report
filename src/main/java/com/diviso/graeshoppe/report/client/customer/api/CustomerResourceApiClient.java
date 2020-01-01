package com.diviso.graeshoppe.report.client.customer.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.diviso.graeshoppe.report.client.customer.ClientConfiguration;

@FeignClient(name="${customer.name:customer}", url="${customer.url:dev.ci1.divisosofttech.com:8088/}", configuration = ClientConfiguration.class)
public interface CustomerResourceApiClient extends CustomerResourceApi {
}