
package solutions;

class count_binary_substrings {
    public int countBinarySubstrings(String s) {
        int ret = 0;
        int ones = 0; int zeroes = 0;
        char prev = s.charAt(0) == '0' ? '1' : '0';

        for(char c: s.toCharArray()){
            if(c == '1'){
                if(prev != c) ones = 0;
                ones++;
                if(zeroes >= ones) ret++;
            } else {
                if(prev != c) zeroes = 0;
                zeroes++;
                if(ones >= zeroes) ret++;
            }
            prev = c;
            // System.out.println(ones + " "+ zeroes + " " + ret + " " + c);
        }

        return ret;
    }
}
