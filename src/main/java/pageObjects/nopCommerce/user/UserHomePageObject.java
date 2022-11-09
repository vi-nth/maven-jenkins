package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Navigate to Register Page")
	public UserRegisterPageObject clickToRegisterLink() {
	waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
	clickToElement(driver, HomePageUI.REGISTER_LINK);
	return PageGeneratorManager.getRegisterPage(driver);
		
	}
	

	
	@Step("Navigate to Login Page")
	public UserLoginPageObject openLoginPage() {
	waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
	clickToElement(driver, HomePageUI.LOGIN_LINK);
	return PageGeneratorManager.getUserLoginPage(driver);
	
	}
	
	@Step("Verify 'My Account' link is displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	

	public UserRegisterPageObject clickButtonLinkByHref(String href) {
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			driver.get(getElementAttribute(driver, HomePageUI.CLICK_BUTTON_BY_HREF, "href"));
		}else {
			clickToElement(driver, HomePageUI.CLICK_BUTTON_BY_HREF);
		}
		return PageGeneratorManager.getRegisterPage(driver);
	}




}
