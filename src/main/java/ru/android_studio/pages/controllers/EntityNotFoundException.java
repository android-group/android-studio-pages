package ru.android_studio.pages.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class EntityNotFoundException extends RuntimeException {
    EntityNotFoundException(String message) {
        super(message);
    }
}
