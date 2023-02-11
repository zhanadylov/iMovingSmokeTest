package apiConnection;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class SendEmailQuery extends ApiConnection{

    @Test
    public static void query_sended()  {
        response = requestSpecification.post("umbraco/Api/Tasks/SendEmails");
        response.prettyPrint();
    }

    @Test
    public static void status_code_is_returned_for_response() {
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }
}
