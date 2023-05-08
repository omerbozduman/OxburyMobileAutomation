package com.bbc_news.pages.actions;

import com.bbc_news.pages.identifiers.HomePageIdentifiers;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

    public Set<String> getTopicsAfterSearch(){
        Set<String> listOfAllResult = new LinkedHashSet<>();
        WebElement element = getElement(homePageIdentifiers.navigationBarForSearchResult);
        int elementHeight =  element.getLocation().getY() + element.getSize().getHeight()/2;
        ((AndroidDriver) driver).hideKeyboard();
       for(int i =0 ; i<10; i++){
           List<String> listOfText = getListOfText(homePageIdentifiers.searchResultTopics);
           scrollWithElementHeight("left" , elementHeight);
           listOfAllResult.addAll(listOfText);
       }
        return listOfAllResult;
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

    public Set<String> getAllContentsOfSearchFromMoreTopics(){
        Set<String> listOfAllResult = new LinkedHashSet<>();
        WebElement element = getElement(homePageIdentifiers.carouselItemHolder);
        int elementHeight =  element.getLocation().getY() + element.getSize().getHeight()/2;
        for(int i =0 ; i<5; i++){
            List<String> listOfText = getListOfText(homePageIdentifiers.contentTitleAfterSearch);
            scrollWithElementHeight("left" , elementHeight);
            listOfAllResult.addAll(listOfText);
        }
        for(int i =0 ; i<8; i++){
            List<String> listOfText = getListOfText(homePageIdentifiers.contentTitleAfterSearch);
            scroll("down");
            listOfAllResult.addAll(listOfText);
        }
        return listOfAllResult;
    }

    public Set<String> getAllContentsAfetrSearchWithAnyTopic(int numberOfContent){
        Set<String> listOfAllResult = new LinkedHashSet<>();
        for(int i =0 ; i<10; i++){
            List<String> listOfText = getListOfText(homePageIdentifiers.contentTitleAfterSearch);
            scroll("down");
            listOfAllResult.addAll(listOfText);
            if(listOfAllResult.size()==numberOfContent){
                break;
            }
        }
        return listOfAllResult;
    }
}
