package solutions;

public class check_if_one_string_swap_can_make_strings_equal {

    public boolean areAlmostEqual(String s1, String s2) {
        char diff = '-';
        char tmp = '-';
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(int i = 0; i < c1.length; i++){
            if(c1[i] == c2[i]) continue;

            if(diff == '-') {
                diff = c1[i];
                tmp = c2[i];
            }
            else if(c2[i] == diff && c1[i] == tmp) diff = '+';
            else return false;
        }

        return diff == '-' || diff == '+';
    }
}
