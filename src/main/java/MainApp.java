import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene;
        Parent parent= FXMLLoader.load(getClass().getResource("/fxml/registration_form.fxml"));
        primaryStage.setTitle("Registration");
        scene= new Scene(parent,800,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
