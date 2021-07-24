
package Utils;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sean
 */
public class SceneChanger {
    
    // Try this; if it doesnt work, use a SceneChanger object instead
    public void changeSceneTo(ActionEvent event, String FXMLPath) throws IOException {

        Parent newScene = FXMLLoader.load(getClass().getResource(FXMLPath));
        Scene scene = new Scene(newScene);

        // this line gets the stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    
}
