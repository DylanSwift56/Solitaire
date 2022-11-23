package solitaire;

import javax.swing.*;
import java.util.ArrayList;

public class Card {
    public String value;
    public String suit;
    private JToggleButton base;
    private ImageIcon cardImage;
    private String cardName;

   public ArrayList<ImageIcon> allImages = new ArrayList<ImageIcon>();


    public Card(String cardName, String value, String suit) {
        setValue(value);
        setSuit(suit);
        setCardName(cardName);

        String image = getCardName() + ".jpg";
        setCardImage(new ImageIcon(image));
        base = new JToggleButton(getCardImage());
        setBase(base);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
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
        this.base.setBorderPainted(false);
        this.base.setContentAreaFilled(false);
    }

    public ImageIcon getCardImage() {
        return cardImage;
    }

    public void setCardImage(ImageIcon cardImage) {
        this.cardImage = cardImage;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
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

    public static void main(String[] args) {


    }
}
