package ru.evoloodsen.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * JavaOneLoodsen
 *
 * @author Gladkov Alex (aka. Anticisco)
 * @version 1.0.0
 */

public class DateHelper {

    public final static String MONTH_YEAR_DATE_PATTERN = "MMMM yyyy";

    public static String transformLocalDateToString(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH));
    }
}
