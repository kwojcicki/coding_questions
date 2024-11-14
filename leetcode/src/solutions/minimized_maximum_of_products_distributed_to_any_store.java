package solutions;

public class minimized_maximum_of_products_distributed_to_any_store {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 100_000;
        int ret = right;

        while(left <= right){
            int mid = (left + right) / 2;
            // System.out.println(left + " " + mid + " " + right + " " + test(n, quantities, mid));
            if(test(n, quantities, mid)){
                ret = Math.min(ret, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ret;
    }

    public boolean test(int n, int[] quantities, int amount){
        for(int q: quantities){
            n -= (int) Math.ceil((double) q / amount);
        }

        // System.out.println(amount + " " + n);
        return n >= 0;
    }
}
