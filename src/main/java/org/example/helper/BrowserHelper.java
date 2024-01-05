package org.example.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.util.LinkedList;
import java.util.Set;

import static org.example.utilities.Driver.clear_Cookies_And_Storage;


public class BrowserHelper{

//	private final WebDriver driver;
//	public BrowserHelper(WebDriver driver) {
//		this.driver = driver;
//	}

	public void newWindow(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open()");
	}

	public void goBack(WebDriver driver) {
		driver.navigate().back();

	}

	public void goForward(WebDriver driver) {
		driver.navigate().forward();

	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Set<String> getWindowHandles(WebDriver driver) {

		return driver.getWindowHandles();
	}

	public void SwitchToWindow(int index, WebDriver driver) {

		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandles(driver));

		if (index < 0 || index > windowsId.size())
			throw new IllegalArgumentException("Invalid Index : " + index);

		driver.switchTo().window(windowsId.get(index));

	}

	public void switchToParentWindow(WebDriver driver) {
		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandles(driver));
		driver.switchTo().window(windowsId.get(0));

	}

	public void switchToParentWithChildClose(WebDriver driver) {
		switchToParentWindow(driver);

		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandles(driver));

		for (int i = 1; i < windowsId.size(); i++) {
			driver.switchTo().window(windowsId.get(i));
			driver.close();
		}
		switchToParentWindow(driver);
	}

	public void switchToFrame(String nameOrId, WebDriver driver) {
		driver.switchTo().frame(nameOrId);
	}

	@AfterTest
	public void clearCookiesAndLocalStorage(WebDriver driver){
		if(clear_Cookies_And_Storage){
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			driver.manage().deleteAllCookies();
			javascriptExecutor.executeScript("window.sessionStorage()");
		}
	}

}