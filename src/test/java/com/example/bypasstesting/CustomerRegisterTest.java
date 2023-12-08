package com.example.bypasstesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Date;

public class CustomerRegisterTest {
    WebDriver driver=new ChromeDriver();

    // Testing for CUSTOMER:
    @Test
    public void validForm() {
        driver.get("http://localhost:3000/customerRegister");
        WebElement username=driver.findElement(By.id("name"));
        WebElement phone=driver.findElement(By.id("phone"));
        WebElement address=driver.findElement(By.id("address"));
        WebElement pincode=driver.findElement(By.id("pincode"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement password1=driver.findElement(By.id("password1"));
        WebElement login=driver.findElement(By.id("registerButton"));
        username.sendKeys("Tested User");
        phone.sendKeys("9650718134");
        address.sendKeys("Just for Testing Purpose");
        pincode.sendKeys("121001");
        password.sendKeys("Tushar@0000");
        password1.sendKeys("Tushar@0000");
        login.click();
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        while (elapsedTime < 1*2*1000) {
            elapsedTime = (new Date()).getTime() - startTime;
        }
        String actualUrl="http://localhost:3000/customer";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test(dependsOnMethods={"validForm"})
    public void invalidForm() {
        driver.get("http://localhost:3000/customerRegister");
        WebElement username=driver.findElement(By.id("name"));
        WebElement phone=driver.findElement(By.id("phone"));
        WebElement address=driver.findElement(By.id("address"));
        WebElement pincode=driver.findElement(By.id("pincode"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement password1=driver.findElement(By.id("password1"));
        WebElement login=driver.findElement(By.id("registerButton"));
        username.sendKeys("Tested User2");
        phone.sendKeys("96507181aa");
        address.sendKeys("Just for Testing Purpose");
        pincode.sendKeys("12100");
        password.sendKeys("0000");
        password1.sendKeys("0000");
        login.click();
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        while (elapsedTime < 1*2*1000) {
            elapsedTime = (new Date()).getTime() - startTime;
        }
        String actualUrl="http://localhost:3000/customerRegister";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        driver.quit();
    }
}