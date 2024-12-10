package shopping;
import java.util.Comparator;

import users.Customer;

public class OrderManager {
    private Customer customer;

    public OrderManager(Customer customer){
        this.customer = customer;
    }

    public boolean reportHighestOrderTotal() {
        Order highestOrder = customer.getOrderHistory()
            .stream()
            .max(Comparator.comparing(Order::getTotal))
            .orElse(null);
            
        if (highestOrder != null) {
            printOrder(highestOrder);
            return true;
        } else {
            System.out.println("No orders found.");
            return false;
        }
    }
    
    private void printOrder(Order order){
        System.out.println(order);
    }
}
