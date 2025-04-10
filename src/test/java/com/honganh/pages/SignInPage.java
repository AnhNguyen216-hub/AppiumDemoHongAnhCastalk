package com.honganh.pages;

import com.honganh.drivers.DriverManager;
import com.honganh.keywords.MobileUI;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignInPage extends BasePage {
    // Constructor
    public SignInPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    //Element/Locators thuộc chính trang này (màn hình này)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'To Your Castalk')]")
    @iOSXCUITFindBy(xpath = "")
    private WebElement headerSignInPage;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "")
    private WebElement emailField;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
    @iOSXCUITFindBy(xpath = "")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign In\"]")
    @iOSXCUITFindBy(xpath = "")
    private WebElement buttonSignIn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Forgot password?\"]")
    @iOSXCUITFindBy(xpath = "")
    private WebElement linkForgotPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Incorrect email address or password. Please try again.\"]")
    @iOSXCUITFindBy(xpath = "")
    private WebElement errorMessageIncorrectEmailPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Incorrect email address format. Please try again.\"]")
    @iOSXCUITFindBy(xpath = "")
    private WebElement errorMessageIncorrectEmailFormat;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Don’t have an account? Sign up here\"]")
    @iOSXCUITFindBy(xpath = "")
    private WebElement linkSignUpHere;


    //Các hàm xử lý trong chính nội bộ trang này (màn hình này)
    public void verifySignInPageDisplay() {
        MobileUI.verifyElementPresentAndDisplayed(headerSignInPage, "The Login page not display. (Header not found)");
        System.out.println("The Login page display.");
    }

    public void signIn(String email, String password) {
        MobileUI.clickElement(emailField); // Click vào email field
        MobileUI.setText(emailField, email); // Nhập email
        MobileUI.clickElement(passwordField); // Click vào password field
        MobileUI.setText(passwordField, password); // Nhập password
        MobileUI.setKey(Keys.TAB);
        MobileUI.sleep(1);
        MobileUI.setKey(Keys.TAB);
        MobileUI.sleep(1);
        MobileUI.verifyElementEnabled(buttonSignIn, "The Sign In button is disabled.");
        MobileUI.clickElement(buttonSignIn); // Click nút sign in
    }

    public HomePage verifySignInSuccess() {
        new HomePage().verifyHomePageDisplay();

        return new HomePage();
    }

    public void verifySignInFail() {
        // Sử dụng hàm verify trong class MobileUI
        MobileUI.verifyElementPresentAndDisplayed(errorMessageIncorrectEmailPassword, "The error message not display.");
        System.out.println(MobileUI.getElementText(errorMessageIncorrectEmailPassword));
        MobileUI.verifyElementText(errorMessageIncorrectEmailPassword, "Incorrect email address or password. Please try again.",
                "The content of error message not display.");
    }

    public void verifySignInFailFormat() {
        // Sử dụng hàm verify trong class MobileUI
        MobileUI.verifyElementPresentAndDisplayed(errorMessageIncorrectEmailFormat, "The error message not display.");
        System.out.println(MobileUI.getElementText(errorMessageIncorrectEmailFormat));
        MobileUI.verifyElementText(errorMessageIncorrectEmailFormat, "Incorrect email address format. Please try again.",
                "The content of error message not display.");
    }

    public void verifySignInButtonDisable(String email, String password) {
        MobileUI.clickElement(emailField); // Click vào email field
        MobileUI.setText(emailField, email); // Nhập email
        MobileUI.clickElement(passwordField); // Click vào password field
        MobileUI.setText(passwordField, password); // Nhập password
        MobileUI.setKey(Keys.TAB);
        MobileUI.sleep(1);
        MobileUI.verifyElementNotClickable(buttonSignIn, "The Sign In button is clickable.");
    }
}