package application;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainGameplayScreen extends JFrame implements ActionListener {

    private JPanel panel = new JPanel();
    private JLabel bgPhoto = new JLabel(new ImageIcon("files/gameplaybg.png"));

    /**
     * This constructor runs everything required in the TitleScreen. This method
     * runs the frameSetup and assembleWindow methods. This method also catches
     * exceptions thrown by these other helper methods.
     */
    public MainGameplayScreen() {
        try {
            frameSetup();
            assembleWindow();
        } catch (IOException e) {
            System.out.println("Error: IOException, error code 10.1");
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println("Error: Unknown exception, error code 10.2");
            e.printStackTrace();
        }
    }

    /**
     * This helper method sets up the basics of the JFrame that this class extends.
     * Sets the size of the window, makes it unresizable, and sets titles as well as
     * layout/decorations.
     *
     * @throws IOException
     */
    private void frameSetup() throws IOException {

        setSize(1920, 1080); // set size of the window to 1920x1080
        setLayout(null); // set to default layout (flow layout)
        setTitle("Ice Cream Truck Tycoon - Lukas, Sabrina, Kevin, Matthew, & Ariana"); // set the title of the window
        setResizable(false); // disallow resizing the window

        setIconImage(ImageIO.read(new File("files/icecreamcone.png")));

        setDefaultCloseOperation(MainGameplayScreen.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // assembles basic parts of the window
    private void assembleWindow() {

        panel.setBounds(0, 0, 1920, 1080);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#7CF3A0"));

        add(panel);

        bgPhoto.setBounds(0, 0, 1920, 1080);
        panel.add(bgPhoto);

        panel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}