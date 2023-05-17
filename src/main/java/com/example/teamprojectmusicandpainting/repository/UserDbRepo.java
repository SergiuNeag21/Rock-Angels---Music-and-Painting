package com.example.teamprojectmusicandpainting.repository;

import com.example.teamprojectmusicandpainting.domain.User;
import com.example.teamprojectmusicandpainting.domain.validate.Validator;
import com.example.teamprojectmusicandpainting.utils.observer.Observable;
import com.example.teamprojectmusicandpainting.utils.observer.Observer;
import javafx.event.Event;

import java.util.List;

public class UserDbRepo implements Repo<Long, User>, Observable<Event> {
    private Validator<User> validator;
    private List<Observer<Event>> observers;

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User delete(Long id) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void addObserver(Observer<Event> e) {

    }

    @Override
    public void notifyObserver(Event t) {

    }
}
