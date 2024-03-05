package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;


public class RestApiMocked {
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

}
