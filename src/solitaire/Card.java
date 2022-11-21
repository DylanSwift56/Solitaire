package solitaire;


import javax.swing.*;
import java.util.ArrayList;

public class Card {
    public int value;
    public int suit;
    private JToggleButton base;
    private ImageIcon cardImage;

   public ArrayList<ImageIcon> allImages = new ArrayList<ImageIcon>();


    public Card(int value, int suit, JToggleButton base, ImageIcon cardImage) {
        getValue();
        getSuit();
        getBase();
        getCardImage();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public JToggleButton getBase() {
        return base;
    }

    public void setBase(JToggleButton base) {
        this.base = base;
    }

    public ImageIcon getCardImage() {
        return cardImage;
    }

    public void setCardImage(ImageIcon cardImage) {
        this.cardImage = cardImage;
    }

    public static String specialCards(int value) {
        if (value == 1)
            return "A";
        else if (value == 11)
            return "J";
        else if(value == 12)
            return "Q";
        else if (value == 13)
            return "K";
        else
            return String.valueOf(value);
    }

    private void setImages(){

        allImages.add(new ImageIcon("aceOfHearts.png"));
        allImages.add(new ImageIcon("aceOfSpades.png"));
        allImages.add(new ImageIcon("aceOfDiamonds.png"));
        allImages.add(new ImageIcon("kingOfHearts.jpg"));
        allImages.add(new ImageIcon("twoOfClubs.jpg"));
        allImages.add(new ImageIcon("threeOfClubs.jpg"));
    }
}
