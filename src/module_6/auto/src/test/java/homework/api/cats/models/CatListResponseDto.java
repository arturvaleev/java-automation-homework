package homework.api.cats.models;

import lombok.Getter;

import java.util.List;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 16.05.2025
 */

@Getter
public class CatListResponseDto {
    private StatusDto status;
    private List<CatDto> data;
}
