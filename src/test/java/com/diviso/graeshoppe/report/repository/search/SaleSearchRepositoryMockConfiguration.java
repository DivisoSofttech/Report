package com.diviso.graeshoppe.report.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link SaleSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class SaleSearchRepositoryMockConfiguration {

    @MockBean
    private SaleSearchRepository mockSaleSearchRepository;

}
