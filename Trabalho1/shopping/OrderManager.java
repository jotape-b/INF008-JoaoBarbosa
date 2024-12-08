package shopping;
import java.util.Comparator;

import users.Customer;

public class OrderManager {
    private Customer customer;

    public OrderManager(Customer customer){
        this.customer = customer;
    }

    public int reportHighestOrderTotal(){
        return customer.getOrderHistory()
            .stream()
            .max(Comparator.comparing(Order::getTotal))
            .map(Order::getId)
            .orElse(null);
    }
    
}
