package recipe.ui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

	public class HomeController {

	    @FXML
	    private Button btn_editrecipe;

	    @FXML
	    private Button btn_myrecipes;

	    @FXML
	    private Button btn_addrecipe;

	    @FXML
	    private Button btn_deleterecipe;

	    @FXML
	    void btn_addrecipe(ActionEvent event) throws Exception{
			Navigation nva = new Navigation();
			nva.goRecipe(this);
	    }

	    @FXML
	    void btn_deleterecipe(ActionEvent event) throws Exception{
			Navigation nv = new Navigation();
			nv.goSearch(this);
	    }

	    @FXML
	    void btn_editrecipe(ActionEvent event) throws Exception{
			Navigation nve = new Navigation();
			nve.goSearch(this);
	    	
	    }

	    @FXML
	    void btn_myrecipes(ActionEvent event) throws Exception{
			Navigation nvd = new Navigation();
			nvd.goSearch(this);
	    }

}
	

