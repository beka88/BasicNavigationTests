package com.cbt.utilities;

public class BrowserUtils {

    public static void wait(int seconds){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

