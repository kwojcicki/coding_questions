
package solutions;


class longest_substring_with_at_most_k_distinct_characters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int start = 0, end = 0, ret = 0;

        while(end < s.length()){
            if(count[s.charAt(end)]++ == 0) k--;
            while(k < 0){
                if(--count[s.charAt(start++)] == 0) k++;
            }
            ret = Math.max(ret, end - start + 1);
            end++;
        }

        return ret;
    }
}
