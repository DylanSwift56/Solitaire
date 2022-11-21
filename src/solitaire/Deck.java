package solitaire;

import java.util.ArrayList;
import java.util.Arrays;

public class Deck extends Card{
    ArrayList<Card> cards;
    ArrayList<String> suits = new ArrayList<>(Arrays.asList("hearts", "diamonds", "spades", "clubs"));

    public Deck() {
        super();

        cards = new ArrayList<>();
    }
}
