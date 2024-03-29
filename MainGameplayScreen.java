package application;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainGameplayScreen extends JFrame implements ActionListener {

	private int xPosBlackStart = 2015, xPosBlackEnd = -200;
	private int xPosBlueStart = 2026, xPosBlueEnd = -200;
	private int xPosRedStart = 2045, xPosRedEnd = -200;
	private int xPosGoldStart = 1909, xPosGoldEnd = -250;
	private int xPosGreenStart = 1962, xPosGreenEnd = -200;

	public Timer timer;

	private JPanel panel = new JPanel();
	private JLabel bgPhoto = new JLabel(new ImageIcon("files/gameplaybg.png"));

	private JLabel buyBubble = new JLabel(new ImageIcon("files/buy.png"));
	private JLabel nobuyBubble = new JLabel(new ImageIcon("files/nobuy.png"));

	// pics of sprites
	private JLabel blackSprite = new JLabel(new ImageIcon("files/SpriteBlack1.png"));
	private JLabel blueSprite = new JLabel(new ImageIcon("files/SpriteBlue1.png"));
	private JLabel redSprite = new JLabel(new ImageIcon("files/SpriteRed1.png"));
	private JLabel goldSprite = new JLabel(new ImageIcon("files/SpriteGold1.png"));
	private JLabel greenSprite = new JLabel(new ImageIcon("files/SpriteGreen1.png"));

	// private boolean[] spriteOrder = MainGamePlayClass.SpriteOrder;
	private boolean[] spriteOrderTest = { true, false, true, false, true, false, true, false, true, false };

	/**
	 * This constructor runs everything required in the TitleScreen. This method
	 * runs the frameSetup and assembleWindow methods. This method also catches
	 * exceptions thrown by these other helper methods.
	 * @param currentPlayer 
	 */
	public MainGameplayScreen(Player currentPlayer) {
		try {
			frameSetup();
			assembleWindow();
			moveBlackSprite();
		} catch (IOException e) {
			System.out.println("Error: IOException, error code 10.1");
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Error: Unknown exception, error code 10.2");
			e.printStackTrace();
		}
	}

	private void moveBlackSprite() {

		// for black sprite
		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xPosBlackStart -= 10; // Adjust the speed of animation by changing this value
				timer.setDelay(10);
				if (xPosBlackStart == 1095) {

					buyBubble.setVisible(false);
					nobuyBubble.setVisible(false);
				}
				if (xPosBlackStart < xPosBlackEnd) {
					// Stop the animation when label moves out of the screen

					((Timer) e.getSource()).stop();
					moveBlueSprite();

				} else if (xPosBlackStart == 1115) {

					if (spriteOrderTest[0]) {

						buyBubble.setVisible(true);

						timer.setDelay(1000);

					} else {
						System.out.println("nobuy");
						nobuyBubble.setVisible(true);

						timer.setDelay(1000);

					}

				} else {
					blackSprite.setLocation(xPosBlackStart, 700);
				}
			}
		});
		timer.start();

	}

	private void moveBlueSprite() {

		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("in actionevent");
				xPosBlueStart -= 10; // Adjust the speed of animation by changing this value
				timer.setDelay(10);
				if (xPosBlueStart == 1096) {

					buyBubble.setVisible(false);
					nobuyBubble.setVisible(false);
				}
				if (xPosBlueStart < xPosBlueEnd) {
					// Stop the animation when label moves out of the screen

					((Timer) e.getSource()).stop();
					moveRedSprite();

				} else if (xPosBlueStart == 1116) {

					if (spriteOrderTest[1]) {

						buyBubble.setVisible(true);

						timer.setDelay(1000);

					} else {

						nobuyBubble.setVisible(true);

						timer.setDelay(1000);

					}

				} else {
					blueSprite.setLocation(xPosBlueStart, 700);
				}
			}
		});
		timer.start();
	}

	private void moveRedSprite() {

		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("in actionevent");
				xPosRedStart -= 10; // Adjust the speed of animation by changing this value
				timer.setDelay(10);
				if (xPosRedStart == 1095) {

					buyBubble.setVisible(false);
					nobuyBubble.setVisible(false);
				}
				if (xPosRedStart < xPosRedEnd) {
					// Stop the animation when label moves out of the screen

					((Timer) e.getSource()).stop();
					moveGoldSprite();

				} else if (xPosRedStart == 1115) {

					if (spriteOrderTest[2]) {

						buyBubble.setVisible(true);

						timer.setDelay(1000);

					} else {

						nobuyBubble.setVisible(true);

						timer.setDelay(1000);

					}

				} else {
					redSprite.setLocation(xPosRedStart, 700);
				}
			}
		});
		timer.start();
	}

	private void moveGoldSprite() {

		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("in actionevent");
				xPosGoldStart -= 10; // Adjust the speed of animation by changing this value
				timer.setDelay(10);
				if (xPosGoldStart == 1099) {

					buyBubble.setVisible(false);
					nobuyBubble.setVisible(false);
				}
				if (xPosGoldStart < xPosGoldEnd) {
					// Stop the animation when label moves out of the screen

					((Timer) e.getSource()).stop();
					moveGreenSprite();

				} else if (xPosGoldStart == 1119) {

					if (spriteOrderTest[3]) {

						buyBubble.setVisible(true);

						timer.setDelay(1000);

					} else {

						nobuyBubble.setVisible(true);

						timer.setDelay(1000);

					}

				} else {
					goldSprite.setLocation(xPosGoldStart, 700);
				}
			}
		});
		timer.start();
	}

	private void moveGreenSprite() {

		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("in actionevent");
				xPosGreenStart -= 10; // Adjust the speed of animation by changing this value
				timer.setDelay(10);
				if (xPosGreenStart == 1092) {

					buyBubble.setVisible(false);
					nobuyBubble.setVisible(false);
				}
				if (xPosGreenStart < xPosGreenEnd) {
					// Stop the animation when label moves out of the screen

					((Timer) e.getSource()).stop();
					moveBlackSpriteSecondTime();

				} else if (xPosGreenStart == 1112) {

					if (spriteOrderTest[4]) {

						buyBubble.setVisible(true);

						timer.setDelay(1000);

					} else {

						nobuyBubble.setVisible(true);

						timer.setDelay(1000);

					}

				} else {
					greenSprite.setLocation(xPosGreenStart, 700);
				}
			}
		});
		timer.start();
	}

	private void moveBlackSpriteSecondTime() {

		xPosBlackStart = 2015;
		xPosBlackEnd = -200;

		blackSprite.setBounds(xPosBlackStart, 700, 105, 200);

		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xPosBlackStart -= 10; // Adjust the speed of animation by changing this value
				timer.setDelay(10);
				if (xPosBlackStart == 1095) {

					buyBubble.setVisible(false);
					nobuyBubble.setVisible(false);
				}
				if (xPosBlackStart < xPosBlackEnd) {
					// Stop the animation when label moves out of the screen

					((Timer) e.getSource()).stop();
					moveBlueSpriteSecondTime();

				} else if (xPosBlackStart == 1115) {

					if (spriteOrderTest[5]) {

						buyBubble.setVisible(true);

						timer.setDelay(1000);

					} else {

						nobuyBubble.setVisible(true);

						timer.setDelay(1000);

					}

				} else {
					blackSprite.setLocation(xPosBlackStart, 700);
				}
			}
		});
		timer.start();
	}

	private void moveBlueSpriteSecondTime() {

		xPosBlueStart = 2026;
		xPosBlueEnd = -200;

		blueSprite.setBounds(xPosBlueStart, 700, 94, 200);

		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xPosBlueStart -= 10; // Adjust the speed of animation by changing this value
				timer.setDelay(10);
				if (xPosBlueStart == 1096) {

					buyBubble.setVisible(false);
					nobuyBubble.setVisible(false);
				}
				if (xPosBlueStart < xPosBlueEnd) {
					// Stop the animation when label moves out of the screen

					((Timer) e.getSource()).stop();
					moveRedSpriteSecondTime();

				} else if (xPosBlueStart == 1116) {

					if (spriteOrderTest[6]) {

						buyBubble.setVisible(true);

						timer.setDelay(1000);

					} else {

						nobuyBubble.setVisible(true);

						timer.setDelay(1000);

					}

				} else {
					blueSprite.setLocation(xPosBlueStart, 700);
				}
			}
		});
		timer.start();
	}

	private void moveRedSpriteSecondTime() {

		xPosRedStart = 2045;
		xPosRedEnd = -200;

		redSprite.setBounds(xPosRedStart, 700, 135, 200);

		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xPosRedStart -= 10; // Adjust the speed of animation by changing this value
				timer.setDelay(10);
				if (xPosRedStart == 1095) {

					buyBubble.setVisible(false);
					nobuyBubble.setVisible(false);
				}
				if (xPosRedStart < xPosRedEnd) {
					// Stop the animation when label moves out of the screen

					((Timer) e.getSource()).stop();
					moveGoldSpriteSecondTime();

				} else if (xPosRedStart == 1115) {

					if (spriteOrderTest[7]) {

						buyBubble.setVisible(true);

						timer.setDelay(1000);

					} else {

						nobuyBubble.setVisible(true);

						timer.setDelay(1000);

					}

				} else {
					redSprite.setLocation(xPosRedStart, 700);
				}
			}
		});
		timer.start();
	}

	private void moveGoldSpriteSecondTime() {

		xPosGoldStart = 1909;
		xPosGoldEnd = -250;
		goldSprite.setBounds(xPosGoldStart, 700, 211, 200);

		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("in actionevent");
				xPosGoldStart -= 10; // Adjust the speed of animation by changing this value
				timer.setDelay(10);
				if (xPosGoldStart == 1099) {

					buyBubble.setVisible(false);
					nobuyBubble.setVisible(false);
				}
				if (xPosGoldStart < xPosGoldEnd) {
					// Stop the animation when label moves out of the screen

					((Timer) e.getSource()).stop();
					moveGreenSpriteSecondTime();

				} else if (xPosGoldStart == 1119) {

					if (spriteOrderTest[8]) {

						buyBubble.setVisible(true);

						timer.setDelay(1000);

					} else {

						nobuyBubble.setVisible(true);

						timer.setDelay(1000);

					}

				} else {
					goldSprite.setLocation(xPosGoldStart, 700);
				}
			}
		});
		timer.start();
	}

	private void moveGreenSpriteSecondTime() {
		xPosGreenStart = 1962;
		xPosGreenEnd = -200;
		greenSprite.setBounds(xPosGreenStart, 700, 158, 200);
		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("in actionevent");
				xPosGreenStart -= 10; // Adjust the speed of animation by changing this value
				timer.setDelay(10);
				if (xPosGreenStart == 1092) {

					buyBubble.setVisible(false);
					nobuyBubble.setVisible(false);
				}
				if (xPosGreenStart < xPosGreenEnd) {
					// Stop the animation when label moves out of the screen

					((Timer) e.getSource()).stop();
					
					///
					///
					///
					System.out.println("new results screen");
					setVisible(false);
					new ResultsScreen();
					///
					///
					///

				} else if (xPosGreenStart == 1112) {

					if (spriteOrderTest[9]) {

						buyBubble.setVisible(true);

						timer.setDelay(1000);

					} else {

						nobuyBubble.setVisible(true);

						timer.setDelay(1000);

					}

				} else {
					greenSprite.setLocation(xPosGreenStart, 700);
				}
			}
		});
		timer.start();
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

		add(panel);

		bgPhoto.setBounds(0, 0, 1920, 1080);

		panel.add(bgPhoto);

		blackSprite.setBounds(xPosBlackStart, 700, 105, 200);
		bgPhoto.add(blackSprite);

		blueSprite.setBounds(xPosBlueStart, 700, 94, 200);
		bgPhoto.add(blueSprite);

		redSprite.setBounds(xPosRedStart, 700, 135, 200);
		bgPhoto.add(redSprite);

		goldSprite.setBounds(xPosGoldStart, 700, 211, 200);
		bgPhoto.add(goldSprite);

		greenSprite.setBounds(xPosGreenStart, 700, 158, 200);
		bgPhoto.add(greenSprite);
		
		buyBubble.setBounds(1115, 485, 200, 200);
		bgPhoto.add(buyBubble);
		buyBubble.setVisible(false);
		nobuyBubble.setBounds(1120, 485, 200, 200);
		bgPhoto.add(nobuyBubble);
		nobuyBubble.setVisible(false);

		panel.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}