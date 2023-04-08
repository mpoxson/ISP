
package encryptiontesting;


import javafx.scene.image.Image;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
    private int[] key;
    
    @Override
    public void start(Stage primaryStage) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            Scene scene1 = new Scene(root);
            primaryStage.getIcons().add(new Image("file:./icon.jpg"));
            primaryStage.setTitle("CAESAR ENCRYPTION");
            primaryStage.setScene(scene1);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println("Load didn't work");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
