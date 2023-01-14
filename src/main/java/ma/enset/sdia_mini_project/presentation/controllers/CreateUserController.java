package ma.enset.sdia_mini_project.presentation.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateUserController implements Initializable {

    public TextField first_name_txt;
    public TextField last_name_txt;
    public TextField phone_txt;
    public TextField email_txt;
    public TextField address_txt;
    public Label pwd_lbl;
    public Text error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
}
