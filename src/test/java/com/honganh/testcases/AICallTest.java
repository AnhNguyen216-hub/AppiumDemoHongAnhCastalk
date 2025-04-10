package com.honganh.testcases;

import com.honganh.common.BaseTest;
import com.honganh.pages.BasePage;
import com.honganh.pages.CallPage;
import com.honganh.pages.ChatPage;
import com.honganh.pages.HomePage;
import org.testng.annotations.Test;

public class AICallTest extends BaseTest {
    BasePage basePage;
    HomePage homePage;
    CallPage callPage;

    @Test(priority = 1)
    public void test_AI_Call_Success() {
        homePage = new HomePage();
        homePage.gotoHomePage();
        homePage.verifyHomePageDisplay();
        callPage = homePage.clickCallButton();

        callPage.verifyCallPageDisplay();

        callPage.verifyCallSuccess();
    }

    @Test(priority = 2)
    public void test_End_Call() {
        homePage = new HomePage();
        homePage.gotoHomePage();
        homePage.verifyHomePageDisplay();
        callPage = homePage.clickCallButton();
        callPage.verifyCallPageDisplay();
        callPage.verifyCallSuccess();
        callPage.clickEndCallButton();
        callPage.verifyEndCallSuccess();
    }
}
