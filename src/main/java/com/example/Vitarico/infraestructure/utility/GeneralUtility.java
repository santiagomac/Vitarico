package com.example.Vitarico.infraestructure.utility;

import java.time.LocalDateTime;

public class GeneralUtility {

    public static LocalDateTime convertStringToLocalDateTime(String date){
        return LocalDateTime.parse(date);
    }
}
