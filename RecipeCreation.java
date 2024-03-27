package application;
/**
 * RecipeCreation class handles the ratios of ingredients required to make an ice cream cone. 
 * <p>
 * It will incorporate signals from the sliders in the GUI to incr/decr the amount of <br>
 * cream, sugar, and vanilla will be in each ice cream cone. The class will additionally <br>
 * verify whether a recipe surpasses the quantity of any ingredient present in the player's <br>
 * inventory and consequently limit any further increment.
 * <p>
 * Current version 1.0.0 is the first implementation of the RecipeCreation class, and <br> 
 * is likely subject to large changes. Newer versions will be better defined in their <br>
 * communication between the IngredientList class, and GUI.
 * 
 * @version 1.0.0
 * @author Matthew Molloy
 * @author Sabrina Lee
 */
public class RecipeCreation {
	/** Stores the measurement of cream to be used in one cone */
	private double creamMes;
	/** Stores the measurement of sugar to be used in one cone */
	private double sugarMes;
	/** Stores the measurement of vanilla to be used in one cone */
	private double vanillaMes;
	
	final double maxConePrice = 10;
	final double minConePrice = 0;
	private double conePrice;

	public RecipeCreation() {
		creamMes = 0;
		sugarMes = 0;
		vanillaMes = 0;
		conePrice = 0;
	}
	
	/**
	 * Used to set cream measurement for recipe from RecipeCreationScreen.java
	 * @param cream
	 */
	public void setCreamMes(double cream) {
		creamMes = cream;
	}
	
	/**
	 * Returns the measurement of cream in the recipe
	 * 
	 * @return Cream in inventory
	 */
	public double getCreamMes() {
		return creamMes;
	}
	
	/**
	 * Used to set sugar measurement for recipe from RecipeCreationScreen.java
	 * @param sugar
	 */
	public void setSugarMes(double sugar) {
		sugarMes = sugar;
	}
	
	/**
	 * Returns the measurement of sugar in the recipe
	 * 
	 * @return Sugar in inventory
	 */
	public double getSugarMes() {
		return sugarMes;
	}
	
	/**
	 * Used to set vanilla measurement for recipe from RecipeCreationScreen.java
	 * @param vanilla
	 */
	public void setVanillaMes(double vanilla) {
		vanillaMes = vanilla;
	}
	
	/**
	 * Returns the measurement of vanilla in the recipe
	 * 
	 * @return Vanilla in inventory
	 */
	public double getVanillaMes() {
		return vanillaMes;
	}
	
	/**
	 * Used to set price for a cone of ice cream from RecipeCreationScreen.java
	 * @param price
	 */
	public void setConePrice(double price) {
		conePrice = price;
	}
	
	/**
	 * Returns the price for a cone of ice cream
	 * 
	 * @return Price for one cone of ice cream
	 */
	public double getConePrice() {
		return conePrice;
	}
	
	
}
