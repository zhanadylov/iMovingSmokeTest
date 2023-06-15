package tests;

import helper.Helper;
import hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.methods.SetUp;
import ui.pageObjectModel.FooterLinksPages;

public class FooterLinksTest extends Hooks implements SetUp{

    FooterLinksPages footerLinksPages = new FooterLinksPages();

    @Test
    public void footerMenuTest(){
//        Helper.javascriptScrollDownThePage();
        Helper.javascriptScrollIntoView(footerLinksPages.aboutUsLink);
        Helper.pause(1000);
        Helper.navigateToElement(footerLinksPages.aboutUsLink);
        Helper.click(footerLinksPages.aboutUsLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.imoving.com/about-us/");
        footerLinksPages.iMovingInaNutshellTitle.isDisplayed();
        Assert.assertEquals(footerLinksPages.iMovingInaNutshellTitle.getText(), "iMoving in a Nutshell");
        Helper.javascriptScrollIntoView(footerLinksPages.ourMoversLink);
        Helper.click(footerLinksPages.ourMoversLink);
    }
}
