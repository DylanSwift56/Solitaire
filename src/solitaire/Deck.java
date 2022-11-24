package solitaire;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Deck{
    ArrayList<Card> cards;
    final ArrayList<String> SUITS = new ArrayList<>(Arrays.asList("H", "D", "S", "C"));
    final ArrayList<Integer> VALUES = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13));

    public Deck() {
        cards = new ArrayList<>();
        for(int i = 0; i < SUITS.size(); i++){
            for(int j = 0; j < VALUES.size(); j++) {
                Card newCard = new Card(VALUES.get(j) + SUITS.get(i), VALUES.get(j), SUITS.get(i), false);//Creates all cards by combining value and suit to match jpg name
                cards.add(newCard);//adds cards to arrayList
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public String getSuits(int index) {
        return SUITS.get(index);
    }

    public ArrayList<Integer> getValues() {
        return VALUES;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        for (Card card: deck.cards) {
            JOptionPane.showMessageDialog(null, card.getBase());
        }
    }
}
