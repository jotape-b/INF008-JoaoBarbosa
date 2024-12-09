package shopping;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ProductManager {
    protected HashMap<Integer, Product> products = new HashMap<Integer, Product>();
    
    public boolean addProduct(String name, String description, float price, int stock, String productType){
        Product newProduct = new Product(name, description, price, stock, productType);
        products.put(newProduct.getId(), newProduct);
        System.out.println("Product registered successfully.");
        return true;
    }

    protected boolean removeProduct(int productId){
        if(!(doesProductExist(productId))) return false;
        products.remove(productId);
        return true;
    }

    protected boolean incrementStock(int productId, int amount){
        if(!(doesProductExist(productId))) return false;
        if(!(isAmountValid(amount))) return false;

        Product product = products.get(productId);
        product.setStock(product.getStock() + amount);
        return true;
    }

    protected boolean decrementStock(int productId, int amount){
        if(!(doesProductExist(productId))) return false;
        if(!(isAmountValid(amount))) return false;

        Product product = products.get(productId);
        if(amount >= product.getStock()) removeProduct(productId);

        product.setStock(product.getStock() - amount);
        return true;
    }

    protected boolean doesProductExist(int productId){
        return products.containsKey(productId);
    }

    private boolean isAmountValid(int amount){
        if(amount <= 0) return false;
        return true;
    }

    public boolean reportLowestStock(){
        Integer lowestStock = products.entrySet()
            .stream()
            .min(Comparator.comparingInt(entry -> entry.getValue().getStock()))
            .map(Map.Entry::getKey)
            .orElse(null);
        if(lowestStock != null){
            printProduct(lowestStock);
            return true;
        }
        else{
            System.out.println("Product not found.");
            return false;
        }
    }

    private void printProduct(int productId){
        Product product = products.get(productId);
        System.out.println(product);
    }

}
