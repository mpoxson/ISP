
package encryptiontesting;


import javafx.scene.image.Image;
import java.awt.Insets;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
            System.out.println("Darn");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
//    public HBox encHBox(){
//        HBox hbox = new HBox();
//
////        Button buttonCurrent = new Button("Current");
////        buttonCurrent.setPrefSize(100, 20);
////
////        Button buttonProjected = new Button("Projected");
////        buttonProjected.setPrefSize(100, 20);
////        hbox.getChildren().addAll(buttonCurrent, buttonProjected);
//        
//        EncryptDecrypt using = new EncryptDecrypt();
//        Button encWork = new Button();
//        encWork.setText("ENCRYPT");
//        encWork.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                try {
//                    key = EncryptDecrypt.encrypt();
//                    String keyString = "";
//                    for (int temp:key){
//                        keyString = keyString + temp;
//                    }
//                    txt.setText(keyString);
//                } catch (IOException ex) {
//                    System.out.println("Something went wrong");
//                }
//            }
//        });
//        
//        Label lab = new Label();
//        lab.setText("Key: ");
//        txt.setText("Waiting for encryption to complete");
//        
//        hbox.getChildren().addAll(encWork,lab,txt);
//        
//
//    return hbox;
//    }  
//    
//    public HBox decHBox() {
//        HBox hbox = new HBox();
//
////        Button buttonCurrent = new Button("Current");
////        buttonCurrent.setPrefSize(100, 20);
////
////        Button buttonProjected = new Button("Projected");
////        buttonProjected.setPrefSize(100, 20);
////        hbox.getChildren().addAll(buttonCurrent, buttonProjected);
//        
//        Button decWork = new Button();
//        decWork.setText("DECRYPT");
//        EncryptDecrypt using = new EncryptDecrypt();
//        decWork.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                try {
//                    using.decrypt();
//                } catch (IOException ex) {
//                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//        
//        Label lab = new Label();
//        lab.setText("Key: ");
//        txt.setText("Waiting for encryption to complete");
//        
//        hbox.getChildren().addAll(decWork,lab,txt);
//        
//
//    return hbox;
//    } 
    
}
