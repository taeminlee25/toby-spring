package org.example.tobyspring.exrate;

import org.example.tobyspring.api.ApiTemplate;
import org.example.tobyspring.payment.ExRateProvider;

import java.math.BigDecimal;

public class WebApiExRateProvider implements ExRateProvider {
    private final ApiTemplate apiTemplate;

    public WebApiExRateProvider(ApiTemplate apiTemplate) {
        this.apiTemplate = apiTemplate;
    }

    @Override
    public BigDecimal getExRate(String currency) {
        String url = "https://open.er-api.com/v6/latest/" + currency;

        // 콜백을 만들어 템플릿 메소드를 호출
        return apiTemplate.getExRate(url); // 콜백
    }

}
