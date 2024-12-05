package shopping;

import java.util.HashMap;

public class ShoppingCart {

    private HashMap<Integer, CartItem> cart = new HashMap<Integer, CartItem>();
    private ProductManager productManager;

    public ShoppingCart(ProductManager productManager) {
        this.productManager = productManager;
    }
    
    public boolean addToCart(int productId, int quantity){
        if(!(productManager.doesProductExist(productId))) return false;
        if(!(isThereEnoughStock(productId, quantity))) return false;

        Product product = productManager.products.get(productId);
        CartItem item = cart.get(productId);

        if(doesCartItemExist(productId)){
            item.incrementQuantity(quantity);
        }
        else{
            cart.put(productId, new CartItem(product, quantity));
        }
        return true;
    }

    public boolean removeFromCart(int itemId, int quantity){
        if(!(doesCartItemExist(itemId))) return false;

        CartItem item = cart.get(itemId);
        if(item.getQuantity() <= quantity){
            cart.remove(itemId);
        }
        else{
            item.decrementQuantity(quantity);
        }
        return true;
    }

    private boolean isThereEnoughStock(int productId, int quantity){
        Product product = productManager.products.get(productId);
        if((quantity <= 0) || (quantity > product.getStock())) return false;
        return true;
    }

    private boolean doesCartItemExist(int itemId){
        return cart.containsKey(itemId);
    }

    private double calculateTotalPrice(){
        double total = 0.0;
        for(CartItem item : cart.values()){
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public Order checkout(){
        if(cart.isEmpty()) return null;

        double total = calculateTotalPrice();
        for(CartItem item : cart.values()){
            productManager.decrementStock(item.product.getId(), item.getQuantity());
        }
        Order order = new Order(cart, total);
        cart.clear();
        return order;
    }


    public static class CartItem{
        private Product product;
        private int quantity;

        public CartItem(Product product, int quantity){
            this.product = product;
            this.quantity = quantity;
        }

        public int getQuantity(){
            return quantity;
        }

        public double getPrice(){
            return product.getPrice();
        }

        public void incrementQuantity(int amount){
            this.quantity += amount;
        }

        public void decrementQuantity(int amount){
            this.quantity -= amount;
        }

    }
}

