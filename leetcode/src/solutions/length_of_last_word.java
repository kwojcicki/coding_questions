package solutions;

public class length_of_last_word {
    public int lengthOfLastWord(String s) {
    	if(s == null || s.length() == 0) return 0;
        return s.length() - 1 - (s.lastIndexOf(' ') > -1 ? s.lastIndexOf(' ') : 0 ); 
    }
}
