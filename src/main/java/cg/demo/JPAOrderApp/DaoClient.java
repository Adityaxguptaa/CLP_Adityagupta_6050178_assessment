package cg.demo.JPAOrderApp;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class DaoClient {

    static OrderDao dao = new OrderDaoImpl();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String opt = null;

        do {

            System.out.println("1 - ADD");
            System.out.println("2 - View by Order ID");
            System.out.println("3 - View Order by customer name");

            int mtype = scan.nextInt();

            processMenu(mtype);

            System.out.println("press y to continue");
            opt = scan.next();

        } while(opt.equalsIgnoreCase("y"));
    }

    public static void processMenu(int mtype) {

        switch(mtype) {

        case 1:
            addOrder();
            break;

        case 2:
            viewOrderByOrderID();
            break;

        case 3:
            viewOrdersByCustName();
            break;

        default:
            System.out.println("Invalid option");
        }
    }

    public static void addOrder() {

        try {

            System.out.println("Enter Customer ID");
            int cid = scan.nextInt();
            scan.nextLine();

            System.out.println("Enter Customer Name");
            String cname = scan.nextLine();

            Customer cust = new Customer(cid, cname);

            System.out.println("Enter Order Date (yyyy-MM-dd)");
            String date = scan.next();

            System.out.println("Enter Order Amount");
            double amt = scan.nextDouble();

            Order order = new Order();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            order.setOrderDate(sdf.parse(date));
            order.setOrderAmt(amt);
            order.setCustomer(cust);

            dao.addOrder(order);

            System.out.println("Order Added Successfully");

        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewOrderByOrderID() {

        System.out.println("Enter Order ID");

        int id = scan.nextInt();

        Order order = dao.viewOrderById(id);

        if(order != null) {

            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Amount: " + order.getOrderAmt());
            System.out.println("Date: " + order.getOrderDate());
            System.out.println("Customer: " +
                    order.getCustomer().getCustomerName());

        } else {

            System.out.println("Order not found");
        }
    }

    public static void viewOrdersByCustName() {

        System.out.println("Enter Customer Name");

        scan.nextLine();
        String name = scan.nextLine();

        List<Order> list = dao.viewOrdersByCustomerName(name);

        for(Order o : list) {

            System.out.println("Order ID: " + o.getOrderId());
            System.out.println("Amount: " + o.getOrderAmt());
            System.out.println("Date: " + o.getOrderDate());

            System.out.println("----------------");
        }
    }
}