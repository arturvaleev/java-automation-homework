package homework.pages.mainPage.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JavaOneLoodsen
 *
 * @author Gladkov Alex (aka. Anticisco)
 * @version 1.0.0
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactTableDto {

    private String name;
    private String city;
    private String phoneNumber;
    private String email;
}
