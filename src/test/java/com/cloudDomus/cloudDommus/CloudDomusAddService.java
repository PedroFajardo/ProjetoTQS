package com.cloudDomus.cloudDommus;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CloudDomusAddService {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/home/tqs/TQS/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCloudDomusAddService() throws Exception {
    driver.get("http://localhost:8080/worker/worker.html");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(current)'])[1]/preceding::span[1]")).click();
    driver.findElement(By.linkText("Add Reservation Post")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=services | label=House Cleaning]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Reservation Services'])[1]/following::option[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=services | label=Clothes Washing and Ironing]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Reservation Services'])[1]/following::option[2]")).click();
    driver.findElement(By.id("description")).click();
    driver.findElement(By.id("description")).clear();
    driver.findElement(By.id("description")).sendKeys("description example");
    driver.findElement(By.id("startHour")).click();
    driver.findElement(By.id("startHour")).clear();
    driver.findElement(By.id("startHour")).sendKeys("21:00");
    driver.findElement(By.id("endHour")).click();
    driver.findElement(By.id("endHour")).click();
    driver.findElement(By.id("endHour")).clear();
    driver.findElement(By.id("endHour")).sendKeys("22:00");
    driver.findElement(By.id("hourPrice")).click();
    driver.findElement(By.id("hourPrice")).clear();
    driver.findElement(By.id("hourPrice")).sendKeys("6");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Price per Hour'])[1]/following::button[1]")).click();
  }

  @After
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
