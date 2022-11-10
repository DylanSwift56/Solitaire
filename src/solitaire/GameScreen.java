package solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameScreen extends JPanel{
    public GameScreen(){
        super("Solitaire");
        setSize(800, 600);

        FlowLayout layout = new FlowLayout();
        setLayout(layout);

        JButton b1 = new JButton();
        b1.setPreferredSize(new Dimension(110,110));
        b1.setText("Button");
        add(b1);
        JButton b2 = new JButton();
        b2.setPreferredSize(new Dimension(110,110));
        b2.setText("Button");
        add(b2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//from https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        addWindowListener(new WindowEventHandler());
        setVisible(true);
    }

    public static void main(String[] args) {
        GameScreen screen = new GameScreen();
    }

    private class WindowEventHandler implements WindowListener{

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
