package com.gokdemiruzunkaya.graduationproject.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    private String username;
    private String password;
    private String image;
    private double balance;
    private int invalidAttemptCounter;

    public static List<Customer> createCustomerList(){
        List<Customer> list = new ArrayList<>();
        list.add(new Customer("1","1", "", 1000.0, 0 ));
        list.add(new Customer("2","2", "", 1000.0, 0 ));
        list.add(new Customer("3","3", "", 1000.0, 0 ));
        list.add(new Customer("4","4", "", 1000.0, 0 ));
        return list;
    }
}
