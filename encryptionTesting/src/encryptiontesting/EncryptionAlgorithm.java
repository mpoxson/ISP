package encryptiontesting;

import java.util.Random;

public class EncryptionAlgorithm {

    public static void main(String[] args) {
        

        //33 to 126
        Random rand = new Random();
        String message = "This is a message and it is super duper ultra mega secret";
        
        int a = rand.nextInt(10); 
        int b = rand.nextInt(10); 
        int c = rand.nextInt(10); 
        int d = rand.nextInt(10); 
        int e = rand.nextInt(10); 
        int f = rand.nextInt(10);
        
        int[] key = {a, b, c, d, e, f};
        int[] key2 = {a, b, c, d + 1, e + 1, f + 1};
        int[] key3 = {a, b, c, d, e, f};
        
        char[] coded = strToArray(message);
        
        coded = encode(coded, key);
      
        char[] uncoded = coded.clone();
        
        uncoded = encode(uncoded, key2);
        
        System.out.print("Original Message: " + message + " with key ");
        printArray(key3);
        System.out.print("Encoded Message: ");
        printArray(coded);
        System.out.print("Uncoded Message: ");
        printArray(uncoded);
        
    }
    
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
            if(coded[i] != ' ') {
                if (key[1] >= 10) {
                    key[1] = 0;
                }
                if(key[0] >= 15) {
                    key[0] = key[1];
                    key[1]++;
                }
                
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
                
                coded[i] = (char)(coded[i] + a + b + c);
                
                key[0]++;
            }
        }
        return coded;
    }
}

