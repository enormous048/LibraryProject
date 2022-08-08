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

    //Creating a private constructor to limit access from outside
    private Driver(){}

    //Creating a private WebDriver to limit access from outside.
    //We make it static because we will use it in static method.
    //private static WebDriver driver;



    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    //Не бійся нових штук через дравейрПул, просто знай шо воно робить все те саме просто доступно ше параллел тестинг


    //Create reusable utility method which will return the same driver when we call it
    public static WebDriver getDriver(){
        if (driverPool.get()==null){

            //We read browser type from configuration properties.
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


    //Коли ти нажимаєш драйвер квит, то велью Драйвера взагалі не існує, воно навіть НЕ null,
    //тому якшо в одному тесті нажав драйвер квит то воно тупо вибє помилку якшо захочеш в іншому тесті знов використати
    public static void closeDriver(){

        if (driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.set(null); //тепер в синглтоні воно зможе визватись
            //driverPool.remove(); -- це то саме шо і driverPool.set(null);
        }

    }
}
