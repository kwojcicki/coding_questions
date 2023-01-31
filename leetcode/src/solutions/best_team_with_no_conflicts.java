package solutions;

import java.util.Arrays;
import java.util.Comparator;

public class best_team_with_no_conflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
    	int[][] people = new int[scores.length][2];
        for(int i = 0; i < scores.length; i++) people[i] = new int[] { scores[i], ages[i] };
        Arrays.sort(people, Comparator.<int[]>comparingInt(a -> a[1])
        		.thenComparing(a -> a[0]));
        int[] dp = new int[people.length];
        dp[0] = people[0][0];
        for(int i = 1; i < people.length; i++){
            dp[i] = people[i][0];
            for(int j = 0; j < i; j++){
                if(people[i][0] >= people[j][0] || people[i][1] == people[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + people[i][0]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
