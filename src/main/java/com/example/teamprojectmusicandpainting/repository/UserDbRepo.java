package com.example.teamprojectmusicandpainting.repository;

import com.example.teamprojectmusicandpainting.domain.User;
import com.example.teamprojectmusicandpainting.domain.validate.Validator;
import com.example.teamprojectmusicandpainting.utils.ChangeEvent;
import com.example.teamprojectmusicandpainting.utils.ChangeEventType;
import com.example.teamprojectmusicandpainting.utils.observer.Observable;
import com.example.teamprojectmusicandpainting.utils.observer.Observer;
import javafx.event.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDbRepo implements Repo<Long, User>, Observable<Event> {
    private Connection connection;
    private Validator<User> validator;
    private List<Observer<Event>> observers;

    public UserDbRepo(Connection connection, Validator<User> validator) {
        this.connection = connection;
        this.validator = validator;
        this.observers = new ArrayList<>();
    }

    @Override
    public User findOne(Long id) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id_user = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("id_user"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setMyPlaylist(resultSet.getString("user_music_playlist"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  user;
    }
    @Override
    public List<User> findAll() {
        List<User> usersList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id_user"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setPassword(resultSet.getString("user_music_playlist"));
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }
    @Override
    public User save(User entity) {
        User user = entity;
        validator.validate(user);
        try{
            String sql = "INSERT INTO users (first_name, last_name, email, password, user_music_playlist) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getFirst_name());
            statement.setString(2, user.getLast_name());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getUserMusicPlaylist());
            statement.executeUpdate();
            notifyObserver(new ChangeEvent(ChangeEventType.ADD, user));
            return entity;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public User delete(Long id) {
        User user = findOne(id);
        if (user != null){
            try{
                String sql = "DELETE FROM users WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setLong(1, id);
                statement.executeQuery();
                notifyObserver(new ChangeEvent(ChangeEventType.DELETE, user));

            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return user;
    }

    @Override
    public User update(User entity) {
        User user = entity;
        validator.validate(user);
        try{
            String sql = "MODIFY users SET first_name = ?, last_name = ?, email = ?, password = ?, user_music_playlist = ?, where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirst_name());
            statement.setString(2, user.getLast_name());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getUserMusicPlaylist());
            statement.executeUpdate();
            notifyObserver(new ChangeEvent(ChangeEventType.UPDATE, user));
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    public User updateMusicPlaylist(User entity, String musicPlaylist) {
        User user = entity;
        validator.validate(user);
        try{
            String sql = "UPDATE  users SET first_name = ?, last_name = ?, email = ?, password = ?, user_music_playlist = ? where id_user = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirst_name());
            statement.setString(2, user.getLast_name());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, musicPlaylist);
            statement.setLong(6, user.getId());
            statement.executeUpdate();
            notifyObserver(new ChangeEvent(ChangeEventType.UPDATE, user));
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    public User findUserByEmail(String email){
        User user = new User();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email=?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                user.setId(resultSet.getLong("id_user"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setMyPlaylist(resultSet.getString("user_music_playlist"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void addObserver(Observer<Event> e) {

    }

    @Override
    public void notifyObserver(ChangeEvent t) {

    }
}
