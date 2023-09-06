package apiConnection;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class SendEmailQueryTest extends ApiConnection{

    @Test
    public void query_send()  {
        response = requestSpecification.get("umbraco/Api/Tasks/SendEmails");
        response.prettyPrint();
    }

    @Test
    public void status_code_is_returned_for_response() {
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }
}
