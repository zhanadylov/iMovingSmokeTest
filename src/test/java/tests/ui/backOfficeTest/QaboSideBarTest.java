package tests.ui.backOfficeTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helper.Helper;
import org.example.ui.methods.BaseTest;
import org.example.ui.methods.BaseTestQaBO;
import org.example.ui.qabo.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.example.utilities.Driver;

//@Listeners(TestListener.class)
@Feature("Checking that side bar in qabo opens")
public class QaboSideBarTest extends BaseTest {
//    private static final Logger logger = LoggerFactory.getLogger(QaboSideBarTest.class);
    private static final Logger logger = LogManager.getLogger(QaboSideBarTest.class);

    static LoginPage loginPage = new LoginPage();
    QaboDashBoardPage qaboDashBoardPage = new QaboDashBoardPage();
    OrdersListPageInQabo ordersListPageInQabo = new OrdersListPageInQabo();
    UsersQabo usersQabo = new UsersQabo();
    CompaniesQabo companiesQabo = new CompaniesQabo();
    BranchesQabo branchesQabo = new BranchesQabo();
    AffiliatesQabo affiliatesQabo = new AffiliatesQabo();
    FinancialQabo financialQabo = new FinancialQabo();
    SupplierRequestsQabo supplierRequestsQabo = new SupplierRequestsQabo();
    CalendarQabo calendarQabo = new CalendarQabo();
    ReviewsQabo reviewsQabo = new ReviewsQabo();

//    private static WebDriver driver = Driver.getDriver();

    public QaboSideBarTest(){
        super("environmentBO");
    }
//    @BeforeClass
//    @Description("Setup in QaboSideBarTest")
//    public static void setUp(){
//        Helper.waitForElementVisibilityOf(loginPage.iMovingManagementText);
//        Helper.waitForElementVisibilityOf(loginPage.emailInputFieldBo);
//        Helper.sendKeys(loginPage.emailInputFieldBo, "qa.imoving@gmail.com");
//        Helper.sendKeys(loginPage.passwordInputFieldBo, "QATest-2022");
//        Helper.click(loginPage.signInButtonBo);
//    }

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
        ordersListPageInQabo.ordersTitleText.isDisplayed();
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

    //Pricing Tools
    @Test
    public void qaDiscounts(){
        Helper.click(qaboDashBoardPage.pricingToolsSideBar);
        qaboDashBoardPage.discountsPricingTool.isDisplayed();
        Helper.click(qaboDashBoardPage.discountsPricingTool);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Discounts");
    }
    @Test
    public void qaFees(){
        Helper.click(qaboDashBoardPage.pricingToolsSideBar);
        qaboDashBoardPage.feesPricingTool.isDisplayed();
        Helper.click(qaboDashBoardPage.feesPricingTool);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Fees");
    }
    @Test
    public void qaFlexibility(){
        Helper.click(qaboDashBoardPage.pricingToolsSideBar);
        qaboDashBoardPage.flexibilityPricingTool.isDisplayed();
        Helper.click(qaboDashBoardPage.flexibilityPricingTool);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/FlexibilitySettings/Index/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaDelivery(){
        Helper.click(qaboDashBoardPage.pricingToolsSideBar);
        qaboDashBoardPage.deliveryPricingTool.isDisplayed();
        Helper.click(qaboDashBoardPage.deliveryPricingTool);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/DeliverySettings/Index/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaDefault(){
        Helper.click(qaboDashBoardPage.pricingToolsSideBar);
        qaboDashBoardPage.defaultPricingTool.isDisplayed();
        Helper.click(qaboDashBoardPage.defaultPricingTool);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Company/DefaultFee/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaService(){
        Helper.click(qaboDashBoardPage.pricingToolsSideBar);
        qaboDashBoardPage.servicePricingTool.isDisplayed();
        Helper.click(qaboDashBoardPage.servicePricingTool);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Company/ServiceFee/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    //Tools
    @Test
    public void qaCarriers(){
        Helper.click(qaboDashBoardPage.toolsSideBar);
        qaboDashBoardPage.carrierSearchTools.isDisplayed();
        Helper.click(qaboDashBoardPage.carrierSearchTools);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Tools");
    }
    //Lists
    @Test
    public void qaMerchant(){
//        Helper.click(qaboDashBoardPage.listsSideBar);
        qaboDashBoardPage.merchantLists.isDisplayed();
        Helper.click(qaboDashBoardPage.merchantLists);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Orders/AuthorizeList/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaFee(){
        Helper.click(qaboDashBoardPage.listsSideBar);
        qaboDashBoardPage.feeTypesLists.isDisplayed();
        Helper.click(qaboDashBoardPage.feeTypesLists);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/FeeType/Index/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaTruck(){
        Helper.click(qaboDashBoardPage.listsSideBar);
        qaboDashBoardPage.truckTypesLists.isDisplayed();
        Helper.click(qaboDashBoardPage.truckTypesLists);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/TruckType/Index/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaLicense(){
//        Helper.click(qaboDashBoardPage.listsSideBar);
        qaboDashBoardPage.licensesTypesLists.isDisplayed();
        Helper.click(qaboDashBoardPage.licensesTypesLists);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/LicenseType/Index/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaInsurance(){
        Helper.click(qaboDashBoardPage.listsSideBar);
        qaboDashBoardPage.insuranceTypesLists.isDisplayed();
        Helper.click(qaboDashBoardPage.insuranceTypesLists);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/InsuranceType/Index/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaServiceLists(){
        Helper.click(qaboDashBoardPage.listsSideBar);
        qaboDashBoardPage.serviceTypesLists.isDisplayed();
        Helper.click(qaboDashBoardPage.serviceTypesLists);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/BranchServiceType");
    }
    @Test
    public void qaOrdersCancelling(){
        Helper.click(qaboDashBoardPage.listsSideBar);
        qaboDashBoardPage.orderCancellingTypesLists.isDisplayed();
        Helper.click(qaboDashBoardPage.orderCancellingTypesLists);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/OrderCancellingReason/Index/5730743773507A72366A6C49577A31325165504561773D3D");
    }
    @Test
    public void qaSpecial(){
//        Helper.click(qaboDashBoardPage.listsSideBar);
        qaboDashBoardPage.specialTypesLists.isDisplayed();
        Helper.click(qaboDashBoardPage.specialTypesLists);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qabo.imoving.com/Tariff/SpecialItemsView/5730743773507A72366A6C49577A31325165504561773D3D");
    }
}
