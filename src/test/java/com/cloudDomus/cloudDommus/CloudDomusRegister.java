package com.cloudDomus.cloudDommus;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CloudDomusRegister {
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
  public void testCloudDomus() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Login'])[1]/following::button[1]")).click();
    driver.findElement(By.id("userType")).click();
    new Select(driver.findElement(By.id("userType"))).selectByVisibleText("Worker");
    driver.findElement(By.id("userType")).click();
    driver.findElement(By.id("InputFirst")).click();
    driver.findElement(By.id("InputFirst")).clear();
    driver.findElement(By.id("InputFirst")).sendKeys("Maria");
    driver.findElement(By.id("InputLast")).clear();
    driver.findElement(By.id("InputLast")).sendKeys("dos Anjos");
    driver.findElement(By.id("InputEmail")).click();
    driver.findElement(By.id("InputEmail")).clear();
    driver.findElement(By.id("InputEmail")).sendKeys("mariadosanjos@mail.com");
    driver.findElement(By.id("InputPhone")).click();
    driver.findElement(By.id("InputPhone")).clear();
    driver.findElement(By.id("InputPhone")).sendKeys("934567453");
    driver.findElement(By.id("InputBirthday")).click();
    driver.findElement(By.id("InputBirthday")).clear();
    driver.findElement(By.id("InputBirthday")).sendKeys("0001-01-01");
    driver.findElement(By.id("InputBirthday")).clear();
    driver.findElement(By.id("InputBirthday")).sendKeys("0019-01-01");
    driver.findElement(By.id("InputBirthday")).clear();
    driver.findElement(By.id("InputBirthday")).sendKeys("0198-01-01");
    driver.findElement(By.id("InputBirthday")).clear();
    driver.findElement(By.id("InputBirthday")).sendKeys("1980-01-01");
    driver.findElement(By.id("InputAddress")).click();
    driver.findElement(By.id("InputAddress")).clear();
    driver.findElement(By.id("InputAddress")).sendKeys("Rua da Fonte, nº5");
    driver.findElement(By.id("InputPassword")).click();
    driver.findElement(By.id("InputPassword")).clear();
    driver.findElement(By.id("InputPassword")).sendKeys("mariadosanjos");
    driver.findElement(By.id("InputPasswordConfirm")).clear();
    driver.findElement(By.id("InputPasswordConfirm")).sendKeys("mariadosanjos");
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
