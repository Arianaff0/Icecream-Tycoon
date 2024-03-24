/**
 * @author Ariana Feng
 * Date: March 20, 2024
 * sugiubguwribgriuwbgiuewbg
 */

public class Player {
    private int balance;
    private String playerInitials;
    private int numIceCreams;
    public IngredientList inventory;
    public RecipeCreation recipe;

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