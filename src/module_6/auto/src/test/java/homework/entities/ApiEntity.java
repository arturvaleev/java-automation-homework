package homework.entities;

import lombok.Getter;

@Getter
public class ApiEntity {

    private String cosmeticName;
    private String ipAddress;

    public ApiEntity withCosmeticName(String data) {
        this.cosmeticName = data;
        return this;
    }

    public ApiEntity withIpAddress(String data) {
        this.ipAddress = data;
        return this;
    }
}
