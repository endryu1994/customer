package com.akybenko.customer.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.akybenko.customer.data.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMER")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CustomerEntity extends AbstractEntity {

    @NotNull
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn
    private AddressEntity address;
}
