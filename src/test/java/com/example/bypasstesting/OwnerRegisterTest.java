package com.example.bypasstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class OwnerRegisterTest {
    WebDriver driver=new ChromeDriver();

    // Testing for CUSTOMER:
    @Test
    public void validForm() {
        driver.get("http://localhost:3000/ownerRegister");
        WebElement username=driver.findElement(By.id("name"));
        WebElement phone=driver.findElement(By.id("phone"));
        WebElement address=driver.findElement(By.id("address"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement password1=driver.findElement(By.id("password1"));
        WebElement login=driver.findElement(By.id("registerButton"));
        username.sendKeys("Tested User");
        phone.sendKeys("9340479615");
        address.sendKeys("Just for Testing Purpose");
        password.sendKeys("Utkarsh@9340");
        password1.sendKeys("Utkarsh@9340");
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
    }

    @Test(dependsOnMethods={"validForm"})
    public void invalidForm() {
        driver.get("http://localhost:3000/ownerRegister");
        WebElement username=driver.findElement(By.id("name"));
        WebElement phone=driver.findElement(By.id("phone"));
        WebElement address=driver.findElement(By.id("address"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement password1=driver.findElement(By.id("password1"));
        WebElement login=driver.findElement(By.id("registerButton"));
        username.sendKeys("Tested User2");
        phone.sendKeys("96507181aa");
        address.sendKeys("Just for Testing Purpose");
        password.sendKeys("0000");
        password1.sendKeys("0000");
        login.click();
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        while (elapsedTime < 1*2*1000) {
            elapsedTime = (new Date()).getTime() - startTime;
        }
        String actualUrl="http://localhost:3000/ownerRegister";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        driver.quit();
    }

}
