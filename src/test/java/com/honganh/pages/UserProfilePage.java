package com.honganh.pages;

import com.honganh.drivers.DriverManager;
import com.honganh.keywords.MobileUI;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage extends BasePage {

    public UserProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"User Profile\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement headerUserProfile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign In\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement buttonSignIn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign in with email\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement buttonSignInWithEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign Out\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement buttonSignOut;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Sign Out\"])[2]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement buttonSignOutOnDialog;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Cancel\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement buttonCancelOnDialog;

    public void verifyUserProfilePageDisplay() {
        MobileUI.verifyElementPresentAndDisplayed(headerUserProfile, "The More page not display. (header User Profile not found)");
        System.out.println("The Home page display.");
    }

    public SignInPage clickSignInButton() {
        MobileUI.clickElement(buttonSignIn);
        return new SignInPage();
    }

    public SignInPage clickSignInWithEmailButton() {
        MobileUI.clickElement(buttonSignInWithEmail);
        return new SignInPage();
    }

    public void clickSignOutButton() {
        MobileUI.clickElement(buttonSignOut);
    }
}