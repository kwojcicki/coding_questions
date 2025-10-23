package solutions;

public class check_if_digits_are_equal_in_string_after_operations_i {
    public boolean hasSameDigits(String s) {
        char[] chars = s.toCharArray();

        for(int i = chars.length; i > 2; i--){
            for(int j = 0; j < i - 1; j++){
                chars[j] = (char)((((int)(chars[j] - '0') + (int)(chars[j + 1] - '0')) % 10) + '0');
            }
            // System.out.println(Arrays.toString(chars));
        }

        return chars[0] == chars[1];
    }
}
