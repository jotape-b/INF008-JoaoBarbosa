package shopping;

import java.util.HashMap;

public class ShoppingCart {

    private HashMap<Integer, CartItem> cart = new HashMap<Integer, CartItem>();
    private ProductManager productManager;

    public ShoppingCart(ProductManager productManager) {
        this.productManager = productManager;
    }
    
    public boolean addToCart(int productId, int quantity){
        if(!(isCartActionValid(productId, quantity))) return false;

        Product product = productManager.products.get(productId);
        CartItem item = cart.get(productId);

        if(item != null){
            item.incrementQuantity(quantity);
        }
        else{
            cart.put(productId, new CartItem(product, quantity));
        }
        return true;
    }

    public boolean removeFromCart(int productId, int quantity){
        if(!(isCartActionValid(productId, quantity))) return false;

        CartItem item = cart.get(productId);
        
        if(item.getQuantity() <= quantity){
            cart.remove(productId);
        }
        else{
            item.decrementQuantity(quantity);
        }
        return true;
    }

    private boolean isCartActionValid(int productId, int quantity){
        Product product = productManager.products.get(productId);
       
        if(product == null){
            return false;
        }

        if((quantity <= 0) || (quantity > product.getStock())){
            return false;
        }

        return true;
    }

    private double calculateTotalPrice(){
        double total = 0.0;
        for(CartItem item : cart.values()){
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public Order checkout(){
        double total = calculateTotalPrice();
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

