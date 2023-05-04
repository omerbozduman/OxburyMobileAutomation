package com.bbc_news.pages.identifiers;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginPageIdentifiers {

    public By signInToYourAccountTitle = By.xpath("//*[@resource-id='bbc.mobile.news.uk:id/msiTitle']");
    public By signInButton = AppiumBy.accessibilityId("Sign in to a BBC Account");
    public By continueSignIn = By.xpath("//*[@text='Continue']");
    public By okButtonForNotification = By.xpath("//*[@text='OK']");
    public By yesButtonForAccessibility = By.xpath("//*[@text='YES.']");
    public By signInPageTitle = By.xpath("//*[@text='Sign in']");

    public By userNameField = By.xpath("//*[@resource-id='user-identifier-input']");
    public By passwordField = By.xpath("//*[@resource-id='password-input']");
    public By signInButtonOnTheSignInPage = By.xpath("//*[@resource-id='submit-button']");
}
