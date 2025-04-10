package com.honganh.pages;

import com.honganh.drivers.DriverManager;
import com.honganh.keywords.MobileUI;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CallPage extends BasePage {

    public CallPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Rina Haruyama\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement labelRinaHaruyama;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Calling…\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement labelCalling;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Hello, I’m Rina Haruyama, your dedicated secretary avatar, evolved to serve you!\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement contentHelloOfRinaHaruyama;

    @AndroidFindBy(xpath = "//android.view.View/android.widget.Button[4]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement buttonEndCall;

    public void verifyCallPageDisplay() {
        clickPermissionAllowOneTimeButton();
        MobileUI.waitForElementVisibe(labelRinaHaruyama);
        MobileUI.verifyElementPresentAndDisplayed(labelRinaHaruyama, "The Call page not display. (label Rina Haruyama not found)");
        System.out.println("The Call page is display.");
    }

    public void verifyCallSuccess() {
        MobileUI.verifyElementPresentAndDisplayed(labelCalling,"The label Calling not display.");
        MobileUI.waitForElementInvisibe(labelCalling);
        MobileUI.verifyElementNotDisplayed(labelCalling,"The label Calling is display.");
        System.out.println("Call success.");
    }

    public void clickEndCallButton() {
        MobileUI.clickElement(buttonEndCall, 30);
    }

    public void verifyEndCallSuccess(){
        MobileUI.waitForElementInvisibe(buttonEndCall);
        MobileUI.verifyElementNotDisplayed(buttonEndCall,"The End Call button is display.");
        System.out.println("End Call success.");
    }

}