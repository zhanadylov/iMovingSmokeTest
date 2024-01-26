package org.example.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.example.utilities.Driver;


public class AlertHelper{
	private static final Logger logger = LogManager.getLogger(AlertHelper.class);

	private WebDriver driver = Driver.getDriver();

	
	public AlertHelper(WebDriver driver) {
		this.driver = driver;

	}
	
	public Alert getAlert() {
		return driver.switchTo().alert();

	}
	
	public void AcceptAlert() {
		logger.info("Alert appeared");
		getAlert().accept();
	}
	
	public void DismissAlert() {
		logger.info("Alert appeared, going to click dismiss button");
		getAlert().dismiss();
	}

	public String getAlertText() {
		String text = getAlert().getText();

		return text;
	}

	public  boolean isAlertPresent() {
		try {
			driver.switchTo().alert().accept();

			return true;
		} catch (NoAlertPresentException e) {
			// Ignore

			return false;
		}
	}

	public void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			return;
		AcceptAlert();

	}

	public void DismissAlertIfPresent() {

		if (!isAlertPresent())
			return;
		DismissAlert();

	}
	
	public void AcceptPrompt(String text) {
		
		if (!isAlertPresent())
			return;
		
		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();

	}
}