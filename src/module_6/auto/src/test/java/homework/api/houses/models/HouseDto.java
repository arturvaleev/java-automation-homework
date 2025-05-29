package homework.api.houses.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import homework.api.cats.models.CatDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HouseDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    private String name;
    private List<CatDto> cats;
}
