package org.example.tobyspring.order;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


/*
데이터 액세스 기술의 하나인 jpa에 의존
jpa를 사용하는 repository 클래스에 의존
jpa transaction manager에 의존
*/

@Service
@Transactional // 프록시 오브젝트를 만들어
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order createOrder(String no, BigDecimal total) {
        Order order = new Order(no, total);

        this.orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> createOrders(List<OrderRequest> reqs) {
          return reqs.stream().map(req ->
                    createOrder(req.no(), req.total())
            ).toList();
    }
}
