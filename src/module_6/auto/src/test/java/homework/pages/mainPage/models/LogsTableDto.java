package homework.pages.mainPage.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LogsTableDto {
    private String date;
    private String action;
    private String user;
    private String ip;
}
