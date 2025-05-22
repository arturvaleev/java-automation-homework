package homework.pages.userPage.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * JavaOneLoodsen
 *
 * @author Gladkov Alex (aka. Anticisco)
 * @version 1.0.0
 */

@Getter
@AllArgsConstructor
public enum UserAction {
    UPDATE("Update"),
    DELETE("Delete");

    private final String value;
}
