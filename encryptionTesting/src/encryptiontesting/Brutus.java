package encryptiontesting;

public class Brutus {
    public static int FindKey(String codedMessage) {
        
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
            "what", "when", "which", "while", "white", "will", "with", "work", "year", "your", "shrek", 
            "word", "had", "which", "has", "number", "made", "part"};
        
        int bestKey = 0;
        int bestHits = 0;
        int hits = 0;
        
        char[] coded = strToArray(codedMessage);
        for(int i = 0; i < 999999; i++) {

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
                int count = 0;
                
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
                if(hits > bestHits) {
                    bestKey = i;
                    bestHits = hits;   
                    System.out.println("Tested key " + i + " number of hits: " + hits);
                    //printArray(tempArray);
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
        int[] result = {0,0,0,0,0,0};
        result[5] = num % 10;
        result[4] = num/10 % 10;
        result[3] = num/100 % 10;
        result[2] = num/1000 % 10;
        result[1] = num/10000 % 10;
        result[0] = num/100000 % 10;
        
        return result;
    }  
}