package recipe.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import recipe.logic.Login;

public class LoginController {

	@FXML
	private PasswordField password;

	@FXML
	private TextField username;

	@FXML
	private Button btn_signin;

	@FXML
	private Label msg_error;

	@FXML
	void password(ActionEvent event) {

	}

	@FXML
	void username(ActionEvent event) {

	}

	@FXML
	void btn_signin(ActionEvent event) throws Exception {
		Login login = new Login();

		if (login.loginStatus(this.username.getText(), this.password.getText())) {
			Navigation.goHome(this);
		} else {
			this.msg_error.setText("There is an error on your input");
		}
		Stage stage = (Stage) this.btn_signin.getScene().getWindow();
		stage.close();
	}

}
