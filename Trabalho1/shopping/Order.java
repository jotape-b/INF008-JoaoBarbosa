package shopping;
import java.time.LocalDate;
import java.util.HashMap;
import shopping.ShoppingCart.CartItem;

public class Order {
    private static int idCounter = 0;
    private int id;
    private final HashMap<Integer, CartItem> items;
    private final LocalDate date;
    private final double total;

    public Order(HashMap<Integer, CartItem> items, double total){
        this.id = idCounter++;
        this.items = new HashMap<>(items);
        this.date = LocalDate.now();
        this.total = total;
    }
    
}
