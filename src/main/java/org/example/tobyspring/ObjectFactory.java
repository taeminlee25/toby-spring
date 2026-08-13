package org.example.tobyspring;

import org.example.tobyspring.exrate.CachedExRateProvider;
import org.example.tobyspring.payment.ExRateProvider;
import org.example.tobyspring.exrate.WebApiExRateProvider;
import org.example.tobyspring.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    // @Bean
    // public ExRateProvider cachedExRateProvider() {
    //     return new CachedExRateProvider(exRateProvider());
    // }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }

}

