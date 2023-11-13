package tests.api;

import apiConnection.ApiConnection;
import hooks.logs.Log;
import static hooks.logs.Log4jDemo.logger;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class CcCaptureStepsTest extends ApiConnection {
//    private static final Logger logger = LoggerFactory.getLogger(CcCaptureStepsTest.class);

//    @Log
//    @Test
//    public void testRegres(){
//        logger.info("Sending endpoints");
//        response = requestSpecification.get("/api/users?page=2");
//        response.prettyPrint();
//    }
    @Log
    @Test
    public void query_send_test()  {
        if (requestSpecification == null || response == null) {
            logger.error("RequestSpecification or Response is not initialized.");
            return;
        }
        response = requestSpecification.post(baseURI+"umbraco/Api/Tasks/CCCaptureTask");
        response.then().log().all();
        response.prettyPrint();
        logger.info("Request sent");
    }
    @Log
    @Test
    public void status_code_is_returned_for_response() {
        if (requestSpecification == null || response == null) {
            logger.error("RequestSpecification or Response is not initialized.");
            return;
        }
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }
    @Log
    @Test
    public void send_Email() {
        if (requestSpecification == null || response == null) {
            logger.error("RequestSpecification or Response is not initialized.");
            return;
        }
        response = requestSpecification.post("umbraco/Api/Tasks/CaptureEmailTask");
        response.prettyPrint();
    }
}
