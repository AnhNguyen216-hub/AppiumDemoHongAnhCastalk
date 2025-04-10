package com.honganh.pages;

import com.honganh.drivers.DriverManager;
import com.honganh.keywords.MobileUI;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//T0.q0//android.view.View[1]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement buttonCall;

    @AndroidFindBy(xpath = "//T0.q0//android.view.View[1]/android.widget.Button[2]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement buttonVideo;

    @AndroidFindBy(xpath = "//T0.q0//android.view.View[1]/android.widget.Button[3]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement buttonChat;

    public void verifyHomePageDisplay() {
        MobileUI.verifyElementPresentAndDisplayed(buttonCall, "The Home page not display. (button Call not found)");
        System.out.println("The Home page display.");
    }

    public CallPage clickCallButton() {
        MobileUI.clickElement(buttonCall);

        return new CallPage();
    }

    public void clickVideoButton() {
        MobileUI.clickElement(buttonVideo);
    }

    public ChatPage clickChatButton() {
        MobileUI.clickElement(buttonChat);

        return new ChatPage();
    }

}