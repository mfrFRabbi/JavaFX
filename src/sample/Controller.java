package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.User;
import sample.model.UserDataSource;

import java.io.IOException;


public class Controller {

    @FXML
    private TextField userNameId;

    @FXML
    private PasswordField passId;

    @FXML
    private Button forgotBtnId;

    @FXML
    private Button loginBtnId;

    @FXML
    private Button signUpBtnId;
    private UserDataSource dataSource = new UserDataSource();

    @FXML
    void initialize() {
        loginBtnId.setOnAction(event -> {
            try {
                gotoDashboard();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        signUpBtnId.setOnAction(event -> {
            signUpBtnId.getScene().getWindow().hide();
            gotoRegistrationForm();
        });
    }

    private void gotoDashboard() throws IOException {
        User user = dataSource.login(userNameId.getText(), passId.getText());
        Stage stage = new Stage();
        if (user != null) {
            loginBtnId.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("views/loginSample.fxml"));

            Parent parent = loader.load();
            LoginController controller = loader.getController();
            controller.setUserData(user);
            stage.setScene(new Scene(parent));
            stage.show();

        } else {
            System.out.println("Data not Existed");
        }
    }

    private void gotoRegistrationForm() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/signUpSample.fxml"));
        Stage stage = new Stage();
        try {
            Parent parent = loader.load();
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
