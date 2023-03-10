package ma.enset.sdia_mini_project.presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import ma.enset.sdia_mini_project.dao.UserDaoImpl;
import ma.enset.sdia_mini_project.dao.entities.User;
import ma.enset.sdia_mini_project.services.UserService;
import ma.enset.sdia_mini_project.services.UserServiceImpl;

import java.net.URL;
import java.security.SecureRandom;
import java.util.ResourceBundle;

public class CreateUserController implements Initializable {

    public TextField first_name_txt;
    public TextField last_name_txt;
    public TextField phone_txt;
    public TextField email_txt;
    public TextField address_txt;
    public Label pwd_lbl;
    public Text message_lbl;
    public RadioButton user_radio;
    public RadioButton admin_radio;
    public ToggleGroup role;
    public Button create_user_btn;
    public CheckBox notify_user_checkBox;
    public TableColumn<User,Long> user_id_cell;
    public TableColumn<User,String> fname_cell;
    public TableColumn<User,String> lname_cell;
    public TableColumn<User,String> email_cell;
    public TableColumn<User,String> phone_cell;
    public TableColumn<User,String> role_cell;
    public TableColumn<User,String> function_cell;
    public TableView user_tableView;
    UserService userService;
    ObservableList<User> userObservableList;

    public CreateUserController() {
        this.userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pwd_lbl.setText(generatePwd());
        create_user_btn.setOnAction(actionEvent -> onAddUser());
        loadUserData();
    }

    private void onAddUser(){
        String f_name;
        String l_name;
        String email;
        String password;
        String phone;
        String role;

        try{
            f_name = first_name_txt.getText();
            l_name = last_name_txt.getText();
            email = email_txt.getText();
            password = PasswordUtils.hashPassword(pwd_lbl.getText());
            phone = phone_txt.getText();

            if(admin_radio.isSelected()){
                role = admin_radio.getText();
            }else{
                role = "user";
            }
            if(f_name.isEmpty() || l_name.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()){
                message_lbl.setText("Please fill all data!");
            }else{
                User u = new User(f_name,l_name, password, email, phone, role);
                userService.add(u);
                loadUserData();
                message_lbl.setStyle("-fx-text-fill: green;");
                message_lbl.setText("user added successfully");
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadUserData(){
         this.userObservableList = FXCollections.observableArrayList(
                userService.getALl()
        );
        user_id_cell.setCellValueFactory(new PropertyValueFactory<User, Long>("id"));
        fname_cell.setCellValueFactory(new PropertyValueFactory<User, String>("F_Name"));
        lname_cell.setCellValueFactory(new PropertyValueFactory<User, String>("L_Name"));
        email_cell.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
        phone_cell.setCellValueFactory(new PropertyValueFactory<User, String>("Phone"));
        role_cell.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
//        user_id_cell.setCellValueFactory(new PropertyValueFactory<User, Long>("FUNCTION"));
        user_tableView.setItems(this.userObservableList);
    }

    private String generatePwd(){
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";
        String OTHER_CHAR = "!@#$%^&*_=+-/";

        String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            int rndCharAt = random.nextInt(PASSWORD_ALLOW_BASE.length());
            char rndChar = PASSWORD_ALLOW_BASE.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }

}
