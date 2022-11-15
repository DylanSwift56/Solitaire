package solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SolitaireGui extends JFrame{
    private JPanel panel1;
    private JPanel cardStack;
    private JPanel tableau;
    private JPanel foundations;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel foundation1;
    private JLabel foundation2;
    private JLabel foundation3;
    private JLabel foundation4;

    public SolitaireGui(){
        setContentPane(panel1);
        setTitle("Solitaire");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);//centers gui on the screen
        addWindowListener(new SolitaireGui.WindowEventHandler());
        JLabel card = new JLabel();
        card.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        cardStack.add(card);

        foundation1.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundation2.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundation3.setIcon(new ImageIcon("backOfCardSmall.jpg"));
        foundation4.setIcon(new ImageIcon("backOfCardSmall.jpg"));

        //foundation1.add(card);

        setVisible(true);


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
