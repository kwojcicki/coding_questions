package solutions;

public class number_of_senior_citizens {
    public int countSeniors(String[] details) {
        int ret = 0;
        for(String s: details) {
        	int age = (s.charAt(11) - '0') * 10 + (s.charAt(12) - '0');
        	if(age > 60) ret++;
        }
        return ret;
    }
}
