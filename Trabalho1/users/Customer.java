package users;

import java.util.ArrayList;
import shopping.Order;
import shopping.ShoppingCart;

public class Customer extends User {
    private ArrayList<Order> orderHistory = new ArrayList<Order>();
    private ShoppingCart shoppingCart;
    private String deliveryAddress;
    public Customer(UserType userType, String name, String email, String password, String deliveryAddress, ShoppingCart shoppingCart) throws Exception{
        super(userType, name, email, password);
        this.deliveryAddress = deliveryAddress;
        this.shoppingCart = shoppingCart;
    }

    public boolean addToCart(int productId, int quantity){
        return shoppingCart.addToCart(productId, quantity);
    }

    public boolean removeFromCart(int itemId, int quantity){
        return shoppingCart.removeFromCart(itemId, quantity);
    }

    public void checkout(){
        Order newOrder = shoppingCart.checkout();
        if(newOrder == null){
            System.out.println("Invalid action. Order is empty.");
        }
        else{
            orderHistory.add(newOrder);
        }
    }

    public ArrayList<Order> getOrderHistory(){
        return orderHistory;
    }
}
