package ru.evoloodsen.api.models;

import lombok.Getter;

import java.util.List;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 16.05.2025
 */

@Getter
public class CatResponseDto {
    private StatusDto status;
    private CatDto data;
}
