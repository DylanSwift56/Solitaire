package solitaire;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Deck {
    ArrayList<Card> cards;
    Card card = new Card();
    ArrayList<String> suits = new ArrayList<>(Arrays.asList("hearts", "diamonds", "spades", "clubs"));
    public ArrayList<ImageIcon> allImages = new ArrayList<ImageIcon>();

    public Deck() {

        allImages.add(new ImageIcon("twoOfClubs.jpg"));
        allImages.add(new ImageIcon("threeOfClubs.jpg"));
        allImages.add(new ImageIcon("fourOfClubs.jpg"));
        allImages.add(new ImageIcon("fiveOfClubs.jpg"));
        allImages.add(new ImageIcon("sixOfClubs.jpg"));
        allImages.add(new ImageIcon("sevenOfClubs.jpg"));
        allImages.add(new ImageIcon("eightOfClubs.jpg"));
        allImages.add(new ImageIcon("nineOfClubs.jpg"));
        allImages.add(new ImageIcon("tenOfClubs.jpg"));
        allImages.add(new ImageIcon("jackOfClubs.jpg"));
        allImages.add(new ImageIcon("QueenOfClubs.jpg"));
        allImages.add(new ImageIcon("kingOfClubs.jpg"));

        deckInitialise();

        setCardImages();
    }


    public void deckInitialise() {
        for (int i = 0; i < 52; i++) {
            cards.add(new Card());
        }
    }

    public void setCardImages() {

        for (Card card : cards) {

        }

    }
}
