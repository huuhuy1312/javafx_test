module org.example.javafxproj {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires spring.data.jpa;
    requires spring.context;
    requires jakarta.persistence;
    requires static lombok;
    requires spring.beans;

    opens org.example.javafxproj to javafx.fxml;
    exports org.example.javafxproj;

}