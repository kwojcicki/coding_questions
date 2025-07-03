package solutions;

public class find_the_k_th_character_in_string_game_i {
    public char kthCharacter(int k) {
        StringBuilder ret = new StringBuilder("a");

        while(ret.length() <= k - 1) {
        	for(int i = ret.length(); i > 0; i--) {
        		char nextChar = (char) (ret.charAt(ret.length() - i) + 1);
        		if(nextChar > 'z') nextChar = 'a';
        		ret.append(nextChar);
        	}
            // System.out.println(ret.toString());
        }
        
        return ret.charAt(k - 1);
    }
}
