package shopping;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import users.Customer;
import users.UserManager;

public class OrderManager implements Serializable{
    private UserManager userManager;

    public OrderManager(UserManager userManager){
        this.userManager = userManager;
    }

    public boolean reportHighestOrderTotal() {
        List<Customer> customers = userManager.getCustomers();
        Optional<Order> highestOrder = customers.stream()
            .map(customer -> {
                if (!customer.getOrderHistory().isEmpty()) {
                    return customer.getOrderHistory().first();
                }
                return null;
            })
            .filter(order -> order != null)
            .max(Comparator.comparing(Order::getTotal));
        
        if (highestOrder.isPresent()) {
            printOrder(highestOrder.get());
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
