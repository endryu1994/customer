package com.akybenko.customer.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.akybenko.customer.common.EntitiesGenerator;
import com.akybenko.customer.data.dto.CustomerDtoGenerated;
import com.akybenko.customer.data.entities.CustomerEntity;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerService customerService;

    private CustomerDtoGenerated customerDtoGenerated;
    private CustomerEntity customerEntity;

    @Before
    public void setUp() {
        customerDtoGenerated = EntitiesGenerator.generatedCustomer();
        customerEntity = EntitiesGenerator.generatedCustomerEntity();
    }

    @Test
    public void testFindById_shouldReturnsCustomer_whenCustomerIsExists() {
        when(customerService.findById(any())).thenReturn(customerDtoGenerated);

        CustomerDtoGenerated customer = customerService.findById(customerEntity.getId());

        assertThat(customer, equalTo(customerDtoGenerated));
    }
}
