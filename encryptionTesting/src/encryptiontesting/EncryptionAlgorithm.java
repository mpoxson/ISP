package encryptiontesting;

import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptionAlgorithm {

    public static int[] encryptFile(String input, String output) throws IOException {
        

        Random rand = new Random();
        String message = input;
        
        //generate 9 random numbers for the key
        int a = rand.nextInt(10); 
        int b = rand.nextInt(10); 
        int c = rand.nextInt(10); 
        int d = rand.nextInt(10); 
        int e = rand.nextInt(10); 
        int f = rand.nextInt(10);
        int g = rand.nextInt(10);
        int h = rand.nextInt(10);
        int i = rand.nextInt(10);
         
        //the key is made from the random numbers, a seperate key is set for the return value since the key gets modified during encrpytion, we need the unmodified key to decrypt
        int[] key = {a, b, c, d, e, f, g, h, i};
        int[] returnKey = {a, b, c, d, e, f, g, h, i};
        
        char[] coded = strToArray(message);
        
        coded = encode(coded, key);
     
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        writer.write(coded);
        writer.close();
        
        
        return returnKey;
        
    }
    
        public static void decryptFile(String input, int[] inKey, String output) throws IOException{
        

        String message = input;
        
        //incrementing keys 3,4 and 5 swaps the parity of them, and reverses the algorithm
        int[] key = inKey;
        key[3]++;
        key[4]++;
        key[5]++;

        
        char[] coded = strToArray(message);
        
        coded = encode(coded, key);
      

        //debug code
        /*System.out.print("Original Message: " + message + " with key ");
        printArray(key3);
        System.out.print("Encoded Message: ");
        printArray(coded);
        System.out.print("Uncoded Message: ");
        printArray(uncoded);*/
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        writer.write(coded);
        writer.close();
        
    }
    
        //these are some various helper functions to do small tasks like conversions or print the arrays for debugging purpouses
    public static void printArray(char[] str) {
        for(int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
        System.out.print("\n");
    }
    public static void printArray(int[] str) {
        for(int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
        System.out.print("\n");
    }
    
    public static char[] strToArray(String str) {
        char[] ch = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        return ch;
    }
    
    public static char[] encode(char[] coded, int[] key) {
        for(int i = 0; i < coded.length; i++) {
            int a, b, c;
                //key1 goes up when key0 gets too high, and will keep going until it reaches a certain point and then will reset
                if (key[1] >= key[6] + 10) {
                    key[1] = key[7] - 5;
                }
                //key0 goes up every loop, once it hits a certain value it gets set to key1 and key1 goes up by one
                if(key[0] >= key[8] + 10) {
                    key[0] = key[1];
                    key[1]++;
                }
                //the sign of the offset amounts is determined by key345, this is why incrementing them reverses the algorithm
                if(key[3] % 2 == 0) {
                    a = key[0];
                } else {
                    a = key[0] * -1;
                }
                if(key[4] % 2 == 0) {
                    b = key[1];
                } else {
                    b = key[1] * -1;
                }
                if(key[5] % 2 == 0) {
                    c = key[2];
                } else {
                    c = key[2] * -1;
                }
                //the numbers are added to the char to offset it and the loop repeats
               coded[i] = (char)(coded[i] + a + b + c);
                    
                key[0]++;
            
        }
        return coded;
    }
}

