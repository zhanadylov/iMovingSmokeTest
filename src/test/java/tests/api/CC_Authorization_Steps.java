package tests.api;

import org.example.apiConnection.ApiConnection;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CC_Authorization_Steps extends ApiConnection {
//    private static final Logger logger = LoggerFactory.getLogger(CC_Authorization_Steps.class);

//    static RequestSpecification requestSpecification;
//    static Response response;


    @Test
    public static void query_sending() {
        response = requestSpecification.post("umbraco/Api/Tasks/CCAuthorizationTask");
        response.prettyPrint();
    }

    @Test
    public static void response_status_is()  {
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }
}
