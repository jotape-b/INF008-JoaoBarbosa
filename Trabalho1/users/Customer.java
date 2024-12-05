package users;

import java.util.ArrayList;
import shopping.Order;

import auth.SessionManager;

public class Customer extends User {
    private SessionManager sessionManager;
    private ArrayList<Order> orderHistory = new ArrayList<Order>();
    private String address;

    public Customer(UserType userType, String name, String email, String password, SessionManager sessionManager) throws Exception{
        super(userType, name, email, password);
        this.sessionManager = sessionManager;
    }

    public boolean addToCart(int productId, int quantity){
        return sessionManager.validateAddToCart(productId, quantity);
    }

    public boolean removeFromCart(int itemId, int quantity){
        return sessionManager.validateRemoveFromCart(itemId, quantity);
    }

    public void checkout(){
        Order newOrder = sessionManager.validateCheckout();
        orderHistory.add(newOrder);
    }

    //start new order
        //add product
        //view shopping cart
            //listar todos os produtos inclusos no carrinho de compras
        //finish order
    //exit
}
