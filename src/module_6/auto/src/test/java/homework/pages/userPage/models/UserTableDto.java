package homework.pages.userPage.models;

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
public class UserTableDto {

    private String name;
    private String username;
}
