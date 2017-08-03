package recipe.logic;

import java.util.HashMap;
import java.util.Map;

//Class to update ingredients into the recipe controller
public class AppContext {
	private static AppContext appContext;
	private Map<String, Object> parameters;

	public static final String RECIPECONTROLLER = "RECIPECONTROLLER";

	// singleton pattern
	private AppContext() {
		this.parameters = new HashMap<>(); // it's not part of the singleton
											// patern
	}

	// method who verify if the appContext exist.
	public static AppContext getAppContext() {
		if (appContext == null) {
			appContext = new AppContext();
		}
		return appContext;
	}

	public void putParameter(String recipecontroller2, Object recipeController3) {
		this.parameters.put(recipecontroller2, recipeController3);
	}

	public Object getParameter(String key) {
		return this.parameters.get(key);

	}

}
