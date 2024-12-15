package shopping;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ProductManager implements Serializable{
    protected HashMap<Integer, Product> products = new HashMap<Integer, Product>();
    
    public boolean addProduct(String name, String description, double price, int stock, String productType){
        if(stock < 1){
            System.out.println("Invalid stock. Registration failed.");
            return false;
        }
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
        Product lowestStock = products.entrySet()
            .stream()
            .min(Comparator.comparingInt(entry -> entry.getValue().getStock()))
            .map(Map.Entry::getValue)
            .orElse(null);
        if(lowestStock != null){
            System.out.println(lowestStock);
            return true;
        }
        else{
            System.out.println("No products found.");
            return false;
        }
    }

    public void printAllProducts(){
        if(products.isEmpty()){
            System.out.println("No products available.");
            return;
        }
        System.out.println("------ PRODUCT LIST: ------\n");
        products.values().forEach(product -> System.out.println(product + "\n"));
    }

    public HashMap<Integer, Product> getProducts(){
        return products;
    }

    public void setProducts(HashMap<Integer, Product> products) {
        this.products.clear(); 
        this.products.putAll(products);
    }

}
