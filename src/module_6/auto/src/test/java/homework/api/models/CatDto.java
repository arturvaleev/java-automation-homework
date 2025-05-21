package homework.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 16.05.2025
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    private String name;
    private Integer age;
    private String color;
}
