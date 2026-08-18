package org.example.tobyspring.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.tobyspring.order.Order;
import org.example.tobyspring.order.OrderRepository;

public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }
}
