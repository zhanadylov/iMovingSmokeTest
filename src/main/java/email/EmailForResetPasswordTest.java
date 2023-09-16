package email;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSummary;
import com.mailosaur.models.SearchCriteria;
import org.testng.annotations.Test;

import java.io.IOException;

public class EmailForResetPasswordTest extends MailSaur {
    static String apiKey = "Db9DvpYQ8Gyk28xB";
    static String serverId = "kmsjdboo";
    String serverDomain = "kmsjdboo.mailosaur.net";


@Test
    public static void check_email_for_reset_password() throws IOException {
        try {
            MailosaurClient mailosaur = new MailosaurClient(apiKey);
            SearchCriteria criteria = new SearchCriteria();
            criteria.withSentFrom("info@imoving.com");
            criteria.withSentTo("qatestimoving@gmail.com");
            criteria.withSubject("iMoving reset password request");

            Message message = mailosaur.messages().get(serverId, criteria);
            System.out.println("Subject: " + message.subject());

//            Assert.assertTrue(message.text().body().contains(currentOrderNumber));

        } catch (MailosaurException e) {
            e.printStackTrace();
            System.err.println("Customer is not get the Email");
        }
    }
//    public void check_for_mover(String confirmText){
//        Helper.pause(120000);
//
//        try {
//            criteria.withSentFrom("info@imoving.com");
//            criteria.withSentTo("kmsjdboo@mailosaur.net");
//            criteria.withSubject("Your booking is confirmed - iMoving order number ".concat(currentOrderNumber));
//            String expected = confirmText + " " + currentOrderNumber;
//            Message message = mailosaur.messages().get(serverId, criteria);
//            System.out.println("Subject: " + message.subject());
//            String actual = message.subject();
//            Assert.assertEquals("Comparing emails: ", expected, actual);
//        } catch (MailosaurException | IOException e) {
//            e.printStackTrace();
//            System.err.println("Mover is not get the Email");
//        }
//    }
//
//    public void check_gmail_email_should_appear(String anotherOrder) throws MailosaurException, IOException {
//        Helper.pause(120000);
//        try {
//            criteria.withSentFrom("info@imoving.com");
//            criteria.withSentTo("kmsjdboo@mailosaur.net");
//            criteria.withSubject(anotherOrder);
//            Message message = mailosaur.messages().get(serverId, criteria);
//            System.out.println("Subject: " + message.subject());
//            String actual = message.subject();
//            Assert.assertEquals("Comparing emails: ", anotherOrder, actual);
//            String getThisJobLink = message.html().links().get(2).href();
//            driver.get(getThisJobLink);
//        } catch (MailosaurException e) {
//            e.printStackTrace();
//        }
//    }
}
