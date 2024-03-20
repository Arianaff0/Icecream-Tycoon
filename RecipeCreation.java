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

	
	public void setCream(double cream) {
		double numCream = getCream();
		if (cream <= numCream) {
			creamMes = cream;
		}
	}
	
	public void setSugar(double sugar) {
		double numSugar = getSugar();
		if (sugar <= numSugar) {
			sugarMes = sugar;
		}
	}
	
	public void setVanilla(double vanilla) {
		double numVanilla = getVanilla();
		if (vanilla <= numVanilla) {
			vanillaMes = vanilla;
		}
	}
	
	public void setConePrice(double price) {
		if (price <= maxConePrice && price >= minConePrice) {
			conePrice = price;
		}
	}
	
	public double getConePrice() {
		return conePrice;
	}
	
	
}
