package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.model.User;

public class LoginController {
    @FXML
    private Label nameLabelId;

    @FXML
    private Label emailLabelId;

    @FXML
    void initialize() {

    }

    public void setUserData(User user){
        nameLabelId.setText(user.getFullName());
        emailLabelId.setText(user.getEmail());
    }
}
