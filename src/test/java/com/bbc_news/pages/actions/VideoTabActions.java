package com.bbc_news.pages.actions;

import com.bbc_news.pages.identifiers.VideoTabIdentifiers;


public class VideoTabActions extends CommonActions {

    VideoTabIdentifiers videoTabIdentifiers;

    public VideoTabActions(){
        videoTabIdentifiers = new VideoTabIdentifiers();
    }

    public void navigateToVideoTab(){
        clickButton(videoTabIdentifiers.videoTabButton);
    }

    public String getWatchLiveBbcNewsTitle(){
        return getTextOfElement(videoTabIdentifiers.watchBbcNewsTitle);
    }

    public String getCopyRightTitle(String expectedTitle){
        return scrollDownToElementByAndroidUIAutomator(expectedTitle).getText();
    }


}
