package com.mingeso.ic.TestNG;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class NavigationTest {

    @Test
    public void NavigateTest(){
        System.setProperty("webdriver.chrome.driver","lib/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("No soy un bot");
        driver.findElement(By.name("btnK")).click();
    }
}
