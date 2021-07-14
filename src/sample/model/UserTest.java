package sample.model;

public class UserTest {
    public static void main(String[] args) {
        UserDataSource userDataSource = new UserDataSource();
        User loginUser = userDataSource.login("user1","11111");
        if (loginUser != null){
            System.out.println(loginUser.getEmail());
        } else {
            System.out.println("Please Registration");
        }
    }
}
