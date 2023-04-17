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
        
        //here is the common word list, compiled from various sources, for consistency, all words have to be at least 3 letters
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
            
            //since only the parity matters for key345, brutus will only test keys that have a 0 or 1 in this slot, this elimates a lot of unneccsarry work
            if(tempKey[3] <= 1 && tempKey[4] <= 1 && tempKey[5] <= 1) {   
                //key345 is incremented so it can decrpyt
                tempKey[3] = tempKey[3] + 1;
                tempKey[4] = tempKey[4] + 1;
                tempKey[5] = tempKey[5] + 1;
                //a new array is made with the decoded version for checking
                char[] newCode =  EncryptionAlgorithm.encode(tempArray, tempKey);
                String testString = toString(newCode).toLowerCase();

                int lastIndex = 0;
                
                //the program counts the number of hits but first checking to see if the decoded version contains that word, then checking to see how many of that word
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
                
                //logs the output for all hits except for 0, so the user can go into the log and get other good keys if the one found by brutus does not result in total decryption
                if(hits != 0) {
                    System.out.println("Tested key " + i + " number of hits: " + hits);
                }
                
                //determines the best key and hits, if a key is found with the same number of hits, it will take the new one
                if(hits >= bestHits) {
                    bestKey = i;
                    bestHits = hits;   
                    //System.out.println("Tested key " + i + " number of hits: " + hits);
                    //EncryptionAlgorithm.printArray(tempArray);
                }
                
            }
            
        }
        return bestKey;
    }
    //helper functions
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
    //this turns an int into the compatible key, since keys are internally stored as an int array
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