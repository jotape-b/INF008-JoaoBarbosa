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
        this.date = LocalDate.now();
        this.total = total;
        this.items = new HashMap<>(items);
    }

    protected double getTotal(){
        return total;
    }

    protected int getId(){
        return id;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(id).append("\n")
            .append("Date: ").append(date).append("\n")
            .append("Total: $").append(String.format("%.2f", total)).append("\n")
            .append("Items:\n");

        for(CartItem item : items.values()){
            sb.append(" ").append(item).append("\n");
        }

        return sb.toString();
    }
    
}
