package solutions;

class valid_word_abbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wIdx = 0; int aIdx = 0;

        while(wIdx < word.length() && aIdx < abbr.length()){
            if(Character.isLetter(abbr.charAt(aIdx))){
                if(word.charAt(wIdx) != abbr.charAt(aIdx)) return false;
                wIdx++; aIdx++;
            } else {
                int digits = 0;
                if(abbr.charAt(aIdx) == '0') return false;
                while(aIdx < abbr.length() && Character.isDigit(abbr.charAt(aIdx))){
                    digits = digits * 10 + (abbr.charAt(aIdx) - '0');
                    aIdx++;
                }

                wIdx += digits;
            }
        }

        return wIdx == word.length() && aIdx == abbr.length();
    }
}
