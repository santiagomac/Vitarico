package com.example.Vitarico.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionResponse {
    NOT_FOUND("El cliente con el id %s no existe"),
    SAVE_ERROR("Ha ocurrido un error al intentar guardar el cliente");

    private String message;
}
