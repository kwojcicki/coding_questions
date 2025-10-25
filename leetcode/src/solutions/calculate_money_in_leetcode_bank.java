package solutions;

public class calculate_money_in_leetcode_bank {
    public int totalMoney(int n) {
        int ret = 0;
        int weeks = n / 7;
        for(int i = 0; i < 7; i ++){
            // System.out.println((weeks + i + (n % 7 > i ? 0 : 1)) + " " + i);
            ret += sum(weeks + i + (n % 7 > i ? 1 : 0)) - sum(i);
        }
        return ret;
    }

    private int sum(int n){ return n * (n + 1) / 2; }
}

/**
1 2 3 4 5 6 7
2 3 4 5 6 7 8
3 4 5 6 7 8 9
4 5 6 7 8 9
 */
