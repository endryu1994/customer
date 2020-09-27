package com.akybenko.customer.constant;

public interface ApiPath {

    String API = "api";
    String V1 = "v1";
    String CUSTOMER = "customer";

    // Name
    String UUID = "uuid";

    // Variables
    String UUID_PATH_VARIABLE = "{" + UUID + "}";

    // Path
    String API_CUSTOMER_PATH = "/" + API + "/" + V1 + "/" + CUSTOMER;
    String UUID_PATH = "/" + UUID_PATH_VARIABLE;
}
