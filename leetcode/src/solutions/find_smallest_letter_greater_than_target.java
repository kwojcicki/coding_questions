package solutions;

import java.util.Arrays;

public class find_smallest_letter_greater_than_target {
    public char nextGreatestLetter(char[] letters, char target) {
        int ret = Arrays.binarySearch(letters, (char) (target + 1));
        
        if(ret >= 0) return letters[ret];
        if(-(ret + 1) >= letters.length) return letters[0];
        return letters[-(ret + 1)];
    }
}
