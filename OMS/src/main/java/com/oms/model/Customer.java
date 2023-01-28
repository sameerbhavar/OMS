package com.oms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    
    private String name;
    
    private String email;
    
    private int orderCount;
    
    private String customerType;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Orders> allOrders;
    
    public void updateCustomerTier() {

        if (orderCount >= 20) {

            this.customerType = "platinum";

        } else if (orderCount >= 10) {

            this.customerType = "gold";

        } else {

            this.customerType = "regular";

        }

    }
}
