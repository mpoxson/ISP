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

    @FXML
    public TextField txtKey, txtKey2, txtKey3;

    @FXML
    public Button encryption, decryption, brutus, encrypt, decrypt, home, crack;

    private Parent root;
    private Scene scene;
    private Stage primaryStage;

    public void setEventHandler(ActionEvent e) throws IOException {
        //System.out.println("test");
        Object source = e.getSource();
        //String test = e.getSource().toString();
        //System.out.println(source);
        //System.out.println(test);
        //System.out.println(encryption);
        if (source.equals(encryption)) {
            root = FXMLLoader.load(getClass().getResource("encryption.fxml"));
            primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
                        primaryStage.getIcons().add(new Image("file:./icon.jpg"));
            primaryStage.setTitle("CAESAR ENCRYPTION");
        } else if (source == decryption) {
            root = FXMLLoader.load(getClass().getResource("decryption.fxml"));
            primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
                        primaryStage.getIcons().add(new Image("file:./icon.jpg"));
            primaryStage.setTitle("ET TU?");
        } else if (source == brutus) {
           root = FXMLLoader.load(getClass().getResource("hack.fxml"));
            primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.getIcons().add(new Image("file:./icon.jpg"));
            primaryStage.setTitle("BRUTUS DECRYPTION");
        } else if (source == encrypt) {
            int[] key = EncryptDecrypt.encrypt();
            String keyString = "";
            for (int temp : key) {
                keyString = keyString + temp;
            }
            txtKey.setText(keyString);
        } else if (source == decrypt) {
            System.out.println(txtKey2.getText().length());
            if (txtKey2.getText().length() != 9) {
                System.out.println("Not a 9 digit code");
            } else {
                int[] key = new int[9];
                int c = 0;
                char[] tempArr = txtKey2.getText().toCharArray();
                for (char temp : tempArr) {
//            System.out.println("temp: " + temp);
                    key[c] = temp - 48;
//            System.out.println("Key at " + c + ": " + key[c]);
                    c++;
                }
                EncryptDecrypt.decrypt(key);
            }
        } else if (source == home) {
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
            primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
                        primaryStage.getIcons().add(new Image("file:./icon.jpg"));
            primaryStage.setTitle("CAESAR ENCRYPTION");
        }else if (source == crack) {
            int crackKey = Brutus.FindKey();
            System.out.println(crackKey);
            txtKey3.setText("" + crackKey);
        }
    }
}
