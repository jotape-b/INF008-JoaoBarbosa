package shopping;
import java.util.HashMap;

public class ProductManager {
    protected HashMap<Integer, Product> products = new HashMap<Integer, Product>();
    
    public boolean addProduct(String name, String description, float price, int stock, String productType){
        Product newProduct = new Product(name, description, price, stock, productType);
        products.put(newProduct.getId(), newProduct);
        System.out.println("Product registered successfully.");
        return true;
    }

    public boolean removeProduct(int itemId){
        if(!(doesProductExist(itemId))) return false;

        products.remove(itemId);
        return true;
    }

    public boolean incrementStock(int itemId, int amount){
        if(!(doesProductExist(itemId))) return false;
        if(!(isAmountValid(amount))) return false;

        Product item = products.get(itemId);
        item.setStock(item.getStock() + amount);
        return true;
    }

    public boolean decrementStock(int itemId, int amount){
        if(!(doesProductExist(itemId))) return false;
        if(!(isAmountValid(amount))) return false;

        Product item = products.get(itemId);
        if(amount >= item.getStock()){
            removeProduct(itemId);
        }

        item.setStock(item.getStock() - amount);
        return true;
    }

    private boolean doesProductExist(int itemId){
        Product item = products.get(itemId);
        if(item == null) return false;
        return true;
    }

    private boolean isAmountValid(int amount){
        if(amount <= 0) return false;
        return true;
    }

}
