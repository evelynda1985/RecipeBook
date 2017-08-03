package recipe.ui;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import recipe.database.DBFacade;
import recipe.logic.Recipe;

public class SearchController {

	@FXML
	private Pane meat;

	@FXML
	private TextField recipe_id;

	@FXML
	private TextField recipe_name;

	@FXML
	private Button btn_search;

	@FXML
	private Button btn_edit_recipe;

	@FXML
	private Button btn_delete_recipe;

	@FXML
	private Button btn_see_recipe;

	private ObservableList<Recipe> data;

	@FXML
	private TableView<Recipe> tblRecipesEntry;

	@FXML
	private TableColumn<Recipe, String> view_recipe_id;

	@FXML
	private TableColumn<Recipe, String> view_recipe_name;

	@FXML
	private TableColumn<Recipe, String> view_recipe_instructions;

	/*
	 * @FXML private TableColumn<Recipe, ?> view_recipe_ingredients;
	 */

	@FXML
	private Pagination pagination;

	@FXML
	void btn_delete_recipe(ActionEvent event) throws Exception {
		Navigation nv = new Navigation();
		nv.goRecipe(this);

	}

	@FXML
	void btn_edit_recipe(ActionEvent event) throws Exception {
		Navigation nv = new Navigation();
		nv.goRecipe(this);

	}

	@FXML
	void btn_search(ActionEvent event) {

		List<Recipe> rList = new DBFacade().getRecepies();

		this.view_recipe_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		this.view_recipe_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		this.view_recipe_instructions.setCellValueFactory(new PropertyValueFactory<>("description"));

		this.data = FXCollections.observableArrayList();
		this.data.addAll(rList);
		this.tblRecipesEntry.setItems(this.data);
	}

	@FXML
	void btn_see_recipe(ActionEvent event) throws Exception {
		Navigation nv = new Navigation();
		nv.goRecipe(this);

	}

	@FXML
	void meat(MouseEvent event) {

	}

	@FXML
	void pagination(MouseEvent event) {

	}

	@FXML
	void recipe_id(ActionEvent event) {

	}

	@FXML
	void recipe_name(ActionEvent event) {

	}

	@FXML
	void view_recipe_description(ActionEvent event) {

	}

	@FXML
	void view_recipe_id(ActionEvent event) {

	}

	@FXML
	void view_recipe_select(ActionEvent event) {

	}

}
