package solutions;

public class alice_and_bob_playing_flower_game {
    public long flowerGame(int n, int m) {
        // n odd, m even
        long one = (long)(n / 2 + n % 2) * (m / 2);
        // n even, m odd
        long two = (long)(n  / 2) * (m / 2 + m % 2);
        // System.out.println(one + " " + two);
        return one + two;
    }
}
