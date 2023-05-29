module com.example.teamprojectmusicandpainting {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;


    opens com.example.teamprojectmusicandpainting to javafx.fxml;
    exports com.example.teamprojectmusicandpainting;
}