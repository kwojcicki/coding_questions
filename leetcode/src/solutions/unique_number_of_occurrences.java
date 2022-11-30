package solutions;

public class unique_number_of_occurrences {
    public boolean uniqueOccurrences(int[] arr) {
    	int[] c = new int[2001];
        for(int i: arr) c[i + 1000]++;
        // System.out.println(Arrays.toString(c));
        for(int i: c) {
        	if(i == 0 || i == -10000) continue;
        	int v = Math.abs(i);
        	if(c[v] < 0) return false;
        	c[v] = c[v] == 0 ? -10000 : - c[v];
        }
        // System.out.println(Arrays.toString(c));
    	return true;
    }
}
