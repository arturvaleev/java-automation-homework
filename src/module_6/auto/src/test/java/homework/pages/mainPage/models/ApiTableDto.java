package homework.pages.mainPage.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiTableDto {

    private String apiToken;
    private String cosmeticName;
    private String authorised_Ip;
}