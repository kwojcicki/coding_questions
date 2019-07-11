package solutions;

public class student_attendance_record_i {
    public boolean checkRecord(String s) {
        
    	if(s.indexOf('A') != s.lastIndexOf('A')) {
    		return false;
    	}
    	
    	for(int i = 0; i < s.length() - 2; i++) {
    		if(s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2) && s.charAt(i) == 'L') {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
