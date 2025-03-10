import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService {
    // List of users credentials, acting as a database
    private ArrayList<User> users;

    /**
     * Initialises the AuthService with empty list.
     */
    public AuthenticationService() {
        this.users = new ArrayList<>();
    }

    /**
     * Attempts to register a new user with the provided credentials.
     * @param username User's username.
     * @param password User's password.
     * @return The newly created user;
     *         null if the username already exists.
     */
    public User signUp(String username, String password) {
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(username)) {
                return null;
            }
        }

        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    /**
     * Attempts to log-in using provided credentials.
     * @param username User's username.
     * @param password User's password.
     * @return The User object if the username and password are correct;
     *         null if any of the credentials are wrong.
     */
    public User logIn(String username, String password) {
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(username) && existingUser.getPassword().equals(password)) {
                return existingUser;
            }
        }

        return null;
    }
}