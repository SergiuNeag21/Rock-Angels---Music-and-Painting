package com.example.teamprojectmusicandpainting.utils.observer;


import com.example.teamprojectmusicandpainting.utils.ChangeEvent;
import javafx.event.Event;

public interface Observable<E extends Event> {
    void addObserver(Observer<E> e);

    void notifyObserver(ChangeEvent t);
    void notifyObserver(E t);
}
