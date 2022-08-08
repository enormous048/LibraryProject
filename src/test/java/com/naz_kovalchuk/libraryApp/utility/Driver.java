package com.naz_kovalchuk.libraryApp.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}


    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){
        if (driverPool.get()==null){


            String browserName = ConfigurationReader.getProperty("browser");

            switch (browserName){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driverPool.set(new OperaDriver());
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driverPool.set(new SafariDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
            }
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        }
        return driverPool.get();
    }


      public static void closeDriver(){

        if (driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.set(null);
        }

    }
}
