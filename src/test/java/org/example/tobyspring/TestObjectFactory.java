package org.example.tobyspring;

import org.example.tobyspring.exrate.WebApiExRateProvider;
import org.example.tobyspring.payment.ExRateProvider;
import org.example.tobyspring.payment.ExRateProviderStub;
import org.example.tobyspring.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class TestObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new ExRateProviderStub(BigDecimal.valueOf(1_000));
    }

}

