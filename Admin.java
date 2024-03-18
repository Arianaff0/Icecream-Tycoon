import java.util.*;
import javax.swing.*;

public class Admin {
	
	
	/***
	 * This method reads in the command given by the administrator and sets the weather, day, and money accordingly
	 * @param cmd
	 */
	public void command(String cmd) {
		String[] cmdList = cmd.split(" ");
		
		if (cmdList[0].equalsIgnoreCase("setweather")){
			double tmp = cmdList[1];
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
