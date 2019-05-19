/*package com.mingeso.ic.TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class NavigationTest {

    @Test
    public void NavigateTest() throws IOException, InterruptedException {
        System.out.println("SELENIUM: INICIANDO PRUEBAS...");
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        // System.setProperty("webdriver.chrome.driver","lib/chromedriver_win32/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.google.com");
        Thread.sleep(1000);
        driver.findElement(By.name("q")).sendKeys("No soy un bot");
        System.out.println("SELENIUM: PRUEBAS PASADAS!");

        driver.quit();
    }
}
*/