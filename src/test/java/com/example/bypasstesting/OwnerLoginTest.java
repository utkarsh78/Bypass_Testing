package com.example.bypasstesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Date;

public class OwnerLoginTest {
    WebDriver driver=new ChromeDriver();
    // Testing for OWNER:
    @Test
    public void validOwnerLogin() {
        driver.get("http://localhost:3000/owner");
        WebElement username=driver.findElement(By.id("phone"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.id("loginButton"));
        username.sendKeys("9407006862");
        password.sendKeys("Utkarsh@9407");
        login.click();
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        while (elapsedTime < 1*2*1000) {
            elapsedTime = (new Date()).getTime() - startTime;
        }
        String actualUrl="http://localhost:3000/ownerProperties";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        WebElement logout=driver.findElement(By.id("logoutButton"));
        logout.click();
    }

    @Test(dependsOnMethods={"validOwnerLogin"})
    public void invalidOwnerLogin() {
        driver.get("http://localhost:3000/owner");
        WebElement username=driver.findElement(By.id("phone"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.id("loginButton"));
        username.sendKeys("9650718132");
        password.sendKeys("Tushar@8795");
        login.click();
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        while (elapsedTime < 1*2*1000) {
            elapsedTime = (new Date()).getTime() - startTime;
        }
        driver.switchTo().alert().accept();
        String actualUrl="http://localhost:3000/owner";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        driver.quit();
    }
}
