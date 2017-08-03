package recipe.logic;

import javafx.beans.property.SimpleStringProperty;

public class RecipeEntry {
	Recipe recipe;
	private SimpleStringProperty recipeId;
	private SimpleStringProperty recipeName;
	private SimpleStringProperty recipeInstructions;

	public RecipeEntry(Recipe recipe) {
		this.recipe = recipe;
		this.recipeId = new SimpleStringProperty(recipe.getId());
		this.recipeName = new SimpleStringProperty(recipe.getName());
		this.recipeInstructions = new SimpleStringProperty(recipe.getDescription());
	}

	public String getRecipeId() {
		return this.recipeId.getValueSafe();
	}

	public void setRecipeId(String recipeId) {
		this.recipeId.set(recipeId);
	}

	public String getRecipeName() {
		return this.recipeName.getValueSafe();
	}

	public void setRecipeName(String recipeName) {
		this.recipeName.set(recipeName);
	}

	public String getRecipeInstructions() {
		return this.recipeInstructions.getValueSafe();
	}

	public void setRecipeInstructions(String recipeInstructions) {
		this.recipeInstructions.set(recipeInstructions);
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

}
