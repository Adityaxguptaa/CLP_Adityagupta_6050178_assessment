package cg.demo.JPAOrderApp;

import java.util.List;

public interface OrderDao {

    void addOrder(Order order);

    Order viewOrderById(int orderId);

    List<Order> viewOrdersByCustomerName(String name);
}