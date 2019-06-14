package top_interview_medium.others;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class reveal_cards_in_increasing_order {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        
        int[] toReturn = new int[deck.length];
        
        Queue<Integer> q = new LinkedList<Integer>();
        IntStream.range(0, deck.length).forEach(i -> q.add(i));
        
        for(int i = 0; i < deck.length; i++) {
        	toReturn[q.poll()] = deck[i];
        	q.add(q.poll());
        }
        
        
        return toReturn;
    }
}
