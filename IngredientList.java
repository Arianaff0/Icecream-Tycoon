import java.util.Stack;
/**
 * The main purpose of the IngredientList class is to store the amount of each ingredient. 
 * <p>
 * This class also handles the increases and decreases of each ingredient's reserves, and calculates
 * <p>
 * Current version 1.0.2 has some building the main methods of the class
 * 
 * @version 1.0.1
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
	 * @param price is how much transaction cost
	 * @return void
	 */
	public void addCones(int numCones, int price){
		if (true /*change to totalMoney < price*/ ) {
			/** Update respective qty and balance variables */
			Balance -= price;
			this.numCones += numCones;
			/** Create a transaction object and push it to the Transaction Stack*/
			Transaction transaction = new Transaction("Cone", numCones, price);
		}
	}
	
	/**
	 * Sets numCream to an updated number specified by the 'numCream' argument
	 * 
	 * @param numCream measurement of cream in cups
	 * @return void
	 */
	public void addCream(int numCream, int price){
		if (true /*change to totalMoney < price*/ ) {  
			Balance -= price;
			this.numCream += numCream;
			/** Create a transaction object and push it to the Transaction Stack*/
			Transaction transaction = new Transaction("Cream", numCream, price);
		}
	}
	
	/**
	 * Sets numSugar to an updated number specified by the 'numSugar' argument
	 * 
	 * @param numSugar measurement of cream in tablespoons
	 * @return void
	 */
	public void addSugar(int numSugar, int price){
		if (true /*change to totalMoney < price*/ ) {  
			Balance -= price;
			this.numSugar += numSugar;
			/** Create a transaction object and push it to the Transaction Stack*/
			Transaction transaction = new Transaction("Sugar", numSugar, price);
		}
	}
	
	/**
	 * Sets numVanilla to an updated number specified by the 'numVanilla' argument
	 * 
	 * @param numVanilla measurement of cream in cups
	 * @return void
	 */
	public void addVanilla(int numVanilla, int price){
		if (true /*change to totalMoney < price*/ ) {  
			Balance -= price;
			this.numVanilla += numVanilla;
			/** Create a transaction object and push it to the Transaction Stack*/
			Transaction transaction = new Transaction("Vanilla", numVanilla, price);
		}
	}
	
	/**
	 * Returns the amount of Cones in the player's inventory
	 * 
	 * @return cones in inventory
	 */
	public double getCones(){
		return numCones;
	}
	
	/**
	 * Returns the amount of Cream in the player's inventory
	 * 
	 * @return cream in inventory
	 */
	public double getCream(){
		return numCream;
	}
	
	/**
	 * Returns the amount of Sugar in the player's inventory
	 * 
	 * @return Sugar in inventory
	 */
	public double getSugar(){
		return numSugar;
	}
	
	/**
	 * Returns the amount of Vanilla in the player's inventory
	 * 
	 * @return Vanilla in inventory 
	 */
	public double getVanilla(){
		return numVanilla;
	}
	
	/**
	 * Returns the amount of sellable ice cream cones to customers
	 * 
	 * The maxSellableProduct is reliant on the ratios of ingredients created in the RecipeCreation class
	 * 
	 * @return maximumn sellable ice cream cones
	 */
	public double getMaxSellableProduct(){
		return maxSellableProduct;
	}
	
	/**
	 * When player pushes the "Undo Purchase" button pops the last transaction off the stack and
	 * refunds the player and decreases the quantity of the ingredient last pruchased.
	 * 
	 * If the stack is empty, do nothing.
	 */
	public void undoPurchase() {
		/** If transactions stack is empty, do some GUI stuff and exit*/
		if (transactions.isEmpty()) {
			// GUI METHOD
			return;
		}
		/** Otherwise, take the top Transaction object off the stack*/
		Transaction popped = transactions.pop();
		switch (popped.getIngredient()) {
		case "Cone":
			addCones(-1 * popped.getQuantity(), -1 * popped.getPrice());
			break;
		case "Cream":
			addCream(-1 * popped.getQuantity(), -1 * popped.getPrice());
			break;
		case "Sugar":
			addSugar(-1 * popped.getQuantity(), -1 * popped.getPrice());
			break;
		default:
			addCream(-1 * popped.getQuantity(), -1 * popped.getPrice());
			break;
		}
		return;
	}
	
}
