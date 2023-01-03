package solutions;

public class delete_columns_to_make_sorted {
    public int minDeletionSize(String[] strs) {
        int ret = 0;
        
        for(int i = 0; i < strs[0].length(); i++) {
        	for(int j = 1; j < strs.length; j++) {
        		if(strs[j].charAt(i) < strs[j - 1].charAt(i)) {
        			ret++;
        			break;
        		}
        	}
        }
        
        return ret;
    }
}
