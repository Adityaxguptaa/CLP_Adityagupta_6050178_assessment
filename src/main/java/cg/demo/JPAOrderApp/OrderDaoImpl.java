package cg.demo.JPAOrderApp;

import java.util.List;
import jakarta.persistence.*;

public class OrderDaoImpl implements OrderDao {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPA-PU");

    @Override
    public void addOrder(Order order) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer cust = em.find(Customer.class,
                order.getCustomer().getCustomerId());

        if(cust == null) {
            em.persist(order.getCustomer());
            cust = order.getCustomer();
        }

        order.setCustomer(cust);

        em.persist(order);

        tx.commit();
        em.close();
    }

    @Override
    public Order viewOrderById(int orderId) {

        EntityManager em = emf.createEntityManager();

        Order order = em.find(Order.class, orderId);

        em.close();

        return order;
    }

    @Override
    public List<Order> viewOrdersByCustomerName(String name) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Order> query =
        em.createQuery(
        "SELECT o FROM Order o WHERE o.customer.customerName=:name",
        Order.class);

        query.setParameter("name", name);

        List<Order> list = query.getResultList();

        em.close();

        return list;
    }
}