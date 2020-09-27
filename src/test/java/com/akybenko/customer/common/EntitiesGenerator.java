package com.akybenko.customer.common;

import java.util.UUID;

import com.akybenko.customer.data.dto.AddressDtoGenerated;
import com.akybenko.customer.data.dto.CustomerDtoGenerated;
import com.akybenko.customer.data.entities.AddressEntity;
import com.akybenko.customer.data.entities.CustomerEntity;

public class EntitiesGenerator {
    
    private static final UUID ADDRESS_ID = UUID.fromString("4b7eb488-ceb3-4eda-9443-1b953418bff3");
    private static final String ADDRESS_ZIP_CODE = "96522";
    private static final String ADDRESS_STATE = "Mississippi";
    private static final String ADDRESS_CITY = "Mankato";
    private static final String ADDRESS_STREET = "711-2880 Nulla St.";

    private static final UUID CUSTOMER_ID = UUID.fromString("90d86dc7-083b-467d-b93a-f638f2d77caa");
    private static final String CUSTOMER_NAME = "Cecilia Chapman";
    private static final String CUSTOMER_DESCRIPTION = "Test customer";
    private static final String CUSTOMER_EMAIL = "cchapman@example.com";

    public static AddressDtoGenerated generatedAddress() {
        AddressDtoGenerated address = new AddressDtoGenerated();
        address.setId(ADDRESS_ID);
        address.setZipCode(ADDRESS_ZIP_CODE);
        address.setState(ADDRESS_STATE);
        address.setCity(ADDRESS_CITY);
        address.setStreet(ADDRESS_STREET);
        return address;
    }

    private static AddressEntity generatedAddressEntity() {
        AddressEntity address = new AddressEntity();
        address.setId(ADDRESS_ID);
        address.setZipCode(ADDRESS_ZIP_CODE);
        address.setState(ADDRESS_STATE);
        address.setCity(ADDRESS_CITY);
        address.setStreet(ADDRESS_STREET);
        return address;
    }

    public static CustomerDtoGenerated generatedCustomer() {
        CustomerDtoGenerated customer = new CustomerDtoGenerated();
        customer.setId(CUSTOMER_ID);
        customer.setName(CUSTOMER_NAME);
        customer.setDescription(CUSTOMER_DESCRIPTION);
        customer.setEmail(CUSTOMER_EMAIL);
        customer.setAddress(generatedAddress());
        return customer;
    }
    
    public static CustomerEntity generatedCustomerEntity() {
        CustomerEntity customer = new CustomerEntity();
        customer.setId(CUSTOMER_ID);
        customer.setName(CUSTOMER_NAME);
        customer.setDescription(CUSTOMER_DESCRIPTION);
        customer.setEmail(CUSTOMER_EMAIL);
        customer.setAddress(generatedAddressEntity());
        return customer;
    }
}
