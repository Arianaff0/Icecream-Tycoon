package application;
/**
 * @author Ariana Feng
 * Date: March 20, 2024
 */

public class Player {

    private String filename;
    private int balance;
    private String playerInitials;
    private int numIceCreams;
    public IngredientList inventory;
    public RecipeCreation recipe;

    private int diff;

    private int currentDay;


    /**
     *This is for the very first creation of the player! they will have predetermined values
     * @param user
     * @param diff
     * @param day
     */
    public Player(String filename,String user,int diff,int day){
        this.playerInitials = user;
        this.diff = diff;
        this.currentDay = day;
        this.filename = filename;
        // TODO: remember to change the diff and the user, this is hardcoded rn. - Kevin
        CSVFile newFile = new CSVFile(filename);
        newFile.CSVWriter(user,diff,1,0,0,0,0,0,0,0);
    }
    /**
     * Player Constructor
     * @param totalMoney
     * @param playerInitials
     */
    public Player(int balance, String playerInitials) {
        this.balance = balance;
        this.playerInitials = playerInitials;
        this.inventory = new IngredientList();
        this.recipe = new RecipeCreation();

    }

    public Player() {

    }

    /**
     * Getters and setters
     * @return
     */
    /////////////////////////////////////////////////////////////
    public void setBalance() {
        this.balance = balance;

    }
    ////////////////////////////////////////////////////////////

    /**
     * Used to change the player's balance during a transaction, refund or sale during the day
     *
     * @param price is either a positive or negative value
     * @param type checks what the balance change is for
     */
    public void changeBalance(int price, String type) {
        // If purchase, remove money from balance
        if (type == "purchase") {
            balance -= price;
        }
        // If refund or sale, increase money
        else if (type == "refund" || type == "sale"){
            balance += price;
        }
    }

    /**
     * Getters and setters
     * @return
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Getters and setters
     * @return
     */
    public int getNumIceCreams() {
        return numIceCreams;
    }

    /**
     * Getters and setters
     * @param Initials
     */
    public void setPlayerInitials(String Initials) {
        this.playerInitials = playerInitials;
    }

    /**
     * Getters and setters
     * @return
     */
    public String getPlayerInitials() {
        return playerInitials;
    }


}