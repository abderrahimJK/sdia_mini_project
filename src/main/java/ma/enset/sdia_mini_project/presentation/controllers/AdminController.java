package ma.enset.sdia_mini_project.presentation.controllers;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ma.enset.sdia_mini_project.presentation.models.Model;

import java.net.URL;
import java.util.ResourceBundle;

import static ma.enset.sdia_mini_project.presentation.views.AdminMenuOptions.*;


public class AdminController implements Initializable {


    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) ->{

            switch(newVal){
                case USERMANAGERVIEW:admin_parent.setCenter(Model.getInstance().getViewFactory().getUserManagerView());
                    break;
                case PROFILE: admin_parent.setCenter(Model.getInstance().getViewFactory().getProfileView());
                    break;
                case LOGOUT: {
                    Model.getInstance().getViewFactory().closeStage((Stage) admin_parent.getScene().getWindow());
                    Model.getInstance().getViewFactory().showLogin();
                } break;
                default: admin_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }
}
