package com.example.teamprojectmusicandpainting.domain.validate;

public interface Validator<T> {
    void validate(T entity) throws ValidationException;
}