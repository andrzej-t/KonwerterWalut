package com.example.demo.client;

import com.example.demo.config.ConnectionConfig;
import com.example.demo.domain.Calculator;
import com.example.demo.domain.Rates;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RequiredArgsConstructor
@Component
public class BackendClient {

    private final RestTemplate restTemplate;
    private final ConnectionConfig connectionConfig;
    private static final Logger LOGGER = LoggerFactory.getLogger(BackendClient.class);
    @Autowired
    Calculator calculator;

    public List<Rates> fetchAllCurrencies() {
        try {
            Optional<Rates[]> boardsResponse = Optional.ofNullable(restTemplate.getForObject(connectionConfig.getBackApiEndpoint() + "/currencies", Rates[].class));
            return Arrays.asList(boardsResponse.orElse(new Rates[0]));
        } catch(RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public Double fetchResult(Integer amount, String currencyFrom, String currencyTo) {

        return restTemplate.getForObject(connectionConfig.getBackApiEndpoint() + "/result" + "?amount=" + amount + "&currencyFrom=" + currencyFrom + "&currencyTo=" + currencyTo, Double.class);
    }
}
