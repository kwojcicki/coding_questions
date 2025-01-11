package solutions;

public class construct_k_palindrome_strings {
    public boolean canConstruct(String s, int k) {
        int size = s.length();
        if(k > size) return false;
        if(k == size) return true;

        int[] count = new int[26];
        for(char c: s.toCharArray()) count[c - 'a']++;

        int pairs = 0;
        int middles = 0;
        for(int i: count){
            if(i == 0) continue;
            pairs += i / 2;
            middles += i % 2;
        }

        if(middles > k) return false;
        return true;
    }
}
