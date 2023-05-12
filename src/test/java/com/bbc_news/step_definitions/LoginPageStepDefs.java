package com.bbc_news.step_definitions;

import com.bbc_news.pages.actions.LoginPageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageStepDefs {

    LoginPageActions loginPageActions;
    public LoginPageStepDefs(){
        loginPageActions = new LoginPageActions();
    }

    @Given("I have launched the BBC news app")
    public void iHaveLaunchedTheBBCNewsApp() {

    }

    @When("{string} title is displayed")
    public void title_is_displayed(String expectedTitle) {
        String actualTitle = loginPageActions.getSignIntoYourAccountTitle();
        System.out.println("actualTitle = " + actualTitle.length());
        System.out.println("expectedTitle = " + expectedTitle.length());
        Assert.assertEquals(expectedTitle , actualTitle);
    }

    @Then("I click the sign in button")
    public void iClickTheSignInButton() {
        loginPageActions.clickSignIn();
    }

    @And("I continue to sign in my account")
    public void iContinueToSignInMyAccount() {
        loginPageActions.continueSignInToMyAccount();
    }

    @Given("I have logged into my BBC News account")
    public void i_have_logged_into_my_bbc_news_account() {
        loginPageActions.loginToBbcAccount();
       // loginPageActions.signInToBbcAccountWithYourCredentials();
    }


    @When("{string} page appears on the screen")
    public void pageAppearsOnTheScreen(String expectedPageTitle) {
        String actualPageTitle = loginPageActions.getSignInPageTitle();
        Assert.assertEquals(expectedPageTitle , actualPageTitle);
    }

    @Then("I enter my username")
    public void iEnterMyUsername() {
        loginPageActions.enterUserName();
    }

    @And("I enter my password")
    public void iEnterMyPassword() {
        loginPageActions.enterPassword();
    }

    @Then("I click sign in button")
    public void iClickSignInButton() {
        loginPageActions.signInAfterEnterCredentials();
    }
}
