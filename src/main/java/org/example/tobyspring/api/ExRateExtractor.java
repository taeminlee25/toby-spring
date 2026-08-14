package org.example.tobyspring.api;

import java.math.BigDecimal;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ExRateExtractor {
    BigDecimal extractExRate(String response) throws JsonProcessingException;
}
