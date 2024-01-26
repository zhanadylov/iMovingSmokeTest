package org.example.email;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class MailSaur {
    String apiKey = "Db9DvpYQ8Gyk28xB";
    String serverId = "kmsjdboo";
    String serverDomain = "mxil4fbe.mailosaur.net";
    MailosaurClient mailosaur = new MailosaurClient(apiKey);
    SearchCriteria criteria = new SearchCriteria();
    MessageSearchParams params = new MessageSearchParams();

    public static void main(String[] args) throws IOException, MailosaurException {

        RequestSpecification requestSpecification;
//        given().auth().preemptive().basic("Zk9adJ9bWFEl8Akc","")
//                .when().get("https://mailosaur.com/api/messages?server=kmsjdboo")
//                .prettyPrint();

        requestSpecification =
                given().auth().preemptive().basic("Zk9adJ9bWFEl8Akc", "");

        Response response = requestSpecification.get("https://mailosaur.com/api/messages?server=kmsjdboo");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }
}
