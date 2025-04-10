package com.honganh.testcases;

import com.honganh.common.BaseTest;
import com.honganh.pages.BasePage;
import com.honganh.pages.SignInPage;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    SignInPage signInPage;
    BasePage basePage;

    @Test(priority = 1)
    public void testLoginSuccess() {
        signInPage = new SignInPage();
        signInPage.gotoSignInPage();
        signInPage.signIn("castalk6@gmail.com", "Luu9i20nm@nj");
        signInPage.verifySignInSuccess();
    }

    @Test(priority = 2)
    public void testLoginFailWithEmailIncorrect() {
        signInPage = new SignInPage();
        signInPage.gotoSignInPage();
        signInPage.signIn("castalk@gmail.com", "Luu9i20nm@nj");
        signInPage.verifySignInFail();
    }

    @Test(priority = 3)
    public void testLoginFailWithPasswordIncorrect() {
        signInPage = new SignInPage();
        signInPage.gotoSignInPage();
        signInPage.signIn("castalk6@gmail.com", "123456");
        signInPage.verifySignInFail();
    }

    @Test(priority = 4)
    public void testLoginFailWithEmailIncorrectFormat() {
        signInPage = new SignInPage();
        signInPage.gotoSignInPage();
        signInPage.signIn("test.gmail.com", "Luu9i20nm@nj");
        signInPage.verifySignInFailFormat();
    }

    @Test(priority = 5)
    public void testLoginNoSetEmailOrPasswordField() {
        signInPage = new SignInPage();
        signInPage.gotoSignInPage();
        signInPage.verifySignInButtonDisable("", "Luu9i20nm@nj");
    }
}
