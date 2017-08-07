package recipe.ui;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import recipe.database.DBFacade;
import recipe.logic.AppContext;
import recipe.logic.Ingredient;
import recipe.logic.IngredientEntry;
import recipe.logic.Recipe;

public class RecipeController {

	@FXML
	private TableView<IngredientEntry> tbl_ingredients;

	@FXML
	private TableColumn<IngredientEntry, String> tbl_name_column;

	@FXML
	private TableColumn<IngredientEntry, String> tbl_amount_column;

	@FXML
	private TableColumn<IngredientEntry, String> tbl_measure_column;

	@FXML
	private Button btn_addrecipe;

	@FXML
	private Button btn_editrecipe;

	@FXML
	private Button btn_addingredient;

	@FXML
	private TextArea recipe_description;

	@FXML
	private TextField recipe_name;

	@FXML
	private TextField recipe_id;

	@FXML
	private Label message;

	private ObservableList<IngredientEntry> data;

	@FXML
	void btn_addingredient(ActionEvent event) throws Exception {
		Navigation.opeWindow(Navigation.FORMPATH, true);

	}

	@FXML
	void btn_addrecipe(ActionEvent event) {
		Recipe recipe = new Recipe(this.recipe_name.getText(), this.recipe_description.getText());
		long id_recipe = 0;
		List<Ingredient> ingredientList = new ArrayList<>();
		for (IngredientEntry entry : this.data) {
			ingredientList.add(entry.getIngredient());
		}
		recipe.setIngredients(ingredientList);

		new DBFacade().registerNewRecipe(recipe, id_recipe);

		this.message.setText("Your recipe was successful created");
		// Navigation.goHome(this);
		// Navigation.goPopUp(this);
		Navigation.goSearch(this);
		System.out.println(">>>>>>>>>>>>>>" + this.recipe_name.getText());
		System.out.println(">>>>>>>>>>>>>>" + String.valueOf(id_recipe));
		System.out.println(">>>>>>>>>>>>>>" + this.recipe_description.getText());

	}

	@FXML
	void btn_ddrecipe(ActionEvent event) {

	}

	@FXML
	void btn_editrecipe(ActionEvent event) {

	}

	@FXML
	void recipe_description(MouseEvent event) {

	}

	@FXML
	void recipe_id(ActionEvent event) {

	}

	@FXML
	void recipe_name(ActionEvent event) {

	}

	@FXML
	void tbl_ingredients_id(ActionEvent event) {

	}

	@FXML
	void tbl_ingredients_measure(ActionEvent event) {

	}

	@FXML
	void tbl_ingredients_name(ActionEvent event) {

	}

	@FXML
	public void initialize() throws Exception {
		this.tbl_name_column.setCellValueFactory(new PropertyValueFactory<>("ingredientName"));
		this.tbl_amount_column.setCellValueFactory(new PropertyValueFactory<>("ingredientAmount"));
		this.tbl_measure_column.setCellValueFactory(new PropertyValueFactory<>("ingredientMeasure"));

		this.data = FXCollections.observableArrayList();
		this.tbl_ingredients.setItems(this.data);
		AppContext.getAppContext().putParameter(AppContext.RECIPECONTROLLER, this);
	}

	public void addIngredient(Ingredient ingredient) {
		IngredientEntry newIngredientEntry = new IngredientEntry(ingredient);
		this.data.add(newIngredientEntry);
	}

}
