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
    private int foundationHeartsValue = 1;
    private int getFoundationClubsValue = 1;
    private int getFoundationSpadesValue = 1;
    private int getFoundationDiamondsValue = 1;
    //private Graphics icon = new ImageIcon()

    private JToggleButton discardPile;
    private JPanel stack1;
    private JPanel stack2;
    private JPanel stack3;
    private JPanel stack4;
    private JPanel stack5;
    private JPanel stack6;
    private JPanel stack7;

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

    private int tableauCounter = 0;

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



        cardStack.addActionListener(this::cardStackClk);
        discardPile.addActionListener(this::actionPerformed);

        populateTableau(deck);

        populateDiscardPile();
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

        for(Card card: deck.getCards())
            JOptionPane.showMessageDialog(null, card.getBase());
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
                Card randomCard = deck.getCards().get(rand);
                if(j == 0) {
                    addComponent(stack, randomCard.getBase(), x, y, 98, 150);
                    deck.getCards().remove(randomCard);
                    deckSize--;
                    cardCount--;
                }
                else{
                    addComponent(stack, new JToggleButton(new ImageIcon("backOfCardSmall.jpg")), x, y, 97, 150);
                }
                if(stack.equals(allStacks.get(0))){
                    stack1Cards.add(randomCard);
                }
                else if(stack.equals(allStacks.get(1))){
                    stack2Cards.add(randomCard);
                }
                else if(stack.equals(allStacks.get(2))){
                    stack3Cards.add(randomCard);
                }
                else if(stack.equals(allStacks.get(3))){
                    stack4Cards.add(randomCard);
                }
                else if(stack.equals(allStacks.get(4))){
                    stack5Cards.add(randomCard);
                }
                else if(stack.equals(allStacks.get(5))){
                    stack6Cards.add(randomCard);
                }
                else{
                    stack6Cards.add(randomCard);
                }

                //JOptionPane.showMessageDialog(null, deck.getCards().size());
                //JOptionPane.showMessageDialog(null, deckSize);
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
        if(item.getIcon() != null)
            foundationHearts.setIcon(item.getIcon());
        if(item.equals(discardPile)) {
            if (currentCard > 1) {
                currentCard--;//Reset the discard pile to previous card as current card was incremented already
                discardCards.remove(currentCard);
                currentCard--;//goes back to card previous to card removed
                //discardPile.setIcon(cards.get(currentCard));
                item.setIcon(null);
                return;
            } else {
                discardCards.remove(0);//if current card is 0 simply remove it
                currentCard = 0;
            }
        }
        //removes icon from button it was attached to

        if(item.getParent().equals(stack7)) {
            //item.setIcon(new ImageIcon("2H.jpg"));
            cardClicked(item);
            repaint();
            revalidate();
        }
        //JOptionPane.showMessageDialog(null, item.getIcon().getIconWidth());
            //JOptionPane.showMessageDialog(null, item.getIcon().getIconWidth());


            //item.setReve

            /*if(e.getSource().getClass().){
                card1.setReversed(false);
                repaint();
                JOptionPane.showMessageDialog(null, card1.getBase().getIcon());
                return;
            */

        //if(item.getIcon().equals(discardPile.getIcon()))



            //Removes any trace of card left, so you are able to click anywhere on the card behind
            //tableau.remove(item);
            tableau.repaint();
            tableau.revalidate();




        validate();

    }

    public void cardClicked(JToggleButton card){
        JOptionPane.showMessageDialog(null, card.getName());
        Icon image = card.getIcon();
        ImageIcon backImage = (ImageIcon) discardPile.getIcon();
        //if(card.getWidth() == 97){//width of reversed card is set to 97 instead of 98
           if(image.getIconWidth() == 100){
               card.setIcon(new ImageIcon("2H.jpg"));
               repaint();
               revalidate();
           }
               // image.equals(new ImageIcon("twoOfHearts.jpg"));
        //JOptionPane.showMessageDialog(null, image.getIconWidth());
        //
            // JOptionPane.showMessageDialog(null, image.getIconWidth());

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
