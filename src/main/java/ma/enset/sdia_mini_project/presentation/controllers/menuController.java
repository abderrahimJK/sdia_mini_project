package ma.enset.sdia_mini_project.presentation.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ma.enset.sdia_mini_project.presentation.models.Model;
import ma.enset.sdia_mini_project.presentation.views.AdminMenuOptions;

import java.net.URL;
import java.util.ResourceBundle;

public class menuController implements Initializable {


    public Button dashboard_btn;
    public Button profile_btn;
    public Button logout_btn;
    public Button user_manager_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners(){
        dashboard_btn.setOnAction(actionEvent -> onDashboard());
        user_manager_btn.setOnAction(actionEvent -> onUserManager());
        profile_btn.setOnAction(actionEvent -> onProfile());
    }

    private void onDashboard(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DASHBOARD);
    }

    private void onUserManager(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.USERMANAGERVIEW);
    }

    private void onProfile(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.PROFILE);
    }
}
