package com.diviso.graeshoppe.report.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of OfferLineSearchRepository to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class OfferLineSearchRepositoryMockConfiguration {

    @MockBean
    private OfferLineSearchRepository mockOfferLineSearchRepository;

}
