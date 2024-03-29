package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

@SuppressWarnings("serial")
public class ResultsScreen extends JFrame implements ActionListener {

	private JPanel panel = new JPanel();
	private JPanel resultsPanel = new JPanel();
	private JPanel separator = new JPanel();

	private JFXPanel fxpanel = new JFXPanel();

	private JLabel title = new JLabel("Results", SwingConstants.CENTER);

	private final String[] graphOptions = { "Reputation", "Profit" }; // rep v days (days x, profit y) and profit v days
																		// (proft y, days x)
	private JComboBox<String> graphDropdown = new JComboBox<String>(graphOptions);

	private Font startFont = new Font("Calibri", 1, 36);
	private Font dropDownLabelFont = new Font("Calibri", 1, 28);
	private Font titleFont = new Font("Calibri", 1, 96);

	private JLabel selectionLabel = new JLabel("Generate Graph");

	/**
	 * This constructor runs everything required in the TitleScreen. This method
	 * runs the frameSetup and assembleWindow methods. This method also catches
	 * exceptions thrown by these other helper methods.
	 */
	public ResultsScreen() {
		try {
			frameSetup();
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					assembleWindow();
				}
			});
			addLabelsAndDropDown();
			panel.repaint();
			revalidate();
			repaint();
		} catch (IOException e) {
			System.out.println("Error: IOException, error code 4.1");
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Error: Unknown exception, error code 4.2");
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
		panel.setBackground(Color.decode("#7CF3A0"));

		fxpanel.setBounds(549, 125, 1100, 650);
		fxpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

		add(fxpanel);
		add(panel);

		title.setBounds(230, 31, 1440, 100);
		title.setForeground(Color.BLACK);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		title.setFont(titleFont);

		resultsPanel.setBounds(250, 125, 300, 650);
		resultsPanel.setLayout(null);
		resultsPanel.setBackground(Color.decode("#FDC6D8"));
		resultsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

		panel.add(title);
		panel.add(resultsPanel);

		panel.setVisible(true);

	}

	private void addLabelsAndDropDown() {

		selectionLabel.setBounds(0, 4, 300, 60);
		selectionLabel.setForeground(Color.BLACK);
		selectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectionLabel.setVerticalAlignment(SwingConstants.CENTER);
		selectionLabel.setFont(startFont);
		resultsPanel.add(selectionLabel);

		graphDropdown.setBounds(25, 60, 250, 60);
		graphDropdown.setFont(dropDownLabelFont);
		graphDropdown.setBackground(Color.decode("#9FDBFE"));
		graphDropdown.setForeground(Color.decode("#1D1128"));
		graphDropdown.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		((JLabel) graphDropdown.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) graphDropdown.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);
		graphDropdown.setSelectedIndex(-1);

		graphDropdown.addActionListener(this);

		separator.setBounds(300, 0, 2, 650);
		separator.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		resultsPanel.add(separator);
		resultsPanel.add(graphDropdown);

		graphDropdown.revalidate();
		graphDropdown.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == graphDropdown && graphDropdown.getSelectedIndex() == 0) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					initFXIndex1(fxpanel);

				}
			});

			panel.repaint();
		} else if (e.getSource() == graphDropdown && graphDropdown.getSelectedIndex() == 1) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					initFXIndex2(fxpanel);

				}
			});

			panel.repaint();
		}

	}

	private static void initFXIndex1(JFXPanel fxPanel) {
		// This method is invoked on the JavaFX thread
		Scene scene = createSceneIndex1();
		fxPanel.setScene(scene);
		fxPanel.setVisible(true);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Scene createSceneIndex1() {

		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		Scene scene = new Scene(lineChart, 800, 600);

		xAxis.setLabel("Days");
		yAxis.setLabel("Reputation");
		// creating the chart

		lineChart.setTitle("Reputation over time");
		// defining a series
		XYChart.Series series = new XYChart.Series();

		series.setName("Reputation Marker");
		// populating the series with data
		
		

		for (int i = 0; i < 11; i++) {

			series.getData().add(new XYChart.Data(i, Results.repArray[i]));
		}
		lineChart.getData().add(series);

		return (scene);
	}

	private static void initFXIndex2(JFXPanel fxPanel) {
		// This method is invoked on the JavaFX thread
		Scene scene = createSceneIndex2();
		fxPanel.setScene(scene);
		fxPanel.setVisible(true);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Scene createSceneIndex2() {

		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		Scene scene = new Scene(lineChart, 800, 600);

		xAxis.setLabel("Days");
		yAxis.setLabel("Profit ($)");
		// creating the chart

		lineChart.setTitle("Profit over time");
		// defining a series
		XYChart.Series series = new XYChart.Series();

		series.setName("Profit Marker");
		// populating the series with data
		for (int i = 0; i < 11; i++) {

			series.getData().add(new XYChart.Data(i, Results.dayCash[i]));

		}
		lineChart.getData().add(series);

		return (scene);
	}

}