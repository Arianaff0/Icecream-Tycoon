package application;
import java.util.*;
import javax.swing.*;


public class Price {
	final double priceRangeMin = 0.5; 
	final double priceRangeMax = 20;
	private double playerConePrice = 0;
	
	public Price() {
		playerConePrice = 0;
	}

	public double getPriceRangeMin() {
		return priceRangeMin;
	}
	
	public double getPriceRangeMax() {
		return priceRangeMax;
	}
	
	public void setPlayerConePrice(double price) {
		if (price >= priceRangeMin && price <= priceRangeMax) {
			playerConePrice = price;
		}
	}
	
	public double getPlayerConePrice() {
		return playerConePrice;
	}
}