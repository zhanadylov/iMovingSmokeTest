package org.example.apiConnection;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.hooks.TestListener;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.*;

import static io.restassured.RestAssured.baseURI;

@Listeners(TestListener.class)
public class ApiConnection {
    private static final Logger logger = LogManager.getLogger(ApiConnection.class);
    protected static ThreadLocal<RequestSpecification> requestSpecificationThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public static void setUp() {
        try {
            logger.info("trying to connect api...");
            RestAssured.baseURI = "https://qa.imoving.com/";
            requestSpecificationThreadLocal.set(
                    RestAssured.given()
                            .when()
                            .accept(ContentType.JSON)
                            .contentType(ContentType.JSON)
                            .header("management-umbraco-token",
                        "L9v5B61A74S2TqOVb2Lknj9So2EFumr0of0gbqw7l5P5YQ291IPiQBpEOTg35Qdj13Mu2TDzEWgR9Bdc41Z0r87NCI513AUAHg5TJc54iA6HfW3nvDFwipf5815f6vkw")
            );
            logger.info("api connected");
        } catch (Exception e) {
            logger.error("An error occurred during test setup: " + e.getMessage());
        }
    }

    public void sendQueryEndPoints(String endPoint)  {
//        Response response = responseThreadLocal.get();
        RequestSpecification requestSpecification = requestSpecificationThreadLocal.get();

        try {
            Response response = requestSpecification.post(baseURI+endPoint);
            response.then().log().all();
            response.prettyPrint();
            logger.info("Request sent");

            if (response.getStatusCode() != 200) {
                logger.error("Request failed with status code: " + response.getStatusCode());
                logger.error("Response body: " + response.getBody().asString());
            }

            MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));

        } catch (Exception e) {
            logger.error("An error occurred while sending the request:", e);
        }
    }

    @AfterMethod
    public static void tearDown() {
        requestSpecificationThreadLocal.remove();
        logger.info("Api connection closed");
    }
}
