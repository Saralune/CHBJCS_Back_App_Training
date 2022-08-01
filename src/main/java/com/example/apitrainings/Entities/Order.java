package com.example.apitrainings.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="orders")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Order {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double amount;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy ="order", cascade = CascadeType.MERGE)
    private Collection<OrderItem> orderItems;

//    @OneToOne
//    private Payment payment;


}
