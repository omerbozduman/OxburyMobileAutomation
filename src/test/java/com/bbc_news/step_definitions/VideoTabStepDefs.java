package com.bbc_news.step_definitions;

import com.bbc_news.pages.actions.VideoTabActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class VideoTabStepDefs {

    VideoTabActions videoTabActions;

    public VideoTabStepDefs(){
        videoTabActions = new VideoTabActions();
    }

    @Then("I navigate to {string} tab")
    public void iNavigateToTab(String tabMenu) {
        videoTabActions.navigateToVideoTab();
    }

    @And("{string} is displayed on the video tab")
    public void isDisplayedOnTheVideoTab(String expectedTitle) {
        String actualTitle = videoTabActions.getWatchLiveBbcNewsTitle();
        Assert.assertEquals(expectedTitle , actualTitle);
    }

    @And("{string} is displayed bottom of the screen")
    public void isDisplayedBottomOfTheScreen(String expectedTitle) {
        String actualTitle = videoTabActions.getCopyRightTitle(expectedTitle);
        Assert.assertEquals(expectedTitle , actualTitle);
    }
}
