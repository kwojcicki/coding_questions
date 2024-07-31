package solutions;

public class minimum_deletions_to_make_string_balanced {
    public int minimumDeletions(String s) {
        int b = 0, a =0;
        char[] cs = s.toCharArray();
        
        for(char c: cs) if(c == 'a') a++;
        int ret = a;
        for(char c: cs) {
        	
        	ret = Math.min(ret, a + b);
        	
        	if(c == 'a') a--;
        	else b++;
        }
        ret = Math.min(ret, b);
        return ret;
    }
}
