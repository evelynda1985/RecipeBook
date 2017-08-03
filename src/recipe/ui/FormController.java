package recipe.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import recipe.logic.Address;
import recipe.logic.AppContext;
import recipe.logic.Ingredient;

public class FormController {
	ObservableList<String> stateList = FXCollections.observableArrayList("Alabama", "Alaska", "Arizona", "Arkansas",
			"California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois",
			"Indiana", "Iowa", "Kansas", "Kentucky", " Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
			"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
			"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
			"Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", " Virginia",
			"Washington", "West Virginia", "Wisconsin", "Wyoming");

	ObservableList<String> measureList = FXCollections.observableArrayList("Onzas", "Pounds", "Spoons", "To taste");

	ObservableList<String> dishWithList = FXCollections.observableArrayList("Vegetable", "Meat", "Pork", "Chicken",
			"Fish");

	@FXML
	private TextField name_ingredient;

	@FXML
	private TextField amount_ingredient;

	@FXML
	private ChoiceBox dishwith;

	@FXML
	// private ChoiceBox measure_ingredient;
	private ChoiceBox<String> measure_ingredient = new ChoiceBox<>(this.stateList);

	@FXML
	private TextField address_ingredient;

	@FXML
	private TextField city_ingredient;

	@FXML
	// private ChoiceBox<?> state_ingredient;
	private ChoiceBox state_ingredient;

	@FXML
	private TextField zip_ingredient;

	@FXML
	private Button btn_saveingredient;

	@FXML
	private Button btn_cancel;

	@FXML
	private Label message;

	@FXML
	void message(MouseEvent event) {

	}

	@FXML
	void address_ingredient(ActionEvent event) {

	}

	@FXML
	void amount_ingredient(ActionEvent event) {

	}

	@FXML
	void brand_ingredient(ActionEvent event) {

	}

	// just go back to the recipe window
	@FXML
	void btn_cancel(ActionEvent event) throws Exception {
		Stage stage = (Stage) this.btn_cancel.getScene().getWindow();
		stage.close();

	}

	@FXML
	void btn_saveingredient(ActionEvent event) {

		Ingredient ingredient = new Ingredient(this.name_ingredient.getText(), this.amount_ingredient.getText(),
				this.measure_ingredient.getSelectionModel().getSelectedItem().toString(),
				this.dishwith.getSelectionModel().getSelectedItem().toString());

		Address address = new Address(this.address_ingredient.getText(), this.city_ingredient.getText(),
				this.state_ingredient.getSelectionModel().getSelectedItem().toString(), this.zip_ingredient.getText());

		ingredient.addAdress(address);
		RecipeController recipeController = (RecipeController) AppContext.getAppContext()
				.getParameter(AppContext.RECIPECONTROLLER);

		recipeController.addIngredient(ingredient);

		System.out.println(ingredient);

	}

	public TextField getName_ingredient() {
		return this.name_ingredient;
	}

	@FXML
	void city_ingredient(ActionEvent event) {

	}

	@FXML
	void measure_ingredient(MouseEvent event) {

	}

	@FXML
	void name_ingredient(ActionEvent event) {

	}

	@FXML
	void state_ingredient(MouseEvent event) {

	}

	@FXML
	private void initialize() {
		this.state_ingredient.setItems(this.stateList);
		this.state_ingredient.setValue("state");
		this.measure_ingredient.setItems(this.measureList);
		this.measure_ingredient.setValue("measure");
		this.dishwith.setItems(this.dishWithList);
		this.dishwith.setValue("dishWith");
	}

	@FXML
	void zip_ingredient(ActionEvent event) {

	}

	@FXML
	void dishwith(MouseEvent event) {

	}

}
