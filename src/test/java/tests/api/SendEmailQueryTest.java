package tests.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.apiConnection.ApiConnection;
import org.example.hooks.TestListener;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
@Listeners(TestListener.class)
public class SendEmailQueryTest extends ApiConnection {
    private static final Logger logger = LogManager.getLogger(SendEmailQueryTest.class);

//    RequestSpecification requestSpecification = requestSpecificationThreadLocal.get();

    @Test
    public void sendQueryForSendsEmails()  {
        sendQueryEndPoints("umbraco/Api/Tasks/SendEmails");
    }
}
