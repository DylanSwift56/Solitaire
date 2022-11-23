package solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
    private JToggleButton discardPile;
    private JToggleButton tableau1;
    private JToggleButton tableau2;
    private JToggleButton tableau3;
    private JToggleButton tableau4;
    private JToggleButton tableau5;
    private JToggleButton tableau6;
    private JToggleButton tableau7;
    public JToggleButton newButton;
    int nextDiscardCard = 1;
    private int currentCard = 0;
    ImageIcon temp;
    Point corner, previousPoint;

    ArrayList<Card> cards;

    Deck deck;

    Iterator<Card> iterator;


    ArrayList<JToggleButton> allTableau = new ArrayList<JToggleButton>();

    private int cardCount = 52;

    private int tableauCounter = 0;


    public SolitaireGui(){

        deck = new Deck();

        iterator = deck.getCards().iterator();

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


        allTableau.add(tableau1);
        allTableau.add(tableau2);
        allTableau.add(tableau3);
        allTableau.add(tableau4);
        allTableau.add(tableau5);
        allTableau.add(tableau6);
        allTableau.add(tableau7);

        populateTableau(deck, iterator);

        cardStack.addActionListener(this::cardStackClk);
        tableau1.addActionListener(this::actionPerformed);
        discardPile.addActionListener(this::actionPerformed);
        tableau2.addActionListener(this::actionPerformed);
        tableau3.addActionListener(this::actionPerformed);
        tableau4.addActionListener(this::actionPerformed);
        tableau5.addActionListener((this::actionPerformed));
        tableau6.addActionListener(this::actionPerformed);
        tableau7.addActionListener(this::actionPerformed);



        tableau.remove(tableau1);
        tableau.remove(tableau2);
        tableau.remove(tableau3);

        tableau.setLayout(null);




        setVisible(true);

    }

    public void cardStackClk(ActionEvent e){
        discardPile.removeAll();

        if(currentCard < deck.getCards().size()) {
            discardPile.setIcon(deck.getCards().get(currentCard).getCardImage());
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

    public void populateTableau(Deck deck, Iterator<Card> iterator){
        int x = 0;
        int y = 0;
        int deckSize = 51;

        Deck dummyDeck = deck;

        for (int i = 1; i < 8; i++) {
            for(int j = 0; j < i; j++) {
                int rand = (int) ((Math.random() * deckSize) + 1);
                Card randomCard = deck.getCards().get(rand);
                if(j == 0) {
                    addComponent(tableau, randomCard.getBase(), x, y, 98, 150);
                }
                else{
                    randomCard.setReversed(true);
                    addComponent(tableau, randomCard.getBase(), x, y, 98, 150);
                }
                deck.getCards().remove(randomCard);
                if(i > 1)
                    y -= 40;
                deckSize--;
            }
            y = i * 40;
            x += 140;
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton item = (JToggleButton) e.getSource();
        if(item.getIcon() != null)
            foundationHearts.setIcon(item.getIcon());
        if(item.equals(discardPile)){
            if(currentCard > 1) {
                currentCard--;//Reset the discard pile to previous card as current card was incremented already
                deck.getCards().remove(currentCard);
                currentCard--;//goes back to card previous to card removed
                //discardPile.setIcon(cards.get(currentCard));
                return;
            }
            else {
                deck.getCards().remove(0);//if current card is 0 simply remove it
                currentCard = 0;

            }
            }
        //removes icon from button it was attached to
        item.setIcon(null);
        if(item.getParent().equals(tableau)){
            JOptionPane.showMessageDialog(null, "aaa");

            //item.setReversed(true);
            for(Card card: deck.getCards()){
                //if(item.getIcon().equals(card.)){


                //}
            }

            /*if(e.getSource().getClass().){
                card1.setReversed(false);
                repaint();
                JOptionPane.showMessageDialog(null, card1.getBase().getIcon());
                return;
            */}

        //if(item.getIcon().equals(discardPile.getIcon()))



            //Removes any trace of card left, so you are able to click anywhere on the card behind
            tableau.remove(item);
            tableau.repaint();
            tableau.revalidate();




        validate();

        //fix this counter needs to only increment by 1
        /*for(JToggleButton toggleButton: allTableau){
            if(toggleButton.getIcon() == null)
                tableauCounter++;
        }

        if(tableauCounter == 28) {
            JOptionPane.showMessageDialog(null, "Congratulations you have won the game!!!", "Congratulations!!", 1);
            dispose();
        }*/
        validate();
    }






    private class WindowEventHandler implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Welcome to Solitaire!", "Welcome!", 1);
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

    private void addComponent(Container container, Component c, int x, int y,int width, int height) {
        JToggleButton tempC = (JToggleButton) c;
    //https://stackoverflow.com/questions/15125388/java-stacking-components
        tempC.setBounds(x, y, width, height);
        container.add(tempC);
        tempC.addActionListener(this::actionPerformed);
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
