package application;
/**
 * @author Ariana Feng
 * Date: March 20, 2024
 */

public class Player {

    private String filename;
    private String playerInitials;
    private int difficulty;
    private int day; 
    private double weather;
    private double reputation;
    private double balance;
    private int numIceCreams;
    public IngredientList inventory;
    public RecipeCreation recipe;


    /**
     *This is for the very first creation of the player! they will have predetermined values
     * @param user
     * @param diff
     * @param day
     */
    public Player(String filename,String user,int diff,int day){
        this.playerInitials = user;
        this.difficulty = diff;
        this.day = day;
        this.filename = filename;
        // TODO: remember to change the diff and the user, this is hardcoded rn. - Kevin
        CSVFile newFile = new CSVFile(filename);
        // UserID, Difficulty, Day Num, Weather Num, Rep, Retained money, cones, Sugar, Vanilla, Cream
        newFile.CSVWriter(user,diff,1,0,0,0,0,0,0,0);
    }
    /**
     * Player Constructor
     * @param totalMoney
     * @param playerInitials
     */
    public Player(String filename, String playerInitials, int diff, int day, double weather, 
    		double reputation, double balance, int numCones, double numSugar, double numVanilla, double numCream) {
        // Store parameters into proper instance variables
        this.playerInitials = playerInitials;
        this.difficulty = diff;
        this.day = day;
        this.weather = weather;
        this.reputation = reputation;
        this.balance = balance;
        this.inventory = new IngredientList(numCones, numCream, numSugar, numVanilla);
        this.recipe = new RecipeCreation();
        
        // add the csv - Kevin Russel

    }
    
    /**
     * 
     * @param Sets the day of the game
     */
    public void setDay(int day) {
    	this.day = day;
    }
    
    /**
     * 
     * @return the current day
     */
    public int getDay() {
    	return day;
    }
    
    /**
     * 
     * @param weather rating
     */
    public void setWeather(double weather) {
    	this.weather = weather;
    }
    
    /**
     * 
     * @return the weather rating
     */
    public double getWeather() {
    	return weather;
    }
    
    /**
     * Getters and setters
     * @return
     */
    public void setBalance() {
        this.balance = balance;
    }

    /**
     * Used to change the player's balance during a transaction, refund or sale during the day
     *
     * @param price is either a positive or negative value
     * @param type checks what the balance change is for
     */
    public void changeBalance(double price, String type) {
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
     * 
     * @return Player's balance
     */
    public double getBalance() {
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