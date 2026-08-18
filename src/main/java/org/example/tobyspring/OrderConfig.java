package org.example.tobyspring;

import org.example.tobyspring.data.JdbcOrderRepository;
import org.example.tobyspring.order.OrderRepository;
import org.example.tobyspring.order.OrderSerivceTxProxy;
import org.example.tobyspring.order.OrderService;
import org.example.tobyspring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@Import({DataConfig.class})
@EnableTransactionManagement // 트랜잭션 프록시를 직접 만들어야 해~
public class OrderConfig {
    @Bean
    public OrderRepository orderRepository(DataSource dataSource) {
        return new JdbcOrderRepository(dataSource);
    }

    @Bean
    public OrderService orderService(
            PlatformTransactionManager transactionManager,
            OrderRepository orderRepository) {
        return  new OrderServiceImpl(orderRepository);
    }
}
