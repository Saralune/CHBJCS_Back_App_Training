package com.example.apitrainings.Entities;


import com.example.apitrainings.security.entities.Uuser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotNull
    private String name;

    @NotNull
    private String firstName;

    @NotNull
    private String email;

    @NotNull
    private String address;

    @NotNull
    private String phone;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL) @JsonIgnore
    Collection<Order> orders;

    @ManyToOne
    private Uuser uuser;

    public Customer(Long customerId, String name, String firstName, String email, String address, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
}
