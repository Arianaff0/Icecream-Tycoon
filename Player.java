package application;
/**
 * @author Ariana Feng
 * Date: March 20, 2024
 */

public class Player {

    private String filename;
    private double balance;
    private String playerInitials;
    private int difficulty;
    private int day; 
    private double weather;
    private double reputation;
    private int diff;
    private int currentDay;
    public IngredientList inventory;
    public RecipeCreation recipe;

    private CSVFile newFile;

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
        this.weather = 0;
        this.reputation = 0;
        this.balance = 30;
        inventory = new IngredientList(this);
        
        this.recipe = new RecipeCreation();
        this.filename = filename;

        // TODO: remember to change the diff and the user, this is hardcoded rn. - Kevin
        newFile = new CSVFile(filename);
        // UserID, Difficulty, Day Num, Weather Num, Rep, Balance, cones, Sugar, Vanilla, Cream
        newFile.CSVWriter(user,diff,1,0,0,30,0,0,0,0);
        


    }
    /**
     * Player Constructor for an existing profile
     * @param balance
     * @param playerInitials
     */
    public Player(String filename, String playerInitials, int diff, int day, double weather, 
    		double reputation, double balance, int numCones, double numSugar, double numVanilla, double numCream) {
        this.balance = balance;
        this.playerInitials = playerInitials;
        this.diff = diff;
        this.currentDay = day;
        this.weather = weather;
        this.reputation = reputation;
        this.balance = balance;
        this.inventory = new IngredientList(numCones, numCream, numSugar, numVanilla);
        this.recipe = new RecipeCreation();
    }

    /**
     * 
     * @return
     */
    public CSVFile getNewFile(){
        return newFile;
    }
    
    /**
     * Getters and setters
     * @return
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Getters and setters
     * @return
     */
    public double getBalance() {
        return balance;
    }
    
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