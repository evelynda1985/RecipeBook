package recipe.logic;

import java.util.ArrayList;
import java.util.List;

public class RecipeRecord {
	List<Recipe> recipeList = new ArrayList<Recipe>();

	public List<Recipe> getRecipeList() {
		return this.recipeList;
	}

	public void addRecipe(Recipe recipe) {
		this.recipeList.add(recipe);
	}

}
