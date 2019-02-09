package top_interview_easy.strings;

public class first_unique {
    public int firstUniqChar(String s) {
        int[] seen = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
        	int x = s.charAt(i) - 'a';
        	if(seen[x] == 0) {
        		seen[x] = i + 1;
        	} else if(seen[x] > 0) {
        		seen[x] = -1;
        	}
        	//System.out.println(Arrays.toString(seen));
        }
        
        int min = Integer.MAX_VALUE;
        for(int x: seen) {
        	if(x != 0 && x != -1) {
        		min = Math.min(min, x);
        	}
        }
        
        if(min == Integer.MAX_VALUE) {
        	return -1;
        }
        
        return min - 1;
    }
    
    public static void main(String[] args) {
    	System.out.println(new first_unique().firstUniqChar("aadadaad"));
    }
}
