package application;
import java.util.Stack;
/**
 * The main purpose of the IngredientList class is to store the amount of each ingredient. 
 * <p>
 * This class also handles the increases and decreases of each ingredient's reserves, and calculates the amound <br>
 * of ice cream that can be served to customers during the daytime cycle.
 * <p>
 * Current version 1.0.3 has converted all "add__" methods to "change__Qty" to handle purchases, refunds and sales
 * 
 * @version 1.0.3
 * @author Matthew Molloy
 */
public class IngredientList {
	
	/** Number of ice cream cones purchased*/
	private int numCones;
	/** Number of Cups of cream purchased*/
	private double numCream;
	/** Number of tablespoons of sugar purchased*/
	private double numSugar;
	/** Number of teaspoons of vanilla purchased*/
	private double numVanilla;
	/** Number of ice cream cones that can be sold to the public with current ingredients and ratios*/
	private int maxSellableProduct;
	
	/** A stack that tracks the order in which ingredients were purchased */
	private Stack<Transaction> transactionStack =  new Stack<Transaction>();
	/**
	 * IngredientList constructor method. 
	 * Sets all private variables to 0 (nothing has been purchased by the user the first time around)
	 */
	
	/** simply a placeholder for the currentPlayer variable*/
	private Player currentPlayer = GameLauncher.currentPlayer;
			
	public IngredientList() {
		numCones = 0;
		numCream = 0;
		numSugar = 0;
		numVanilla = 0;
	}
	
	/**
	 * Updates number of ice cream cones depending on reason for change
	 * 
	 * @param numCones number of ice cream cones
	 * @param price is how much transaction cost
	 * @param transactionType checks if this was a purchase (true) or refund (false)
	 * @return void
	 */
	public void changeConeQty(int numCones, int price, String type){
		// Purpose of change
		switch (type) {
		case "purchase":
			if (currentPlayer.getBalance() >= price) {
				currentPlayer.changeBalance(price, type);
				this.numCones += numCones;
				
				// Create transaction object and push onto the transactionStack
				Transaction purchase = new Transaction("Cone", numCones, price);
				transactionStack.push(purchase);
			}
			break;
		
		case "refund":
			currentPlayer.changeBalance(price, type);
			this.numCones -= numCones;
			break;
		
		// Default case is a sale
		default:
			currentPlayer.changeBalance(price, type);
			this.numCones -= numCones;
		}
	}
	
	/**
	 * Sets numCream to an updated number specified by the 'numCream' argument
	 * 
	 * @param numCream measurement of cream in cups
	 * @return void
	 */
	public void changeCreamQty(int numCream, int price, String type){
		// Purpose of change
		switch (type) {
		case "purchase":
			if (currentPlayer.getBalance() >= price) {
				currentPlayer.changeBalance(price, type);
				this.numCream += numCream;
				
				// Create transaction object and push onto the transactionStack
				Transaction purchase = new Transaction("Cream", numCream, price);
				transactionStack.push(purchase);
			}
			break;
		
		case "refund":
			currentPlayer.changeBalance(price, type);
			this.numCream -= numCream;
			break;
		
		// Default case is a sale
		default:
			currentPlayer.changeBalance(price, type);
			this.numCream -= numCream;
		}
	}
	
	/**
	 * Sets numSugar to an updated number specified by the 'numSugar' argument
	 * 
	 * @param numSugar measurement of cream in tablespoons
	 * @return void
	 */
	public void changeSugarQty(int numSugar, int price, String type){
		// Purpose of change
		switch (type) {
		case "purchase":
			if (currentPlayer.getBalance() >= price) {
				currentPlayer.changeBalance(price, type);
				this.numSugar+= numSugar;
				
				// Create transaction object and push onto the transactionStack
				Transaction purchase = new Transaction("Sugar", numSugar, price);
				transactionStack.push(purchase);
			}
			break;
		
		case "refund":
			currentPlayer.changeBalance(price, type);
			this.numSugar -= numSugar;
			break;
		
		// Default case is a sale
		default:
			currentPlayer.changeBalance(price, type);
			this.numSugar -= numSugar;
		}
	}
	
	/**
	 * Sets numVanilla to an updated number specified by the 'numVanilla' argument
	 * 
	 * @param numVanilla measurement of cream in cups
	 * @return void
	 */
	public void changeVanillaQty(int numVanilla, int price, String type){
		// Purpose of change
		switch (type) {
		case "purchase":
			if (currentPlayer.getBalance() >= price) {
				currentPlayer.changeBalance(price, type);
				this.numVanilla += numVanilla;
				
				// Create transaction object and push onto the transactionStack
				Transaction purchase = new Transaction("Vanilla", numVanilla, price);
				transactionStack.push(purchase);
			}
			break;
		
		case "refund":
			currentPlayer.changeBalance(price, type);
			this.numVanilla -= numVanilla;
			break;
		
		// Default case is a sale
		default:
			currentPlayer.changeBalance(price, type);
			this.numVanilla -= numVanilla;
		}
	}
	
	/**
	 * Returns the amount of Cones in the player's inventory
	 * 
	 * @return cones in inventory
	 */
	public int getCones(){
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
	 * Used to set cones at beginning of profile load
	 * @param numCones
	 */
	public void setCones(int numCones) {
		this.numCones = numCones;
	}
	
	/**
	 * Used to set cream at beginning of profile load
	 * @param numCream
	 */
	public void setCream(double numCream) {
		this.numCream = numCream;
	}
	
	/**
	 * Used to set sugar at beginning of profile load
	 * @param numSugar
	 */
	public void setSugar(double numSugar) {
		this.numSugar = numSugar;
	}
	
	/**
	 * Used to set vanilla at beginning of profile load
	 * @param numVanilla
	 */
	public void setVanilla(double numVanilla) {
		this.numVanilla = numVanilla;
	}
	
	/**
	 * Returns the amount of sellable ice cream cones to customers
	 * 
	 * The maxSellableProduct is reliant on the ratios of ingredients created in the RecipeCreation class
	 * 
	 * @return maximumn sellable ice cream cones
	 */
	public int getMaxSellableProduct(){
		/** The amount of each ingredient that can be portioned by the recipe*/
		int amtCream = (int) Math.floor(numCream / currentPlayer.recipe.getCreamMes());
		int amtSugar = (int) Math.floor(numSugar / currentPlayer.recipe.getSugarMes());
		int amtVanilla = (int) Math.floor(numVanilla / currentPlayer.recipe.getVanillaMes());

		if (amtCream < 1 || amtSugar < 1 || amtVanilla < 1 || numCones < 1) {
			maxSellableProduct = 0;
		}
		else {
			/** The limiting variable determines how many ice creams can actually be made*/
			maxSellableProduct = Math.min(Math.min(amtCream, amtSugar), Math.min(numCones, amtVanilla));
		}
		return maxSellableProduct;
	}
	
	/**
	 * When player pushes the "Undo Purchase" button pops the last transaction off the stack, refunding 
	 * the player and decreasing the quantity of the ingredient last purchased.
	 * 
	 * If the stack is empty, do nothing.
	 */
	public void undoPurchase() {
		/** If transactions stack is empty, do some GUI stuff and exit*/
		if (transactionStack.isEmpty()) {
			// GUI METHOD
			return;
		}
		/** Otherwise, take the top Transaction object off the stack*/
		Transaction popped = transactionStack.pop();
		switch (popped.getIngredient()) {
		case "Cone":
			changeConeQty(popped.getQuantity(), popped.getPrice(), "refund");
			break;
		case "Cream":
			changeCreamQty(popped.getQuantity(), popped.getPrice(), "refund");
			break;
		case "Sugar":
			changeSugarQty(popped.getQuantity(), popped.getPrice(), "refund");
			break;
		default:
			changeVanillaQty(popped.getQuantity(), popped.getPrice(), "refund");
			break;
		}
		return;
	}
	
}