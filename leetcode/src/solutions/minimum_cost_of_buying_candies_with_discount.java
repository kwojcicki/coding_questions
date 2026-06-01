package solutions;

class minimum_cost_of_buying_candies_with_discount {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ret = 0;

        for(int i = cost.length - 1; i >= 0; i = i - 3){
            ret += cost[i];
            if(i - 1 >= 0) ret += cost[i - 1];
        }

        return ret;
    }
}
