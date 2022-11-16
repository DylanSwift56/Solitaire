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


    public SolitaireGui(){



        setContentPane(mainPanel);
        setTitle("Solitaire");
        setSize(new Dimension(1050, 600));
        setLocationRelativeTo(null);//centers gui on the screen
        addWindowListener(new SolitaireGui.WindowEventHandler());
        JLabel card = new JLabel();
        card.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        //setResizable(false);



        cardStackPanel.setBackground(Color.BLUE);
        foundations.setBackground(Color.BLUE);
        //bottomPanel.setBackground(Color.BLUE);
        topPanel.setBackground(Color.BLUE);
        cardStack.add(card);




        foundation1.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundation2.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundation3.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundation4.setIcon(new ImageIcon("backOfCardSmall.jpg"));

        tableau1.setIcon(new ImageIcon("aceOfHearts.png"));
        tableau2.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        tableau3.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        tableau4.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        tableau5.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        tableau6.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        tableau7.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        cardStack.addActionListener(this::cardStackClk);
        tableau1.addActionListener(this::actionPerformed);

        //if(tableau1.isSelected()){
          //  temp.set(tableau1.getI);
        //}

        setVisible(true);

       // discardcards.add(new ImageIcon("backOfCardSmall.jpg"));
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

    public void moveCardToFoundation(ActionEvent e){
            //foundation1.setIcon(new ImageIcon(get));
            tableau1.setIcon(null);
    }



    public static void main(String[] args) {
        SolitaireGui gui = new SolitaireGui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton item = (JToggleButton) e.getSource();
        foundation1.setIcon(item.getIcon());
        tableau1.setIcon(null);
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

            if(choice==JOptionPane.YES_OPTION)
                dispose();
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
