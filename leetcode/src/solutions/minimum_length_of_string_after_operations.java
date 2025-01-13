package solutions;

public class minimum_length_of_string_after_operations {
    public int minimumLength(String s) {
        int[] count = new int[26];
        for(char c: s.toCharArray()){
            count[c - 'a']++;
        }

        int ret = 0;
        for(int i: count){
            if(i <= 2) ret += i;
            else if(i % 2 == 1) ret += 1;
            else if(i % 2 == 0) ret += 2;
            // System.out.println(i + " " + ret);
        }

        return ret;
    }
}
