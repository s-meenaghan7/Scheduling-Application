
package SchedulingApp;

import java.util.Locale;
import Utils.DBConnection;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;

public class SchedulingApp extends Application {
    
    static Stage stage;
    
    public static void main(String[] args) {
        
        DBConnection.startConnection();
        launch(args);
        DBConnection.closeConnection();
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/LoginScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        if (Locale.getDefault() == Locale.FRENCH) {
            stage.setTitle("Rendez-vous et planification");
        } else stage.setTitle("Scheduling");
        stage.show();
    }
    
}
