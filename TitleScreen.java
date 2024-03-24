package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class TitleScreen extends JFrame implements ActionListener {

	private JPanel panel = new JPanel();
	private JLabel truckPhoto = new JLabel(new ImageIcon("files/icecreamtruck.png"));
	private JLabel iceCreamConePhotoR = new JLabel(new ImageIcon("files/icecreamcone.png"));
	private JLabel iceCreamConePhotoL = new JLabel(new ImageIcon("files/icecreamcone.png"));
	private JLabel title = new JLabel("Ice Cream Truck Tycoon", SwingConstants.CENTER);

	private Font sideButtonFont = new Font("Calibri", Font.BOLD, 36);
	private Font startFont = new Font("Calibri", Font.BOLD, 72);
	private Font titleFont = new Font("Calibri", Font.BOLD, 96);

	private JButton start = new JButton("Play");
	private JButton highScores = new JButton("High Scores");
	private JButton tutorial = new JButton("Tutorial");
	private JLabel credits = new JLabel("Made by Group 48 (Lukas Bozinov, Ariana Feng, Matthew Molloy, Kevin Russel, Sabrina Lee)");

	
	/**
	 * This constructor runs everything required in the TitleScreen.
	 * This method runs the frameSetup and assembleWindow methods.
	 * This method also catches exceptions thrown by these other helper methods.
	 */
	public TitleScreen() {
		try {
			frameSetup();
			assembleWindow();
		} catch (IOException e) {
			System.out.println("Error: IOException, error code 6.1");
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Error: Unknown exception, error code 6.2");
			e.printStackTrace();
		}
	}

	/**
	 * This helper method sets up the basics of the JFrame that this class extends.
	 * Sets the size of the window, makes it unresizable, and sets titles as well as layout/decorations.
	 * @throws IOException
	 */
	private void frameSetup() throws IOException {

		setSize(1920, 1080); // set size of the window to 1920x1080
		setLayout(null); // set to default layout (flow layout)
		setTitle("Ice Cream Truck Tycoon - Lukas, Sabrina, Kevin, Matthew, & Ariana"); // set the title of the window
		setResizable(false); // disallow resizing the window

		setIconImage(ImageIO.read(new File("files/icecreamcone.png")));

		setDefaultCloseOperation(TitleScreen.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// assembles basic parts of the window
	private void assembleWindow() {

		panel.setBounds(0, 0, 1920, 1080);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#7CF3A0"));

		add(panel);

		truckPhoto.setBounds(550, 100, 800, 800);
		panel.add(truckPhoto);

		iceCreamConePhotoR.setBounds(1440, 140, 300, 768);
		panel.add(iceCreamConePhotoR);

		iceCreamConePhotoL.setBounds(140, 140, 300, 768);
		panel.add(iceCreamConePhotoL);

		start.setBounds(745, 800, 400, 145);
		start.setFont(startFont);
		start.setBackground(Color.decode("#9FDBFE"));
		start.setForeground(Color.decode("#1D1128"));
		start.setFocusPainted(false);
		start.setHorizontalAlignment(SwingConstants.CENTER);
		start.setVerticalAlignment(SwingConstants.CENTER);
		start.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		start.addActionListener(this);

		highScores.setBounds(370, 800, 350, 145);
		highScores.setFont(sideButtonFont);
		highScores.setBackground(Color.decode("#9FDBFE"));
		highScores.setForeground(Color.decode("#1D1128"));
		highScores.setFocusPainted(false);
		highScores.setHorizontalAlignment(SwingConstants.CENTER);
		highScores.setVerticalAlignment(SwingConstants.CENTER);
		highScores.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		highScores.addActionListener(this);

		tutorial.setBounds(1170, 800, 350, 145);
		tutorial.setFont(sideButtonFont);
		tutorial.setBackground(Color.decode("#9FDBFE"));
		tutorial.setForeground(Color.decode("#1D1128"));
		tutorial.setFocusPainted(false);
		tutorial.setHorizontalAlignment(SwingConstants.CENTER);
		tutorial.setVerticalAlignment(SwingConstants.CENTER);
		tutorial.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		tutorial.addActionListener(this);

		title.setBounds(230, 31, 1440, 100);
		title.setForeground(Color.BLACK);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		title.setFont(titleFont);
		
		credits.setBounds(5, 1022, 1440, 18);
		credits.setForeground(Color.BLACK);
		credits.setFont(new Font("Calibri", Font.BOLD, 18));

		panel.add(start);
		panel.add(highScores);
		panel.add(tutorial);
		panel.add(title);
		panel.add(credits);

		panel.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == start) {
			setVisible(false);
			new SaveAndLoadScreen();
		} else if (e.getSource() == tutorial) {
			new TutorialScreen();
			
		} else if (e.getSource() == highScores) {
			new HighScoreScreen();
		}

	}

}