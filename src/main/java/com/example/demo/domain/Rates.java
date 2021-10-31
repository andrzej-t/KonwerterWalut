package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {

    @JsonProperty("currency")
    String currency;
    @JsonProperty("code")
    String code;
    @JsonProperty("bid")
    Double bid;
    @JsonProperty("ask")
    Double ask;
}
