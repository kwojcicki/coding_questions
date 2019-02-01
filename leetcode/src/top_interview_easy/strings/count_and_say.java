package top_interview_easy.strings;

public class count_and_say {
    public String countAndSay(int n) {
    	String s = "1";
    	n--;
    	while(n > 0) {
    		
    		char number = s.charAt(0);
    		int count = 1;
    		
    		String temp = "";
    		
    		for(int i = 1; i < s.length(); i++) {
    			if(s.charAt(i) == number) {
    				count++;
    			} else {
    				temp += count + "" + number;
    				number = s.charAt(i);
    				count = 1;
    			}
    		}
    		
    		temp += count + "" + number;
    		s = temp;
    		n--;
    		System.out.println(s);
    	}
    	
    	return s;
    }
    
    public static void main(String[] args) {
    	System.out.println(new count_and_say().countAndSay(4));
    }
}
