package recipe.logic;

import javafx.beans.property.SimpleStringProperty;

public class IngredientEntry {
	Ingredient ingredient;

	private SimpleStringProperty ingredientName;
	private SimpleStringProperty ingredientMeasure;
	private SimpleStringProperty ingredientAmount;

	public IngredientEntry(Ingredient ingredient) {
		this.ingredient = ingredient;
		this.ingredientName = new SimpleStringProperty(ingredient.getName());
		this.ingredientMeasure = new SimpleStringProperty(ingredient.getMeasure());
		this.ingredientAmount = new SimpleStringProperty(ingredient.getAmount());
	}

	public String getIngredientName() {
		return this.ingredientName.getValueSafe();
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName.set(ingredientName);
	}

	public String getIngredientMeasure() {
		return this.ingredientMeasure.getValueSafe();
	}

	public void setIngredientMeasure(String ingredientMeasure) {
		this.ingredientMeasure.set(ingredientMeasure);
	}

	public String getIngredientAmount() {
		return this.ingredientAmount.getValueSafe();
	}

	public void setIngredientAmount(String ingredientAmount) {
		this.ingredientAmount.set(ingredientAmount);
	}

	public Ingredient getIngredient() {
		return this.ingredient;
	}

}
