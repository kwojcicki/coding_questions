package solutions;

public class add_to_array_form_of_integer {
	public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ret =  new ArrayList<>();
        int carry = 0;

        for(int i = num.length - 1; i >= 0; i--){
            int t = carry + num[i] + k % 10;
            ret.add(t % 10);
            k /= 10;
            carry = t / 10;
        }

        while(k > 0 || carry > 0){
            int t = carry + k % 10;
            ret.add(t % 10);
            k /= 10;
            carry = t / 10;
        }

        Collections.reverse(ret);
        return ret;
    }
}
