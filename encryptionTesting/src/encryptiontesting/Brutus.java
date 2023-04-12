package encryptiontesting;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Brutus {
    public static int FindKey() throws IOException{
        
        FileDialog input = new FileDialog((Frame)null, "Select the File You Want to Attempt to Get the Key For");
        input.setMode(FileDialog.LOAD);
        input.setVisible(true);
        String pathIn = input.getDirectory() + input.getFile();
        input.dispose();
        System.out.println(pathIn + " chosen.");
        
        InputStream inputStream = new FileInputStream(pathIn);
        InputStreamReader isReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine())!= null){
           sb.append(str);
        }
        String codedMessage = sb.toString();
        //System.out.println(codedMessage);
        
        String[] common = {"the", "and", "that", "have", "for", "not", "with", "you", 
            "this", "but", "his", "from", "they", "say", "her", "she", "will", "one", "all", "would", 
            "there", "their", "what", "out", "about", "who", "get", "which", "make", "can", "like", 
            "time", "just", "him", "know", "take", "people", "into", "year", "your", "good", "some", 
            "could", "them", "see", "other", "than", "then", "now", "look", "only", "come", "its", 
            "over", "think", "also", "back", "after", "use", "two", "how", "our", "work", "first", 
            "well", "way", "even", "new", "want", "because", "any", "these", "give", "day", "most", 
            "also", "back", "been", "both", "call", "came", "come", "could", "each", "even", "find", 
            "first", "five", "form", "four", "give", "hand", "head", "high", "home", "just", "keep", 
            "kind", "last", "life", "line", "long", "made", "many", "mean", "might", "more", "most", 
            "much", "must", "name", "need", "never", "next", "only", "open", "part", "play", "read", 
            "real", "room", "same", "show", "small", "some", "take", "tell", "than", "that", "them", 
            "then", "they", "time", "took", "tree", "turn", "very", "want", "well", "went", "were", 
            "what", "when", "which", "while", "white", "will", "with", "work", "year", "your", 
            "word", "had", "which", "has", "number", "made", "part"};
        
        int bestKey = 0;
        int bestHits = 0;
        int hits = 0;
        
        char[] coded = strToArray(codedMessage);
        for(int i = 0; i < 999999999; i++) {

            int[] tempKey = intToArray(i);
            char[] tempArray = coded.clone();
            hits = 0;
            
            if(tempKey[3] <= 1 && tempKey[4] <= 1 && tempKey[5] <= 1) {           
                tempKey[3] = tempKey[3] + 1;
                tempKey[4] = tempKey[4] + 1;
                tempKey[5] = tempKey[5] + 1;
                char[] newCode =  EncryptionAlgorithm.encode(tempArray, tempKey);
                String testString = toString(newCode).toLowerCase();

                int lastIndex = 0;
                
                for(int j = 0; j < common.length; j++) {                    
                    if(testString.contains(common[j])) {
                        while (lastIndex != -1) {
                            lastIndex = testString.indexOf(common[j], lastIndex);
                            if (lastIndex != -1) {
                                hits++;
                                lastIndex += common[j].length();
                            }
                        }
                    }
                }
                if(hits != 0) {
                    System.out.println("Tested key " + i + " number of hits: " + hits);
                }
                
                if(hits > bestHits) {
                    bestKey = i;
                    bestHits = hits;   
                    //System.out.println("Tested key " + i + " number of hits: " + hits);
                    EncryptionAlgorithm.printArray(tempArray);
                }
                
            }
            
        }
        return bestKey;
    }
    public static String toString(char[] a)
    {
        String string = new String(a);
        return string;
    }
    
    public static char[] strToArray(String str) {
        char[] ch = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        return ch;
    }
    public static int[] intToArray(int num) {
        int[] result = {0,0,0,0,0,0,0,0,0};
        result[8] = num % 10;
        result[7] = num/10 % 10;
        result[6] = num/100 % 10;
        result[5] = num/1000 % 10;
        result[4] = num/10000 % 10;
        result[3] = num/100000 % 10;
        result[2] = num/1000000 % 10;
        result[1] = num/10000000 % 10;
        result[0] = num/100000000 % 10;
        
        return result;
    }  
}