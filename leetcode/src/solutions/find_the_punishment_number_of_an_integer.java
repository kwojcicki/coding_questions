package solutions;

public class find_the_punishment_number_of_an_integer {
    public int punishmentNumber(int n) {
        int ret = 0;

        for(int i = 1; i <= n; i++){
            // System.out.println(i);
            if(partitioned(i * i, 0, 0, i)){
                // System.out.println(i + " is partitioned");
                ret += i * i;
            }
        }

        return ret;
    }

    public boolean partitioned(int sum, int curr, int len, int target){
        // System.out.println(sum + " " + curr + " " + len + " " + target);
        if(sum == 0) return target - curr == 0;

        return partitioned(sum / 10, curr + (int)Math.pow(10, len) * (sum % 10), len + 1, target) ||
            partitioned(sum / 10, sum % 10, 1, target - curr);
    }
}
