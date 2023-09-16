package tests.api;

import apiConnection.ApiConnection;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class SendEmailQueryTest extends ApiConnection {
    private static final Logger logger = LoggerFactory.getLogger(SendEmailQueryTest.class);

    @Test
    public void query_send()  {
        if (requestSpecification == null || response == null) {
            logger.error("RequestSpecification or Response is not initialized.");
            return;
        }
        response = requestSpecification.get("umbraco/Api/Tasks/SendEmails");
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
}
