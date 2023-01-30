package solutions;

public class n_th_tribonacci_number {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int n1 = 0, n2 = 1, n3 = 1;
        for(int i = 0; i <= n - 3; i++){
            int t = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = t;
        }
        return n3;
    }
}
