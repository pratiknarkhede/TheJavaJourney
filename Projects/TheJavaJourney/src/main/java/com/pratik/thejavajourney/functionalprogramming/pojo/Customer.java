package com.pratik.thejavajourney.functionalprogramming.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;
    private List<Double> purchaseHistory;
}
