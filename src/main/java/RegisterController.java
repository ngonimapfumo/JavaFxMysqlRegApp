import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.awt.event.ActionEvent;

public class RegisterController {

    @FXML
    private TextField fullNameField;
    @FXML
    private TextField emailIdField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button submitButton;


    @FXML
    public void register(ActionEvent actionEvent) {
        Window window = submitButton.getScene().getWindow();

        if(fullNameField.getText().isEmpty()){
            Alert(Alert.AlertType.ERROR,window,"Error","Name cannot be empty");
            return;
        }

    }


    private void Alert(Alert.AlertType alertType, Window window, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(window);
        alert.show();

    }


}
