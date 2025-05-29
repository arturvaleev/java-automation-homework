package homework.api.houses;

import homework.BaseTestClass;
import homework.api.cats.CatConnector;
import homework.api.cats.models.CatDto;
import homework.api.houses.models.HouseDto;
import homework.api.houses.models.StatusDto;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiTest extends BaseTestClass {

    private static final Random RANDOM = new Random();

    private static final String NEW_CAT_NAME_TEMPLATE = "Name_%s";
    private static final String NEW_COLOR_TEMPLATE = "Color_%s";

    private static final String NEW_NAME_TEMPLATE = "Home_%s";
    private static final String CHANGE_TEMPLATE = "Change_%s";

    private final HouseConnector houseConnector = new HouseConnector();
    private final CatConnector catConnector = new CatConnector();


    private HouseDto houseEntity;
    private CatDto catEntity;

    @BeforeClass
    private void apiPrecondition() {
        houseEntity = HouseDto.builder()
                .name(String.format(NEW_NAME_TEMPLATE, System.currentTimeMillis()))
                .build();

        catEntity = CatDto.builder()
                .name(String.format(NEW_CAT_NAME_TEMPLATE, System.currentTimeMillis()))
                .age(RANDOM.nextInt(10, 100))
                .color(String.format(NEW_COLOR_TEMPLATE, RANDOM.nextInt(200)))
                .build();
    }

    @Test(priority = 1)
    public void apiCreateHouseTest() {
        HouseDto actualHouse = houseConnector.createNewHouse(houseEntity);

        SoftAssertions.assertSoftly(
                softAssertions -> {
                    softAssertions.assertThat(actualHouse.getName())
                            .as("Check create House Name")
                            .isEqualTo(houseEntity.getName());
                }
        );
        houseEntity.setId(actualHouse.getId());
        houseEntity.setCats(actualHouse.getCats());
    }

    @Test(priority = 2)
    public void apiInputCatInHouseTest() {
        CatDto actualCat = catConnector.createNewCat(catEntity);
        catEntity.setId(actualCat.getId());
        StatusDto actualStatus = houseConnector.inputCatInHouseById(houseEntity, actualCat);
        houseEntity.setCats(Collections.singletonList(actualCat));

        SoftAssertions.assertSoftly(
                softAssertions -> {
                    softAssertions.assertThat(actualStatus.getStatus())
                            .as("Check Status Code InputCatInHouseById")
                            .isEqualTo(SUCCESS_STATUS);
                    softAssertions.assertThat(actualStatus.getMessage())
                            .as("Check Status Message InputCatInHouseById")
                            .isEqualTo(SUCCESS_MESSAGE);
                }
        );
    }

    @Test(priority = 3)
    public void apiAvailableHouseInListTest() {
        List<HouseDto> houseList = houseConnector.getHouseList();

        List<String> houseNameList = houseList.stream()
                .map(HouseDto::getName)
                .toList();

        assertThat(houseNameList)
                .as("Check avaliable expected house")
                .contains(houseEntity.getName());
    }

    @Test(priority = 4)
    public void apiAvailableHouseTest() {
        HouseDto actualHouse = houseConnector.getHouseById(houseEntity.getId());
        assertThat(actualHouse)
                .as("Full Check Create House")
                .usingRecursiveComparison()
                .isEqualTo(houseEntity);
    }

    @Test(priority = 5)
    public void apiEditHouseTest() {
        houseEntity.setName(String.format(CHANGE_TEMPLATE, houseEntity.getName()));

        HouseDto actualUpdateHouse = houseConnector.updateHouseById(houseEntity);

        assertThat(actualUpdateHouse)
                .as("Full Check Edit House")
                .usingRecursiveComparison()
                .isEqualTo(houseEntity);
    }

    @Test(priority = 6)
    public void apiDeleteHouseTest() {
        StatusDto statusDeleteHouse = houseConnector.deleteHouseById(houseEntity);

        assertThat(statusDeleteHouse.getStatus())
                .as("Check Delete Status")
                .isEqualTo(1);
    }

    @Test(priority = 7)
    public void apiNotExistDeleteHouseTest() {
        List<HouseDto> houseList = houseConnector.getHouseList();

        List<Integer> houseIds = houseList.stream().map(HouseDto::getId).toList();

        assertThat(houseIds)
                .as("Check Not Available Delete House")
                .doesNotContain(houseEntity.getId());
    }
}
