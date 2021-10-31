package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {

    @JsonProperty("table")
    String table;
    @JsonProperty("no")
    String no;
    @JsonProperty("effectiveDate")
    LocalDate effectiveDate;
    @JsonProperty("rates")
    List<Rates> rates;
}
