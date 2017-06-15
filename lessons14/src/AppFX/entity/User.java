package AppFX.entity;

/**
 * Created by adm on 14.06.2017.
 */
public class User {
    String login;
    String email;
    String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
