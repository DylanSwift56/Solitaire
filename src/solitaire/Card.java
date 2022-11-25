package solitaire;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Card implements Serializable {
    public int value;
    public String suit;
    private JToggleButton base;
    private ImageIcon cardImage;
    private String cardName;
    private boolean isReversed;

    public Card() {
    }

    public Card(String cardName, int value, String suit, boolean isReversed) {
        setValue(value);
        setSuit(suit);
        setCardName(cardName);
        setReversed(isReversed);

        String image = getCardName() + ".jpg";
        setCardImage(new ImageIcon(image));
        base = new JToggleButton(getCardImage());
        setBase(base);
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
        this.base.setBorderPainted(false);
        this.base.setContentAreaFilled(false);
    }

    public boolean isReversed() {
        return isReversed;
    }

    public void setReversed(boolean reversed) {
        isReversed = reversed;
        if (reversed == true) {
            this.cardImage = new ImageIcon("backOfCardSmall.jpg");
            setBase(new JToggleButton(getCardImage()));
        }
    }

    public ImageIcon getCardImage() {
        return cardImage;
    }

    public void setCardImage(ImageIcon cardImage) {
        if(!isReversed())
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


    public static void main(String[] args) {


    }

}
