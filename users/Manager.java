package users;

public class Manager extends User {

    public Manager(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    @Override
    public void showMenu() {
        System.out.println("Manager Menu");
    }
}