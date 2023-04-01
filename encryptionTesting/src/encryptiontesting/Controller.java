
package encryptiontesting;

import java.awt.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Controller extends Application {
    private int key;
    public TextField txt = new TextField();
    private HBox encBox;
    
    @Override
    public void start(Stage primaryStage) {
        HBox decBox;
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        GridPane root = new GridPane();
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
                encBox = encHBox();
                root.add(encBox, 1, 2);
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
        System.out.println("Added");
         
        root.add(hbox,1,1);
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
    
    public HBox encHBox() {
        HBox hbox = new HBox();

//        Button buttonCurrent = new Button("Current");
//        buttonCurrent.setPrefSize(100, 20);
//
//        Button buttonProjected = new Button("Projected");
//        buttonProjected.setPrefSize(100, 20);
//        hbox.getChildren().addAll(buttonCurrent, buttonProjected);
        
        EncryptDecrypt using = new EncryptDecrypt();
        Button enc = new Button();
        enc.setText("ENCRYPT");
        enc.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                key = using.encrypt();
            }
        });
        
        Label lab = new Label();
        lab.setText("Key: ");
        txt.setText("Waiting for encryption to complete");
        
        hbox.getChildren().addAll(enc,lab,txt);
        

    return hbox;
    }  
    
    
}
