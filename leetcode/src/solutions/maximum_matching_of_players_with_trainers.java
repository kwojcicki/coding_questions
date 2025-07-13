package solutions;

import java.util.Arrays;

public class maximum_matching_of_players_with_trainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int ret = 0;
        
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int p = 0, t = 0;
        
        while(p < players.length && t < trainers.length) {
        	if(players[p] <= trainers[t]) {
        		ret++;
        		p++;
        		t++;
        	} else {
        		t++;
        	}
        }
        
        return ret;
    }
}
