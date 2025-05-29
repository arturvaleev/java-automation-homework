package homework.api.contact;

import homework.api.contact.models.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;

public class ContactSystemConnector {

    public FindNumberResponseDto findNumber(String token, String method, String number) {
        return RestAssured.given()
                .baseUri("http://localhost:12301")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post("/api.php?t={token}&m={method}&q={number}", token, method, number)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(FindNumberResponseDto.class, ObjectMapperType.GSON);
    }


}
