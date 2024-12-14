package app;

import java.util.Scanner;

import javax.swing.text.View;

import shopping.ProductManager;

public class CustomerSubmenus {
    Scanner scanner = new Scanner(System.in);
    ProductManager productManager = new ProductManager();

    protected void newOrderMenu(){
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
                    
                    break;
            }
        }

    }

    /*◦ Para usuários clientes:
        ▪ Start new order
            • Add product
            • View shopping cart
                ◦ Listar todos os produtos incluídos no carrinho de compras
            • Finish order
        ▪ Exit */
}
