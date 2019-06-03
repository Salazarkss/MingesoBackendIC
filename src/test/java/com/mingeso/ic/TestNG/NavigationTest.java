package com.mingeso.ic.TestNG;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class NavigationTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.out.println("SELENIUM: INICIANDO PRUEBAS...");
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        // System.setProperty("webdriver.chrome.driver","lib/chromedriver_win32/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        driver = new ChromeDriver(chromeOptions);
        //driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testBorrarYAgregarReservaEnRack() throws Exception {
        driver.get("http://165.22.249.5/#/");
        driver.findElement(By.linkText("Rack")).click();
        driver.findElement(By.id("inicio")).click();
        driver.findElement(By.id("inicio")).clear();
        driver.findElement(By.id("inicio")).sendKeys("2019-05-01");
        driver.findElement(By.id("inicio")).click();
        assertEquals(closeAlertAndGetItsText(), "Dias: 61");
        acceptNextAlert = true;
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Francisco Diaz'])[1]/following::span[1]")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Seguro desea cancelar esta reserva[\\s\\S]$"));
        assertEquals(closeAlertAndGetItsText(), "Eliminado con éxito");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='julio 2019'])[1]/following::div[130]")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Prueba");
        driver.findElement(By.id("tipo")).click();
        driver.findElement(By.id("tipo")).clear();
        driver.findElement(By.id("tipo")).sendKeys("Particular");
        driver.findElement(By.name("precio")).click();
        driver.findElement(By.name("precio")).clear();
        driver.findElement(By.name("precio")).sendKeys("25000");
        driver.findElement(By.name("precio")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Valor de la reserva'])[1]/following::button[1]")).click();
        assertEquals(closeAlertAndGetItsText(), "Insertado con éxito");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

/*
package com.mingeso.ic.TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class NavigationTest {

    @Test
    public void EliminarAgregarReserva() throws  IOException, Imn{

    }

    /*@Test
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
}*/