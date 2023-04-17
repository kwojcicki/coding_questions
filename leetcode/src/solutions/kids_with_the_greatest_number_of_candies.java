package solutions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class kids_with_the_greatest_number_of_candies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(i -> (i + extraCandies) >= max).collect(Collectors.toList());
    }
}
