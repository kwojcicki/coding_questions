package solutions;

public class water_bottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        if(numExchange > numBottles) return numBottles;
        int ret = 0;
        int remainder = 0;
        while(numBottles + remainder >= numExchange){
            // System.out.println(numBottles + " " + remainder);
            ret += numBottles;
            numBottles += remainder;
            remainder = numBottles % numExchange;
            numBottles /= numExchange;
        }
        // System.out.println(numBottles + " " + remainder);
        return ret + numBottles;
    }
}
