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


public class SignUpController {


    @FXML
    private Button submitBtnId;

    @FXML
    private TextField userNameTextFieldId;

    @FXML
    private TextField fullNameTextFieldId;

    @FXML
    private TextField emailTextFieldId;

    @FXML
    private PasswordField passTextFieldId;
    @FXML
    private Button backToLoginSceneId;

    @FXML
    void initialize() {
        submitBtnId.setOnAction(event -> {
            if (!isEmpty()) {
                UserDataSource userDataSource = new UserDataSource();
                userDataSource.registrationUser(new User(userNameTextFieldId.getText(),fullNameTextFieldId.getText(),
                        emailTextFieldId.getText(),passTextFieldId.getText()));
                clear();
            }
        });
        backToLoginSceneId.setOnAction(event -> {
            try {
                backToLoginSceneId.getScene().getWindow().hide();
                gotoHome();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    private boolean isEmpty(){
        boolean isEmpty = false;
        if(userNameTextFieldId.getText().isEmpty() || fullNameTextFieldId.getText().isEmpty() || emailTextFieldId.getText().isEmpty() ||
                passTextFieldId.getCharacters().toString().isEmpty()){
            isEmpty = true;
        }
        return isEmpty;
    }

    private void clear(){
        userNameTextFieldId.clear();
        fullNameTextFieldId.clear();
        emailTextFieldId.clear();
        passTextFieldId.clear();
    }
    private void gotoHome() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/sample.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}
