package com.mingeso.ic.TestNG;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class NavigationTest {
    private WebDriver driver;
    private String baseUrl;
    private String currentUrl;
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    ///////
    /*@Test
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
    }//////////// Se realizara esta prueba manualmente */

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
                System.out.println(e);
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
        driver.findElement(By.linkText("Habitaciones")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Editor de habitaciones'])[1]/following::button[1]")).click();
        driver.findElement(By.id("number")).click();
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys("777");
        driver.findElement(By.id("tipo")).click();
        new Select(driver.findElement(By.id("tipo"))).selectByIndex(0);
        driver.findElement(By.id("tipo")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
        for (int second = 0;; second++) {
            if (second >= 10) fail("timeout");
            try { if (driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Simple'])[3]/following::button[1]")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Simple'])[3]/following::button[1]")).click();
        //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Tipo'])[2]/following::button[1]")).click();
        System.out.println("Fin de la prueba, cerrando sesión...");
        driver.findElement(By.id("logout-button")).click();
        System.out.println("(EliminarHabitacion) Pruebas terminadas");
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
        waitElement(10, "profile");
        driver.findElement(By.linkText("Habitaciones")).click();
        for (int second = 0;; second++) {
            if (second >= 10) fail("timeout");
            try { if (driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Editar'])[6]/following::button[1]")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        acceptNextAlert = true;
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Editar'])[6]/following::button[1]")).click();
        assertEquals(closeAlertAndGetItsText(), "Seguro que desea eliminar la habitación 777");
        System.out.println("Fin de la prueba, cerrando sesión...");
        driver.findElement(By.id("logout-button")).click();
        System.out.println("(EliminarHabitacion) Pruebas terminadas");
    }

    /*@Test
    public void testRegistroReserva() throws Exception {
        driver.get("http://165.22.249.5/#/");
        driver.findElement(By.linkText("Registro de reservas")).click();
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("Vicente");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("pass");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contraseña'])[1]/following::button[1]")).click();
        waitElement(10, "profile");
        driver.findElement(By.linkText("Registro de reservas")).click();
        driver.findElement(By.xpath("(.//input[starts-with(@id='filtro-codigo')])")).click();
        driver.findElement(By.xpath("(.//input[starts-with(@id='filtro-codigo')])")).clear();
        driver.findElement(By.xpath("(.//input[starts-with(@id='filtro-codigo')])")).sendKeys("A");
        driver.findElement(By.xpath("(.//input[starts-with(@id='filtro-codigo')])")).sendKeys(Keys.ENTER);
        System.out.println("Fin de filtro por código, esperando resultados...");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(.//input[starts-with(@id='filtro-nombre')])")).click();
        driver.findElement(By.xpath("(.//input[starts-with(@id='filtro-nombre')])")).clear();
        driver.findElement(By.xpath("(.//input[starts-with(@id='filtro-nombre')])")).sendKeys("Francisco");
        driver.findElement(By.xpath("(.//input[starts-with(@id='filtro-nombre')])")).sendKeys(Keys.ENTER);
        System.out.println("Fin de filtro por nombre, esperando resultados...");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        /*driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filtro por código'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filtro por código'])[1]/following::input[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filtro por código'])[1]/following::input[1]")).sendKeys("A");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filtro por código'])[1]/following::input[1]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filtro por nombre'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filtro por nombre'])[1]/following::input[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filtro por nombre'])[1]/following::input[1]")).sendKeys("Francisco");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filtro por nombre'])[1]/following::input[1]")).sendKeys(Keys.ENTER);
        //driver.findElement(By.id("titulo")).click();
        //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Salir'])[1]/following::h1[1]")).click();
        System.out.println("Fin de la prueba, cerrando sesión...");
        driver.findElement(By.xpath("(.//input[starts-with(@id='logout-button')])")).click();
        currentUrl = driver.getCurrentUrl();
        System.out.println("URL actual: " + currentUrl);
        System.out.println("(testRegistroReserva) Pruebas terminadas");
        //assertEquals(currentUrl, "http://165.22.249.5/#/login");
        //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Habitaciones'])[1]/following::div[1]")).click();
    }*/
}