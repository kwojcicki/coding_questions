package solutions;

import java.util.Arrays;

public class maximum_ice_cream_bars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0;
        while(i < costs.length && coins - costs[i] >= 0){
            coins -= costs[i];
            i++;
        }

        return i;
    }
}
