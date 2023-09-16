package tests.api;

import apiConnection.ApiConnection;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class CcCaptureStepsTest extends ApiConnection {
    private static final Logger logger = LoggerFactory.getLogger(CcCaptureStepsTest.class);


    @Test
    public void query_send_test()  {
        if (requestSpecification == null || response == null) {
            logger.error("RequestSpecification or Response is not initialized.");
            return;
        }
        response = requestSpecification.post("umbraco/Api/Tasks/CCCaptureTask");
        response.prettyPrint();
        logger.info("Request sent");
    }

    @Test
    public void status_code_is_returned_for_response() {
        if (requestSpecification == null || response == null) {
            logger.error("RequestSpecification or Response is not initialized.");
            return;
        }
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }
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
