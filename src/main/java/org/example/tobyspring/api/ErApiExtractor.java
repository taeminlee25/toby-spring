package org.example.tobyspring.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.tobyspring.exrate.ExRateData;

import java.math.BigDecimal;

public class ErApiExtractor implements ExRateExtractor {

    @Override
    public BigDecimal extractExRate(String response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ExRateData data = mapper.readValue(response, ExRateData.class);
        return data.rates().get("KRW");
    }
}
