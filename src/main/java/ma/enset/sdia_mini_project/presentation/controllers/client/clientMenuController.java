package ma.enset.sdia_mini_project.presentation.controllers.client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ma.enset.sdia_mini_project.presentation.models.Model;
import ma.enset.sdia_mini_project.presentation.views.UserMenuOptions;

import java.net.URL;
import java.util.ResourceBundle;

import static ma.enset.sdia_mini_project.presentation.views.UserMenuOptions.*;

public class clientMenuController implements Initializable {


    public Button userdashboard_btn;
    public Button userprofile_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners(){
        userdashboard_btn.setOnAction(actionEvent -> onDashboard());
        userprofile_btn.setOnAction(actionEvent -> onProfile());
    }

    private void onDashboard(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set(UserMenuOptions.DASHBOARD);
    }
    private void onProfile(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set(UserMenuOptions.PROFILE);
    }
}
