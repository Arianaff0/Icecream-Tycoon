

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class DebugScreen extends JFrame implements ActionListener {

	private JPanel panel = new JPanel();
	private JPanel commandPanel = new JPanel();

	private JLabel title = new JLabel("Administrator Console", SwingConstants.CENTER);

	private final String[] weatherOptions = { "Freezing (<0 deg)", "Cold (0-5 deg)", "Cool (6-10 deg)",
			"Warm (10-15 deg)", "Hot (15-20 deg)", "Scalding (>20 deg)" }; 
	private final Double[] moneyOptions = { 0.0, 10.0, 50.0, 100.0, 1000.0 }; // 0.10.50.100.1000
	private final Integer[] dayOptions = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }; // 1-14
	private final Integer[] reputationOptions = { -10, -5, 0, 5, 10 }; // -10/-5/0/5/10
	private final String[] difficultyOptions = { "Easy", "Medium", "Hard" }; // easy/med/hard
	private final Integer[] profileOptions = { 1, 2, 3 };

	private JComboBox<String> weatherDropdown = new JComboBox<String>(weatherOptions);
	private JComboBox<Double> moneyDropdown = new JComboBox<Double>(moneyOptions);
	private JComboBox<Integer> dayDropdown = new JComboBox<Integer>(dayOptions);
	private JComboBox<Integer> reputationDropdown = new JComboBox<Integer>(reputationOptions);
	private JComboBox<String> difficultyDropdown = new JComboBox<String>(difficultyOptions);
	private JComboBox<Integer> profileDropdown = new JComboBox<Integer>(profileOptions);

	private Font startFont = new Font("Calibri", Font.BOLD, 36);
	private Font dropDownFont = new Font("Calibri", Font.BOLD, 24);
	private Font dropDownLabelFont = new Font("Calibri", Font.BOLD, 28);
	private Font titleFont = new Font("Calibri", Font.BOLD, 96);
	
	private JLabel weatherLabel = new JLabel("Select Weather", SwingConstants.CENTER);
	private JLabel moneyLabel = new JLabel("Set Money ($)", SwingConstants.CENTER);
	private JLabel dayLabel = new JLabel("Select Day", SwingConstants.CENTER);
	private JLabel reputationLabel = new JLabel("Select Reputation", SwingConstants.CENTER);
	private JLabel difficultyLabel = new JLabel("Select Difficulty", SwingConstants.CENTER);
	private JLabel profileLabel = new JLabel("Select Profile", SwingConstants.CENTER);

	private JButton execute = new JButton("Execute");

	/**
	 * This constructor runs everything required in the TitleScreen. This method
	 * runs the frameSetup and assembleWindow methods. This method also catches
	 * exceptions thrown by these other helper methods.
	 */
	public DebugScreen() {
		try {
			frameSetup();
			assembleWindow();
			addDropDownLabels();
			addDropDowns();
		} catch (IOException e) {
			System.out.println("Error: IOException, error code 9.1");
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Error: Unknown exception, error code 9.2");
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

		setDefaultCloseOperation(TitleScreen.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// assembles basic parts of the window
	private void assembleWindow() {

		panel.setBounds(0, 0, 1920, 1080);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#70FFB3"));

		add(panel);

		title.setBounds(230, 31, 1440, 100);
		title.setForeground(Color.BLACK);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		title.setFont(titleFont);

		execute.setBounds(745, 800, 400, 100);
		execute.setFont(startFont);
		execute.setBackground(Color.decode("#7CC6FE"));
		execute.setForeground(Color.decode("#1D1128"));
		execute.setFocusPainted(false);
		execute.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		execute.addActionListener(this);

		commandPanel.setBounds(125, 125, 1625, 650);
		commandPanel.setLayout(null);
		commandPanel.setBackground(Color.decode("#FFADAD"));
		commandPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

		panel.add(commandPanel);
		panel.add(title);
		panel.add(execute);

		panel.setVisible(true);
	}
	
	private void addDropDownLabels() {
		
		weatherLabel.setBounds(0, 4, 250, 60);
		weatherLabel.setForeground(Color.BLACK);
		weatherLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weatherLabel.setVerticalAlignment(SwingConstants.CENTER);
		weatherLabel.setFont(dropDownLabelFont);
		commandPanel.add(weatherLabel);
		
		moneyLabel.setBounds(275, 4, 250, 60);
		moneyLabel.setForeground(Color.BLACK);
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyLabel.setVerticalAlignment(SwingConstants.CENTER);
		moneyLabel.setFont(dropDownLabelFont);
		commandPanel.add(moneyLabel);
		
		dayLabel.setBounds(550, 4, 250, 60);
		dayLabel.setForeground(Color.BLACK);
		dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dayLabel.setVerticalAlignment(SwingConstants.CENTER);
		dayLabel.setFont(dropDownLabelFont);
		commandPanel.add(dayLabel);
		
		reputationLabel.setBounds(825, 4, 250, 60);
		reputationLabel.setForeground(Color.BLACK);
		reputationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reputationLabel.setVerticalAlignment(SwingConstants.CENTER);
		reputationLabel.setFont(dropDownLabelFont);
		commandPanel.add(reputationLabel);
		
		difficultyLabel.setBounds(1100, 4, 250, 60);
		difficultyLabel.setForeground(Color.BLACK);
		difficultyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		difficultyLabel.setVerticalAlignment(SwingConstants.CENTER);
		difficultyLabel.setFont(dropDownLabelFont);
		commandPanel.add(difficultyLabel);
		
		profileLabel.setBounds(1375, 4, 250, 60);
		profileLabel.setForeground(Color.BLACK);
		profileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		profileLabel.setVerticalAlignment(SwingConstants.CENTER);
		profileLabel.setFont(dropDownLabelFont);
		commandPanel.add(profileLabel);
		
	}

	private void addDropDowns() {

		weatherDropdown.setBounds(0, 60, 250, 60);
		weatherDropdown.setFont(dropDownFont);
		weatherDropdown.setBackground(Color.decode("#7CC6FE"));
		weatherDropdown.setForeground(Color.decode("#1D1128"));
		weatherDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		((JLabel) weatherDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) weatherDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);
		weatherDropdown.addActionListener(this);
		commandPanel.add(weatherDropdown);
		weatherDropdown.revalidate();
		weatherDropdown.repaint();
		
		moneyDropdown.setBounds(275, 60, 250, 60);
		moneyDropdown.setFont(dropDownFont);
		moneyDropdown.setBackground(Color.decode("#7CC6FE"));
		moneyDropdown.setForeground(Color.decode("#1D1128"));
		moneyDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));		
		((JLabel) moneyDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) moneyDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);
		moneyDropdown.addActionListener(this);
		commandPanel.add(moneyDropdown);
		moneyDropdown.revalidate();
		moneyDropdown.repaint();
		
		dayDropdown.setBounds(550, 60, 250, 60);
		dayDropdown.setFont(dropDownFont);
		dayDropdown.setBackground(Color.decode("#7CC6FE"));
		dayDropdown.setForeground(Color.decode("#1D1128"));
		dayDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));		
		((JLabel) dayDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) dayDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);
		dayDropdown.addActionListener(this);
		commandPanel.add(dayDropdown);
		dayDropdown.revalidate();
		dayDropdown.repaint();
		
		reputationDropdown.setBounds(825, 60, 250, 60);
		reputationDropdown.setFont(dropDownFont);
		reputationDropdown.setBackground(Color.decode("#7CC6FE"));
		reputationDropdown.setForeground(Color.decode("#1D1128"));
		reputationDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));		
		((JLabel) reputationDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) reputationDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);
		reputationDropdown.addActionListener(this);
		commandPanel.add(reputationDropdown);
		reputationDropdown.revalidate();
		reputationDropdown.repaint();
		
		difficultyDropdown.setBounds(1100, 60, 250, 60);
		difficultyDropdown.setFont(dropDownFont);
		difficultyDropdown.setBackground(Color.decode("#7CC6FE"));
		difficultyDropdown.setForeground(Color.decode("#1D1128"));
		difficultyDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));		
		((JLabel) difficultyDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) difficultyDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);
		difficultyDropdown.addActionListener(this);
		commandPanel.add(difficultyDropdown);
		difficultyDropdown.revalidate();
		difficultyDropdown.repaint();
		
		profileDropdown.setBounds(1375, 60, 250, 60);
		profileDropdown.setFont(dropDownFont);
		profileDropdown.setBackground(Color.decode("#7CC6FE"));
		profileDropdown.setForeground(Color.decode("#1D1128"));
		profileDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));		
		((JLabel) profileDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) profileDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);
		profileDropdown.addActionListener(this);
		commandPanel.add(profileDropdown);
		profileDropdown.revalidate();
		profileDropdown.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == execute) {
			setVisible(false);
			// new RecipeCreationScreen();
		}

	}
}
