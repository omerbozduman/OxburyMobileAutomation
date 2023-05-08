package com.bbc_news.pages.identifiers;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class HomePageIdentifiers {

    public By searchButton = AppiumBy.accessibilityId("Search");
    public By searchField = By.xpath("//*[@resource-id='bbc.mobile.news.uk:id/search']");
    public By moreTopicsTitleOnSearchPage = By.xpath("//*[@resource-id='bbc.mobile.news.uk:id/heading']");

    public By searchResultArticlesRelatedHeading = By.xpath("(//*[@resource-id='bbc.mobile.news.uk:id/heading'])[2]");

    public By searchResultNumberOfTopics = By.xpath("(//*[@resource-id='bbc.mobile.news.uk:id/heading'])[1]");

    public By searchResultTopics = By.xpath("//*[@resource-id='bbc.mobile.news.uk:id/chip_item']");

    public By navigationBarForSearchResult = By.xpath("//*[@resource-id='bbc.mobile.news.uk:id/chip_set']");

    public By backButtonOnTheSearchPage = AppiumBy.accessibilityId("Back");

    public By contentTitleAfterSearch = By.xpath("//*[@resource-id='bbc.mobile.news.uk:id/content_card_title']");

    public By carouselItemHolder = By.xpath("//*[@resource-id='bbc.mobile.news.uk:id/rubikCarouselItemHolder']");
}
