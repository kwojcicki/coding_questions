package solutions;

public class find_closest_person {
    public int findClosest(int x, int y, int z) {
        int d1 = (int)Math.abs(x - z);
        int d2 = (int) Math.abs(y - z);
        if(d1 == d2) return 0;

        return d1 > d2 ? 2 : 1;
    }
}
