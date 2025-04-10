package com.honganh.pages;

import com.honganh.drivers.DriverManager;
import com.honganh.keywords.MobileUI;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        // Constructor
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Home\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement menuHome;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Together\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement menuTogether;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Style\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement menuStyle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"History\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement menuHistory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"More\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement menuMore;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Agree and Continue\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement selectAgreeAndContinue;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    @iOSXCUITFindBy(id = "")
    public WebElement permission_allow_button;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    @iOSXCUITFindBy(id = "")
    public WebElement permission_deny_button;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    @iOSXCUITFindBy(id = "")
    public WebElement permission_message;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    @iOSXCUITFindBy(id = "")
    public WebElement permission_allow_one_time_button;

    public UserProfilePage clickMenuMore() {
        MobileUI.clickElement(menuMore);

        return new UserProfilePage();
    }

    public HomePage gotoHomePage() {
        MobileUI.clickElement(selectAgreeAndContinue);
        MobileUI.sleep(2);
        MobileUI.clickElement(permission_allow_button);
        MobileUI.swipe(600, 2000, 600, 200, 200);
        MobileUI.sleep(7);
        new HomePage().verifyHomePageDisplay();

        return new HomePage();
    }

    public SignInPage gotoSignInPage() {
        MobileUI.clickElement(selectAgreeAndContinue);
        MobileUI.sleep(2);
        MobileUI.clickElement(permission_allow_button);
        MobileUI.swipe(600, 2000, 600, 200, 200);
        MobileUI.sleep(7);
        new HomePage().verifyHomePageDisplay();
        clickMenuMore();
        new UserProfilePage().verifyUserProfilePageDisplay();
        new UserProfilePage().clickSignInButton();
        new UserProfilePage().clickSignInWithEmailButton();

        return new SignInPage();
    }

    public void clickPermissionAllowOneTimeButton() {
        MobileUI.clickElement(permission_allow_one_time_button);
    }

}
