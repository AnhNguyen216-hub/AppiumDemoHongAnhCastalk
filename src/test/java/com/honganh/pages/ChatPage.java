package com.honganh.pages;

import com.honganh.drivers.DriverManager;
import com.honganh.keywords.MobileUI;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ChatPage extends BasePage {

    public ChatPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Today\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement labelToday;

    @AndroidFindBy(accessibility = "call icon")
    @iOSXCUITFindBy(accessibility = "call icon")
    public WebElement callIcon;

    @AndroidFindBy(accessibility = "report icon")
    @iOSXCUITFindBy(accessibility = "report icon")
    public WebElement reportIcon;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(xpath = "")
    public WebElement inputChatText;

    @AndroidFindBy(xpath = "((//android.widget.TextView[@text=\"Your name\"])[1])/following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "")
    public WebElement inputYourName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Confirm\"]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement buttonConfirm;

    @AndroidFindBy(xpath = "(//android.view.View[1]/android.widget.Button)[1]")
    @iOSXCUITFindBy(xpath = "")
    public WebElement buttonBack;


    public void verifyChatPageDisplay() {
        MobileUI.waitForElementVisibe(labelToday);
        MobileUI.verifyElementPresentAndDisplayed(labelToday, "The Chat page not display. (label Today not found)");
        System.out.println("The Chat page is display.");
    }

    public void inputYourName(String name) {
        MobileUI.waitForElementVisibe(inputYourName, 30);
        MobileUI.setText(inputYourName, name);
    }

    public void clickConfirmButton() {
        MobileUI.clickElement(buttonConfirm);
    }

    public void chatTextAndSend(String text) {
        MobileUI.setText(inputChatText, text);
        MobileUI.sleep(1);
        MobileUI.clickElement(By.xpath("//android.widget.EditText[@text='" + text + "']/android.widget.Button"));
        MobileUI.sleep(1);
        verifyChatTextSent(text);
    }

    public void verifyChatTextSent(String text) {
        MobileUI.verifyElementPresentAndDisplayed(By.xpath("//android.widget.TextView[@text='" + text + "']"), "The chat text not found.");
        System.out.println("The chat text is display.");
    }

    public void clickBackButton() {
        MobileUI.clickElement(buttonBack);
    }

    public void verifyEndChatSuccess() {
        MobileUI.waitForElementInvisibe(reportIcon);
        MobileUI.verifyElementNotDisplayed(reportIcon, "The Report icon in Chat page is display.");
        System.out.println("End Chat success.");
    }

}