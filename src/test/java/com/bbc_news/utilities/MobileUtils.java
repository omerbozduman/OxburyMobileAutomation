package com.bbc_news.utilities;

import java.io.File;

public class MobileUtils {

    public static String GetAppFilePathAddress(){

        File file = new File("src/test/java/com/bbc_news/appFiles/bbc.mobile.news.uk_6.2.41-6024105_minAPI21(arm64-v8a,armeabi,armeabi-v7a,mips,mips64,x86,x86_64)(nodpi)_apkmirror.com.apk");
        return file.getAbsolutePath();
    }

}
