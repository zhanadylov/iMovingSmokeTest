package tests.backOfficeTest;

import helper.BrowserHelper;
import helper.DropDownHelper;
import helper.Helper;
import hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.methods.SaveOrderInfo;
import ui.methods.SetUpBO;
import ui.qabo.*;


public class QaboSideBarTest extends Hooks implements SetUpBO {

    LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersPageInQabo ordersPageInQabo = new OrdersPageInQabo();
    DropDownHelper dropDownHelper = new DropDownHelper();
    SaveOrderInfo saveOrderInfo = new SaveOrderInfo();
    BrowserHelper browserHelper = new BrowserHelper(driver);
    OrderInfoQaBo orderInfoQaBo = new OrderInfoQaBo();
    UsersQabo usersQabo = new UsersQabo();
    CompaniesQabo companiesQabo = new CompaniesQabo();
    BranchesQabo branchesQabo = new BranchesQabo();
    AffiliatesQabo affiliatesQabo = new AffiliatesQabo();
    FinancialQabo financialQabo = new FinancialQabo();
    SupplierRequestsQabo supplierRequestsQabo = new SupplierRequestsQabo();
    CalendarQabo calendarQabo = new CalendarQabo();
    ReviewsQabo reviewsQabo = new ReviewsQabo();

    @BeforeTest
    public void loginToQaBO(){
//        driver.get("https://qabo.imoving.com/Account/Login");
        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
        Helper.click(loginPage.signInButtonBo);
    }

    @Test
    public void qaDashBoard(){
        Helper.click(qaboDashBoardPage.dashboardLabelInSideBar);
        qaboDashBoardPage.ordersDashboardTitle.isDisplayed();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Orders/Index/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaUsers(){
        Helper.click(qaboDashBoardPage.usersLabelInSideBar);
        usersQabo.usersTitle.isDisplayed();
        usersQabo.createNewUserButton.isDisplayed();
        usersQabo.createNewUserButton.isEnabled();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/UsersAdmin/UsersIndex/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaCompanies(){
        Helper.click(qaboDashBoardPage.companiesLabelInSideBar);
        companiesQabo.companiesTitle.isDisplayed();
        companiesQabo.createNewCompanyButton.isDisplayed();
        companiesQabo.createNewCompanyButton.isEnabled();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Company/Index/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaBranches(){
        Helper.click(qaboDashBoardPage.branchesLabelInSideBar);
        branchesQabo.branchesTitle.isDisplayed();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Branch/List/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaAffiliates(){
        Helper.click(qaboDashBoardPage.affiliatesLabelInSideBar);
        affiliatesQabo.affiliatesTitle.isDisplayed();
        affiliatesQabo.createNewAffiliatesButton.isDisplayed();
        affiliatesQabo.createNewAffiliatesButton.isEnabled();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Affiliate/Index/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaOrders(){
        Helper.click(qaboDashBoardPage.ordersLabelInSideBar);
        ordersPageInQabo.ordersTitleText.isDisplayed();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Orders/Orders/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaFinancial(){
        Helper.click(qaboDashBoardPage.financialLabelInSideBar);
        financialQabo.financialTitle.isDisplayed();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Financial/List/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaSupplierRequests(){
        Helper.click(qaboDashBoardPage.supplierRequestsLabelInSideBar);
        supplierRequestsQabo.supplierRequestsTitle.isDisplayed();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/JoiningRequests");
    }
    @Test
    public void qaCalendar(){
        Helper.click(qaboDashBoardPage.calendarLabelInSideBar);
        calendarQabo.calendarTitle.isDisplayed();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Calendar");
    }
    @Test
    public void qaReview(){
        Helper.click(qaboDashBoardPage.reviewLabelInSideBar);
        reviewsQabo.reviewsTitle.isDisplayed();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Reviews");
    }
}
