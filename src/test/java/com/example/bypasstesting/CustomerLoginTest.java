package com.example.bypasstesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Date;

public class CustomerLoginTest {
    WebDriver driver=new ChromeDriver();
    // Testing for CUSTOMER:
    @Test
    public void validCustomerLogin() {
        driver.get("http://localhost:3000/customer");
        WebElement username=driver.findElement(By.id("phone"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.id("loginButton"));
        username.sendKeys("9650718131");
        password.sendKeys("Tushar@9650");
        login.click();
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        while (elapsedTime < 1*2*1000) {
            elapsedTime = (new Date()).getTime() - startTime;
        }
        String actualUrl="http://localhost:3000/bookings";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        WebElement logout=driver.findElement(By.id("logoutButton"));
        logout.click();
    }

    @Test(dependsOnMethods={"validCustomerLogin"})
    public void invalidCustomerLogin() {
        driver.get("http://localhost:3000/customer");
        WebElement username=driver.findElement(By.id("phone"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.id("loginButton"));
        username.sendKeys("9650718131");
        password.sendKeys("Tushar@8795");
        login.click();
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        while (elapsedTime < 1*2*1000) {
            elapsedTime = (new Date()).getTime() - startTime;
        }
        driver.switchTo().alert().accept();
        String actualUrl="http://localhost:3000/customer";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        driver.quit();
    }
}