import java.awt.Image;
import java.awt.Point;

/**
 * @author Ariana Feng
 * Date: March 18,2024
 */
public class Sprite {
    private String spriteName;
    private Image spriteImage;
    private Image defaultSpriteImage;
    private Image spriteImageDest; //Image when the sprite is at the truck
    private double currReputation;
    private double moneyAllowance;
    private int spriteOpinion;

    private Point iceCreamTruck;
    private Point position;
    private long arrivalTime;
    private boolean isOnScreen; //flag for determining if the Sprite is on screen or not
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
     * Getters and setters
     * @return
     */
    private Image getDefaultSpriteImage() {
        return defaultSpriteImage;
    }

    /**
     * Getters and setters
     * @param spriteName
     */
    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }

    /**
     * Getters and setters
     * @return
     */
    public String getSpriteName() {
        return spriteName;
    }


    /**
     * Getters and setters
     * @param spriteImage
     */
    public void setSpriteImage(Image spriteImage) {
        this.spriteImage = spriteImage;
    }

    /**
     * Getters and setters
     * @return
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
     * @return
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
     * Getters and Setters
     * @param reputation
     */
    public void setReuptation(double reputation) {
        this.currReputation = reputation;
    }

    /**
     * Getters and setters
     * @return
     */
    public double getReputation() {
        return currReputation;
    }

    /**
     * Getters and setters
     * @param allowance
     */
    public void setAllowance(double allowance) {
        this.moneyAllowance = allowance;
    }

    /**
     * Getters and setters
     * @return
     */
    public double getAllowance() {
        return moneyAllowance;
    }

    /**
     * Getters and setters
     * @return
     */
    public int getOpinion() {
        return spriteOpinion;
    }

    /**
     * Getters and setters
     * @param opinion
     */
    private void setOpinion(int opinion) {
        this.spriteOpinion = opinion;
    }
}
