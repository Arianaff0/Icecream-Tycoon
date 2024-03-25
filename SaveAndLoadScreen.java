package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @author Lukas Bozinov
 */
@SuppressWarnings("serial")
public class SaveAndLoadScreen extends JFrame implements ActionListener {

	// declare all instance variables
	private JPanel panel = new JPanel();
	private JPanel profilePanel1 = new JPanel();
	private JPanel profilePanel2 = new JPanel();
	private JPanel profilePanel3 = new JPanel();
	private JLabel title = new JLabel("Save or Load Game", SwingConstants.CENTER);

	private Font buttonFont = new Font("Calibri", Font.BOLD, 48);
	private Font profileFont = new Font("Calibri", Font.BOLD, 24);
	private Font titleFont = new Font("Calibri", Font.BOLD, 96);

	private JButton start = new JButton("Play");

	private JButton profileButton1 = new JButton();
	private JButton profileButton2 = new JButton();
	private JButton profileButton3 = new JButton();

	/**
	 * This is the constructor method for the Save and Load Screen. It handles
	 * IOExceptions with custom error code, as well as general Exceptions.
	 */
	public SaveAndLoadScreen() {
		try {
			frameSetup();
			assembleWindow();
			assembleProfiles();
			loadProfileData();
		} catch (IOException e) {
			System.out.println("Error: IOException, error code 3.1");
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Error: Unknown exception, error code 3.2");
			e.printStackTrace();
		}
	}

	/**
	 * Sets up full frame with title, icon, turns of resizability, and sets the
	 * default close operation. Throws an IOException if the image that's being used
	 * in the Icon is not readable or not found.
	 * 
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

	/**
	 * Assembles basic parts of the window, including the panel and title.
	 */
	private void assembleWindow() {

		panel.setBounds(0, 0, 1920, 1080);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#7CF3A0"));

		add(panel);

		title.setBounds(230, 31, 1440, 100);
		title.setForeground(Color.BLACK);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		title.setFont(titleFont);

		panel.add(start);
		panel.add(title);

		panel.setVisible(true);
	}

	/**
	 * This method is somewhat repetitive in its code, but accomplishes several
	 * different tasks: - Lays out three panels for each profile Sets text based on
	 * other conditions (fulfilled by an if-else)
	 */
	private void assembleProfiles() {
		profilePanel1.setBounds(275, 225, 300, 560);
		profilePanel1.setLayout(null);
		profilePanel1.setBackground(Color.decode("#589BDA"));
		profilePanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		panel.add(profilePanel1);

		profilePanel2.setBounds(775, 225, 300, 560);
		profilePanel2.setLayout(null);
		profilePanel2.setBackground(Color.decode("#589BDA"));
		profilePanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		panel.add(profilePanel2);

		profilePanel3.setBounds(1275, 225, 300, 560);
		profilePanel3.setLayout(null);
		profilePanel3.setBackground(Color.decode("#589BDA"));
		profilePanel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		panel.add(profilePanel3);

		profileButton1.setBounds(350, 825, 150, 80);
		profileButton1.setFont(buttonFont);
		profileButton1.setBackground(Color.decode("#9FDBFE"));
		profileButton1.setForeground(Color.decode("#1D1128"));
		profileButton1.setFocusPainted(false);
		profileButton1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		profileButton1.addActionListener(this);

		profileButton1.setText("Load"); // we will need to set up an if-else here (if hasData=true then "load", else
										// "create")
		panel.add(profileButton1);

		profileButton2.setBounds(850, 825, 150, 80);
		profileButton2.setFont(buttonFont);
		profileButton2.setBackground(Color.decode("#9FDBFE"));
		profileButton2.setForeground(Color.decode("#1D1128"));
		profileButton2.setFocusPainted(false);
		profileButton2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		profileButton2.addActionListener(this);

		profileButton2.setText("Create"); // we will need to set up an if-else here (if hasData=true then "load", else
											// "create")
		panel.add(profileButton2);

		profileButton3.setBounds(1350, 825, 150, 80);
		profileButton3.setFont(buttonFont);
		profileButton3.setBackground(Color.decode("#9FDBFE"));
		profileButton3.setForeground(Color.decode("#1D1128"));
		profileButton3.setFocusPainted(false);
		profileButton3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		profileButton3.addActionListener(this);

		profileButton3.setText("Create"); // we will need to set up an if-else here (if hasData=true then "load", else
											// "create")
		panel.add(profileButton3);

	}

	/**
	 * This method load all of the profile data (and labels) that correspond to each
	 * respective profile. Every button is initialized and positioned using the
	 * FlowLayout (default for Java Swing). User data is loaded via //FILL THIS
	 * LATER// and passed into the respective buttons and labels.
	 */
	private void loadProfileData() {

		// we would load the data from each respectable csv file here
		// then concatenate the data from csv into the JLabel string
		// for now, they will have placeholder data

		JLabel profileInitials1 = new JLabel("Initials: LB");
		JLabel profileRevenue1 = new JLabel("Revenue: $1");
		JLabel profileWeather1 = new JLabel("Weather: Sunny");
		JLabel profileDifficulty1 = new JLabel("Difficulty: Impossible");

		// this header is pretty packed, but every "integer to string" can be thought of
		// as one of the parameters for this JLabel
		// those labels being each ingredients' current count, and the same goes for the
		// following ones below
		JLabel profileIngredientsHeader1 = new JLabel("<html>Ingredients&nbsp;-<br/>&nbsp;&nbsp;Cream:&nbsp;"
				+ Integer.toString(100) + " <br/>&nbsp;&nbsp;Cones:&nbsp;" + Integer.toString(100)
				+ "<br/>&nbsp;&nbsp;Sugar:&nbsp;" + Integer.toString(100) + "<br/>&nbsp;&nbsp;Vanilla:&nbsp;"
				+ Integer.toString(100) + "</html>");

		JLabel profileInitials2 = new JLabel("Initials: AF");
		JLabel profileRevenue2 = new JLabel("Revenue: $10");
		JLabel profileWeather2 = new JLabel("Weather: Rainy");
		JLabel profileDifficulty2 = new JLabel("Difficulty: Medium");

		JLabel profileIngredientsHeader2 = new JLabel("<html>Ingredients&nbsp;-<br/>&nbsp;&nbsp;Cream:&nbsp;"
				+ Integer.toString(100) + " <br/>&nbsp;&nbsp;Cones:&nbsp;" + Integer.toString(100)
				+ "<br/>&nbsp;&nbsp;Sugar:&nbsp;" + Integer.toString(100) + "<br/>&nbsp;&nbsp;Vanilla:&nbsp;"
				+ Integer.toString(100) + "</html>");

		JLabel profileInitials3 = new JLabel("Initials: KR");
		JLabel profileRevenue3 = new JLabel("Revenue: $1846421");
		JLabel profileWeather3 = new JLabel("Weather: Cloudy");
		JLabel profileDifficulty3 = new JLabel("Difficulty: Hard");

		JLabel profileIngredientsHeader3 = new JLabel("<html>Ingredients&nbsp;-<br/>&nbsp;&nbsp;Cream:&nbsp;"
				+ Integer.toString(100) + " <br/>&nbsp;&nbsp;Cones:&nbsp;" + Integer.toString(100)
				+ "<br/>&nbsp;&nbsp;Sugar:&nbsp;" + Integer.toString(100) + "<br/>&nbsp;&nbsp;Vanilla:&nbsp;"
				+ Integer.toString(100) + "</html>");

		/*
		 * These next sections are all very similar to each other. First, the label (or
		 * button) has its boundaries initialized (size of the component, and its
		 * location relative to the panel) Foreground is set (text colour), then the
		 * font is set (instance variables) Finally, the button/label is added to its
		 * respective panel, and actionListeners are added if required.
		 */

		profileInitials1.setBounds(10, 25, 295, 30);
		profileInitials1.setForeground(Color.BLACK);
		profileInitials1.setFont(profileFont);
		profilePanel1.add(profileInitials1);

		profileRevenue1.setBounds(10, 75, 295, 30);
		profileRevenue1.setForeground(Color.BLACK);
		profileRevenue1.setFont(profileFont);
		profilePanel1.add(profileRevenue1);

		profileWeather1.setBounds(10, 125, 295, 30);
		profileWeather1.setForeground(Color.BLACK);
		profileWeather1.setFont(profileFont);
		profilePanel1.add(profileWeather1);

		profileDifficulty1.setBounds(10, 175, 295, 30);
		profileDifficulty1.setForeground(Color.BLACK);
		profileDifficulty1.setFont(profileFont);
		profilePanel1.add(profileDifficulty1);

		profileIngredientsHeader1.setBounds(10, 215, 150, 180);
		profileIngredientsHeader1.setForeground(Color.BLACK);
		profileIngredientsHeader1.setFont(profileFont);
		profilePanel1.add(profileIngredientsHeader1);

		profileInitials2.setBounds(10, 25, 295, 30);
		profileInitials2.setForeground(Color.BLACK);
		profileInitials2.setFont(profileFont);
		profilePanel2.add(profileInitials2);

		profileRevenue2.setBounds(10, 75, 295, 30);
		profileRevenue2.setForeground(Color.BLACK);
		profileRevenue2.setFont(profileFont);
		profilePanel2.add(profileRevenue2);

		profileWeather2.setBounds(10, 125, 295, 30);
		profileWeather2.setForeground(Color.BLACK);
		profileWeather2.setFont(profileFont);
		profilePanel2.add(profileWeather2);

		profileDifficulty2.setBounds(10, 175, 295, 30);
		profileDifficulty2.setForeground(Color.BLACK);
		profileDifficulty2.setFont(profileFont);
		profilePanel2.add(profileDifficulty2);

		profileIngredientsHeader2.setBounds(10, 215, 295, 180);
		profileIngredientsHeader2.setForeground(Color.BLACK);
		profileIngredientsHeader2.setFont(profileFont);
		profilePanel2.add(profileIngredientsHeader2);

		profileInitials3.setBounds(10, 25, 295, 30);
		profileInitials3.setForeground(Color.BLACK);
		profileInitials3.setFont(profileFont);
		profilePanel3.add(profileInitials3);

		profileRevenue3.setBounds(10, 75, 295, 30);
		profileRevenue3.setForeground(Color.BLACK);
		profileRevenue3.setFont(profileFont);
		profilePanel3.add(profileRevenue3);

		profileWeather3.setBounds(10, 125, 295, 30);
		profileWeather3.setForeground(Color.BLACK);
		profileWeather3.setFont(profileFont);
		profilePanel3.add(profileWeather3);

		profileDifficulty3.setBounds(10, 175, 295, 30);
		profileDifficulty3.setForeground(Color.BLACK);
		profileDifficulty3.setFont(profileFont);
		profilePanel3.add(profileDifficulty3);

		profileIngredientsHeader3.setBounds(10, 215, 295, 180);
		profileIngredientsHeader3.setForeground(Color.BLACK);
		profileIngredientsHeader3.setFont(profileFont);
		profilePanel3.add(profileIngredientsHeader3);

	}

	/**
	 * This actionPerformed method checks the actionListeners of every clickable
	 * button on this screen. When a button is clicked, the subsequent actions
	 * inside each if statement are executed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == profileButton1) {
			GameLauncher.currentPlayer = GameLauncher.player1;
			// 

			setVisible(false);
			new IngredientSelectionScreen();
		} else if (e.getSource() == profileButton2) {
			GameLauncher.currentPlayer = GameLauncher.player2;


			setVisible(false);
			new IngredientSelectionScreen();
		} else if (e.getSource() == profileButton3) {
			GameLauncher.currentPlayer = GameLauncher.player3;

			setVisible(false);
			new IngredientSelectionScreen();
		}

	}

}