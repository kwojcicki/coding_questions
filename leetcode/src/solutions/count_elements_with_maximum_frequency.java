package solutions;

public class count_elements_with_maximum_frequency {
    public int maxFrequencyElements(int[] nums) {
        int[] cnt = new int[101];
        for(int i: nums) cnt[i]++;
        int max = 0;
        for(int i = 0; i < cnt.length; i++) if(cnt[i] > cnt[max]) max = i;
        int ret = 0;
        for(int i: cnt) if(i == cnt[max]) ret += cnt[max];
        return ret;
    }
}
