package solitaire;


import javax.swing.*;
import java.util.ArrayList;

public class Card {
    public int value;
    public String suit;
    private JToggleButton base;
    private ImageIcon cardImage;

   public ArrayList<ImageIcon> allImages = new ArrayList<ImageIcon>();


    public Card(int value, String  suit) {
        getValue();
        getSuit();

        String image = this.toString() + ".jpg";
        base = new JToggleButton(new ImageIcon(image));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public JToggleButton getBase() {
        return base;
    }

    public void setBase(JToggleButton base) {
        this.base = base;
    }

    public ImageIcon getCardImage() {
        return (ImageIcon) base.getIcon();

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
        allImages.add(new ImageIcon("aceOfClubs.jpg"));

        allImages.add(new ImageIcon("kingOfHearts.jpg"));
        allImages.add(new ImageIcon("twoOfClubs.jpg"));
        allImages.add(new ImageIcon("threeOfClubs.jpg"));


    }
}
