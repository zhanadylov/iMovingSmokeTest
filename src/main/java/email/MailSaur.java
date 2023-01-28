package email;

import com.mailosaur.MailosaurException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class MailSaur {

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



//        RestAssured.baseURI = "https://mailosaur.com/api/messages?server=kmsjdboo";
//        requestSpecification = RestAssured.given()
//                .given()
//          //      .auth().preemptive().basic("Zk9adJ9bWFEl8Akc","")
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON);

//        Response response = RestAssured
//                .given()
//                .auth().preemptive().basic("Zk9adJ9bWFEl8Akc","")
//                .request("GET");
//
//        response.prettyPrint();
//        System.out.println(response.statusCode());


    }
}
