package com.lohika.gap.core;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

/**
 * Created by vova on 10.01.2017.
 */
public class Wait {

    private static final int DEFAULT_TIMEOUT = 30000;
    private static final int DEFAULT_RETRY_DELAY = 500;

   public static void seconds(int time) {
       try {
           Thread.sleep(time*1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
      // System.out.println("Wait " + time + " seconds");
   }

    public static void miliseconds(int time, WebElement element) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Wait " + time + " miliseconds for element: " + element);
    }

    public static boolean isReady (WebElement element) {
        boolean res = false;
        try {
            res = element.isDisplayed ();
            return res;
        } catch (NoSuchElementException e) {
            return res;
        }
    }

    public static void forElement(WebElement element){
        int time = 0;
        while (time <= DEFAULT_TIMEOUT){
            if (isReady(element)){
                return;
            }
            time = time + DEFAULT_RETRY_DELAY;
            miliseconds(time, element);
        }
        if (!isReady(element)){
            throw new TimeoutException("Timed out after 30s. waiting for element: " + element );
        }

    }

}
