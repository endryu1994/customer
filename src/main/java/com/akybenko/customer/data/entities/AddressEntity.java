package com.akybenko.customer.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.akybenko.customer.data.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADDRESS")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AddressEntity extends AbstractEntity {

    @NotNull
    @Size(max = 5)
    @Column(name = "ZIP_CODE")
    private String zipCode;

    @NotNull
    @Size(max = 255)
    @Column(name = "STATE")
    private String state;

    @NotNull
    @Size(max = 255)
    @Column(name = "CITY")
    private String city;

    @NotNull
    @Size(max = 255)
    @Column(name = "STREET")
    private String street;
}
