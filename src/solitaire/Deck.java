package solitaire;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Deck{
    ArrayList<Card> cards;
    ArrayList<String> suits = new ArrayList<>(Arrays.asList("hearts", "diamonds", "spades", "clubs"));

    public Deck() {


    }

    public static void main(String[] args) {
        Card twoOfHearts = new Card(2, "Hearts");
        JOptionPane.showMessageDialog(null, twoOfHearts.toString());
    }
}
