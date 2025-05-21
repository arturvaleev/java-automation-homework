package ru.evoloodsen.pages.cotactInfoPage;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 13.05.2025
 */

@AllArgsConstructor
@Getter
public enum ContactInfoTitle {
    FULL_NAME("Full Name:"),
    HOME_NUMBER("Home Number:"),
    MOBILE_NUMBER("Mobile Number:"),
    EMAIL("Email Address:"),
    BIRTH_DATE("Date Of Birth:"),
    ADDRESS("Address:");

    private final String value;
}
