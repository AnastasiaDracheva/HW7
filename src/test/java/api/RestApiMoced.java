package api;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RestApiMoced {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://35.208.34.242";
        RestAssured.port = 8080;
    }

    @Test
    public void getOrderByCheckResponseCodeIsOk (){
        get("/test-orders/5")
                .then()
                .statusCode(200);

    }
    @Test
    public void getOrderByInvalidCheckResponseCodeIsBadRequest (){
        given().
                when().

                get("/test-orders/11")
                .then()
                .statusCode(400);

    }
    @Test
    public void getOrderByResponseCodeIsOk (){
        get("/test-orders/get_orders")
                .then()
                .statusCode(200);

    }
    @Test
    public void deleteOrderByProvidingAValidOrder (){
        get("/test-orders/9");
        given()
                .log()
                .all()
                .when()
                .header("api_ky","1234567890123456")
                .then()
                .statusCode(204);

    }
    @Test
    public void deleteOrderByProvidingAValidOrderWithDoubleNumber (){
        get("/test-orders/09");
        given()
                .log()
                .all()
                .when()
                .header("api_ky","1234567890123456")
                .then()
                .statusCode(204);

    }

    @Test
    public void deleteAnOrderByProvidingAInvalidRequest() {
        get("/test-orders/11");
        given()
                .log()
                .all()
                .when()
                .header("api_ky", "1234567890123456")
                .then()
                .statusCode(400);

    }
    @Test
    public void deleteAnOrderByProvidingAUnauthorized (){
        get("/test-orders/9");
        given()
                .log()
                .all()
                .when()
                .header("api_ky","1234567890123456")
                .then()
                .statusCode(401);

    }

    @ParameterizedTest
    @ValueSource(ints = {1,4,5,9,10})
    public void dummyTest(int value){
        Assertions.assertTrue(value > 3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 9, 10})
    public void getOrdersByIdAndCheckResponseCodeIsOk(int orderId) {

        int responseOrderId = given()
                .log()
                .all()
                .when()
               // .get("/test-orders/" + orderId)
                .get("/test-orders/{orderId}", orderId)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .path("id");

        Assertions.assertEquals(orderId, responseOrderId);
    }
    @ParameterizedTest
    @ValueSource(ints = {0,18})
    public void getOrdersByIdAndCheckResponseCodeIsInvalid(int orderId) {

        given()
                .log()
                .all()
                .when()
                // .get("/test-orders/" + orderId)
                .get("/test-orders/{orderId}", orderId)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);


    }
    @ParameterizedTest
    @CsvSource({

            "123ht45, gyjft67 ",
            "678th90, 7t rth  ",
            "543rth21, 3ghfgyn"

    })
    void testWithCsvSource(String username, String password){
        given()
                .log()
                .all()
                .when()
                // .get("/test-orders/" + orderId)
                .get("/test-orders/{message}/{apiKey}",username,password)
                .then()
                .log()
                .all()
                .assertThat()
                .extract()
                .path("message","apiKey");
        Assertions.assertNotNull("message");
        Assertions.assertNotNull("apiKey");
    }



}


