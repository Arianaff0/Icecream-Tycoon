package application;

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

	private final String[] weatherOptions = { "Freezing (0 deg)", "Cold (1-5 deg)", "Cool (6-10 deg)",
			"Warm (11-15 deg)", "Hot (16-20 deg)", "Scalding (>20 deg)" };
	private final Double[] moneyOptions = { 0.0, 10.0, 50.0, 100.0, 1000.0 }; // 0.10.50.100.1000
	private final Integer[] vanillaOptions = { 0, 10, 50, 100, 1000 }; 
	private final Integer[] creamOptions = { 0, 10, 50, 100, 1000 }; 
	private final Integer[] sugarOptions = { 0, 10, 50, 100, 1000 }; 
	private final Integer[] coneOptions = { 0, 10, 50, 100, 1000 }; 
	private final Integer[] reputationOptions = { -10, -5, 0, 5, 10 }; // -10/-5/0/5/10
	private final String[] difficultyOptions = { "Easy", "Medium", "Hard" }; // easy/med/hard

	private JComboBox<String> weatherDropdown = new JComboBox<String>(weatherOptions);
	private JComboBox<Double> moneyDropdown = new JComboBox<Double>(moneyOptions);
	private JComboBox<Integer> vanillaDropdown = new JComboBox<Integer>(vanillaOptions);
	private JComboBox<Integer> creamDropdown = new JComboBox<Integer>(creamOptions);
	private JComboBox<Integer> sugarDropdown = new JComboBox<Integer>(sugarOptions);
	private JComboBox<Integer> conesDropdown = new JComboBox<Integer>(coneOptions);
	private JComboBox<Integer> reputationDropdown = new JComboBox<Integer>(reputationOptions);
	private JComboBox<String> difficultyDropdown = new JComboBox<String>(difficultyOptions);

	private Font startFont = new Font("Calibri", Font.BOLD, 36);
	private Font dropDownFont = new Font("Calibri", Font.BOLD, 24);
	private Font dropDownLabelFont = new Font("Calibri", Font.BOLD, 28);
	private Font titleFont = new Font("Calibri", Font.BOLD, 96);

	private JLabel weatherLabel = new JLabel("Select Weather", SwingConstants.CENTER);
	private JLabel moneyLabel = new JLabel("Set Money ($)", SwingConstants.CENTER);
	private JLabel vanillaLabel = new JLabel("Add Vanilla", SwingConstants.CENTER);
	private JLabel creamLabel = new JLabel("Add Cream", SwingConstants.CENTER);
	private JLabel sugarLabel = new JLabel("Add Sugar", SwingConstants.CENTER);
	private JLabel conesLabel = new JLabel("Add Cones", SwingConstants.CENTER);
	private JLabel reputationLabel = new JLabel("Select Reputation", SwingConstants.CENTER);
	private JLabel difficultyLabel = new JLabel("Select Difficulty", SwingConstants.CENTER);

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

		title.setBounds(230, 31, 1440, 100); // x, y, width, height
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

		weatherLabel.setBounds(137, 4, 250, 60);
		weatherLabel.setForeground(Color.BLACK);
		weatherLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weatherLabel.setVerticalAlignment(SwingConstants.CENTER);
		weatherLabel.setFont(dropDownLabelFont);
		commandPanel.add(weatherLabel);

		moneyLabel.setBounds(412, 4, 250, 60);
		moneyLabel.setForeground(Color.BLACK);
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyLabel.setVerticalAlignment(SwingConstants.CENTER);
		moneyLabel.setFont(dropDownLabelFont);
		commandPanel.add(moneyLabel);

		vanillaLabel.setBounds(687, 4, 250, 60);
		vanillaLabel.setForeground(Color.BLACK);
		vanillaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vanillaLabel.setVerticalAlignment(SwingConstants.CENTER);
		vanillaLabel.setFont(dropDownLabelFont);
		commandPanel.add(vanillaLabel);
		
		creamLabel.setBounds(687, 274, 250, 60);
		creamLabel.setForeground(Color.BLACK);
		creamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creamLabel.setVerticalAlignment(SwingConstants.CENTER);
		creamLabel.setFont(dropDownLabelFont);
		commandPanel.add(creamLabel);
		
		
		sugarLabel.setBounds(412, 274, 250, 60);
		sugarLabel.setForeground(Color.BLACK);
		sugarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sugarLabel.setVerticalAlignment(SwingConstants.CENTER);
		sugarLabel.setFont(dropDownLabelFont);
		commandPanel.add(sugarLabel);
		
		
		conesLabel.setBounds(962, 274, 250, 60);
		conesLabel.setForeground(Color.BLACK);
		conesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		conesLabel.setVerticalAlignment(SwingConstants.CENTER);
		conesLabel.setFont(dropDownLabelFont);
		commandPanel.add(conesLabel);

		reputationLabel.setBounds(962, 4, 250, 60);
		reputationLabel.setForeground(Color.BLACK);
		reputationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reputationLabel.setVerticalAlignment(SwingConstants.CENTER);
		reputationLabel.setFont(dropDownLabelFont);
		commandPanel.add(reputationLabel);

		difficultyLabel.setBounds(1237, 4, 250, 60);
		difficultyLabel.setForeground(Color.BLACK);
		difficultyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		difficultyLabel.setVerticalAlignment(SwingConstants.CENTER);
		difficultyLabel.setFont(dropDownLabelFont);
		commandPanel.add(difficultyLabel);

	}

	private void addDropDowns() {

		weatherDropdown.setBounds(137, 60, 250, 60);
		weatherDropdown.setFont(dropDownFont);
		weatherDropdown.setBackground(Color.decode("#7CC6FE"));
		weatherDropdown.setForeground(Color.decode("#1D1128"));
		weatherDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		((JLabel) weatherDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) weatherDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);

		commandPanel.add(weatherDropdown);
		weatherDropdown.revalidate();
		weatherDropdown.repaint();

		moneyDropdown.setBounds(412, 60, 250, 60);
		moneyDropdown.setFont(dropDownFont);
		moneyDropdown.setBackground(Color.decode("#7CC6FE"));
		moneyDropdown.setForeground(Color.decode("#1D1128"));
		moneyDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		((JLabel) moneyDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) moneyDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);

		commandPanel.add(moneyDropdown);
		moneyDropdown.revalidate();
		moneyDropdown.repaint();

		vanillaDropdown.setBounds(687, 60, 250, 60);
		vanillaDropdown.setFont(dropDownFont);
		vanillaDropdown.setBackground(Color.decode("#7CC6FE"));
		vanillaDropdown.setForeground(Color.decode("#1D1128"));
		vanillaDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		((JLabel) vanillaDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) vanillaDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);

		commandPanel.add(vanillaDropdown);
		vanillaDropdown.revalidate();
		vanillaDropdown.repaint();
		
		creamDropdown.setBounds(687, 330, 250, 60);
		creamDropdown.setFont(dropDownFont);
		creamDropdown.setBackground(Color.decode("#7CC6FE"));
		creamDropdown.setForeground(Color.decode("#1D1128"));
		creamDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		((JLabel) creamDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) creamDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);

		commandPanel.add(creamDropdown);
		creamDropdown.revalidate();
		creamDropdown.repaint();
		
		sugarDropdown.setBounds(412, 330, 250, 60);
		sugarDropdown.setFont(dropDownFont);
		sugarDropdown.setBackground(Color.decode("#7CC6FE"));
		sugarDropdown.setForeground(Color.decode("#1D1128"));
		sugarDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		((JLabel) sugarDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) sugarDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);

		commandPanel.add(sugarDropdown);
		sugarDropdown.revalidate();
		sugarDropdown.repaint();
		
		conesDropdown.setBounds(962, 330, 250, 60);
		conesDropdown.setFont(dropDownFont);
		conesDropdown.setBackground(Color.decode("#7CC6FE"));
		conesDropdown.setForeground(Color.decode("#1D1128"));
		conesDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		((JLabel) conesDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) conesDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);

		commandPanel.add(conesDropdown);
		conesDropdown.revalidate();
		conesDropdown.repaint();

		reputationDropdown.setBounds(962, 60, 250, 60);
		reputationDropdown.setFont(dropDownFont);
		reputationDropdown.setBackground(Color.decode("#7CC6FE"));
		reputationDropdown.setForeground(Color.decode("#1D1128"));
		reputationDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		((JLabel) reputationDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) reputationDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);

		commandPanel.add(reputationDropdown);
		reputationDropdown.revalidate();
		reputationDropdown.repaint();

		difficultyDropdown.setBounds(1237, 60, 250, 60);
		difficultyDropdown.setFont(dropDownFont);
		difficultyDropdown.setBackground(Color.decode("#7CC6FE"));
		difficultyDropdown.setForeground(Color.decode("#1D1128"));
		difficultyDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		((JLabel) difficultyDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) difficultyDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);

		commandPanel.add(difficultyDropdown);
		difficultyDropdown.revalidate();
		difficultyDropdown.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == execute) {
			setVisible(false);

		}
	}
}