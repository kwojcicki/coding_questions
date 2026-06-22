package solutions;

class rearrange_characters_to_make_target_string {
    public int rearrangeCharacters(String s, String target) {
        int[] cnt = new int[26];
        int[] tarCnt = new int[26];
        for(char c: s.toCharArray()) cnt[c - 'a']++;
        for(char c: target.toCharArray()) tarCnt[c - 'a']++;

        int ret = 999999999;
        for(int i = 0; i < 26; i++) if (tarCnt[i] != 0) ret = Math.min(ret, cnt[i] / tarCnt[i]);
        return ret;
    }
}
