
public class minimum_length_of_string_after_deleting_similar_ends {
    public int minimumLength(String s) {
    	int start = 0, end = s.length() - 1;
        char[] c = s.toCharArray();
        
        while(start < end) {
        	if(c[start] == c[end]) {
        		char t = c[start];
        		while(start < end && c[start] == t) start++;
        		while(end > 0 && c[end] == t) end--;
        	} else {
        		break;
        	}
        }
        if(end < start) return 0;
        return end - start + 1;
    }
}
