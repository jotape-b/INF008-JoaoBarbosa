package users;
enum UserType{USER, ADMIN}
public class User {
    private static int idCounter = 0;
    private int id;
    private UserType userType;
    private String name;
    private String email;
    private String salt;
    private String password;

    public User(UserType userType, String name, String email, String password) throws Exception{
        this.id = idCounter++;
        this.userType = userType;
        this.name = name;
        this.email = email;
        String[] hashAndSalt = PasswordHasher.createHashWithSalt(password);
        this.salt = hashAndSalt[0];
        this.password = hashAndSalt[1];
    }

    public boolean isAdmin(){
        return false;
    }

    public int getId(){
        return id;
    }
}
