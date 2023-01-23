package ma.enset.sdia_mini_project.presentation.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import ma.enset.sdia_mini_project.dao.UserDaoImpl;
import ma.enset.sdia_mini_project.dao.entities.User;
import ma.enset.sdia_mini_project.services.UserService;
import ma.enset.sdia_mini_project.services.UserServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {


    public Label full_name_label;
    public Label user_function_label;
    public TextField f_name_txt;
    public TextField l_name_txt;
    public TextField email_txt;
    public TextField phone_txt;
    public Button save_update_btn;
    public TextField pwd_txt;
    public TextField pwd_conf_txt;
    public Label alert_lbl;

    private UserService userService;
    private User currentUser;


    public ProfileController() {
        this.userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        save_update_btn.setOnAction(actionEvent -> update());
        loadProfile();
    }

    private void loadProfile(){
        currentUser = userService.findById(LoginSession.id);
        full_name_label.setText(currentUser.getF_Name()+ " "+ currentUser.getL_Name());
        user_function_label.setText(currentUser.getRole());
        f_name_txt.setText(currentUser.getF_Name());
        l_name_txt.setText(currentUser.getL_Name());
        email_txt.setText(currentUser.getEmail());
        phone_txt.setText(currentUser.getPhone());
    }

    private void update(){
        currentUser.setF_Name(f_name_txt.getText());
        currentUser.setL_Name(l_name_txt.getText());
        currentUser.setEmail(email_txt.getText());
        currentUser.setPhone(phone_txt.getText());

        String pwd = pwd_txt.getText();

        if(!pwd.isEmpty()){
            if(pwd.equals(pwd_conf_txt.getText())){
                currentUser.setPassword(PasswordUtils.hashPassword(pwd));
                System.out.println(currentUser.getPassword());
            }else{
                alert_lbl.setTextFill(Color.web("red"));
                alert_lbl.setText("please confirm your password");
                return;
            }
        }
        userService.update(currentUser);
        alert_lbl.setText("you are updated");
        loadProfile();
    }
}
