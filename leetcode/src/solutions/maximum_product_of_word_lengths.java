package solutions;

public class maximum_product_of_word_lengths {
    public int maxProduct(String[] words) {
        int max = 0;
        int[] sets = new int[words.length];
        
        for(int i = 0; i < words.length; i++) {
        	sets[i] = createSet(words[i]);
        }
        
        for(int i = 0; i < words.length; i++) {
        	for (int j = i + 1; j < words.length; j++) {
        		if(!share(sets[i], sets[j])) {
        			max = Math.max(max, words[i].length() * words[j].length());
        		}
        	}
        }
        
        return max;
    }
    
    public int createSet(String i) {
    	int ret = 0;
    	
    	for(char c: i.toCharArray()) {
    		ret = ret | (1 << (c - 'a'));
    	}
    	
    	return ret;
    }
    
    public boolean share(int i, int j) {
    	return (i & j) > 0;
    }
}
