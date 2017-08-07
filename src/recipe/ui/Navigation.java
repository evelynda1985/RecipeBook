package recipe.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

final class Navigation {
	static Stage navigationStage;
	public static final String FORMPATH = "Form.fxml";

	// Create a new stage and set the window title
	protected static void createStage() {
		navigationStage = new Stage();
		navigationStage.setTitle("Recipe System");
	}

	public static void opeWindow(String fxmlPath, boolean newStage) {
		Stage stage;
		if (newStage) {
			stage = new Stage();
			stage.setTitle("Recipe System");
		} else {
			stage = navigationStage;
			navigationStage.setTitle("Recipe System");
		}
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(Navigation.class.getResource(fxmlPath));
			Parent root1 = (Parent) fxmlLoader.load();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	// After login navigate the user to home screen
	protected static void goHome(Object o) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(o.getClass().getResource("Home.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			if (navigationStage == null) {
				createStage();
			}
			navigationStage.setScene(new Scene(root1));
			navigationStage.show();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	// After login navigate the user to Search screen
	protected static void goSearch(Object o) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(o.getClass().getResource("Search.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			if (navigationStage == null) {
				createStage();
			}
			navigationStage.setScene(new Scene(root1));
			navigationStage.show();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	// After login navigate the user to Recipe screen
	protected static void goRecipe(Object o) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(o.getClass().getResource("Recipe.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			if (navigationStage == null) {
				createStage();
			}
			navigationStage.setScene(new Scene(root1));
			navigationStage.show();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	protected static void goForm(Object o) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(o.getClass().getResource("Form.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			if (navigationStage == null) {
				createStage();
			}
			navigationStage.setScene(new Scene(root1));
			navigationStage.show();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	protected static void exitProgram(Object o) {
		navigationStage.close();
	}

}
