package com.bbc_news.pages.actions;

import com.bbc_news.pages.identifiers.HomePageIdentifiers;
import org.openqa.selenium.By;

import java.util.List;

public class HomePageActions extends CommonActions {

    HomePageIdentifiers homePageIdentifiers;

    public HomePageActions(){
        homePageIdentifiers = new HomePageIdentifiers();
    }

    public void clickSearchButton(){
        clickButton(homePageIdentifiers.searchButton);
    }

    public String getMoreTopicsTitle(){
        return getTextOfElement(homePageIdentifiers.moreTopicsTitleOnSearchPage);
    }

    public void searchTopic(String topic){
        enterTextToField(homePageIdentifiers.searchField , topic);
    }

    public String getArticlesRelatedTitle(){
        return getTextOfElement(homePageIdentifiers.searchResultArticlesRelatedHeading);
    }

    public List<String> getTopicsAfterSearch(){
        return getListOfText(homePageIdentifiers.searchResultTopics);
    }

    public void navigateToHomePageAfterSearch(){
        clickButton(homePageIdentifiers.backButtonOnTheSearchPage);
    }

    public boolean verifyTabListAfterSearch(List<String> tabList){
        boolean flag = true;
        for (String tab:tabList) {
            By locator = By.xpath("//*[@text='"+tab+"']");
            if(!getElement(locator).isDisplayed()){
                flag = false;
            }
        }
        return flag;
    }

    public void searchFromMoreTopic(String topic){
        By locator = By.xpath("//*[@text='"+topic+"']");
        clickButton(locator);
    }

    public boolean getNumberOfNewsAfterSearch(){
        int numberOfNews = getListOfElement(homePageIdentifiers.contentTitleAfterSearch).size();
        return numberOfNews>0;
    }
}
