package solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class SolitaireGui extends JFrame implements ActionListener{
    private JPanel mainPanel;
    private JToggleButton cardStack;
    private JPanel cardStackPanel;
    private JPanel tableau;
    private JPanel foundations;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JToggleButton foundationHearts;
    private JToggleButton foundationClubs;
    private JToggleButton foundationSpades;
    private JToggleButton foundationDiamonds;
    private int getFoundationHeartsValue = 0;
    private int getFoundationClubsValue = 0;
    private int getFoundationSpadesValue = 0;
    private int getFoundationDiamondsValue = 0;
    //private Graphics icon = new ImageIcon()

    private JToggleButton discardPile;
    private JPanel stack1;
    private JPanel stack2;
    private JPanel stack3;
    private JPanel stack4;
    private JPanel stack5;
    private JPanel stack6;
    private JPanel stack7;

    private ArrayList<JToggleButton> stack1CardImages = new ArrayList<>();
    private ArrayList<JToggleButton> stack2CardImages = new ArrayList<>();
    private ArrayList<JToggleButton> stack3CardImages = new ArrayList<>();
    private ArrayList<JToggleButton> stack4CardImages = new ArrayList<>();
    private ArrayList<JToggleButton> stack5CardImages = new ArrayList<>();
    private ArrayList<JToggleButton> stack6CardImages = new ArrayList<>();
    private ArrayList<JToggleButton> stack7CardImages = new ArrayList<>();

    private ArrayList<Card> stack1Cards = new ArrayList<>();
    private ArrayList<Card> stack2Cards = new ArrayList<>();
    private ArrayList<Card> stack3Cards = new ArrayList<>();
    private ArrayList<Card> stack4Cards = new ArrayList<>();
    private ArrayList<Card> stack5Cards = new ArrayList<>();
    private ArrayList<Card> stack6Cards = new ArrayList<>();
    private ArrayList<Card> stack7Cards = new ArrayList<>();

    public JToggleButton newButton;
    int nextDiscardCard = 1;
    private int currentCard = 0;
    ImageIcon temp;
    Point corner, previousPoint;

    ArrayList<Card> cards;

    Deck deck;

    Iterator<Card> iterator;


    ArrayList<JPanel> allStacks = new ArrayList<JPanel>();

    private int cardCount = 52;

    private int scoreCounter = 0;

    String name;

    private int randomCard = (int) (Math.random() * (cardCount - 1)) + 1;

    ArrayList<Card> discardCards = new ArrayList<>(25);


    public SolitaireGui(){

        deck = new Deck();



        setContentPane(mainPanel);
        setTitle("Solitaire");
        setSize(new Dimension(1050, 600));
        setLocationRelativeTo(null);//centers gui on the screen
        addWindowListener(new SolitaireGui.WindowEventHandler());
        JLabel card = new JLabel();
        card.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        cardStack.add(card);

        corner = new Point(0,0);

        foundationHearts.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundationClubs.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundationSpades.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundationDiamonds.setIcon(new ImageIcon("backOfCardSmall.jpg"));


        allStacks.add(stack1);
        allStacks.add(stack2);
        allStacks.add(stack3);
        allStacks.add(stack4);
        allStacks.add(stack5);
        allStacks.add(stack6);
        allStacks.add(stack7);

        populateTableau(deck);

        populateDiscardPile();

        cardStack.addActionListener(this::cardStackClk);
        discardPile.addActionListener(this::actionPerformed);


        stack1.setLayout(null);
        stack2.setLayout(null);
        stack3.setLayout(null);
        stack4.setLayout(null);
        stack5.setLayout(null);
        stack6.setLayout(null);
        stack7.setLayout(null);

        setVisible(true);

    }

    public void cardStackClk(ActionEvent e){
        discardPile.removeAll();

        if(currentCard < discardCards.size()) {
            discardPile.setIcon(discardCards.get(currentCard).getCardImage());
            currentCard++;
        }
        else{
            discardPile.setIcon(null);
            currentCard = 0;
        }

        //JOptionPane.showMessageDialog(null, iterator.next().getCardImage());
        
        

        //else{
          //  discardPile.setIcon(null);
            //currentCard = 0;
        //}
    }

    public static void main(String[] args) {
        SolitaireGui gui = new SolitaireGui();
    }

    public void populateDiscardPile(){
       // int cards = cardCount - 1;
        int rand;

        for (int i = 0; i < 24 ; i++) {
            rand = (int) (Math.random() * (cardCount));
            discardCards.add(deck.getCards().get(rand));
            deck.getCards().remove(deck.getCards().get(rand));
            cardCount--;
        }


        //JOptionPane.showMessageDialog(null, rand);

        //for(Card card: deck.getCards())
            //JOptionPane.showMessageDialog(null, card.getBase());
        //JOptionPane.showMessageDialog(null, cardCount);
    }


    public void populateTableau(Deck deck){
        int x = stack1.getWidth() / 2;
        int y = 0;
        int deckSize = 51;
        int counter = 1;

        Deck dummyDeck = deck;

        for (JPanel stack: allStacks){
            for(int j = 0; j < counter; j++) {
                int rand = (int) ((Math.random() * deckSize) + 1);
                Card randomCard = deck.getCards().get((int) ((Math.random() * deckSize) + 1));
                JToggleButton image = new JToggleButton(randomCard.getCardImage());

                    addComponent(stack, image, x, y, 98, 150);

                    deckSize--;
                    cardCount--;

                    if(stack.equals(allStacks.get(0))){
                        stack1Cards.add(randomCard);
                        stack1CardImages.add(randomCard.getBase());

                    }
                    else if(stack.equals(allStacks.get(1))){
                        stack2Cards.add(randomCard);
                        stack2CardImages.add(randomCard.getBase());
                    }
                    else if(stack.equals(allStacks.get(2))){
                        stack3Cards.add(randomCard);
                        stack3CardImages.add(randomCard.getBase());
                    }
                    else if(stack.equals(allStacks.get(3))){
                        stack4Cards.add(randomCard);
                        stack4CardImages.add(randomCard.getBase());
                    }
                    else if(stack.equals(allStacks.get(4))){
                        stack5Cards.add(randomCard);
                        stack5CardImages.add(randomCard.getBase());
                    }
                    else if(stack.equals(allStacks.get(5))){
                        stack6Cards.add(randomCard);
                        stack6CardImages.add(randomCard.getBase());
                    }
                    else if(stack.equals(allStacks.get(6))){

                        stack7Cards.add(randomCard);
                        stack7CardImages.add(randomCard.getBase());

                    }
                    deck.getCards().remove(randomCard);

                /*else{
                    addComponent(stack, new JToggleButton(new ImageIcon("backOfCardSmall.jpg")), x, y, 97, 150);
                    deckSize--;
                    if(stack.equals(allStacks.get(0))){
                        stack1Cards.add(new Card());
                        stack1CardImages.add(new JToggleButton(new ImageIcon("backOfCardSmall.jpg")));
                    }
                    else if(stack.equals(allStacks.get(1))){
                        stack2Cards.add(new Card());
                        stack2CardImages.add(new JToggleButton(new ImageIcon("backOfCardSmall.jpg")));
                    }
                    else if(stack.equals(allStacks.get(2))){
                        stack3Cards.add(new Card());
                        stack3CardImages.add(new JToggleButton(new ImageIcon("backOfCardSmall.jpg")));
                    }
                    else if(stack.equals(allStacks.get(3))){
                        stack4Cards.add(new Card());
                        stack4CardImages.add(new JToggleButton(new ImageIcon("backOfCardSmall.jpg")));
                    }
                    else if(stack.equals(allStacks.get(4))){
                        stack5Cards.add(new Card());
                        stack5CardImages.add(new JToggleButton(new ImageIcon("backOfCardSmall.jpg")));
                    }
                    else if(stack.equals(allStacks.get(5))){
                        stack6Cards.add(new Card());
                        stack6CardImages.add(new JToggleButton(new ImageIcon("backOfCardSmall.jpg")));
                    }
                    else if(stack.equals(allStacks.get(6))){
                        stack7CardImages.add(new JToggleButton(new ImageIcon("backOfCardSmall.jpg")));
                        stack7Cards.add(new Card());

                    }
                }*/
                if(counter > 1)
                    y -= 40;
            }
            y = counter * 40;
            counter++;
        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton item = (JToggleButton) e.getSource();
       /* if(item.equals(discardPile)) {
            if (currentCard > 1) {
                currentCard--;//Reset the discard pile to previous card as current card was incremented already
                discardCards.remove(currentCard);
                currentCard--;//goes back to card previous to card removed
                //discardPile.setIcon(cards.get(currentCard));
                item.setIcon(nu;
                //return;ll)
            } else {
                discardCards.remove(0);//if current card is 0 simply remove it
                currentCard = 0;
            }
        }*/


        //removes icon from button it was attached to
        int cardIndex;
        if (!item.getParent().equals(null) && item.getIcon() != null) {

            if(item.equals(discardPile)){
                if(discardCards.get(currentCard - 1).getSuit() == "H" && discardCards.get(currentCard - 1).getValue() == getFoundationHeartsValue + 1){
                    foundationHearts.setIcon(item.getIcon());
                    getFoundationHeartsValue++;
                    if(currentCard == 1){
                        currentCard = 0;
                        discardCards.remove(0);
                        item.setIcon(null);
                        return;
                    }
                    currentCard--;
                    discardCards.remove(currentCard);
                    currentCard--;
                    item.setIcon(null);
                    repaint();
                    revalidate();
                    return;
                }
                else if(discardCards.get(currentCard - 1).getSuit() == "D" && discardCards.get(currentCard - 1).getValue() == getFoundationDiamondsValue + 1){
                    foundationDiamonds.setIcon(item.getIcon());
                    getFoundationDiamondsValue++;
                    if(currentCard == 1){
                        currentCard = 0;
                        discardCards.remove(0);
                        item.setIcon(null);
                        return;
                    }
                    currentCard--;
                    discardCards.remove(currentCard);
                    currentCard--;
                    item.setIcon(null);
                    repaint();
                    revalidate();
                    return;
                }
                else if(discardCards.get(currentCard - 1).getSuit() == "C" && discardCards.get(currentCard - 1).getValue() == getFoundationClubsValue + 1){
                    foundationClubs.setIcon(item.getIcon());
                    getFoundationClubsValue++;
                    if(currentCard == 1){
                        currentCard = 0;
                        discardCards.remove(0);
                        item.setIcon(null);
                        return;
                    }
                    currentCard--;
                    discardCards.remove(currentCard);
                    currentCard--;
                    item.setIcon(null);
                    repaint();
                    revalidate();
                    return;
                }
                else if(discardCards.get(currentCard - 1).getSuit() == "S" && discardCards.get(currentCard - 1).getValue() == getFoundationSpadesValue + 1){
                    foundationSpades.setIcon(item.getIcon());
                    getFoundationSpadesValue++;
                    if(currentCard == 1){
                        currentCard = 0;
                        discardCards.remove(0);
                        item.setIcon(null);
                        return;
                    }
                    currentCard--;
                    discardCards.remove(currentCard);
                    currentCard--;
                    item.setIcon(null);
                    repaint();
                    revalidate();
                    return;
                }
            }

            if (item.getParent().equals(stack7)) {
                    if (stack7Cards.get(0).getSuit() == "D" && stack7Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                        foundationDiamonds.setIcon(stack7CardImages.get(0).getIcon());
                        getFoundationDiamondsValue++;
                        stack7.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack7Cards.get(0).getSuit() == "H" && stack7Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                        foundationHearts.setIcon(stack7CardImages.get(0).getIcon());
                        getFoundationHeartsValue++;
                        stack7.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack7Cards.get(0).getSuit() == "S" && stack7Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                        foundationSpades.setIcon(stack7CardImages.get(0).getIcon());
                        getFoundationSpadesValue++;
                        stack7.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack7Cards.get(0).getSuit() == "C" && stack7Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                        foundationClubs.setIcon(stack7CardImages.get(0).getIcon());
                        getFoundationClubsValue++;
                        stack7.remove(0);
                        repaint();
                        revalidate();
                        return;
                    }

            }


            if (item.getParent().equals(stack6)) {

                    if (stack6Cards.get(0).getSuit() == "D" && stack6Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                        foundationDiamonds.setIcon(stack6CardImages.get(0).getIcon());
                        getFoundationDiamondsValue++;
                        stack6.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack6Cards.get(0).getSuit() == "H" && stack6Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                        foundationHearts.setIcon(stack6CardImages.get(0).getIcon());
                        getFoundationHeartsValue++;
                        stack6.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack6Cards.get(0).getSuit() == "S" && stack6Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                        foundationSpades.setIcon(stack6CardImages.get(0).getIcon());
                        getFoundationSpadesValue++;
                        stack6.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack6Cards.get(0).getSuit() == "C" && stack6Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                        foundationClubs.setIcon(stack6CardImages.get(0).getIcon());
                        getFoundationClubsValue++;
                        stack6.remove(0);
                        repaint();
                        revalidate();
                        return;
                    }

            }


            if (item.getParent().equals(stack5)) {
                    if (stack5Cards.get(0).getSuit() == "D" && stack5Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                        foundationDiamonds.setIcon(stack5CardImages.get(0).getIcon());
                        getFoundationDiamondsValue++;
                        stack5.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack5Cards.get(0).getSuit() == "H" && stack5Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                        foundationHearts.setIcon(stack5CardImages.get(0).getIcon());
                        getFoundationHeartsValue++;
                        stack5.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack5Cards.get(0).getSuit() == "S" && stack5Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                        foundationSpades.setIcon(stack5CardImages.get(0).getIcon());
                        getFoundationSpadesValue++;
                        stack5.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack5Cards.get(0).getSuit() == "C" && stack5Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                        foundationClubs.setIcon(stack5CardImages.get(0).getIcon());
                        getFoundationClubsValue++;
                        stack5.remove(0);
                        repaint();
                        revalidate();
                        return;
                    }
            }

            if (item.getParent().equals(stack4)) {
                    if (stack4Cards.get(0).getSuit() == "D" && stack4Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                        foundationDiamonds.setIcon(stack4CardImages.get(0).getIcon());
                        getFoundationDiamondsValue++;
                        stack4.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack4Cards.get(0).getSuit() == "H" && stack4Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                        foundationHearts.setIcon(stack4CardImages.get(0).getIcon());
                        getFoundationHeartsValue++;
                        stack4.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack4Cards.get(0).getSuit() == "S" && stack4Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                        foundationSpades.setIcon(stack4CardImages.get(0).getIcon());
                        getFoundationSpadesValue++;
                        stack4.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack4Cards.get(0).getSuit() == "C" && stack4Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                        foundationClubs.setIcon(stack4CardImages.get(0).getIcon());
                        getFoundationClubsValue++;
                        stack4.remove(0);
                        repaint();
                        revalidate();
                        return;
                    }
            }

            if (item.getParent().equals(stack3)) {
                    if (stack3Cards.get(0).getSuit() == "D" && stack3Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                        foundationDiamonds.setIcon(stack3CardImages.get(0).getIcon());
                        getFoundationDiamondsValue++;
                        stack3.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack3Cards.get(0).getSuit() == "H" && stack3Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                        foundationHearts.setIcon(stack3CardImages.get(0).getIcon());
                        getFoundationHeartsValue++;
                        stack3.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack3Cards.get(0).getSuit() == "S" && stack3Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                        foundationSpades.setIcon(stack3CardImages.get(0).getIcon());
                        getFoundationSpadesValue++;
                        stack3.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack3Cards.get(0).getSuit() == "C" && stack3Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                        foundationClubs.setIcon(stack3CardImages.get(0).getIcon());
                        getFoundationClubsValue++;
                        stack3.remove(0);
                        repaint();
                        revalidate();
                        return;
                    }
            }

            if (item.getParent().equals(stack2)) {
                    if (stack2Cards.get(0).getSuit() == "D" && stack2Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                        foundationDiamonds.setIcon(stack2CardImages.get(0).getIcon());
                        getFoundationDiamondsValue++;
                        stack2.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack2Cards.get(0).getSuit() == "H" && stack2Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                        foundationHearts.setIcon(stack2CardImages.get(0).getIcon());
                        getFoundationHeartsValue++;
                        stack2.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack2Cards.get(0).getSuit() == "S" && stack2Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                        foundationSpades.setIcon(stack2CardImages.get(0).getIcon());
                        getFoundationSpadesValue++;
                        stack2.remove(0);
                        repaint();
                        revalidate();
                        return;
                    } else if (stack2Cards.get(0).getSuit() == "C" && stack2Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                        foundationClubs.setIcon(stack2CardImages.get(0).getIcon());
                        getFoundationClubsValue++;
                        stack2.remove(0);
                        repaint();
                        revalidate();
                        return;
                    }
            }

            if (item.getParent().equals(stack1)) {

                if (stack1Cards.get(0).getSuit() == "D" && stack1Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                    foundationDiamonds.setIcon(item.getIcon());
                    getFoundationDiamondsValue++;
                    stack1.remove(item);
                    repaint();
                    revalidate();
                    return;
                } else if (stack1Cards.get(0).getSuit() == "H" && stack1Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                    foundationHearts.setIcon(item.getIcon());
                    getFoundationHeartsValue++;
                    stack1.remove(item);
                    repaint();
                    revalidate();
                    return;
                } else if (stack1Cards.get(0).getSuit() == "S" && stack1Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                    foundationSpades.setIcon(item.getIcon());
                    getFoundationSpadesValue++;
                    stack1.remove(item);
                    repaint();
                    revalidate();
                    return;
                } else if (stack1Cards.get(0).getSuit() == "C" && stack1Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                    foundationClubs.setIcon(item.getIcon());
                    getFoundationClubsValue++;
                    stack1.remove(item);
                    repaint();
                    revalidate();
                    return;

                }


            }
        }


    }

    public void checkReversed(JToggleButton card){
        Icon image = card.getIcon();
        Card randomCard = deck.getCards().get((int) ((Math.random() * cardCount)));
        if(image != null)
           if(image.getIconWidth() == 100){//width of reversed card is 100
               card.setIcon(randomCard.getCardImage());
               deck.getCards().remove(randomCard);
               repaint();
               revalidate();
               if(card.getParent().equals(stack2)){
                   stack2Cards.add(stack2Cards.indexOf(card), randomCard);
                   //stack2CardImages.
                   stack2CardImages.add(1, randomCard.getBase());
                   JOptionPane.showMessageDialog(null, stack2CardImages.get(0));
                   JOptionPane.showMessageDialog(null, stack2CardImages.get(1));
               }
               if(card.getParent().equals(stack3)){
                   //stack3Cards.add(randomCard);
                   //stack3CardImages.add(randomCard.getBase());
                   stack3Cards.trimToSize();
                            JOptionPane.showMessageDialog(null, stack3CardImages.indexOf(card.getIcon()));
               }
               if(card.getParent().equals(stack4)){
                   stack4Cards.add(randomCard);
                   stack4CardImages.add(randomCard.getBase());
               }
               if(card.getParent().equals(stack5)){
                   stack5Cards.add(randomCard);
                   stack5CardImages.add(randomCard.getBase());
               }
               if(card.getParent().equals(stack6)){
                   stack6Cards.add(randomCard);
                   stack6CardImages.add(randomCard.getBase());
               }
               if(card.getParent().equals(stack7)){
                   stack7Cards.add(randomCard);
                   stack7CardImages.add(randomCard.getBase());
               }
               cardCount--;
           }

    }






    private class WindowEventHandler implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Welcome to Solitaire!", "Welcome!", 1);
            name = JOptionPane.showInputDialog("Please enter your name:");
        }

        @Override
        public void windowClosing(WindowEvent e) {


            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exiting....",
                    JOptionPane.YES_NO_CANCEL_OPTION);

            if(choice==JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Thanks for Playing!", "Goodbye", 1);
                dispose();
            }
            else{

            }
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

    private void addComponent(Container container, JToggleButton c, int x, int y,int width, int height) {
        JToggleButton tempC = c;
    //https://stackoverflow.com/questions/15125388/java-stacking-components
        tempC.setBounds(x, y, width, height);
        container.add(tempC);
        c.addActionListener(this::actionPerformed);
    }

    private void addComponent(Container container, Component c, int x, int y) {
    //https://stackoverflow.com/questions/15125388/java-stacking-components
        c.setBounds(x, y, c.getWidth(), c.getHeight());
        container.add(c);
    }

    private JToggleButton addJToggleButton(ImageIcon icon) {
        //https://stackoverflow.com/questions/15125388/java-stacking-components
        JToggleButton button = new JToggleButton(icon);
        button.addActionListener(this::actionPerformed);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }
}
