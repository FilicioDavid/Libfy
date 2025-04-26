package Controller;

import Model.User;
import Model.UserType;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private static List<User> users = new ArrayList<>();
    private static int nextId = 0;

    static {
        //set do usuario admin raiz
        users.add(new User(nextId++, "Admin", "admin@biblioteca.com", "admin123", UserType.ADMIN));
    }


    public static void addUser(String name, String email,String password, UserType type) {
        User user = new User(nextId++, name, email, password, type);
        users.add(user);
        System.out.println("Usuario adicionado com sucesso!");
    }

    public static User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static void listUsers() {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}
