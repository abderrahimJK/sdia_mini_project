package ma.enset.sdia_mini_project.presentation.controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ma.enset.sdia_mini_project.presentation.models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public TextField email_txt;
    public TextField password_txt;
    public FontAwesomeIconView close_btn;
    public Label error_lbl;
    public Button login_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_btn.setOnAction(actionEvent -> onLogin());
    }

    private void onLogin(){
        Stage stage = (Stage) login_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showAdminWindow();
    }
}
