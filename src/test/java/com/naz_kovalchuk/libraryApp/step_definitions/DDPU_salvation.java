package com.naz_kovalchuk.libraryApp.step_definitions;

import com.github.javafaker.Faker;
import com.naz_kovalchuk.libraryApp.utility.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class DDPU_salvation {


    int count = 1;
    @When("something happens")
    public void something_happens() {

        for (int i = 1; i <= 110; i++) {
            Driver.getDriver().get("https://docs.google.com/forms/d/e/1FAIpQLSfcN_88HawJwUcqLyxZ0NlKxieX354fwVlyhJPWIIlmBl77Bg/viewform");


            Faker faker = new Faker();
            String r = faker.numerify("#");
            int random = Integer.valueOf(r);

            if (Integer.valueOf(r) < 5) {
                //чоловіча стать
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i5\"]/div[3]/div")).click();
            } else {
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i8\"]/div[3]/div")).click();
            }


            if (random == 0 || random == 1) {
                //перший курс
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i15\"]/div[3]/div")).click();
            } else if (random == 2 || random == 8) {
                //другий курс
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i18\"]/div[3]/div")).click();
            } else if (random == 3 || random == 7) {
                //4 курс
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i24\"]/div[3]/div")).click();
            } else if (random == 4) {
                //5 курс
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i27\"]/div[3]/div")).click();
            } else if (random == 5) {
                //6 курс
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i30\"]/div[3]/div")).click();
            } else if (random == 6 || random == 9) {
                //третій курс
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i21\"]/div[3]/div")).click();
            }


            //faculty
            if (random == 1) {
                //physics
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i37\"]/div[3]/div")).click();
            } else if (random == 0 || random == 2) {
                //foreign lang
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i40\"]/div[3]/div")).click();
            } else if (random == 3) {
                //music
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i43\"]/div[3]/div")).click();
            } else if (random == 4) {
                //fizra
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i46\"]/div[3]/div")).click();
            } else if (random == 5) {
                //filology
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i49\"]/div[3]/div")).click();
            } else if (random == 6) {
                //historical
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i52\"]/div[3]/div")).click();
            } else if (random == 7) {
                //biology
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i58\"]/div[3]/div")).click();
            } else if (random == 8) {
                //pochatkova osvita
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i55\"]/div[3]/div")).click();
            } else if (random == 9) {
                //psycology
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i61\"]/div[3]/div")).click();
            }


            //знаходження
            if (random <= 7) {
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i68\"]/div[3]/div")).click();
            } else {
                Driver.getDriver().findElement(By.xpath("//*[@id=\"i71\"]/div[3]/div")).click();

            }

            Driver.getDriver().findElement(By.xpath("//*[@id=\"i84\"]/div[3]/div")).click();

            Driver.getDriver().findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[3]/div/div[1]/div/span/span")).click();


            Assert.assertEquals(random, random);
            System.out.println("random = " + random);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Driver.closeDriver();


            int time = Integer.valueOf( faker.number().numberBetween(2000, 200000) );
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            if (count==40){
                try {
                    Thread.sleep(6000000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }
}





