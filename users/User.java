package users;

public abstract class User {

    private String userId;
    private String name;
    private String email;
    private String password;
    private String role;

    // Constructor
    public User(String userId, String name,
                String email, String password) {

        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

  
    public String getPassword() {
        return password;
    }

    // Login (can be overridden/used)
    public void login(){

        System.out.println("[LOGIN] " + name
                + " logged in as " + role);
    }

    // Logout
    public void logout() {

        System.out.println("[LOGOUT] " + name
                + " logged out");
    }

    // Display Profile
    public void displayProfile() {

        System.out.println("\n----------------------");
        System.out.println("ID    : " + userId);
        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
        System.out.println("----------------------");
    }

    // Abstract method (abstraction)
    public abstract void showMenu();
}

// Exception (same file as per your rule)
class InvalidLoginException extends Exception {

    public InvalidLoginException(String msg) {
        super(msg);
    }
}