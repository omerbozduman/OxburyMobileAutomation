package com.bbc_news.step_definitions;

import com.bbc_news.pages.actions.HomePageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class HomePageStepDefs {

    HomePageActions homePageActions;
    public HomePageStepDefs(){
        homePageActions = new HomePageActions();
    }

    @Then("I click the search button")
    public void iClickTheSearchButton() {
        homePageActions.clickSearchButton();
    }

    @When("{string} is displayed on the search page")
    public void isDisplayedOnTheSearchPage(String expectedTitle) {
        String actualTitle = homePageActions.getMoreTopicsTitle();
        Assert.assertEquals(expectedTitle , actualTitle);
    }

    @Then("I search for {string}")
    public void iSearchFor(String topic) {
        homePageActions.searchTopic(topic);
    }

    @And("{string} {string} is displayed on the page")
    public void isDisplayedOnThePage(String title1, String title2) {
        String expectedTitle = title1 + " \"" + title2 + "\"";
        String actualTitle = homePageActions.getArticlesRelatedTitle();
        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);
        Assert.assertEquals(expectedTitle , actualTitle);
    }

    @Then("all topics on the navigation bar should contain {string}")
    public void allTopicsOnTheNavigationBarShouldContain(String expectedTopic) {
        List<String> listOfText = homePageActions.getTopicsAfterSearch();
        boolean flag = true;
        for (String text:listOfText) {
            if(!text.contains(expectedTopic)){
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @Then("I navigate to home page")
    public void iNavigateToHomePage() {
        homePageActions.navigateToHomePageAfterSearch();
    }

    @Then("following tab titles are displayed on the home page")
    public void following_tab_titles_are_displayed_on_the_home_page(List<String> tabList) {
       Assert.assertTrue(homePageActions.verifyTabListAfterSearch(tabList));
    }

    @Then("I select {string} from more topics")
    public void iSelectFromMoreTopics(String topic) {
        homePageActions.searchFromMoreTopic(topic);
    }

    @And("I should be see all related topics on the navigation bar")
    public void iShouldBeSeeAllRelatedTopicsOnTheNavigationBar() {
        Assert.assertTrue(homePageActions.getNumberOfNewsAfterSearch());
    }
}
