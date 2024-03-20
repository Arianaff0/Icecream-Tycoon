import java.util.Stack;
/**
 * The main purpose of the IngredientList class is to store the amount of each ingredient. 
 * <p>
 * This class also handles the increases and decreases of each ingredient's reserves, and calculates
 * <p>
 * Current version 1.0.0 is the first implementation of the IngredientList class, and is likely subject to large changes
 * 
 * @version 1.0.0
 * @author Matthew Molloy
 */
public class IngredientList {
	
	/** Number of ice cream cones purchased*/
	private int numCones;
	/** Number of Cups of crean purchased*/
	private double numCream;
	/** Number of tablespoons of sugar purchased*/
	private double numSugar;
	/** Number of teaspoons of vanilla purchased*/
	private double numVanilla;
	/** Number of ice cream cones that can be sold to the public with current ingredients and ratios*/
	private int maxSellableProduct;
	/** Amount of money that the player has*/
	private int Balance;
	
	/** A stack that tracks the order in which  */
	private Stack<Transaction> transactions =  new Stack<Transaction>();
	/**
	 * IngredientList constructor method. 
	 * Sets all private variables to 0 (nothing has been purchased by the user the first time around)
	 */
	public IngredientList() {
		numCones = 0;
		numCream = 0;
		numSugar = 0;
		numVanilla = 0;
	}
	
	/**
	 * Sets numCones to an updated number of ice cream cones
	 * 
	 * @param numCones number of ice cream cones
	 * @return void
	 */
	public void addCones(int numCones, int price){
		if (true /*change to totalMoney < price*/ ) {  
			//totalMoney -= price
			this.numCones += numCones;
		}
		
		
	}
	
	/**
	 * Sets numCream to an updated number specified by the 'numCream' argument
	 * 
	 * @param numCream measurement of cream in cups
	 * @return void
	 */
	public void addCream(int numCream){
		this.numCream = (double)numCream;
	}
	
	/**
	 * Sets numSugar to an updated number specified by the 'numSugar' argument
	 * 
	 * @param numSugar measurement of cream in tablespoons
	 * @return void
	 */
	public void addSugar(int numSugar){
		this.numSugar = (double)numSugar;
	}
	
	/**
	 * Sets numVanilla to an updated number specified by the 'numVanilla' argument
	 * 
	 * @param numVanilla measurement of cream in cups
	 * @return void
	 */
	public void addVanilla(int numVanilla){
		this.numVanilla  = (double)numVanilla;
	}
	
	/**
	 * Returns the amount of Cones in the player's inventory
	 * 
	 * @return cones in inventory
	 */
	private double getCones(){
		return numCones;
	}
	
	/**
	 * Returns the amount of Cream in the player's inventory
	 * 
	 * @return cream in inventory
	 */
	private double getCream(){
		return numCream;
	}
	
	/**
	 * Returns the amount of Sugar in the player's inventory
	 * 
	 * @return Sugar in inventory
	 */
	private double getSugar(){
		return numSugar;
	}
	
	/**
	 * Returns the amount of Vanilla in the player's inventory
	 * 
	 * @return Vanilla in inventory 
	 */
	private double getVanilla(){
		return numVanilla;
	}
	
	/**
	 * Returns the amount of sellable ice cream cones to customers
	 * 
	 * The maxSellableProduct is reliant on the ratios of ingredients created in the RecipeCreation class
	 * 
	 * @return maximumn sellable ice cream cones
	 */
	private double getMaxSellableProduct(){
		return maxSellableProduct;
	}
	
}
