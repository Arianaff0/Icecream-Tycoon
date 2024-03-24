import java.util.*;
import javax.swing.*;

public class Admin {
	/**
	 * This is for Kevin : FIGURE OUT HOW SPRITES WORK FOR THE WEATHER RETURN
	 */
	
	
	/***
	 * This method reads in the command given by the administrator and sets the weather, day, and money accordingly
	 * @param cmd
	 */
	public void command(String cmd) {
		String[] cmdList = cmd.split(" ");
		String weather; // FIGURE OUT WHAT TO DO WITH THIS????????
		
		if (cmdList[0].equalsIgnoreCase("setweather")){ // got to make this into a button?
			Weather weather = new Weather; // work on this after (kevin) we need to ensure that it returns
											//the range, I really do not want to hard code this.
			double tmp = cmdList[1];
			if(tmp == 0){
				weather = "Freezing";
			}
			else if(tmp >0 && tmp <= 5){
				weather = "cold";
			} else if (tmp >6 && tmp <= 10) {
				weather = "cool";

			} else if (tmp >10 && tmp <= 15) {
				weather = "warm";
			} else if (tmp >15 && tmp <=20 ) {
				weather = "hot";
			}
			else{
				weather = "scolding hot";
			}

			// 
		}
		else if (cmdList[0].equalsIgnoreCase("setday")) {
			int day = cmdList[1];
			//
		}
		else if (cmdList[0].equalsIgnoreCase("setmoney")) {
			double money = cmdList[1];
			//
		}
		else if (cmdList[0].equalsIgnoreCase("setdifficulty")) {
			
		}
		else if (cmdList[0].equalsIgnoreCase("setreputation")) {
			
		}
	}
	
}