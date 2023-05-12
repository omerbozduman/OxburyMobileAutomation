package com.bbc_news.pages.actions;

import com.bbc_news.pages.identifiers.LoginPageIdentifiers;
import com.bbc_news.utilities.ConfigurationReader;

public class LoginPageActions extends CommonActions {

    LoginPageIdentifiers loginPageIdentifiers;
    public LoginPageActions(){
        loginPageIdentifiers = new LoginPageIdentifiers();
    }

    public void clickSignIn(){
        clickButton(loginPageIdentifiers.signInButton);
    }

    public String getSignIntoYourAccountTitle(){
        String text = getTextOfElement(loginPageIdentifiers.signInToYourAccountTitle);
        int index = text.indexOf("B");
        String firstPart = text.substring(0 , index-1);
        String secondPart = text.substring(index-1);
        text = (firstPart + " " + secondPart.replaceAll("(?m)^\\s*$[\n\r]{1,}", "")).replaceAll(" ", " ");
        return text;
    }

    public void continueSignInToMyAccount(){
        clickButton(loginPageIdentifiers.continueSignIn);
        try{
            clickButton(loginPageIdentifiers.okButtonForNotification);
            clickButton(loginPageIdentifiers.yesButtonForAccessibility);
        }catch (Exception exception){
            System.out.println("exception = " + exception);
        }
    }

    public void loginToBbcAccount(){
        clickSignIn();
        continueSignInToMyAccount();
    }

    public String getSignInPageTitle(){
        return getTextOfElement(loginPageIdentifiers.signInPageTitle);
    }

    public void enterUserName(){
        String userName = ConfigurationReader.get("userName");
        enterTextToField(loginPageIdentifiers.userNameField , userName);
    }

    public void enterPassword(){
        String password = ConfigurationReader.get("password");
        enterTextToField(loginPageIdentifiers.passwordField , password);
    }

    public void signInAfterEnterCredentials(){
        clickButton(loginPageIdentifiers.signInButtonOnTheSignInPage);
    }

    public void signInToBbcAccountWithYourCredentials(){
        clickButton(loginPageIdentifiers.signInButton);
        String userName = ConfigurationReader.get("userName");
        enterTextToField(loginPageIdentifiers.userNameField , userName);
        String password = ConfigurationReader.get("password");
        enterTextToField(loginPageIdentifiers.passwordField , password);
        clickButton(loginPageIdentifiers.signInButtonOnTheSignInPage);

    }
}
