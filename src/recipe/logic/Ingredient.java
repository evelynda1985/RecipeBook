package recipe.logic;

import static java.lang.Math.toIntExact;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {
	List<Address> address = new ArrayList<>();
	private int id;
	private int recipe_id;
	private String name;
	private String amount;
	private String measure;
	private String dishWith;
	private String brand;

	public Ingredient(String name, String amount, String measure, String dishWith) {
		this.name = name;
		this.amount = amount;
		this.measure = measure;
		this.dishWith = dishWith;
	}

	public Ingredient(long recipe_id, String name, String amount, String measure) {
		this.recipe_id = toIntExact(recipe_id);
		this.name = name;
		this.amount = amount;
		this.measure = measure;
	}

	public Ingredient(String name, String amount, String measure) {
		this.name = name;
		this.amount = amount;
		this.measure = measure;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getMeasure() {
		return this.measure;
	}

	public String getDishWith() {
		return this.dishWith;
	}

	public void addAdress(Address address) {
		this.address.add(address);
	}

	@Override
	public String toString() {
		String addressString = this.address.get(0).toString();

		/*
		 * for(Address oneAddress:address){ addressString +=
		 * oneAddress:address.toString(); }
		 */
		return this.id + " " + "Ingredient: " + this.name + "\n" + "Amount: " + this.measure + "\n" + "Brand: " + "\n"
				+ "Type of ingredient: " + this.dishWith + "\n" + addressString;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getTBL_RECIPES_ID() {
		return this.recipe_id;
	}

	public String getBrand() {
		return this.brand;
	}

}
