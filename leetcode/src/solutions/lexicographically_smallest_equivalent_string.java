package solutions;

public class lexicographically_smallest_equivalent_string {
	public char find(char[] f, char x) {
		if(x == f[x - 'a']) return x;
		return find(f, f[x - 'a']);
	}
	
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
    	char[] f = new char[26];
    	for(int i = 0; i < f.length; i++) {
    		f[i] = (char)('a' + i);
    	}
    	
    	for(int i = 0; i < s1.length(); i++) {
    		char l = find(f, s1.charAt(i));
    		char r = find(f, s2.charAt(i));
    		if(l == r) continue;
    		if(l < r) {
    			f[r - 'a'] = l;
    		} else {
    			f[l - 'a'] = r;
    		}
    	}
    	
    	StringBuilder ret = new StringBuilder();
    	for(char c: baseStr.toCharArray()) {
    		ret.append(find(f, c));
    	}
    	
    	return ret.toString();
    }
}
