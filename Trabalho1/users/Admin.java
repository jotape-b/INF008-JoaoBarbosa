package users;

import shopping.ProductManager;
import shopping.OrderManager;

public class Admin extends User{
    private UserManager userManager;
    private ProductManager productManager;
    private OrderManager orderManager;

    public Admin(UserType userType, String name, String email, String password, UserManager userManager, ProductManager productManager, OrderManager orderManager) throws Exception{
        super(userType, name, email, password);
        this.userManager = userManager;
        this.productManager = productManager;
        this.orderManager = orderManager;
    }
    
    public boolean addUser(UserType userType, String name, String email, String password, String deliveryAddress, ProductManager productManager, OrderManager orderManager) throws Exception{
        return userManager.addUser(userType, name, email, password, deliveryAddress, productManager, orderManager);
    }

    public boolean addProduct(String name, String description, double price, int inStock, String productType){
        return productManager.addProduct(name, description, price, inStock, productType);
    }

    public boolean reportHighestOrderTotal(){
        return orderManager.reportHighestOrderTotal();
    }

    public boolean reportLowestStock(){
        return productManager.reportLowestStock();
    }

    //create new product
    //create new user
        //Solicitar tipo do perfil do novo usuário, seu login e sua senha
    //report - more expensive order
    //report - product with lowerst inventory
    //exit
}
