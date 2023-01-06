module ma.enset.sdia_mini_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires de.jensd.fx.glyphs.fontawesome;

    opens ma.enset.sdia_mini_project to javafx.fxml;
    exports ma.enset.sdia_mini_project;
    exports ma.enset.sdia_mini_project.presentation.controllers to javafx.fxml;
}