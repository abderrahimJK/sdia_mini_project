package ma.enset.sdia_mini_project.presentation.controllers;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import ma.enset.sdia_mini_project.presentation.models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {


    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) ->{
            if ("userMangerView".equals(newVal)) {
                admin_parent.setCenter(Model.getInstance().getViewFactory().getUserManagerView());
            }else{
                admin_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }
}
