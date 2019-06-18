package com.mingeso.ic.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class NavigationTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(NavigationTest.class);

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        logger.info("SELENIUM: INICIANDO PRUEBAS...");
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        //System.setProperty("webdriver.chrome.driver","lib/chromedriver_win32/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        driver = new ChromeDriver(chromeOptions);
        //driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        assertNotNull(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

    private void waitElement(int timeout, String elementId) throws InterruptedException{
        for (int second = 0; ; second++) {
            if (second >= timeout) fail("timeout");
            try { if (driver.findElement(By.id(elementId)).isDisplayed()) break; } catch (Exception e) {
                logger.debug("Error en wait element", e);
            }
            Thread.sleep(1000);
        }
    }

    @Test
    public void testAgregarHabitacion() throws Exception {
        driver.get("http://165.22.249.5/#/");
        driver.findElement(By.linkText("Habitaciones")).click();
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("mingeso");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contraseña'])[1]/following::button[1]")).click();
        waitElement(10, "profile");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Habitaciones")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Editor de habitaciones'])[1]/following::button[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("number")).click();
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys("777");
        driver.findElement(By.id("tipo")).click();
        new Select(driver.findElement(By.id("tipo"))).selectByVisibleText("Simple");
        driver.findElement(By.id("tipo")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
        Thread.sleep(10000);
        logger.info("Fin de la prueba, cerrando sesión...");
        driver.findElement(By.id("logout-button")).click();
        Thread.sleep(5000);
        logger.info("(EliminarHabitacion) Pruebas terminadas");
    }

   @Test
    public void testEliminarHabitacion() throws Exception {
        driver.get("http://165.22.249.5/#/");
        driver.findElement(By.linkText("Habitaciones")).click();
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("mingeso");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contraseña'])[1]/following::button[1]")).click();
        waitElement(7, "profile");
        driver.findElement(By.linkText("Habitaciones")).click();
        for (int second = 0;; second++) {
            if (second >= 7) fail("timeout");
            try { if (driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Editar'])[6]/following::button[1]")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        acceptNextAlert = true;
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Editar'])[6]/following::button[1]")).click();
        logger.info(closeAlertAndGetItsText());
        Thread.sleep(8000);
        logger.info("Fin de la prueba, cerrando sesión...");
        driver.findElement(By.id("logout-button")).click();
        logger.info("(EliminarHabitacion) Pruebas terminadas");
    }

    @Test
    public void testRegistroReserva() throws Exception {
        private String currentUrl;
        driver.get("http://165.22.249.5/#/");
        driver.findElement(By.linkText("Registro de reservas")).click();
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("mingeso");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contraseña'])[1]/following::button[1]")).click();
        waitElement(10, "profile");
        driver.findElement(By.linkText("Registro de reservas")).click();
        waitElement(10, "filtro-codigo");
        driver.findElement(By.id("filtro-codigo")).click();
        driver.findElement(By.id("filtro-codigo")).clear();
        driver.findElement(By.id("filtro-codigo")).sendKeys("A");
        driver.findElement(By.id("filtro-codigo")).sendKeys(Keys.ENTER);
        logger.info("Fin de filtro por código, esperando resultados...");
        Thread.sleep(8000);
        driver.findElement(By.id("filtro-nombre")).click();
        driver.findElement(By.id("filtro-nombre")).clear();
        driver.findElement(By.id("filtro-nombre")).sendKeys("Francisco");
        driver.findElement(By.id("filtro-nombre")).sendKeys(Keys.ENTER);
        logger.info("Fin de filtro por nombre, esperando resultados...");
        Thread.sleep(8000);
         logger.info("Fin de la prueba, cerrando sesión...");
        driver.findElement(By.id("logout-button")).click();
        currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "http://165.22.249.5/#/login");
        logger.info("(testRegistroReserva) Pruebas terminadas");
    }
}
