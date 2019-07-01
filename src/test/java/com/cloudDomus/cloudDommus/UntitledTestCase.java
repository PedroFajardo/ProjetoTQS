package com.cloudDomus.cloudDommus;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/home/pedrofajardo/Downloads/chromedriver_linux64 (1)/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Login'])[1]/following::button[1]")).click();
    new Select(driver.findElement(By.id("userType"))).selectByVisibleText("Worker");
    driver.findElement(By.id("userType")).click();
    driver.findElement(By.id("InputFirst")).click();
    driver.findElement(By.id("InputFirst")).clear();
    driver.findElement(By.id("InputFirst")).sendKeys("hello");
    driver.findElement(By.id("InputLast")).clear();
    driver.findElement(By.id("InputLast")).sendKeys("guys");
    driver.findElement(By.id("InputEmail")).clear();
    driver.findElement(By.id("InputEmail")).sendKeys("hello@mail.com");
    driver.findElement(By.id("InputPhone")).clear();
    driver.findElement(By.id("InputPhone")).sendKeys("987654321");
    driver.findElement(By.id("InputBirthday")).click();
    driver.findElement(By.id("InputBirthday")).click();
    driver.findElement(By.id("InputBirthday")).click();
    driver.findElement(By.id("InputBirthday")).click();
    driver.findElement(By.id("InputBirthday")).clear();
    driver.findElement(By.id("InputBirthday")).sendKeys("2019-07-17");
    driver.findElement(By.id("InputAddress")).click();
    driver.findElement(By.id("InputBirthday")).click();
    driver.findElement(By.id("InputBirthday")).clear();
    driver.findElement(By.id("InputBirthday")).sendKeys("0001-07-17");
    driver.findElement(By.id("InputBirthday")).clear();
    driver.findElement(By.id("InputBirthday")).sendKeys("0019-07-17");
    driver.findElement(By.id("InputBirthday")).clear();
    driver.findElement(By.id("InputBirthday")).sendKeys("0199-07-17");
    driver.findElement(By.id("InputBirthday")).clear();
    driver.findElement(By.id("InputBirthday")).sendKeys("1990-07-17");
    driver.findElement(By.id("InputAddress")).click();
    driver.findElement(By.id("InputAddress")).clear();
    driver.findElement(By.id("InputAddress")).sendKeys("hello guys");
    driver.findElement(By.id("InputPassword")).click();
    driver.findElement(By.id("InputPassword")).clear();
    driver.findElement(By.id("InputPassword")).sendKeys("hello");
    driver.findElement(By.id("InputPasswordConfirm")).clear();
    driver.findElement(By.id("InputPasswordConfirm")).sendKeys("hello");
    driver.findElement(By.id("Check")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check me out'])[2]/following::button[1]")).click();
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
