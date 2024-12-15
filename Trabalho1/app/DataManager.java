package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import shopping.Product;
import shopping.ProductManager;
import users.User;
import users.UserManager;

public class DataManager {

    public void saveData(UserManager userManager, ProductManager productManager) throws IOException{
        try(FileOutputStream fos = new FileOutputStream("newfile.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(userManager.getUsers());
            oos.writeObject(productManager.getProducts());
            oos.flush();
        }
    }

    public void loadData(UserManager userManager, ProductManager productManager) {
        try (FileInputStream fis = new FileInputStream("newfile.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
    
            HashMap<String, User> loadedUsers = (HashMap<String, User>) ois.readObject();
            HashMap<Integer, Product> loadedProducts = (HashMap<Integer, Product>) ois.readObject();
    
            loadedUsers.forEach((email, user) -> {
                if (!userManager.getUsers().containsKey(email)) {
                    userManager.getUsers().put(email, user);
                }
            });
    
            loadedProducts.forEach((id, product) -> {
                if (!productManager.getProducts().containsKey(id)) {
                    productManager.getProducts().put(id, product);
                }
            });
    
            System.out.println("Data loaded and merged successfully.");
        } catch (Exception e) {
            System.out.println("No data found.");
        }
    }  
}
