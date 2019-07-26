package solutions;

public class shortest_completing_word {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
    	// possibility for the usage of prime #s
    	
    	licensePlate = licensePlate.toLowerCase();
    	char[] p = new char[26];
    	for(char c: licensePlate.toCharArray()) if(Character.isAlphabetic(c)) p[c - 'a']++;
    	
    	String best = "aaaaaaaaaaaaaaaa";
    	
    	for(int i = 0; i < words.length; i++) words[i] = words[i].toLowerCase();
    	
    	outerloop:
    	for(String word: words) {
    		char[] attempt = new char[26];
    		for(char c: word.toCharArray()) if(Character.isAlphabetic(c))  attempt[c - 'a']++;
    		
    		
    		for(int i = 0; i < p.length; i++) {
    			if(p[i] > attempt[i]) {
    				continue outerloop;
    			}
    		}
    		
    		if(best.length() > word.length()) {
    			best = word;
    		}
    	}
    	
    	return best;
    }
}
