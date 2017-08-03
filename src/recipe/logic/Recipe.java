package recipe.logic;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
	List<Ingredient> ingredientList = new ArrayList<>();
	private String id;
	private String name;
	private String description;

	public Recipe(Ingredient ingredient, String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.ingredientList.add(ingredient);
	}

	public Recipe(String name, String description) {
		this.name = name;
		this.description = description;

	}

	public Recipe(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;

	}

	public Recipe(Ingredient ingredient, String name, String description) {
		this.name = name;
		this.description = description;
		this.ingredientList.add(ingredient);
	}

	public void addIngredient(Ingredient ingredeint) {
		this.ingredientList.add(ingredeint);
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		String ingString = "";
		for (Ingredient ing : this.ingredientList) {
			ingString += ing.toString();
		}
		return "Recipe id: " + this.id + " \n" + "Name: " + this.name + "Instrucciones " + this.description + ingString;
	}

	public List<Ingredient> getIngredientList() {
		return this.ingredientList;
	}

	public void setIngredients(List<Ingredient> ingredientList2) {
		this.ingredientList = ingredientList2;
	}

}
