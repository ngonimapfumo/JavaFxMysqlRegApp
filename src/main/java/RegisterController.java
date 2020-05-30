import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.sql.SQLException;

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
    public void register(javafx.event.ActionEvent actionEvent) throws SQLException {
        Window window = submitButton.getScene().getWindow();

        if (fullNameField.getText().isEmpty()) {
            Alert(Alert.AlertType.ERROR, window, "Error", "Name cannot be empty");
            return;
        }
        if (emailIdField.getText().isEmpty()) {
            Alert(Alert.AlertType.ERROR, window, "Error", "Email cannot be empty");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            Alert(Alert.AlertType.ERROR, window, "Error", "Please enter password");
            return;
        }


        String fullName = fullNameField.getText();
        String email = emailIdField.getText();
        String password = passwordField.getText();

        JdbcDao jdbcDao = new JdbcDao();
        jdbcDao.insertData(fullName, email, password);


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
