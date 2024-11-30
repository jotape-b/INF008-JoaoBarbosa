package shopping;

public class Product {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String description;
    private float price;
    private int inStock;
    private String productType;

    public Product(String name, String description, float price, int inStock, String productType){
        this.id = idCounter++;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
        this.productType = productType;
    }
}
