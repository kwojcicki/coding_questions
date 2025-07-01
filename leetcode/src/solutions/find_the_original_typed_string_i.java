package solutions;

public class find_the_original_typed_string_i {
    public int possibleStringCount(String word) {
        int ret = 1;
        char[] cs = word.toCharArray();
        
        for(int i = 1; i < cs.length; i++) {
        	if(cs[i] == cs[i - 1]) ret++;
        }
        
        return ret;
    }
}
