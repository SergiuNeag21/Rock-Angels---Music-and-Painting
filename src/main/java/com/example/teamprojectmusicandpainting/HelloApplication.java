package com.example.teamprojectmusicandpainting;

import com.example.teamprojectmusicandpainting.domain.validate.UserValidator;
import com.example.teamprojectmusicandpainting.repository.UserDbRepo;
import com.example.teamprojectmusicandpainting.service.Service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        String url ="jdbc:postgresql://localhost:5432/MusicAndPainting";
        String username =  "postgres";
        String password =  "postgres";

        Connection connection = DriverManager.getConnection(url, username, password);
        UserDbRepo userRepository = new UserDbRepo(connection, new UserValidator());

        Service service = new Service(userRepository);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginRegisterView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 549, 700);

        LoginSingupViewController loginSingupViewController = fxmlLoader.getController();
        loginSingupViewController.setService(service);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}