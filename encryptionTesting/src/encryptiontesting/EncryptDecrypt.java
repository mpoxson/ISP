
package encryptiontesting;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;


public class EncryptDecrypt extends EncryptionAlgorithm{
    public static int[] encrypt()throws IOException{
        System.out.println("You have chosen to encrypt, select the text file you want to encrypt, then select a blank file you want the encrypted output to go to");
        
        FileDialog input = new FileDialog((Frame)null, "Select the File You Want to Encrypt");
        input.setMode(FileDialog.LOAD);
        input.setVisible(true);
        String pathIn = input.getDirectory() + input.getFile();
        input.dispose();
        System.out.println(pathIn + " chosen.");
        
        FileDialog output = new FileDialog((Frame)null, "Select the File You Want the Encrypted Message to Store in");
        input.setMode(FileDialog.LOAD);
        input.setVisible(true);
        String pathOut = input.getDirectory() + input.getFile();
        input.dispose();
        System.out.println(pathOut + " chosen.");
        
        InputStream inputStream = new FileInputStream(pathIn);
        InputStreamReader isReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine())!= null){
           sb.append(str);
        }
        String inputFile = sb.toString();
        
        int[] key = encryptFile(inputFile, pathOut);
        
        
        
        return key;
    }
    
    public static void decrypt() throws IOException{
        System.out.println("You have chosen to decrypt, choose the file you want to decrypt, then chooose the file you want the decrypted message to store, then type in your key for decrypting, one digit at a time");
        
        FileDialog input = new FileDialog((Frame)null, "Select the File You Want to Decrypt");
        input.setMode(FileDialog.LOAD);
        input.setVisible(true);
        String pathIn = input.getDirectory() + input.getFile();
        input.dispose();
        System.out.println(pathIn + " chosen.");

        FileDialog output = new FileDialog((Frame)null, "Select the File You Want the Decryption to Store in");
        input.setMode(FileDialog.LOAD);
        input.setVisible(true);
        String pathOut = input.getDirectory() + input.getFile();
        input.dispose();
        System.out.println(pathOut + " chosen.");
        
        InputStream inputStream = new FileInputStream(pathIn);
        InputStreamReader isReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine())!= null){
           sb.append(str);
        }
        String inputFile = sb.toString();
        
        //System.out.println("Enter in your key for decryption, one digit at a time");
        int[] key = new int[6];
        int c = 0;
        char[] tempArr = Controller.txt.getText().toCharArray();
        for (char temp: tempArr){
//            System.out.println("temp: " + temp);
            key[c] = temp - 48;
//            System.out.println("Key at " + c + ": " + key[c]);
            c++;
        }
//        for(int x=0; x<6; x++){
//        //Scanner s = new Scanner(System.in);
//        //key[x] = s.nextInt();
//            System.out.print(key[x]);
//        }
        
        decryptFile(inputFile, key, pathOut);
        
    }
}
