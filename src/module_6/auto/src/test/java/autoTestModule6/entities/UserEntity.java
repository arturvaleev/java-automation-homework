package ru.evoloodsen.entities;

import lombok.Getter;
import ru.evoloodsen.tools.DateHelper;

import java.time.LocalDate;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 06.05.2025
 */

@Getter
public class UserEntity {
    private String fullName;
    private String username;
    private String password;

    public UserEntity withFullName(String data) {
        this.fullName = data;
        return this;
    }

    public UserEntity withUsername(String data) {
        this.username = data;
        return this;
    }

    public UserEntity withPassword(String data) {
        this.password = data;
        return this;
    }
}
