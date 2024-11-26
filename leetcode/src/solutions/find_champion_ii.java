package solutions;

public class find_champion_ii {
    public int findChampion(int n, int[][] edges) {
        int[] count = new int[n];
        for(int[] i: edges){
            count[i[1]]++;
        }

        int ret = -1;

        for(int i = 0; i < count.length; i++){
            if(count[i] == 0){
                if(ret != -1) return -1;
                ret = i;
            }
        }

        return ret;
    }
}
