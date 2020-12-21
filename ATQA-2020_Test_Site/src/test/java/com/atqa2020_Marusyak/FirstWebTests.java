package com.atqa2020_Marusyak;
import org.hamcrest.generator.qdox.model.Annotation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstWebTests {
    private RemoteWebDriver driver;
    JavascriptExecutor js;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vasya\\Desktop\\IT_Cluster_AQA\\IT_Cluster_AQA\\ATQA-2020_Test_Site\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;


    }
    @Test
    public void Test1() {
        //Given user opens a browser and provides a valid url
        driver.get("https://www.foxtrot.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js.executeScript("window.scrollBy(0,1000)");
        //When user clicks enter
        //And
        //Then user is redirected to the main page
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'scroll-top-button active')]")).isDisplayed());
    }

    @Test
    public void Test2() {
        //Given user opens a browser and provides a valid url
        driver.get("https://www.foxtrot.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[@class = 'header__categories-items smooth-scroll']/li[1]")).click();
        driver.findElement(By.cssSelector("li[data-category = '32014'] > div.catalog-sub > div > div.catalog-sub__body.smooth-scroll > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a")).click();
        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.cssSelector(".card.js-card.isTracked.desc-loaded:nth-child(1) >div:nth-child(3) .button")).click();

        //When user clicks enter
        //And
        //Then user is redirected to the main page
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'card js-card isTracked desc-loaded'][1]//div[@data-title-in-the-card= 'В корзине']")).isDisplayed());
    }

    @Test
    public void Test3() {
        //Given user opens a browser and provides a valid url
        driver.get("https://www.foxtrot.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".header__sub-lang li [data-lang = 'uk']")).click();
        String text = driver.findElement(By.xpath("//input[@type='button']")).getAttribute("value");
        System.out.println(text);
        //When user clicks enter
        //And
        //Then user is redirected to the main page
        Assert.assertEquals( "ЗНАЙТИ", text);
    }

    @Test
    public void Test4() {
        //Given user opens a browser and provides a valid url
        driver.get("https://www.foxtrot.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text = driver.findElement(By.cssSelector("#callbackFeature")).getText();
        //And
        //Then user is redirected to the main page
        Assert.assertEquals( "0 800 300-353", text);
    }

    @Test
    public void Test5() {
        //Given user opens a browser and provides a valid url
        driver.get("https://www.foxtrot.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#callbackFeature")).click();
        driver.findElement(By.cssSelector(".tooltip.tooltip_active .button-link.button-link_black.jslink label")).click();
        js.executeScript("window.scrollBy(0,1000)");
        //driver.findElement(By.xpath("//span[contains(@id,'select2-fox-stores-container')]")).click();
        //And
        //Then user is redirected to the main page
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@id,'select2-fox-stores-container')]")).isDisplayed());
    }



    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


