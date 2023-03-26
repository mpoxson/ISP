
package encryptiontesting;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class EncryptDecrypt {
    public static int encrypt(){
        System.out.println("You have chosen to encrypt");
        
        FileDialog input = new FileDialog((Frame)null, "Select File to Open");
        input.setMode(FileDialog.LOAD);
        input.setVisible(true);
        String file = input.getFile();
        input.dispose();
        System.out.println(file + " chosen.");
        
        return 0;
    }
    
    public static void decrypt(){
        System.out.println("You have chosen to decrypt");
        
        FileDialog input = new FileDialog((Frame)null, "Select File to Open");
        input.setMode(FileDialog.LOAD);
        input.setVisible(true);
        String file = input.getFile();
        input.dispose();
        System.out.println(file + " chosen.");
        
        System.out.println("Enter in your key for decryption");
        Scanner s = new Scanner(System.in);
        int key = s.nextInt();
        
    }
}
