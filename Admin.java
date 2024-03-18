import java.util.*;
import javax.swing.*;

public class Admin {
	private String initials;
	private String password;
	
	public Admin(){
		initials = "";
		password = "";
	}
	
	public void setPassword(String pw){
		password = pw;
	}
	
	public void setInitials(String intl) {
		initials = intl;
	}
}
