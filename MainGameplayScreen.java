package application;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class MainGameplayScreen extends JFrame implements ActionListener {

    private int xPosBlackStart = 2015, xPosBlackEnd = -200;
    private int xPosBlueStart = 2026, xPosBlueEnd = -200;
    private int xPosRedStart = 2045, xPosRedEnd = -200;
    private int xPosGoldStart = 1909, xPosGoldEnd = -250;
    private int xPosGreenStart = 1962, xPosGreenEnd = -200;

    public Timer timer;

    private JPanel panel = new JPanel();

    private JPanel daysAndWeatherPanel = new JPanel();
    private JPanel inventoryPanel = new JPanel();
    private JPanel moneyPanel = new JPanel();

    private Font dayFont = new Font("Calibri", Font.BOLD, 70);
    private Font weatherFont = new Font("Calibri", Font.BOLD, 70);
    private Font moneyFont = new Font("Calibri", Font.BOLD, 70);
    private Font inventoryFont = new Font("Calibri", Font.BOLD, 50);
    private Font ingredientsFont = new Font("Calibri", Font.BOLD, 25);

    private JLabel moneyLabel = new JLabel();
    private JLabel inventoryLabel = new JLabel();
    private JLabel ingredientsLabel = new JLabel();

    private JLabel daysLabel = new JLabel();
    private JLabel weatherLabel = new JLabel();

    private JLabel bgPhoto = new JLabel(new ImageIcon("files/gameplaybg.png"));

    private JLabel buyBubble = new JLabel(new ImageIcon("files/buy.png"));
    private JLabel nobuyBubble = new JLabel(new ImageIcon("files/Dontbuy.png"));

    // pics of sprites
    private JLabel blackSprite = new JLabel(new ImageIcon("files/SpriteBlack1.png"));
    private JLabel blueSprite = new JLabel(new ImageIcon("files/SpriteBlue1.png"));
    private JLabel redSprite = new JLabel(new ImageIcon("files/SpriteRed1.png"));
    private JLabel goldSprite = new JLabel(new ImageIcon("files/SpriteGold1.png"));
    private JLabel greenSprite = new JLabel(new ImageIcon("files/SpriteGreen1.png"));

    private Player currentPlayer;

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
            this.currentPlayer = currentPlayer;

            daysLabel.setText("DAY " + currentPlayer.getDay());
            weatherLabel.setText(currentPlayer.getWeather()+ " °");
            moneyLabel.setText("$ " + currentPlayer.getBalance());
            inventoryLabel.setText("Inventory");
            ingredientsLabel.setText("<html>Cones: " + currentPlayer.inventory.getCones() + "<br>" +
                    "Cream: " + currentPlayer.inventory.getCream() + "<br>" +
                    "Sugar: " + currentPlayer.inventory.getSugar() + "<br>" +
                    "Vanilla: " + currentPlayer.inventory.getVanilla() + "</html>");

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
        inventoryPanel.setBounds(1600,250,300,235);
        inventoryPanel.setLayout(null);
        inventoryPanel.setBackground(new Color(39, 76, 119, 100));
        bgPhoto.add(inventoryPanel);

        panel.add(bgPhoto);
        daysAndWeatherPanel.setBounds(1600,0,300,235);
        daysAndWeatherPanel.setLayout(null);
        daysAndWeatherPanel.setBackground(new Color(39, 76, 119, 100));
        bgPhoto.add(daysAndWeatherPanel);

        panel.add(bgPhoto);
        moneyPanel.setBounds(1285,0,300,125);
        moneyPanel.setLayout(null);
        moneyPanel.setBackground(new Color(39, 76, 119, 100));
        bgPhoto.add(moneyPanel);

        bgPhoto.revalidate();
        bgPhoto.repaint();

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

        JLayeredPane daysBox = new JLayeredPane();
        daysBox.setBounds(1615, 15, 270, 95);
        daysBox.setOpaque(true);
        daysBox.setBackground(new Color(255, 255, 255, 75));
        bgPhoto.add(daysBox);
        bgPhoto.setComponentZOrder(daysBox, 0);

        daysLabel.setBounds(0, 15, 270, 95);
        daysLabel.setFont(dayFont);
        daysLabel.setForeground(Color.BLACK);
        daysLabel.setHorizontalAlignment(SwingConstants.CENTER);
        daysLabel.setVerticalAlignment(SwingConstants.CENTER);
        daysBox.add(daysLabel, JLayeredPane.PALETTE_LAYER);

        JLayeredPane weatherBox = new JLayeredPane();
        weatherBox.setBounds(1615, 125, 270, 95);
        weatherBox.setOpaque(true);
        weatherBox.setBackground(new Color(255, 255, 255, 75)); // White color with 150/255 transparency
        bgPhoto.add(weatherBox);
        bgPhoto.setComponentZOrder(weatherBox, 0);

        weatherLabel.setBounds(0, 15, 270, 95);
        weatherLabel.setFont(weatherFont);
        weatherLabel.setForeground(Color.BLACK);
        weatherLabel.setHorizontalAlignment(SwingConstants.CENTER);
        weatherLabel.setVerticalAlignment(SwingConstants.CENTER);
        weatherBox.add(weatherLabel, JLayeredPane.PALETTE_LAYER);

        JLayeredPane inventoryBox = new JLayeredPane();
        inventoryBox.setBounds(1615, 270, 270, 200);
        inventoryBox.setOpaque(true);
        inventoryBox.setBackground(new Color(255, 255, 255, 75));
        bgPhoto.add(inventoryBox);
        bgPhoto.setComponentZOrder(inventoryBox, 0);

        inventoryLabel.setBounds(0, 15, 270, 50);
        inventoryLabel.setFont(inventoryFont);
        inventoryLabel.setForeground(Color.BLACK);
        inventoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inventoryLabel.setVerticalAlignment(SwingConstants.CENTER);
        inventoryBox.add(inventoryLabel, JLayeredPane.PALETTE_LAYER);

        ingredientsLabel.setBounds(0, 55, 270, 150);
        ingredientsLabel.setFont(ingredientsFont);
        ingredientsLabel.setForeground(Color.BLACK);
        ingredientsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ingredientsLabel.setVerticalAlignment(SwingConstants.CENTER);
        inventoryBox.add(ingredientsLabel, JLayeredPane.PALETTE_LAYER);

        JLayeredPane moneyBox = new JLayeredPane();
        moneyBox.setBounds(1300, 15, 270, 95);
        moneyBox.setOpaque(true);
        moneyBox.setBackground(new Color(255, 255, 255, 75));
        moneyBox.setFont(moneyFont);
        bgPhoto.add(moneyBox);
        bgPhoto.setComponentZOrder(moneyBox, 0);

        moneyLabel.setBounds(0, 15, 270, 95);
        moneyLabel.setFont(moneyFont);
        moneyLabel.setForeground(Color.BLACK);
        moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        moneyLabel.setVerticalAlignment(SwingConstants.CENTER);
        moneyBox.add(moneyLabel, JLayeredPane.PALETTE_LAYER);

        panel.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

}