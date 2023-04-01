
package encryptiontesting;

import java.awt.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Controller extends Application {
    private int key;
    
    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane(); 
        HBox box = addHBox();
        root.getChildren().add(box);
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Encryption/Decryption");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

//        Button buttonCurrent = new Button("Current");
//        buttonCurrent.setPrefSize(100, 20);
//
//        Button buttonProjected = new Button("Projected");
//        buttonProjected.setPrefSize(100, 20);
//        hbox.getChildren().addAll(buttonCurrent, buttonProjected);
        
        EncryptDecrypt using = new EncryptDecrypt();
        Button enc = new Button();
        enc.setText("ENCRYPTION");
        enc.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                key = using.encrypt();
            }
        });
        
        Button dec = new Button();
        dec.setText("DECRYPTION");
        dec.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                using.decrypt();
            }
        });
        
        Button quit = new Button();
        quit.setText("QUIT");
        quit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Quitting");
                System.exit(0);  
            }
        });
        
        hbox.getChildren().addAll(enc,dec,quit);
        

    return hbox;
    }
 
    public HBox addEnc() {
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

//        Button buttonCurrent = new Button("Current");
//        buttonCurrent.setPrefSize(100, 20);
//
//        Button buttonProjected = new Button("Projected");
//        buttonProjected.setPrefSize(100, 20);
//        hbox.getChildren().addAll(buttonCurrent, buttonProjected);
        
        EncryptDecrypt using = new EncryptDecrypt();
        Button enc = new Button();
        enc.setText("ENCRYPTION");
        enc.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                key = using.encrypt();
            }
        });
        
        Button dec = new Button();
        dec.setText("DECRYPTION");
        dec.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                using.decrypt();
            }
        });
        
        Button quit = new Button();
        quit.setText("QUIT");
        quit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Quitting");
                System.exit(0);  
            }
        });
        
        hbox.getChildren().addAll(enc,dec,quit);
        

    return hbox;
    }    
    
    
}
