package encryptiontesting;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

    //The @FXML tag lets the compiler know these objects are in an FXML file
    @FXML
    public TextField txtKey, txtKey2, txtKey3;

    @FXML
    public Button encryption, decryption, brutus, encrypt, decrypt, home, crack;

    private Parent root;
    private Scene scene;
    private Stage primaryStage;

    //Handles button clicks
    public void setEventHandler(ActionEvent e) throws IOException {
        
        //Grabs source of mouse click or enter press
        Object source = e.getSource();
        
        //Determines which button was clicked
        if (source.equals(encryption)) {
            //Changes the scene to the Encryption FXML page
            root = FXMLLoader.load(getClass().getResource("encryption.fxml"));
            primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.getIcons().add(new Image("file:./icon.jpg"));
            primaryStage.setTitle("CAESAR ENCRYPTION");
        } else if (source == decryption) {
            //Changes the scene to the Decryption FXML page
            root = FXMLLoader.load(getClass().getResource("decryption.fxml"));
            primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.getIcons().add(new Image("file:./icon.jpg"));
            primaryStage.setTitle("ET TU?");
        } else if (source == brutus) {
            //Changes the scene to the Brutus FXML page
            root = FXMLLoader.load(getClass().getResource("hack.fxml"));
            primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.getIcons().add(new Image("file:./icon.jpg"));
            primaryStage.setTitle("BRUTUS DECRYPTION");
        } else if (source == encrypt) {
            //Connects to the encryption method
            int[] key = EncryptDecrypt.encrypt();
            String keyString = "";
            
            //loops through the returned key and makes it into a string
            for (int temp : key) {
                keyString = keyString + temp;
            }
            
            //Outputs the key needed for decryption
            txtKey.setText(keyString);
        } else if (source == decrypt) {
            
            //Outputs length of the key
            System.out.println(txtKey2.getText().length());
            
            //If the key isn't 9 digits, do not decrypt
            if (txtKey2.getText().length() != 9) {
                //Displace "error" message in the console
                System.out.println("Not a 9 digit code");
            } else {
                int[] key = new int[9];
                int c = 0;
                
                //Converts inputted string in the textfield to character array
                char[] tempArr = txtKey2.getText().toCharArray();
                
                //Loops through character array and converts to an integer
                for (char temp : tempArr) {
                    key[c] = temp - 48;
                    c++;
                }
                
                //Connects to decryption method with key
                EncryptDecrypt.decrypt(key);
            }
        } else if (source == home) {
            //Returns to the homepage FXML
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
            primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.getIcons().add(new Image("file:./icon.jpg"));
            primaryStage.setTitle("CAESAR ENCRYPTION");
        } else if (source == crack) {
            //Connects to the brute force attack method
            int crackKey = Brutus.FindKey();
            
            //Displays most likely key
            System.out.println(crackKey);
            txtKey3.setText("" + crackKey);
        }
    }
}
