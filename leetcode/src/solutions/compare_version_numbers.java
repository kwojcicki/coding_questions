package solutions;

public class compare_version_numbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
    	String[] v2 = version2.split("\\.");
    	
    	int index = 0;
        
    	while(index < v1.length || index < v2.length) {
            int left = 0;
            int right = 0;
    		if(index < v1.length) left = Integer.parseInt(v1[index]);
    		if(index < v2.length) right = Integer.parseInt(v2[index]);
    		
    		int compare = Integer.compare(left, right);
    		if(compare != 0) {
    			return compare;
    		}
            
            index++;
    	}
    	
    	return 0;
    }
}
