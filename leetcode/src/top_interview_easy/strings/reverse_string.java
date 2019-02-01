package top_interview_easy.strings;

public class reverse_string {
    public void reverseString(char[] s) {
        if(s == null || s.length == 0) {
        	return;
        }
        
        int start = 0;
        int end = s.length - 1;
        while(start < end) {
        	char temp = s[start];
        	s[start] = s[end];
        	s[end] = temp;
        	start++;
        	end--;
        }
    }
}
