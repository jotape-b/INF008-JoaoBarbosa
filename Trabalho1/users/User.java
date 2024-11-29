package users;
public class User {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String email;
    private String salt;
    private String password;

    public User(String name, String email, String password) throws Exception{
        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.salt = PasswordHasher.generateSalt();
        this.password = PasswordHasher.hashPassword(password, this.salt);
    }
}
