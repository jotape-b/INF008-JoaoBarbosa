package users;
import java.util.HashMap;
public class Admin extends User{
    HashMap<Integer, User> users = new HashMap<Integer, User>();

    public Admin(int userType, String name, String email, String password) throws Exception{
        super(userType, name, email, password);
    }

    public boolean addUser(int userType, String name, String email, String password){
        
        return true;
    }
    //gerenciar produtos e usuários
    //acessar relatórios

    //create new product
    //create new user
        //Solicitar tipo do perfil do novo usuário, seu login e sua senha
    //report - more expensive order
    //report - product with lowerst inventory
    //exit
}
