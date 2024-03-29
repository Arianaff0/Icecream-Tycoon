
/**
 * This class is used to set the reputation of the storefront. This can be used as a multiplier for either buying the
 * product.
 * Or after buying, the sprite can give the shop more reputation or less depending on wheter it likes the ice creme or not.
 * TO- DO: we are going to make this an addivite multiplier instead of multiplicative. Probably easier
 * TO-DO make the graphic for the multipler.
 */

package application;
public class Reputation {

    private double currReputation;


    // constructor of this class that sets the current reputation to 0.
    public Reputation(){
        currReputation = 0;
    }

    public void setReputation (double Rep){
        this.currReputation =  currReputation+ Rep;
    }
    public Reputation(double rep){
        this.currReputation = rep;
    }





    /**
     * this class sets the reputation of the shop
     * @param num, this is how much the currReputation is going to change by.
     * @return void.
     */


    /**
     * Method that returns the reputation
     * @return the reputation
     */
    public double getReputation(){
    return currReputation;
    }

}
