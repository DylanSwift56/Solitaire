package solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SolitaireGui extends JFrame{
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

    public SolitaireGui(){
        setContentPane(mainPanel);
        setTitle("Solitaire");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(900, 600));
        setLocationRelativeTo(null);//centers gui on the screen
        addWindowListener(new SolitaireGui.WindowEventHandler());
        JLabel card = new JLabel();
        card.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        setResizable(false);

        cardStackPanel.setBackground(Color.BLUE);
        foundations.setBackground(Color.BLUE);
        bottomPanel.setBackground(Color.BLUE);
        cardStack.add(card);


        foundation1.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundation2.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundation3.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundation4.setIcon(new ImageIcon("backOfCardSmall.jpg"));

        cardStack.addActionListener(this::cardStackClk);
        //foundation2.addActionListener(this::a);

        //foundation1.add(card);

        setVisible(true);



    }

    public void cardStackClk(ActionEvent e){
        discardPile.removeAll();
        discardPile.setIcon(new ImageIcon("aceOfHearts.png"));
        validate();
    }

    public void a(ActionEvent e){
        if(e.getSource().toString().equals("foundation1"))
            JOptionPane.showMessageDialog(null, "", "!!!", 1);

    }



    public static void main(String[] args) {
        SolitaireGui gui = new SolitaireGui();
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
