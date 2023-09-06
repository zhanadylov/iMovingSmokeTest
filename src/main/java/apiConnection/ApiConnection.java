package apiConnection;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.testng.annotations.BeforeTest;

public class ApiConnection {
    static RequestSpecification requestSpecification;
    static Response response;

    @BeforeTest
    public static void setUp(){
        RestAssured.baseURI="https://qa.imoving.com/";
        requestSpecification = RestAssured.given()
//                .auth()
//                .basic("L9v5B61A74S2TqOVb2Lknj9So2EFumr0of0gbqw7l5P5YQ291IPiQBpEOTg35Qdj13Mu2TDzEWgR9Bdc41Z0r87NCI513AUAHg5TJc54iA6HfW3nvDFwipf5815f6vkw",
//                        "management-umbraco-token")
                .header("management-umbraco-token",
                        "L9v5B61A74S2TqOVb2Lknj9So2EFumr0of0gbqw7l5P5YQ291IPiQBpEOTg35Qdj13Mu2TDzEWgR9Bdc41Z0r87NCI513AUAHg5TJc54iA6HfW3nvDFwipf5815f6vkw")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
    }
}
