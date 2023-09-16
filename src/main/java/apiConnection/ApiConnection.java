package apiConnection;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class ApiConnection {
    private static final Logger logger = LoggerFactory.getLogger(ApiConnection.class);

    protected static RequestSpecification requestSpecification;
    protected static Response response;

    @BeforeMethod
    public static void setUp() {
        try {
            logger.info("trying to connect to api...");
            RestAssured.baseURI = "https://qa.imoving.com/";
            requestSpecification = RestAssured.given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON);
            logger.info("api connected");
        } catch (Exception e) {
            logger.error("An error occurred during test setup: " + e.getMessage());
        }
    }
//    public static void setUp(){
//        RestAssured.baseURI="https://qa.imoving.com/";
//        requestSpecification = RestAssured.given()
////                .auth()
////                .basic("L9v5B61A74S2TqOVb2Lknj9So2EFumr0of0gbqw7l5P5YQ291IPiQBpEOTg35Qdj13Mu2TDzEWgR9Bdc41Z0r87NCI513AUAHg5TJc54iA6HfW3nvDFwipf5815f6vkw",
////                        "management-umbraco-token")
//                .header("management-umbraco-token",
//                        "L9v5B61A74S2TqOVb2Lknj9So2EFumr0of0gbqw7l5P5YQ291IPiQBpEOTg35Qdj13Mu2TDzEWgR9Bdc41Z0r87NCI513AUAHg5TJc54iA6HfW3nvDFwipf5815f6vkw")
//                .accept(ContentType.JSON)
//                .contentType(ContentType.JSON);
//    }
}
