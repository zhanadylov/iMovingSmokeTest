package tests.backOfficeTest;

import helper.Helper;
import hooks.Hooks;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.methods.CalendarClass;
import ui.methods.HelperForWeb;
import ui.methods.SetUpBO;
import ui.qabo.LoginPage;
import ui.qabo.OrderInfoQaBo;
import ui.qabo.OrdersListPageInQabo;
import ui.qabo.QaboDashBoardPage;

public class DeliveryProcessTest extends Hooks implements SetUpBO{
    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersListPageInQabo ordersListPageInQabo = new OrdersListPageInQabo();
    OrderInfoQaBo orderInfoQaBo = new OrderInfoQaBo();
    CalendarClass calendarClass = new CalendarClass();
    HelperForWeb helperForWeb = new HelperForWeb();
    String newAddressValue;
    String newAdddedAddressValue;
    String moverPassword = "Star12@";

    String orderNumber = "";
    String moverName = "";
    String moverEmail = "";
    @BeforeTest
    public void loginToQaBO(){
        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
        Helper.click(loginPage.signInButtonBo);
    }

    @Test
    public void deliveryProcess(){
        //TODO
    }
}
