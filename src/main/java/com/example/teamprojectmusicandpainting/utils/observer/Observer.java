package com.example.teamprojectmusicandpainting.utils.observer;


import javafx.event.Event;

public interface Observer<E extends Event>{
    void update(E e);
}
