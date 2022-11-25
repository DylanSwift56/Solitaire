package solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

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

    private JToggleButton discardPile;
    private JPanel stack1;
    private JPanel stack2;
    private JPanel stack3;
    private JPanel stack4;
    private JPanel stack5;
    private JPanel stack6;
    private JPanel stack7;

    private final ArrayList<JToggleButton> stack1CardImages = new ArrayList<>();
    private final ArrayList<JToggleButton> stack2CardImages = new ArrayList<>();
    private final ArrayList<JToggleButton> stack3CardImages = new ArrayList<>();
    private final ArrayList<JToggleButton> stack4CardImages = new ArrayList<>();
    private final ArrayList<JToggleButton> stack5CardImages = new ArrayList<>();
    private final ArrayList<JToggleButton> stack6CardImages = new ArrayList<>();
    private final ArrayList<JToggleButton> stack7CardImages = new ArrayList<>();

    private final ArrayList<Card> stack1Cards = new ArrayList<>();
    private final ArrayList<Card> stack2Cards = new ArrayList<>();
    private final ArrayList<Card> stack3Cards = new ArrayList<>();
    private final ArrayList<Card> stack4Cards = new ArrayList<>();
    private final ArrayList<Card> stack5Cards = new ArrayList<>();
    private final ArrayList<Card> stack6Cards = new ArrayList<>();
    private final ArrayList<Card> stack7Cards = new ArrayList<>();

    private int currentCard = 0;
    Point corner;

    Deck deck;

    ArrayList<JPanel> allStacks = new ArrayList<>();

    private int cardCount = 52;

    private int scoreCounter = 0;

    String name;

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
    //Called when a card from the card stack is clicked. A card is then revealed from the pile
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
    }

    public static void main(String[] args) {
        SolitaireGui gui = new SolitaireGui();
    }

    //populates the discard pile with cards from the deck
    public void populateDiscardPile(){
        int rand;

        for (int i = 0; i < cardCount ; i++) {
            rand = (int) (Math.random() * (cardCount));
            discardCards.add(deck.getCards().get(rand));
            deck.getCards().remove(deck.getCards().get(rand));
            cardCount--;
        }

    }


    public void populateTableau(Deck deck){
        int x = 0;
        int y = 0;
        int deckSize = 51;
        int counter = 1;

        for (JPanel stack: allStacks){
            for(int j = 0; j < counter; j++) {
                Card randomCard = deck.getCards().get((int) ((Math.random() * deckSize) + 1));
                JToggleButton image = new JToggleButton(randomCard.getCardImage());

                if (j == 0) {
                    addComponent(stack, image, x, y, 98, 150);
                    deckSize--;
                    cardCount--;
                    if (stack.equals(allStacks.get(0))) {
                        stack1Cards.add(randomCard);
                        stack1CardImages.add(randomCard.getBase());

                    } else if (stack.equals(allStacks.get(1))) {
                        stack2Cards.add(randomCard);
                        stack2CardImages.add(randomCard.getBase());
                    } else if (stack.equals(allStacks.get(2))) {
                        stack3Cards.add(randomCard);
                        stack3CardImages.add(randomCard.getBase());
                    } else if (stack.equals(allStacks.get(3))) {
                        stack4Cards.add(randomCard);
                        stack4CardImages.add(randomCard.getBase());
                    } else if (stack.equals(allStacks.get(4))) {
                        stack5Cards.add(randomCard);
                        stack5CardImages.add(randomCard.getBase());
                    } else if (stack.equals(allStacks.get(5))) {
                        stack6Cards.add(randomCard);
                        stack6CardImages.add(randomCard.getBase());
                    } else if (stack.equals(allStacks.get(6))) {

                        stack7Cards.add(randomCard);
                        stack7CardImages.add(randomCard.getBase());

                    }
                    deck.getCards().remove(randomCard);
                }
                else{
                    addComponent(stack, new JToggleButton(new ImageIcon("backOfCardSmall.jpg")), x, y, 97, 150);
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
                }
                if(counter > 1)
                    y -= 40;//Places next card up 40 and behind previous card
            }
            y = counter * 40;
            counter++;
        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton item = (JToggleButton) e.getSource();
        if (item.getIcon() != null) {
            if(item.equals(discardPile)){
                if(discardCards.get(currentCard - 1).getSuit().equals("H") && discardCards.get(currentCard - 1).getValue() == getFoundationHeartsValue + 1){
                    foundationHearts.setIcon(item.getIcon());
                    getFoundationHeartsValue++;
                    if(currentCard == 1){
                        currentCard = 0;
                        discardCards.remove(0);
                        item.setIcon(null);
                        scoreCounter++;
                        return;
                    }
                    currentCard--;
                    discardCards.remove(currentCard);
                    currentCard--;
                    item.setIcon(null);
                    repaint();
                    revalidate();
                    scoreCounter++;
                    return;
                }
                else if(discardCards.get(currentCard - 1).getSuit().equals("D") && discardCards.get(currentCard - 1).getValue() == getFoundationDiamondsValue + 1){
                    foundationDiamonds.setIcon(item.getIcon());
                    getFoundationDiamondsValue++;
                    if(currentCard == 1){
                        currentCard = 0;//set index to 0 to prevent it being -1
                        discardCards.remove(0);
                        item.setIcon(null);
                        scoreCounter++;
                        return;
                    }
                    currentCard--;
                    discardCards.remove(currentCard);
                    currentCard--;
                    item.setIcon(null);
                    repaint();
                    revalidate();
                    scoreCounter++;
                    return;
                }
                else if(discardCards.get(currentCard - 1).getSuit().equals("C") && discardCards.get(currentCard - 1).getValue() == getFoundationClubsValue + 1){
                    foundationClubs.setIcon(item.getIcon());
                    getFoundationClubsValue++;
                    if(currentCard == 1){
                        currentCard = 0;
                        discardCards.remove(0);
                        item.setIcon(null);
                        scoreCounter++;
                        return;
                    }
                    currentCard--;
                    discardCards.remove(currentCard);
                    currentCard--;
                    item.setIcon(null);
                    repaint();
                    revalidate();
                    scoreCounter++;
                    return;
                }
                else if(discardCards.get(currentCard - 1).getSuit().equals("S") && discardCards.get(currentCard - 1).getValue() == getFoundationSpadesValue + 1){
                    foundationSpades.setIcon(item.getIcon());
                    getFoundationSpadesValue++;
                    if(currentCard == 1){
                        currentCard = 0;
                        discardCards.remove(0);
                        item.setIcon(null);
                        scoreCounter++;
                        return;
                    }
                    currentCard--;
                    discardCards.remove(currentCard);
                    currentCard--;
                    item.setIcon(null);
                    repaint();
                    revalidate();
                    scoreCounter++;
                    return;
                }
            }

            if (item.getParent().equals(stack7)) {
                    if (stack7Cards.get(0).getSuit().equals("D") && stack7Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                        foundationDiamonds.setIcon(stack7CardImages.get(0).getIcon());
                        getFoundationDiamondsValue++;
                        stack7.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack7Cards.get(0).getSuit().equals("H") && stack7Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                        foundationHearts.setIcon(stack7CardImages.get(0).getIcon());
                        getFoundationHeartsValue++;
                        stack7.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack7Cards.get(0).getSuit().equals("S") && stack7Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                        foundationSpades.setIcon(stack7CardImages.get(0).getIcon());
                        getFoundationSpadesValue++;
                        stack7.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack7Cards.get(0).getSuit().equals("C") && stack7Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                        foundationClubs.setIcon(stack7CardImages.get(0).getIcon());
                        getFoundationClubsValue++;
                        stack7.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    }

            }


            if (item.getParent().equals(stack6)) {

                    if (stack6Cards.get(0).getSuit().equals("D") && stack6Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                        foundationDiamonds.setIcon(stack6CardImages.get(0).getIcon());
                        getFoundationDiamondsValue++;
                        stack6.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack6Cards.get(0).getSuit().equals("H") && stack6Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                        foundationHearts.setIcon(stack6CardImages.get(0).getIcon());
                        getFoundationHeartsValue++;
                        stack6.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack6Cards.get(0).getSuit().equals("S") && stack6Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                        foundationSpades.setIcon(stack6CardImages.get(0).getIcon());
                        getFoundationSpadesValue++;
                        stack6.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack6Cards.get(0).getSuit().equals("C") && stack6Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                        foundationClubs.setIcon(stack6CardImages.get(0).getIcon());
                        getFoundationClubsValue++;
                        stack6.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    }

            }


            if (item.getParent().equals(stack5)) {
                    if (stack5Cards.get(0).getSuit().equals("D") && stack5Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                        foundationDiamonds.setIcon(stack5CardImages.get(0).getIcon());
                        getFoundationDiamondsValue++;
                        stack5.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack5Cards.get(0).getSuit().equals("H") && stack5Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                        foundationHearts.setIcon(stack5CardImages.get(0).getIcon());
                        getFoundationHeartsValue++;
                        stack5.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack5Cards.get(0).getSuit().equals("S") && stack5Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                        foundationSpades.setIcon(stack5CardImages.get(0).getIcon());
                        getFoundationSpadesValue++;
                        stack5.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack5Cards.get(0).getSuit().equals("C") && stack5Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                        foundationClubs.setIcon(stack5CardImages.get(0).getIcon());
                        getFoundationClubsValue++;
                        stack5.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    }
            }

            if (item.getParent().equals(stack4)) {
                    if (stack4Cards.get(0).getSuit().equals("D") && stack4Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                        foundationDiamonds.setIcon(stack4CardImages.get(0).getIcon());
                        getFoundationDiamondsValue++;
                        stack4.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack4Cards.get(0).getSuit().equals("H") && stack4Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                        foundationHearts.setIcon(stack4CardImages.get(0).getIcon());
                        getFoundationHeartsValue++;
                        stack4.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack4Cards.get(0).getSuit().equals("S") && stack4Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                        foundationSpades.setIcon(stack4CardImages.get(0).getIcon());
                        getFoundationSpadesValue++;
                        stack4.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack4Cards.get(0).getSuit().equals("C") && stack4Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                        foundationClubs.setIcon(stack4CardImages.get(0).getIcon());
                        getFoundationClubsValue++;
                        stack4.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    }
            }

            if (item.getParent().equals(stack3)) {
                    if (stack3Cards.get(0).getSuit().equals("D") && stack3Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                        foundationDiamonds.setIcon(stack3CardImages.get(0).getIcon());
                        getFoundationDiamondsValue++;
                        stack3.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack3Cards.get(0).getSuit().equals("H") && stack3Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                        foundationHearts.setIcon(stack3CardImages.get(0).getIcon());
                        getFoundationHeartsValue++;
                        stack3.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack3Cards.get(0).getSuit().equals("S") && stack3Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                        foundationSpades.setIcon(stack3CardImages.get(0).getIcon());
                        getFoundationSpadesValue++;
                        stack3.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack3Cards.get(0).getSuit().equals("C") && stack3Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                        foundationClubs.setIcon(stack3CardImages.get(0).getIcon());
                        getFoundationClubsValue++;
                        stack3.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    }
            }

            if (item.getParent().equals(stack2)) {
                    if (stack2Cards.get(0).getSuit().equals("D") && stack2Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                        foundationDiamonds.setIcon(stack2CardImages.get(0).getIcon());
                        getFoundationDiamondsValue++;
                        stack2.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack2Cards.get(0).getSuit().equals("H") && stack2Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                        foundationHearts.setIcon(stack2CardImages.get(0).getIcon());
                        getFoundationHeartsValue++;
                        stack2.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack2Cards.get(0).getSuit().equals("S") && stack2Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                        foundationSpades.setIcon(stack2CardImages.get(0).getIcon());
                        getFoundationSpadesValue++;
                        stack2.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    } else if (stack2Cards.get(0).getSuit().equals("C") && stack2Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                        foundationClubs.setIcon(stack2CardImages.get(0).getIcon());
                        getFoundationClubsValue++;
                        stack2.remove(0);
                        repaint();
                        revalidate();
                        scoreCounter++;
                        return;
                    }
            }

            if (item.getParent().equals(stack1)) {

                if (stack1Cards.get(0).getSuit().equals("D") && stack1Cards.get(0).getValue() == getFoundationDiamondsValue + 1) {
                    foundationDiamonds.setIcon(item.getIcon());
                    getFoundationDiamondsValue++;
                    stack1.remove(item);
                    repaint();
                    revalidate();
                    scoreCounter++;
                    return;
                } else if (stack1Cards.get(0).getSuit().equals("H") && stack1Cards.get(0).getValue() == getFoundationHeartsValue + 1) {
                    foundationHearts.setIcon(item.getIcon());
                    getFoundationHeartsValue++;
                    stack1.remove(item);
                    repaint();
                    revalidate();
                    scoreCounter++;
                    return;
                } else if (stack1Cards.get(0).getSuit().equals("S") && stack1Cards.get(0).getValue() == getFoundationSpadesValue + 1) {
                    foundationSpades.setIcon(item.getIcon());
                    getFoundationSpadesValue++;
                    stack1.remove(item);
                    repaint();
                    revalidate();
                    scoreCounter++;
                    return;
                } else if (stack1Cards.get(0).getSuit().equals("C") && stack1Cards.get(0).getValue() == getFoundationClubsValue + 1) {
                    foundationClubs.setIcon(item.getIcon());
                    getFoundationClubsValue++;
                    stack1.remove(item);
                    repaint();
                    revalidate();
                    scoreCounter++;
                    return;

                }


            }
        }


    }

    //This method would've flipped a reversed card and assigned it a random card from the remaining cards in the deck
    /*public void checkReversed(JToggleButton card){
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

    }*/






    private class WindowEventHandler implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Welcome to Solitaire!", "Welcome!", JOptionPane.INFORMATION_MESSAGE);
            name = JOptionPane.showInputDialog("Please enter your name:");
        }

        @Override
        public void windowClosing(WindowEvent e) {


            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exiting....",
                    JOptionPane.YES_NO_CANCEL_OPTION);

            if(choice==JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Thanks for Playing!", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
                saveScore();//Saves data to file
                dispose();
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
    //https://stackoverflow.com/questions/15125388/java-stacking-components
        c.setBounds(x, y, width, height);
        container.add(c);
        c.addActionListener(this::actionPerformed);
    }


    private void saveScore(){
        try {
            File score = new File("nameAndScore.txt");

            FileWriter writer = new FileWriter(score);

            writer.write("Name: " + name + " Score: " + scoreCounter);
            writer.close();

        }catch (IOException exception){
            JOptionPane.showMessageDialog(null, "Invalid path to file", "Invalid", JOptionPane.ERROR_MESSAGE);
        }
    }
}
