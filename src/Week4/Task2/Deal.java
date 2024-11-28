package Week4.Task2;

import java.util.*;

public class Deal {
    public static void main(String[] args) {
        List<String> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }

        Collections.shuffle(deck);

        System.out.println("Dealt cards:");
        for (int i = 0; i < 5; i++) {
            System.out.println(deck.get(i));
        }
    }
}
