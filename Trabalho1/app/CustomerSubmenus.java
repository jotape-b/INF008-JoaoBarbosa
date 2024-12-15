package app;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.text.View;

import shopping.ProductManager;
import shopping.ShoppingCart;

public class CustomerSubmenus {
    Scanner scanner = new Scanner(System.in);
    ProductManager productManager = new ProductManager();
    ShoppingCart shoppingCart = new ShoppingCart(productManager);

    public CustomerSubmenus(ProductManager productManager, ShoppingCart shoppingCart){
        this.productManager = productManager;
        this.shoppingCart = shoppingCart;
    }

    protected void newOrderMenu() throws IOException{
        int selectedOption;
        while(true){
            productManager.printAllProducts();
            System.out.println("\n---------");
            System.out.println("\n1 - ADD PRODUCT BY ID");
            System.out.println("\n2 - VIEW SHOPPING CART");
            System.out.println("\n3 - FINISH ORDER");
            selectedOption = scanner.nextInt();
            switch(selectedOption){
                case 1:
                    addProductToCartMenu();
                    break;
                case 2:
                    viewShoppingCartMenu();
                    break;
                case 3:
                    checkoutMenu();
                    return;
                default:
                    System.out.println("Invalid entry.");
                    break;
            }
        }

    }

    protected void addProductToCartMenu(){
        int productId, quantity;
        boolean isOperationFinished = false;
        do{
            System.out.println("PRODUCT ID: ");
            productId = scanner.nextInt();
            System.out.println("QUANTITY TO BE ADDED: ");
            quantity = scanner.nextInt();
            isOperationFinished = shoppingCart.addToCart(productId, quantity);
        }while(isOperationFinished == false);
    }

    protected void viewShoppingCartMenu() throws IOException{
        shoppingCart.printShoppingCart();
        System.out.println("Press any key to exit.");
        System.in.read();
    }

    protected void checkoutMenu() throws IOException{
        shoppingCart.checkout();
        System.out.println("Press any key to exit.");
        System.in.read();
    }

    /*◦ Para usuários clientes:
        ▪ Start new order
            • Add product
            • View shopping cart
                ◦ Listar todos os produtos incluídos no carrinho de compras
            • Finish order
        ▪ Exit */
}
