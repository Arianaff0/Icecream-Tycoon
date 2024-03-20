/**
 * This class stores each purchase that the player transacts from the Ingredient Selection screen <br>
 * Each transaction will be put on a stack so that players can undo their purchases<br><br>
 * 
 * The stack's contents should be cleared once the player starts the daytime cycle
 * 
 * @version 1.0.0
 * @author Matthew Molloy
 */
public class Transaction {
	private String ingredient;
	private int quantity;
	private int price;
	
	public Transaction(String ingredient, int quantity, int price) {
		this.ingredient = ingredient;
		this.quantity = quantity;
		this.price = price;
	}
	
	private String getIngredient() {
		return ingredient;
	}
	
	private int getQuantity() {
		return quantity;
	}
	
	private int getPrice() {
		return price;
	}
}
