package homework.api.contact.models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindNumberResponseDto {
    private Integer success;
    private String method;
    private String query;
    private String result;

    @SerializedName("result_message")
    private String resultMessage;
}
