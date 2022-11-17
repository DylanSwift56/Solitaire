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
    int nextDiscardCard = 0;
    ImageIcon temp;

    ArrayList<ImageIcon> discardcards = new ArrayList<ImageIcon>();

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

        setVisible(true);

        discardcards.add(new ImageIcon("aceOfHearts.png"));
        discardcards.add(new ImageIcon("aceOfSpades.png"));
        discardcards.add(new ImageIcon("aceOfDiamonds.png"));

    }

    public void cardStackClk(ActionEvent e){
        discardPile.removeAll();

        if((nextDiscardCard + 1) <= discardcards.size()) {
            discardPile.setIcon(discardcards.get(nextDiscardCard));
            nextDiscardCard++;
            validate();
        }
        else{
            discardPile.setIcon(null);
            nextDiscardCard = 0;
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
            discardcards.remove(nextDiscardCard - 1);
        }

        item.setIcon(null);

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


            /*int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exiting....",
                    JOptionPane.YES_NO_CANCEL_OPTION);

            if(choice==JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Thanks for Playing!", "Goodbye", 1);
                dispose();
            }
            else{

            }*/
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
}
