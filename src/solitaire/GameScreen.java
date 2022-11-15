package solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameScreen extends JFrame{
    public GameScreen(){

        super("Solitaire");

        JPanel mainPanel = new JPanel(new BorderLayout(2,2));
        setBackground(Color.DARK_GRAY);

       // mainPanel.setSize(100, 100);
        setSize(800, 600);
        JButton b1 = new JButton();
        b1.setPreferredSize(new Dimension(50,100));
        b1.setText("Card Stack");

        JButton b2 = new JButton();
        b2.setPreferredSize(new Dimension(50,100));
        b2.setText("Card Stack");

        JPanel cardStack = new JPanel(new BorderLayout(2,2));
        cardStack.setPreferredSize(new Dimension(800, 100));
        cardStack.setBackground(Color.BLACK);

       // mainPanel.paint(Graphics(d));

        cardStack.add(b1, BorderLayout.WEST);
        cardStack.add(b2, BorderLayout.EAST);

        mainPanel.add(cardStack, BorderLayout.NORTH);

        BorderLayout layout = new BorderLayout(2, 2);
        setLayout(layout);

        mainPanel.setBackground(Color.green);

        add(mainPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//from https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        ;
        setVisible(true);
    }

    public static void main(String[] args) {
        SolitaireGui screen = new SolitaireGui();
    }

    /*private class WindowEventHandler implements WindowListener{

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
    }*/
}
