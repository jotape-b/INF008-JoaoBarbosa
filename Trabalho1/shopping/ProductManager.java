package shopping;
import users.SessionManager;
import java.util.HashMap;

public class ProductManager {
    HashMap<Integer, Product> products = new HashMap<Integer, Product>();
    private SessionManager sessionManager;
    
    public boolean addProduct(String name, String description, float price, int inStock, String productType){
        if(!sessionManager.isAdmin()){
            System.out.println("Invalid action. User is not administrator.");
            return false;
        }
        Product newProduct = new Product(name, description, price, inStock, productType);
        products.put(newProduct.getId(), newProduct);
        System.out.println("Product registered successfully.");
        return true;
    }

}
