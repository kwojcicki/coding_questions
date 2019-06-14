package top_interview_medium.others;

public class minimum_add_to_make_parentheses_valid {
    public int minAddToMakeValid(String S) {
        int count = 0;
        
        int leftCount = 0;
        
        for(char c: S.toCharArray()) {
        	if(c == ')' && leftCount == 0) {
        		count++;
        	} else if(c == ')'){
        		leftCount--;
        	} else if(c == '(') {
        		leftCount++;
        	}
        }
        
        return count + leftCount;
    }
}
