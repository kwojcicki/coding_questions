package solutions;

public class water_bottles_ii {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        if(numExchange > numBottles) return numBottles;
        int ret = 0;
        while(numBottles >= numExchange){
            ret += numExchange;
            numBottles = numBottles - numExchange + 1;
            numExchange++;
        }
        return ret + numBottles;
    }
}
