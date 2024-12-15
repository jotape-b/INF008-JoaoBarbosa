package users;

import java.util.TreeSet;

import shopping.Order;
import shopping.ProductManager;
import shopping.ShoppingCart;

public class Customer extends User {
    private TreeSet<Order> orderHistory = new TreeSet<>();
    ShoppingCart shoppingCart;
    private String deliveryAddress;
    public Customer(UserType userType, String name, String email, String password, String deliveryAddress, ProductManager productManager) throws Exception{
        super(userType, name, email, password);
        this.deliveryAddress = deliveryAddress;
        this.shoppingCart = new ShoppingCart(productManager);
    }

    public boolean addToCart(int productId, int quantity){
        return shoppingCart.addToCart(productId, quantity);
    }

    public boolean removeFromCart(int itemId, int quantity){
        return shoppingCart.removeFromCart(itemId, quantity);
    }

    public void checkout(){
        Order newOrder = shoppingCart.checkout();
        if(newOrder != null){
            orderHistory.add(newOrder);
        }
    }

    public ShoppingCart getShoppingCart(){
        return shoppingCart;
    }

    public TreeSet<Order> getOrderHistory(){
        return orderHistory;
    }
}
