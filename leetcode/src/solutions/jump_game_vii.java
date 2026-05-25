package solutions;

class jump_game_vii {
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] chars = s.toCharArray();
        if(chars[chars.length - 1] == '1') return false;
        boolean[] dp = new boolean[chars.length];
        int count = 0;
        dp[0] = true;

        for(int i = 1; i < chars.length; i++){
            if(i >= minJump && dp[i - minJump]) count++;
            if(i > maxJump && dp[i - maxJump - 1]) count--;
            dp[i] = count > 0 && chars[i] == '0';
        }


        return dp[chars.length - 1];
    }
}
