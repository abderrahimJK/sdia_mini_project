module ma.enset.sdia_mini_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires de.jensd.fx.glyphs.fontawesome;
    requires mysql.connector.java;

    exports ma.enset.sdia_mini_project.dao.entities;
    opens ma.enset.sdia_mini_project to javafx.fxml;
    opens ma.enset.sdia_mini_project.dao.entities to javafx.base;
    exports ma.enset.sdia_mini_project;
    exports ma.enset.sdia_mini_project.presentation.controllers to javafx.fxml;
    exports ma.enset.sdia_mini_project.presentation.controllers.client to javafx.fxml;
//    exports ma.enset.sdia_mini_project.presentation.models to javafx.fxml;
//    exports ma.enset.sdia_mini_project.presentation.views to javafx.fxml;

}