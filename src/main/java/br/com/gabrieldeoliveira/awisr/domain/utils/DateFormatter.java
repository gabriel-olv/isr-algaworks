package br.com.gabrieldeoliveira.awisr.domain.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    public static String formatInstantOnPattern(Instant instant, String pattern) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(instant.atZone(ZoneId.systemDefault()));
    }
}
