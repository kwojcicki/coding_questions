package solutions;

import java.util.regex.Pattern;

public class detect_capital {
    public boolean detectCapitalUse(String word) {
        return Pattern.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+", word);
    }
}
