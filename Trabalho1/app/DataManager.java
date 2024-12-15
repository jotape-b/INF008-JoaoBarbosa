package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import shopping.Product;
import shopping.ProductManager;
import users.User;
import users.UserManager;

public class DataManager {

    public static void saveData(UserManager userManager, ProductManager productManager) {
        try (FileOutputStream fos = new FileOutputStream("newfile.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
    
            oos.writeObject(userManager.getUsers());
            oos.writeObject(productManager.getProducts());
    
            System.out.println("Data saved successfully.");
        } catch (Exception e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }
    

    public static void loadData(UserManager userManager, ProductManager productManager) {
        try (FileInputStream fis = new FileInputStream("newfile.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
    
            HashMap<String, User> loadedUsers = (HashMap<String, User>) ois.readObject();
            HashMap<Integer, Product> loadedProducts = (HashMap<Integer, Product>) ois.readObject();
    
            userManager.getUsers().putAll(loadedUsers);
            productManager.getProducts().putAll(loadedProducts);
    
            System.out.println("Data loaded and merged successfully.");
        } catch (Exception e) {
            System.out.println("No data found.");
        }
    }
    
}
