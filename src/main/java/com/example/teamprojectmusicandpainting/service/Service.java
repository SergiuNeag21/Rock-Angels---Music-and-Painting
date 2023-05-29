package com.example.teamprojectmusicandpainting.service;

import com.example.teamprojectmusicandpainting.domain.User;
import com.example.teamprojectmusicandpainting.repository.UserDbRepo;
import com.example.teamprojectmusicandpainting.utils.ChangeEvent;
import com.example.teamprojectmusicandpainting.utils.observer.Observable;
import com.example.teamprojectmusicandpainting.utils.observer.Observer;
import javafx.event.Event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Service implements Observable<Event> {
    private UserDbRepo userRepository;

    private Connection connection;
    private List<Observer<Event>> observers;


    @Override
    public void addObserver(Observer<Event> e) {

    }

    @Override
    public void notifyObserver(ChangeEvent t) {

    }

    public Service(UserDbRepo userDbRepo){
        this.userRepository = userDbRepo;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MusicAndPainting",
                    "postgres" , "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User addUser(User user){return userRepository.save(user);}

    public User deleteUser(Long id){return userRepository.delete(id);}

    public User updateUser(User user){return userRepository.update(user);}

    public User findOneUser(Long id){return userRepository.findOne(id);}

    public User findUserByEmail(String email){return userRepository.findUserByEmail(email);}

    public User updateUserMusicPlaylist(User user, String userMusicPlaylist){return userRepository.updateMusicPlaylist(user, userMusicPlaylist);}
}
