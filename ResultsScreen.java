package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * This class displays a screen right after the main gameplay animation has
 * finished. This class extends JFrame for the GUI and listens for actions that
 * take place when clicking JButtons using an ActionListener.
 * 
 * @author Lukas Bozinov
 */
@SuppressWarnings("serial")
public class ResultsScreen extends JFrame implements ActionListener {

	// declare all jpanel instance variables
	private JPanel panel = new JPanel();
	private JPanel resultsPanel = new JPanel();
	private JPanel infoPanel = new JPanel();
	private JPanel separator = new JPanel();

	// declare JFXpanel (for graphs)
	private JFXPanel fxpanel = new JFXPanel();

	// set up dropdown menus
	private final String[] graphOptions = { "Reputation", "Profit" };
	private JComboBox<String> graphDropdown = new JComboBox<String>(graphOptions);
	private JComboBox<String> infoDropdown = new JComboBox<String>(graphOptions);

	// declare all possible fonts that will be used
	private Font startFont = new Font("Calibri", 1, 36);
	private Font dropDownLabelFont = new Font("Calibri", 1, 28);
	private Font titleFont = new Font("Calibri", 1, 96);

	// declare all jlabels, objects for game functionality, and sound clips
	private JLabel title = new JLabel("Results", SwingConstants.CENTER);
	private JLabel selectionLabel = new JLabel("Generate Graph");
	private JLabel infoSelectionLabel = new JLabel("Information");
	private JButton startNextDayButton = new JButton("<html><center>Start Next Day<center/><html/>");
	private Player currentPlayer;
	private Clip sound1;

	/**
	 * This constructor runs everything required in the ResultsScreen. This method
	 * runs the frameSetup, assembleWindow, and addLabelsAndDropDown methods. This
	 * method catches exceptions thrown by these other helper methods, and
	 * differentiates between JavaFX and Java Swing calls by calling SwingUtilities
	 * and PlatformRun.
	 * 
	 * @param currentPlayer
	 */
	public ResultsScreen(Player currentPlayer) {
		try {

			this.currentPlayer = currentPlayer; // pass in current player as parameter and set instance variable

			// run all swing-related methods (javafx is nested in these methods)
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					try {
						frameSetup();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					assembleWindow();
					addLabelsAndDropDown();
				}
			});

			// catch any exceptions
		} catch (Exception e) {
			System.out.println("Error: Unknown exception, error code 4.2");
			e.printStackTrace();
		}
	}

	/**
	 * This method plays the menu music on the Results Screen.
	 */
	private void playMusic() {
		try {
			// create a new input stream and grab the file from the sounds folder
			AudioInputStream audio = AudioSystem
					.getAudioInputStream(new File("files/MainGamePlayScreenMusic.wav").getAbsoluteFile());
			sound1 = AudioSystem.getClip(); // create a clip called startGame and get the clip from the
			// "audio

			sound1.open(audio);
			sound1.start(); // play the clip/sound
		} catch (Exception ex) { // print in console if the clip doesn't work for whatever reason
			System.out.println("Error playing sound.");
			ex.printStackTrace();
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

		setDefaultCloseOperation(TitleScreen.EXIT_ON_CLOSE);
		setVisible(true);

	}

	/**
	 * This method assembles all of the visible parts of the window and plays menu
	 * music. The only object not initialized here are dropdown menus.
	 */
	private void assembleWindow() {
		playMusic(); // play the menu music

		// initialize the panel on which GUI components will be placed
		panel.setBounds(0, 0, 1920, 1080);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#7CF3A0"));

		// initialize the jfxpanel where the graph of results will be displayed
		fxpanel.setBounds(549, 125, 1100, 650);
		fxpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

		// initialize the swing jpanel where the education information will be displayed
		infoPanel.setBounds(549, 125, 1100, 650);
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

		// add all the panels to the screen (and make info panel invisible to start, so
		// panels don't overlap)
		add(fxpanel);
		add(infoPanel);
		add(panel);
		infoPanel.setVisible(false);

		// initialize the title label
		title.setBounds(230, 31, 1440, 100);
		title.setForeground(Color.BLACK);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		title.setFont(titleFont);

		// initialize the jbutton to lead into the next day of the game
		// this sets boundaries, font, golours, alignment, and border/actionlisteners
		startNextDayButton.setBounds(745, 800, 400, 100);
		startNextDayButton.setFont(startFont);
		startNextDayButton.setBackground(Color.decode("#9FDBFE"));
		startNextDayButton.setForeground(Color.decode("#1D1128"));
		startNextDayButton.setFocusPainted(false);
		startNextDayButton.setHorizontalAlignment(SwingConstants.CENTER);
		startNextDayButton.setVerticalAlignment(SwingConstants.CENTER);
		startNextDayButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		startNextDayButton.addActionListener(this);

		// initialize the results panel (in the same way as the main panel)
		resultsPanel.setBounds(250, 125, 300, 650);
		resultsPanel.setLayout(null);
		resultsPanel.setBackground(Color.decode("#FDC6D8"));
		resultsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

		// add everything to the panel
		panel.add(title);
		panel.add(resultsPanel);
		panel.add(startNextDayButton);

		panel.setVisible(true); // set the panel as visible

	}

	/**
	 * This method assembles all of the dropdown menus and a separator to split
	 * apart the two panels.
	 */
	private void addLabelsAndDropDown() {

		// initialize the label for the graph dropdown
		selectionLabel.setBounds(0, 4, 300, 60);
		selectionLabel.setForeground(Color.BLACK);
		selectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectionLabel.setVerticalAlignment(SwingConstants.CENTER);
		selectionLabel.setFont(startFont);
		resultsPanel.add(selectionLabel);

		// initialize the graph dropdown's position in the GUI
		graphDropdown.setBounds(25, 60, 250, 60);
		graphDropdown.setFont(dropDownLabelFont);
		graphDropdown.setBackground(Color.decode("#9FDBFE"));
		graphDropdown.setForeground(Color.decode("#1D1128"));
		graphDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		((JLabel) graphDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) graphDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);
		graphDropdown.setSelectedIndex(-1);
		graphDropdown.addActionListener(this);

		// initialize the graph dropdown's position in the GUI
		infoSelectionLabel.setBounds(0, 194, 300, 60);
		infoSelectionLabel.setForeground(Color.BLACK);
		infoSelectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoSelectionLabel.setVerticalAlignment(SwingConstants.CENTER);
		infoSelectionLabel.setFont(startFont);
		resultsPanel.add(infoSelectionLabel);

		// initialize the info dropdown's position in the GUI
		infoDropdown.setBounds(25, 240, 250, 60);
		infoDropdown.setFont(dropDownLabelFont);
		infoDropdown.setBackground(Color.decode("#9FDBFE"));
		infoDropdown.setForeground(Color.decode("#1D1128"));
		infoDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		((JLabel) infoDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) infoDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);
		infoDropdown.setSelectedIndex(-1);
		infoDropdown.addActionListener(this);

		// include the line of separation between the dropdown menus and the jfxpanel
		separator.setBounds(300, 0, 2, 650);
		separator.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

		// add everything to the results panel
		resultsPanel.add(separator);
		resultsPanel.add(graphDropdown);
		resultsPanel.add(infoDropdown);

	}

	/**
	 * This method, which is a mandatory method when implementing an ActionListener,
	 * listens for any actions taken by the user and performs a corresponding
	 * action.
	 * 
	 * @param ActionEvent (e)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// stop all music when an action is taken
		sound1.stop();
		sound1.close();

		// if the first option of the graph dropdown is taken, then we use the javafx
		// library to generate a graph
		if (e.getSource() == graphDropdown && graphDropdown.getSelectedIndex() == 0) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					initFXIndex1(fxpanel);

				}
			});

			panel.repaint(); // repaint the swing panel after the jfxpanel's been changed

			// if the second option of the graph dropdown is taken, then we use the javafx
			// library to generate a graph
		} else if (e.getSource() == graphDropdown && graphDropdown.getSelectedIndex() == 1) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					initFXIndex2(fxpanel);

				}
			});

			panel.repaint(); // repaint the swing panel after the jfxpanel's been changed
		}

		// if the next day button has been clicked
		else if (e.getSource() == startNextDayButton) {
			setVisible(false);

			// if it's been three days (meaning easy, medium, and hard difficulty have all
			// been progressed through)
			if (currentPlayer.getDay() == 3) {

				// if the player has broken even or made a profit
				if (currentPlayer.getBalance() >= 30) {
					new VictoryScreen(); // the player wins!
				} else { // otherwise
					new DefeatScreen(); // the player LOSES!!!!
				}

				// if it isn't day three yet, the player has more difficulties to progress
				// through, so we go to the next day
			} else {
				Player newDay = new Player(currentPlayer.getNewFile(), currentPlayer.getPlayerInitials(),
						currentPlayer.getDay(), currentPlayer.getDay(), currentPlayer.getWeather(),
						currentPlayer.getReputation(), currentPlayer.getBalance(), currentPlayer.inventory.getCones(),
						currentPlayer.inventory.getSugar(), currentPlayer.inventory.getVanilla(),
						currentPlayer.inventory.getCream());
				new IngredientSelectionScreen(newDay); // start from the ingredient selection screen, not the title
														// screen
			}

			// if the info drop down menu was clicked with "reputation"
		} else if (e.getSource() == infoDropdown && infoDropdown.getSelectedIndex() == 0) {

			// initialize the info panel and display educational information to the user
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					/*
					 * Hide the JFXPanel, initialize an information label and panel for the label,
					 * and display an info panel with helpful tips on how to increase reputation
					 */
					fxpanel.setVisible(false);
					infoPanel.removeAll();
					infoPanel.setBackground(Color.decode("#9FDBFE"));

					JLabel infoLabel = new JLabel("<html>To increase reputation, you need to sell more ice cream!<br>"
							+ "Try the following strategies:&nbsp;<br>"
							+ "&nbsp;- Lower your prices, so more people buy the ice cream. <br>"
							+ "&nbsp;&nbsp;&nbsp;Word-of-mouth goes a long way!<br>"
							+ "&nbsp;- Increase the amount of ingredients you use in your recipe! <br>"
							+ "&nbsp;&nbsp;&nbsp;People want tasty ice cream.</html>");

					infoLabel.setBounds(0, 0, 1095, 650);
					infoLabel.setForeground(Color.BLACK);
					infoLabel.setFont(new Font("Calibri", Font.BOLD, 36));
					infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
					infoLabel.setVerticalAlignment(SwingConstants.TOP);
					infoPanel.add(infoLabel);
					infoPanel.setVisible(true);
					infoPanel.repaint();
					infoLabel.repaint();
				}
			});
			// if the info drop down menu was clicked with "profits"
		} else if (e.getSource() == infoDropdown && infoDropdown.getSelectedIndex() == 1) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					/*
					 * Hide the JFXPanel, initialize an information label and panel for the label,
					 * and display an info panel with helpful tips on how to increase profits
					 */
					fxpanel.setVisible(false);
					infoPanel.removeAll();
					infoPanel.setBackground(Color.decode("#9FDBFE"));

					JLabel infoLabel = new JLabel("<html>To increase profits, you need to increase prices!<br>"
							+ "Try the following other strategies, too:&nbsp;<br>"
							+ "&nbsp;- Decrease the amount of ingredients you use in your recipe! <br>"
							+ "&nbsp;&nbsp;&nbsp;This saves on cost.<br>"
							+ "&nbsp;- Try not to spend all your money buying more ingredients! <br>"
							+ "&nbsp;&nbsp;&nbsp;This helps you save money, too.</html>");

					infoLabel.setBounds(0, 0, 1095, 650);
					infoLabel.setForeground(Color.BLACK);
					infoLabel.setFont(new Font("Calibri", Font.BOLD, 36));
					infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
					infoLabel.setVerticalAlignment(SwingConstants.TOP);
					infoPanel.add(infoLabel);
					infoPanel.setVisible(true);
					infoPanel.repaint();
					infoLabel.repaint();
				}
			});
		}

	}

	/**
	 * This method initializes the JFXPanel that holds the reputation graph.
	 * 
	 * @param fxPanel
	 */
	private static void initFXIndex1(JFXPanel fxPanel) {
		// This method is invoked on the JavaFX thread
		Scene scene = createSceneIndex1();
		fxPanel.setScene(scene);
		fxPanel.setVisible(true);
	}

	/**
	 * This method creates a scene on which the JavaFX reputation 
	 * graph will be generated and displayed.
	 * 
	 * @return JavaFX Scene
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Scene createSceneIndex1() {

		// create the axes for the line graph
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();

		// implement the axes with a linechart
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		Scene scene = new Scene(lineChart, 800, 600); // place the line chart onto the scene

		// set labels for each of the axes
		xAxis.setLabel("Sprite #");
		yAxis.setLabel("Reputation");
		// creating the chart

		lineChart.setTitle("Reputation over time");
		// defining a series
		XYChart.Series series = new XYChart.Series();

		series.setName("Reputation Marker");
		// populating the series with data

		for (int i = 0; i < 11; i++) {

			series.getData().add(new XYChart.Data(i, Results.repArray[i])); // populated with data from Results.java
		}
		lineChart.getData().add(series); //add the series to the chart

		return (scene); // return the scene
	}

	/**
	 * This method initializes the JFXPanel that holds the profits graph.
	 * 
	 * @param fxPanel
	 */
	private static void initFXIndex2(JFXPanel fxPanel) {
		// This method is invoked on the JavaFX thread
		Scene scene = createSceneIndex2();
		fxPanel.setScene(scene);
		fxPanel.setVisible(true);
	}

	/**
	 * This method creates a scene on which the JavaFX profits 
	 * graph will be generated and displayed.
	 * 
	 * @return JavaFX Scene
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Scene createSceneIndex2() {

		// create the axes for the line graph
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		
		//implement the axes with a line chart
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		Scene scene = new Scene(lineChart, 800, 600); //place the linechart onto the scene

		//set axes labels
		xAxis.setLabel("Sprite #");
		yAxis.setLabel("Profit ($)");
		// creating the chart

		lineChart.setTitle("Profit over time");
		// defining a series
		XYChart.Series series = new XYChart.Series();

		series.setName("Profit Marker");
		// populating the series with data
		for (int i = 0; i < 11; i++) {

			series.getData().add(new XYChart.Data(i, Results.dayCash[i])); //populate the series with cash data from Results.java

		}
		lineChart.getData().add(series); //add the series to the chart

		return (scene); //return the scene
	}

}