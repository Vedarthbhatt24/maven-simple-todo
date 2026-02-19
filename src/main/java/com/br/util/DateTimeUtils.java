package com.br.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private DateTimeUtils() {}

    public static final DateTimeFormatter PADRAO_BR =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static String formatar(LocalDateTime data) {

        if (data == null) {
            return "";
        }

        return data.format(PADRAO_BR);
    }
}
