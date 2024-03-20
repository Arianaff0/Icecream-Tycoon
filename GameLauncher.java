/**
 * @author Lukas Bozinov
 */
public class GameLauncher {
	/** Initialize the three player/profiles objects that will be used */
	public static Player player1;
	public static Player player2;
	public static Player player3;
	/** can be used as a bases for method calls instead of player1,2,3*/
	public static Player currentPlayer;
	
	/**
	 * This method is the main method of the program. 
	 * This is what needs to be compiled and run for the program to execute.
	 */
	public static void main(String[] args) {
		new TitleScreen();
	}

}
