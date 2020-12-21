package com.atqa2020_Marusyak;

import org.hamcrest.generator.qdox.model.Annotation;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SampleTest {
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vasya\\Desktop\\IT_Cluster_AQA\\IT_Cluster_AQA\\ATQA-2020_Test_Site\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test(priority = 0, suiteName = "main")
    public void mainUrlTest() {


        //Given user opens a browser and provides a valid url
        driver.get("https://google.com");
        //When user clicks enter

        //And

        //Then user is redirected to the main page
        Assert.assertTrue(driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).isDisplayed());
    }
}
