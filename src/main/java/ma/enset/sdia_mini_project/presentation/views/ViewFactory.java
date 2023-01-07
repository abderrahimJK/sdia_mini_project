package ma.enset.sdia_mini_project.presentation.views;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ma.enset.sdia_mini_project.presentation.controllers.AdminController;

public class ViewFactory {
    private final StringProperty adminSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane userManagerView;

    public ViewFactory(){
        this.adminSelectedMenuItem = new SimpleStringProperty("");
    }

    public StringProperty getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
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

    public void showLogin() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        createScene(fxmlLoader);
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
            stage.setResizable(false);
            stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }

}
