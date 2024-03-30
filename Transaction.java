package application;
/**
 * This class stores each purchase that the player transacts from the Ingredient Selection screen <br>
 * Each transaction will be put on a stack so that players can undo their purchases<br><br>
 *
 * The stack's contents should be cleared once the player starts the daytime cycle
 *
 * @version 1.0.0
 * @author Matthew Molloy
 * CS2212 Spring 2024 term
 * Group 48
 * Prof. Servos
 * Monday April 5, 2024
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

    public String getIngredient() {
        return ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}