package gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class manage the GUI for the gameplay in {@code BlackJack}.
 * 
 * @author LeCuay
 * @version 0.1 Early
 * @see JFrame
 * @see JLabel
 * @see Dimension
 */
public class MainFrame extends JFrame {

    /**
     * This variables manages the version. <br>
     * And that's it.
     */
    private final double version = 0.1;

    private JLabel labelBet = new JLabel();

    /**
     * Empty constructor that creates and shows a panel.
     * @see JFrame
     */
    public MainFrame(){
        try{
            createFrame();
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
        }catch(Exception e){
            e.getStackTrace();
        }
    }

    /**
     * This method creates a main frame and shows the bet.
     */
    private void createFrame(){
        this.setTitle("BlackJack Game - Version "+version);
        this.setSize(new Dimension(720, 480));
        labelBet.setBounds(new Rectangle(50, 50, 100, 200));
        labelBet.setText("Apuesta total: ");
        this.getContentPane().add(labelBet);
    }

    /**
     * Simple method to shows the Frame once the Object is created.
     */
    public void showFrame(){
        this.setVisible(true);
    }
    
}