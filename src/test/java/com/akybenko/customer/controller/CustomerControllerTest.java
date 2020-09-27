package com.akybenko.customer.controller;

import static com.akybenko.customer.constant.ApiPath.API_CUSTOMER_PATH;
import static com.akybenko.customer.constant.ApiPath.UUID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.akybenko.customer.common.EntitiesGenerator;
import com.akybenko.customer.data.dto.CustomerDtoGenerated;
import com.akybenko.customer.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integration.properties")
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private CustomerDtoGenerated customer;

    @Before
    public void setUp() {
        customer = EntitiesGenerator.generatedCustomer();
    }

    @Test
    public void testFindById_shouldReturnsCustomer_whenCustomerIsExists() throws Exception {
        when(customerService.findById(any())).thenReturn(customer);
        mockMvc.perform(get(API_CUSTOMER_PATH)
                .param(UUID, customer.getId().toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
