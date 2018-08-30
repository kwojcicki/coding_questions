package solutions.mathematics.lowest_triangle;

import java.util.Scanner;

public class Solution {

    static int lowestTriangle(int base, int area){
        return (int)Math.ceil(area * 2.00 / base);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int base = in.nextInt();
        int area = in.nextInt();
        int height = lowestTriangle(base, area);
        System.out.println(height);
    }
}