package shopping;
import users.User;
import java.util.HashMap;

public class ProductManager {
    HashMap<Integer, Product> products = new HashMap<Integer, Product>();
    
    public boolean addProduct(String name, String description, float price, int inStock, String productType, User user){
        if(!user.isAdmin()){
            System.out.println("Access denied. User is not administrator.");
            return false;
        }
        Product newProduct = new Product(name, description, price, inStock, productType);
        products.put(newProduct.getId(), newProduct);
        System.out.println("Product registered successfully.");
        return true;
    }


}
