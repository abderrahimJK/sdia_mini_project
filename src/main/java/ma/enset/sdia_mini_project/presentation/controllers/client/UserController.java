package ma.enset.sdia_mini_project.presentation.controllers.client;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ma.enset.sdia_mini_project.presentation.models.Model;
import ma.enset.sdia_mini_project.presentation.views.UserMenuOptions;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    public BorderPane user_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().addListener((observableValue, oldVal, newVal) ->{
            switch(newVal){
                case PROFILE:user_parent.setCenter(Model.getInstance().getViewFactory().getProfileView());
                    break;
                case LOGOUT: {
                    Model.getInstance().getViewFactory().closeStage((Stage) user_parent.getScene().getWindow());
                    Model.getInstance().getViewFactory().showLogin();
                } break;
                default: user_parent.setCenter(Model.getInstance().getViewFactory().getUserDashboard());
            }
        });
    }
}
