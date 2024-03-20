/**
 * @author Ariana Feng
 * Date: March 20, 2024
 */

public class Player {
    private int totalMoney;
    private String playerInitials;
    private int numIceCreams;

    /**
     * Player Constructor
     * @param totalMoney
     * @param playerInitials
     */
    public Player(int totalMoney, String playerInitials) {
        this.totalMoney = totalMoney;
        this.playerInitials = playerInitials;
    }

    /**
     * Getters and setters
     * @return
     */
    /////////////////////////////////////////////////////////////
    public int setTotalMoney() {
        this.totalMoney = totalMoney;

    }
    ////////////////////////////////////////////////////////////

    /**
     * Getters and setters
     * @return
     */
    public int getTotalMoney() {
        return totalMoney;
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
