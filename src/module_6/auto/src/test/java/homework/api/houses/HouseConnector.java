package homework.api.houses;

import homework.api.cats.models.CatDto;
import homework.api.houses.models.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;

import java.util.List;

public class HouseConnector {

    public HouseDto createNewHouse(HouseDto body) {
        return RestAssured.given()
                .baseUri("http://localhost:8080")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON)
                .post("/api/v1/houses/create")
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(HouseResponseDto.class, ObjectMapperType.GSON)
                .getData();
    }

    public List<HouseDto> getHouseList() {
        return RestAssured.given()
                .baseUri("http://localhost:8080")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .get("/api/v1/houses/list")
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(HouseListResponseDto.class, ObjectMapperType.GSON)
                .getData();
    }

    public HouseDto getHouseById(int houseId) {
        return RestAssured.given()
                .baseUri("http://localhost:8080")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .get("/api/v1/houses/get/{houseId}", houseId)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(HouseResponseDto.class, ObjectMapperType.GSON)
                .getData();
    }

    public HouseDto updateHouseById(int houseId, HouseDto body) {
        return RestAssured.given()
                .baseUri("http://localhost:8080")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON)
                .put("/api/v1/houses/update/{houseId}", houseId)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(HouseResponseDto.class, ObjectMapperType.GSON)
                .getData();
    }

    public HouseDto updateHouseById(HouseDto body) {
        return updateHouseById(body.getId(), body);
    }

    public StatusDto deleteHouseById(int houseId) {
        return RestAssured.given()
                .baseUri("http://localhost:8080")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .delete("/api/v1/houses/delete/{houseId}", houseId)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(DeleteHouseDto.class, ObjectMapperType.GSON)
                .getStatus();
    }

    public StatusDto deleteHouseById(HouseDto house) {
        return deleteHouseById(house.getId());
    }

    public StatusDto inputCatInHouseById(int houseId, int catId) {
        return RestAssured.given()
                .baseUri("http://localhost:8080")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post("/api/v1/houses/input/{houseId}/{catId}", houseId, catId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(InputCatInHouseDto.class, ObjectMapperType.GSON)
                .getStatus();
    }

    public StatusDto inputCatInHouseById(HouseDto house, CatDto cat) {
        return inputCatInHouseById(house.getId(), cat.getId());
    }
}
