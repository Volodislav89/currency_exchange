package com.spring.currency_exchange.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exchange {
    private Long userId;
    private int sum;
    private String in;
    private String out;
}
