package email;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.SearchCriteria;
import helper.Helper;
import org.junit.Assert;

import java.io.IOException;

public class Email_For_Reset_Password extends MailSaur {
    String apiKey = "Db9DvpYQ8Gyk28xB";
    String serverId = "kmsjdboo";
    String serverDomain = "kmsjdboo.mailosaur.net";

    MailosaurClient mailosaur = new MailosaurClient(apiKey);
    SearchCriteria criteria = new SearchCriteria();


    public void check_email_for_reset_password() throws MailosaurException, IOException {
        try {
            criteria.withSentFrom("info@imoving.com");
            criteria.withSentTo("qa@imoving.com");
            criteria.withSubject("iMoving reset password request");

            Message message = mailosaur.messages().get(serverId, criteria);
            System.out.println("Subject: " + message.subject());

//            Assert.assertTrue(message.text().body().contains(currentOrderNumber));

        } catch (MailosaurException | IOException e) {
            e.printStackTrace();
            System.err.println("Mover is not get the Email");
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
