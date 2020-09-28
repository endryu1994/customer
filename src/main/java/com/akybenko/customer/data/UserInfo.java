package com.akybenko.customer.data;

import java.util.List;
import java.util.UUID;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserInfo {

    @Id
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles;
}
