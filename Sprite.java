package application;
import java.awt.Image;
import java.awt.Point;

/**
 * This class represents attributes of each sprite and their behaviour. <b>
 * Attributes include the sprite's opinion of the icecream cost, the amount <b>
 * of money it is allowed to use on a purchase, visual aspects of the sprite <b>
 * on screen.
 * <p>
 * 
 * @author Ariana Feng
 * CS2212 Spring 2024 term
 * Group 48
 * Prof. Servos
 * Monday April 5, 2024
 */
public class Sprite {
	/** represents the name of the sprite */
    private String spriteName;
    /** the on screen image of the sprite */
    private Image spriteImage;
    /** the image of the sprite when moving across screen */
    private Image defaultSpriteImage;
    /** the image of the sprite when at the icecream truck */
    private Image spriteImageDest; 
    /** the reputation that is judged by the sprite*/
    private double currReputation;
    /** the allowance of spending by the sprite */
    private double moneyAllowance;
    /** the sprite's opinion of the price of icecream */
    private int spriteOpinion;

    /** the on screen location where the sprite will stop for icecream */
    private Point iceCreamTruck;
    /** represents a point on screen */
    private Point position;
    /** the time  for arrival of the sprite */
    private long arrivalTime;
    /** determines if the sprite is visible on screen*/
    private boolean isOnScreen; 
    /** width of the screen, to be kept constant */
    private static final int SCREEN_WIDTH = 1920;


    /**
     * Sprite Constructor
     * @param spriteName
     * @param defaultSpriteImage
     * @param spriteImageDest
     * @param moneyAllowance
     * @param iceCreamTruck
     * @param position
     * @param arrivalTime
     */
    public Sprite(String spriteName, Image defaultSpriteImage, Image spriteImageDest, double moneyAllowance, Point iceCreamTruck, Point position, long arrivalTime) {
        this.spriteName = spriteName;
        this.spriteImage = getDefaultSpriteImage();
        this.defaultSpriteImage = defaultSpriteImage;
        this.spriteImageDest = spriteImageDest;
        this.currReputation = 0.0;
        this.moneyAllowance = moneyAllowance;
        this.spriteOpinion = 0;
        this.iceCreamTruck = iceCreamTruck;
        this.position = position;
        this.isOnScreen = false; //All Sprites are initially not going to be on screen (glide into view)
        this.arrivalTime = arrivalTime;
    }

    /**
     * Returns the default sprite image
     * @return defaultSpriteImage
     */
    private Image getDefaultSpriteImage() {
        return defaultSpriteImage;
    }

    /**
     * Sets the image of the sprite at the destination
     * @param spriteImageDest
     */
    public void setSpriteImageDest(Image spriteImageDest) {
        this.spriteImageDest = spriteImageDest;
    }

    /**
     * Returns the image of the sprite at the destination
     * @return spriteImageDest
     */
    public Image getSpriteImageDest() {
        return spriteImageDest;
    }

    /**
     * Sets the name of the sprite
     * @param spriteName
     */
    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }

    /**
     * Returns the name of the sprite
     * @return spriteName
     */
    public String getSpriteName() {
        return spriteName;
    }


    /**
     * Sets the image of the sprite
     * @param spriteImage
     */
    public void setSpriteImage(Image spriteImage) {
        this.spriteImage = spriteImage;
    }

    /**
     * Returns the image of the sprite
     * @return spriteImage
     */
    public Image getSpriteImage() {
        return spriteImage;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Method to move the sprites across the screen. Only stopping at the iceCream Truck.
     * Checks to see if Sprite is on or off-screen, then flag is set, and we move Sprite to be on screen for further actions.
     *      Further Actions:
     *      1) Calculate the distance between destination(truck) and Sprite. Y coordinates not in consideration
     *         because predefined path set to horizontal
     *      2) Once at destination(truck), Sprite stops for 2 seconds, image is changed.
     *      3) After 2 seconds, Sprite image changes back to original, and we increment x coordinate until Sprite goes off-screen.
     */
    public void moveSprite() {
        if (!isOnScreen) {
            position.setLocation(position.getX() + 1.0, 0); //the X coordinate is increased by 1 unit for Sprite to be on screen.

            //checking if the sprite is on screen
            if (position.getX() >= 0) {
                isOnScreen = true;
            }
        } else {
            //this is to calculate the distance between the distance from starting point and icecream truck
            double dx = iceCreamTruck.getX() - position.getX();
            double distance = Math.abs(dx);  //may have to change later because the sprite needs to go offscreen, cant be absolute

            double speed = 1.0;
            while (!spriteIsAtDestination()) {
                position.setLocation(position.getX() +1.0, 0);
            }
            if (spriteIsAtDestination()) {
                //if Sprite is at the truck we have to check how long the Sprite stayed there for. (Stay for 2 seconds and then leave the truck)
                if (arrivalTime== -1) {
                    arrivalTime = System.currentTimeMillis();
                    changeSpriteImage();
                }
                else if (System.currentTimeMillis()- arrivalTime >= 2000) {
                    spriteImage = defaultSpriteImage;

                    //moving the sprite off screen
                    while (position.getX() <= SCREEN_WIDTH) {
                        position.setLocation(position.getX()+1.0, 0);
                    }
                    isOnScreen = false;
                }
            }
        }
    }


    /**
     * Boolean method, is the sprite at the icecream truck? True or False.
     * @return true if the sprite is at the icecream truck or false otherwise
     */
    private boolean spriteIsAtDestination() {
        return position.equals(iceCreamTruck);
    }

    /**
     * Method to change Sprite Image to the destination image.
     */
    public void changeSpriteImage() {
        spriteImage = spriteImageDest;
    }

    /**
     * Sets the reputation 
     * @param reputation
     */
    public void setReuptation(double reputation) {
        this.currReputation = reputation;
    }

    /**
     * Returns the reputation
     * @return currReputation
     */
    public double getReputation() {
        return currReputation;
    }

    /**
     * Sets the amount a sprite is allowed to spend on an icecream
     * @param allowance
     */
    public void setAllowance(double allowance) {
        this.moneyAllowance = allowance;
    }

    /**
     * Returns the amount the sprite is allowed to spend on an icecream
     * @return moneyAllowance
     */
    public double getAllowance() {
        return moneyAllowance;
    }

    /**
     * Returns sprite opinion of price of icecream
     * @return SpriteOpinion 
     */
    public int getOpinion() {
        return spriteOpinion;
    }

    /**
     * Sets sprite opinion of price of icecream
     * @param opinion
     */
    private void setOpinion(int opinion) {
        this.spriteOpinion = opinion;
    }
}