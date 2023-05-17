package com.example.teamprojectmusicandpainting.utils;

public class ChangeEvent<E> implements Event{
    private ChangeEventType type;
    private E entity;

    public ChangeEvent(ChangeEventType type, E entity){
        this.type = type;
        this.entity = entity;
    }
}
