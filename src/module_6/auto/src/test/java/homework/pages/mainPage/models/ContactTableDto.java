package homework.pages.mainPage.models;

import lombok.Builder;
import lombok.Data;

/**
 * JavaOneLoodsen
 *
 * @author Gladkov Alex (aka. Anticisco)
 * @version 1.0.0
 */

@Builder
@Data
public class ContactTableDto {

    private String name;
    private String city;
    private String phoneNumber;
    private String email;
}
