package com.example.teamprojectmusicandpainting.utils.observer;


import javafx.event.Event;

public interface Observable<E extends Event> {
    void addObserver(Observer<E> e);

    void notifyObserver(E t);
}
