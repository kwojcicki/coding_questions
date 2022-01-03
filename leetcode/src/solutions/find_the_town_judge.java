package solutions;

public class find_the_town_judge {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n];
        
        if(trust.length < n - 1) return -1;
        
        for(int[] t: trust){
            trusts[t[0] - 1]--;
            trusts[t[1] - 1]++;
        }
        
        for(int i = 0; i < n; i++) {
        	if(trusts[i] == n - 1) {
        		return i + 1;
        	}
        }
        
        return -1;
    }
}
