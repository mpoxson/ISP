
package encryptiontesting;
import java.util.*;
import java.io.IOException;

public class EncryptionTesting extends EncryptDecrypt {

    public static void main(String[] args) throws IOException{
        System.out.println("Enter 1 to enccrypt a file, 2 to decrypt a file with your key, or 3 to quit.");
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();

        
        switch (input) {
            case 1:
                int[] key = encrypt();
                System.out.print("Your key for decryption is: ");
                printArray(key);
                break;
            case 2:
                decrypt();
                break;
            case 3:
                System.out.println("Quitting");
                System.exit(0);
            default:
                System.out.println("Input was invalid, rerun the program");
                break;
        }
    }
    
        public static void printArray(char[] str) {
        for(int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
        System.out.print("\n");
    }
    
}
