package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Currency {
    String flag;
    String currencyName;
    String currencySymbol;
    Double exchangeRate;
    Double percentChange;
    Double zlotyChange;
}
