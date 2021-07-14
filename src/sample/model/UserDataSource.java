package sample.model;

import java.util.ArrayList;
import java.util.List;

public class UserDataSource {
    private static List<User> userList = new ArrayList<>();
    static {
        userList.add(new User("user1","First User","user1@mail.com","11111"));
        userList.add(new User("user2","Second User","user2@mail.com","22222"));
        userList.add(new User("user3","third User","user3@mail.com","33333"));
        userList.add(new User("user4","Fourth User","user4@mail.com","44444"));
        userList.add(new User("user5","Fifth User","user5@mail.com","55555"));
    }

    public static List<User> getUserList() {
        return userList;
    }

    public User login(String username, String pass){
        final User[] loginUser = {null};
        userList.forEach(user -> {
            if (user.getUsername().equals(username) && user.getPassword().equals(pass)) {
                 loginUser[0] = user;
            }
        });
        return loginUser[0];
    }

    public void registrationUser(User user){
        userList.add(user);
    }
}
