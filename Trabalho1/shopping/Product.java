package shopping;

public class Product {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String productType;

    public Product(String name, String description, double price, int stock, String productType){
        this.id = ++idCounter;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.productType = productType;
    }

    public int getId(){
        return id;
    }

    public double getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    protected String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Product ID: " + id + "\n" +
            "Name: " + name + "\n" +
            "Description: " + description + "\n" +
            "Price: " + price + "\n" +
            "Stock: " + stock + "\n" +
            "Category: " + productType;
    }

}
