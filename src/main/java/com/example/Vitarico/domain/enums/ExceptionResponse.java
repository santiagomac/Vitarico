package com.example.Vitarico.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionResponse {
    NOT_FOUND("El %s con el id %s no existe"),
    SAVE_ERROR("Ha ocurrido un error al intentar guardar el registro");

    private final String message;
}
