package apiConnection;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CC_Capture_Steps extends ApiConnection{
//    static RequestSpecification requestSpecification;
//    static Response response;


    @Test
    public static void query_sended()  {
        response = requestSpecification.post("umbraco/Api/Tasks/CCCaptureTask");
        response.prettyPrint();
    }

    @Test
    public static void status_code_is_returned_for_response() {
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }
    @Test
    public static void send_Email() {
        response = requestSpecification.post("umbraco/Api/Tasks/CaptureEmailTask");
        response.prettyPrint();
    }
}
