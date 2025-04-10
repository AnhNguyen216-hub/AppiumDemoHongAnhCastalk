package com.honganh.testcases;

import com.honganh.common.BaseTest;
import com.honganh.pages.BasePage;
import com.honganh.pages.ChatPage;
import com.honganh.pages.HomePage;
import org.testng.annotations.Test;

public class AIChatTest extends BaseTest {
    BasePage basePage;
    HomePage homePage;
    ChatPage chatPage;

    @Test(priority = 1)
    public void test_AI_Chat() {
        homePage = new HomePage();
        homePage.gotoHomePage();
        homePage.verifyHomePageDisplay();
        chatPage = homePage.clickChatButton();

        chatPage.verifyChatPageDisplay();
        chatPage.chatTextAndSend("Hello, AI!");
    }

    @Test(priority = 2)
    public void test_End_Chat() {
        homePage = new HomePage();
        homePage.gotoHomePage();
        homePage.verifyHomePageDisplay();
        chatPage = homePage.clickChatButton();

        chatPage.verifyChatPageDisplay();
        chatPage.chatTextAndSend("Hi you!");
        chatPage.clickBackButton();
        chatPage.verifyEndChatSuccess();
        homePage.verifyHomePageDisplay();
    }
}
