package ma.enset.sdia_mini_project.presentation.controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ma.enset.sdia_mini_project.dao.UserDaoImpl;
import ma.enset.sdia_mini_project.dao.entities.User;
import ma.enset.sdia_mini_project.presentation.models.Model;
import ma.enset.sdia_mini_project.services.UserService;
import ma.enset.sdia_mini_project.services.UserServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public TextField email_txt;

    public FontAwesomeIconView close_btn;
    public Label error_lbl;
    public Button login_btn;
    public PasswordField password_txt;
    private UserService userService;

    public LoginController() {
        this.userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_btn.setOnAction(actionEvent -> onLogin());
    }

    private void onLogin(){
//        close();
//        Model.getInstance().getViewFactory().showAdminWindow();
        try {
            String email = email_txt.getText();
            String password = password_txt.getText();
            User user = userService.login(email,password);
            if(user.getRole().equals("admin")){
                close();
                Model.getInstance().getViewFactory().showAdminWindow();
            }else{
                close();
                Model.getInstance().getViewFactory().showUserWindow();
            }
            LoginSession.id = user.getId();
            LoginSession.f_Name = user.getF_Name();
            LoginSession.l_Name = user.getL_Name();
            LoginSession.UsetrType = user.getRole();
        }catch(Exception e) {
            alertErr();
        }
    }

    private void close(){
        Stage stage = (Stage) login_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }

    private void alertErr(){
        error_lbl.setText("Email or password incorrect");
    }
}
