package solutions;

public class vowels_game_in_a_string {
    public boolean doesAliceWin(String s) {
        for(char c: s.toCharArray()){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        }

        return false;
    }
}
