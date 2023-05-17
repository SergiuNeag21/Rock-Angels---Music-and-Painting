module com.example.teamprojectmusicandpainting {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.teamprojectmusicandpainting to javafx.fxml;
    exports com.example.teamprojectmusicandpainting;
}