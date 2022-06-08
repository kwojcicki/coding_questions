package solutions;

public class remove_palindromic_subsequences {
    public int removePalindromeSub(String s) {
        return s.equals(new StringBuilder(s).reverse().toString()) ? 1 : 2;
    }
}
