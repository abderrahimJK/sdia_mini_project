package ma.enset.sdia_mini_project;

import javafx.application.Application;
import javafx.stage.Stage;
import ma.enset.sdia_mini_project.presentation.models.Model;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLogin();
    }
}
