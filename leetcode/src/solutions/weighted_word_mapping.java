package solutions;

class weighted_word_mapping {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ret = new StringBuilder();
        for(String word: words){
            int val = 0;
            for(char c: word.toCharArray()){
                val += weights[c - 'a'];
            }
            ret.append((char)('z' - (val + 26) % 26));
        }

        return ret.toString();
    }
}
