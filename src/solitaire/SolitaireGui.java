package solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SolitaireGui extends JFrame implements ActionListener{
    private JPanel mainPanel;
    private JToggleButton cardStack;
    private JPanel cardStackPanel;
    private JPanel tableau;
    private JPanel foundations;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JToggleButton foundation1;
    private JToggleButton foundation2;
    private JToggleButton foundation3;
    private JToggleButton foundation4;
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

    ArrayList<ImageIcon> cards = new ArrayList<ImageIcon>();

    ArrayList<JToggleButton> allTableau = new ArrayList<JToggleButton>();

    private int cardCount = 52;

    private int tableauCounter = 0;


    public SolitaireGui(){

        setContentPane(mainPanel);
        setTitle("Solitaire");
        setSize(new Dimension(1050, 600));
        setLocationRelativeTo(null);//centers gui on the screen
        addWindowListener(new SolitaireGui.WindowEventHandler());
        JLabel card = new JLabel();
        card.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        cardStack.add(card);

        foundation1.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundation2.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundation3.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundation4.setIcon(new ImageIcon("backOfCardSmall.jpg"));

        tableau1.setIcon(new ImageIcon("aceOfHearts.png"));
        tableau2.setIcon(new ImageIcon("aceOfDiamonds.png"));
        tableau3.setIcon(new ImageIcon("aceOfSpades.png"));
        tableau4.setIcon(new ImageIcon("aceOfHearts.png"));
        tableau5.setIcon(new ImageIcon("aceOfDiamonds.png"));
        tableau6.setIcon(new ImageIcon("aceOfSpades.png"));
        tableau7.setIcon(new ImageIcon("aceOfHearts.png"));

        allTableau.add(tableau1);
        allTableau.add(tableau2);
        allTableau.add(tableau3);
        allTableau.add(tableau4);
        allTableau.add(tableau5);
        allTableau.add(tableau6);
        allTableau.add(tableau7);

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

        addComponent(tableau, tableau1, 0, 80, 98,150);
        addComponent(tableau,addJToggleButton(new ImageIcon("aceOfDiamonds.png")), 0,40, 98, 150);
        addComponent(tableau,addJToggleButton(new ImageIcon("backOfCardSmall.jpg")), 0,0, 98, 150);

        addComponent(tableau, addJToggleButton(new ImageIcon("kingOfHearts.jpg")), 140, 80, 98,150);
        addComponent(tableau,addJToggleButton(new ImageIcon("aceOfDiamonds.png")), 140,40, 98, 150);
        addComponent(tableau,addJToggleButton(new ImageIcon("backOfCardSmall.jpg")), 140,0, 98, 150);

        addComponent(tableau, addJToggleButton(new ImageIcon("kingOfHearts.jpg")), 280, 80, 98,150);
        addComponent(tableau,addJToggleButton(new ImageIcon("aceOfDiamonds.png")), 280,40, 98, 150);
        addComponent(tableau,addJToggleButton(new ImageIcon("backOfCardSmall.jpg")), 280,0, 98, 150);

        addComponent(tableau, addJToggleButton(new ImageIcon("kingOfHearts.jpg")), 420, 80, 98,150);
        addComponent(tableau,addJToggleButton(new ImageIcon("aceOfDiamonds.png")), 420,40, 98, 150);
        addComponent(tableau,addJToggleButton(new ImageIcon("backOfCardSmall.jpg")), 420,0, 98, 150);

        addComponent(tableau, addJToggleButton(new ImageIcon("kingOfHearts.jpg")), 560, 80, 98,150);
        addComponent(tableau,addJToggleButton(new ImageIcon("aceOfDiamonds.png")), 560,40, 98, 150);
        addComponent(tableau,addJToggleButton(new ImageIcon("backOfCardSmall.jpg")), 560,0, 98, 150);

        addComponent(tableau, addJToggleButton(new ImageIcon("kingOfHearts.jpg")), 700, 80, 98,150);
        addComponent(tableau,addJToggleButton(new ImageIcon("aceOfDiamonds.png")), 700,40, 98, 150);
        addComponent(tableau,addJToggleButton(new ImageIcon("backOfCardSmall.jpg")), 700,0, 98, 150);

        addComponent(tableau, addJToggleButton(new ImageIcon("kingOfHearts.jpg")), 840, 80, 98,150);
        addComponent(tableau,addJToggleButton(new ImageIcon("aceOfDiamonds.png")), 840,40, 98, 150);
        addComponent(tableau,addJToggleButton(new ImageIcon("backOfCardSmall.jpg")), 840,0, 98, 150);


        setVisible(true);

        cards.add(new ImageIcon("aceOfHearts.png"));
        cards.add(new ImageIcon("aceOfSpades.png"));
        cards.add(new ImageIcon("aceOfDiamonds.png"));
        cards.add(new ImageIcon("kingOfHearts.jpg"));
        cards.add(new ImageIcon("twoOfClubs.jpg"));
        cards.add(new ImageIcon("threeOfClubs.jpg"));

    }

    public void cardStackClk(ActionEvent e){
        discardPile.removeAll();

        if(currentCard < cards.size()) {
            discardPile.setIcon(cards.get(currentCard));
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton item = (JToggleButton) e.getSource();
        if(item.getIcon() != null)
            foundation1.setIcon(item.getIcon());
        if(item.equals(discardPile)){
            if(currentCard > 1) {
                currentCard--;//Reset the discard pile to previous card as current card was incremented already
                cards.remove(currentCard);
                currentCard--;//goes back to card previous to card removed
                discardPile.setIcon(cards.get(currentCard));
                return;
            }
            else {
                cards.remove(0);//if current card is 0 simply remove it
                currentCard = 0;

            }
            }
        //removes icon from button it was attached to
        item.setIcon(null);
        if(item.getParent().equals(tableau)){
            //Removes any trace of card left, so you are able to click anywhere on the card behind
            tableau.remove(item);
            tableau.repaint();
            tableau.revalidate();
        }



        validate();

        //fix this counter needs to only increment by 1
        for(JToggleButton toggleButton: allTableau){
            if(toggleButton.getIcon() == null)
                tableauCounter++;
        }

        if(tableauCounter == 28) {
            JOptionPane.showMessageDialog(null, "Congratulations you have won the game!!!", "Congratulations!!", 1);
            dispose();
        }
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
        Component tempC = c;
    //https://stackoverflow.com/questions/15125388/java-stacking-components
        tempC.setBounds(x, y, width, height);
        container.add(tempC);
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
