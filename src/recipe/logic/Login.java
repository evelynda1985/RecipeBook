package recipe.logic;

public class Login {
	
	public boolean loginStatus(String username, String password) {
		if (username.equals("admin") && password.equals("admin"))
			return true;
		else 
			return false;
		
	}

}
