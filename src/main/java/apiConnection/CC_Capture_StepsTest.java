package apiConnection;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CC_Capture_StepsTest extends ApiConnection{
//    static RequestSpecification requestSpecification;
//    static Response response;


    @Test
    public void query_sended()  {
        response = requestSpecification.post("umbraco/Api/Tasks/CCCaptureTask");
        response.prettyPrint();
    }

    @Test
    public void status_code_is_returned_for_response() {
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }
    @Test
    public void send_Email() {
        response = requestSpecification.post("umbraco/Api/Tasks/CaptureEmailTask");
        response.prettyPrint();
    }
}
