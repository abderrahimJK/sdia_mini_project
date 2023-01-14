package ma.enset.sdia_mini_project.presentation.views;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ma.enset.sdia_mini_project.presentation.controllers.AdminController;
import ma.enset.sdia_mini_project.presentation.controllers.client.UserController;

public class ViewFactory {
    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane userManagerView;
    private AnchorPane profileView;
    //--------------------------------------

    private AnchorPane userDashboard;
    private final ObjectProperty<UserMenuOptions> userSelectedMenuItem;

    public ViewFactory(){
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
        this.userSelectedMenuItem = new SimpleObjectProperty<>();
    }


    /*
     * Admin Views section
     * */

    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }

    public AnchorPane getProfileView() {
        if (profileView == null){
            try{
                profileView = new FXMLLoader(getClass().getResource("/fxml/profile.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return profileView;
    }

    public AnchorPane getDashboardView(){
        if (dashboardView == null){
            try{
                dashboardView = new FXMLLoader(getClass().getResource("/fxml/admin/adminDashboard.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public void showAdminWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/admin.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);
        createScene(loader);
    }

    public AnchorPane getUserManagerView() {
        if (userManagerView == null){
            try{
                userManagerView = new FXMLLoader(getClass().getResource("/fxml/admin/userView.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return userManagerView;
    }

    /*
    * User Views section
    * */

    public ObjectProperty<UserMenuOptions> getUserSelectedMenuItem() {
        return userSelectedMenuItem;
    }
    public AnchorPane getUserDashboard() {
        if (userDashboard == null){
            try{
                userDashboard = new FXMLLoader(getClass().getResource("/fxml/user/userDashboard.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return userDashboard;
    }
    public void showUserWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user.fxml"));
        UserController userController = new UserController();
        loader.setController(userController);
        createScene(loader);
    }


    /*******************************************************************************/

    public void showLogin() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        createScene(fxmlLoader);
    }

    private void createScene(FXMLLoader loader){
            Scene scene= null;
            try{
                scene = new Scene(loader.load());
//                scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
            Stage stage = new Stage();
//            stage.initStyle(StageStyle.UNDECORATED);
//            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
//            stage.setResizable(false);
            stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }

}
