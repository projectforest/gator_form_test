package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FeedbackForm {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFeedbackForm() throws Exception {
    driver.get("http://cautious-mamba.w5.wpsandbox.pro/wp-admin/admin.php?page=pwebcontact");
    driver.findElement(By.xpath("//div[@id='wpbody-content']/div[2]/h2/a")).click();
    driver.findElement(By.xpath("//div[@id='pweb-location-after']/div")).click();
    driver.findElement(By.id("pweb_params_effect_modal_square")).click();
    driver.findElement(By.id("pweb-tab-fields")).click();
    driver.findElement(By.id("pweb_load_fields")).click();
    new Select(driver.findElement(By.id("pweb_load_fields"))).selectByVisibleText("Feedback");
    driver.findElement(By.id("pweb_load_fields")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[62]")).click();
    driver.findElement(By.id("title")).clear();
    driver.findElement(By.id("title")).sendKeys("feedback form");
    driver.findElement(By.id("pweb-tab-theme")).click();
    driver.findElement(By.id("pweb-themes-coverflow-control-prev")).click();
    driver.findElement(By.id("pweb-themes-coverflow-control-prev")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=pweb-themes-coverflow-control-prev | ]]
    driver.findElement(By.id("pweb-themes-coverflow-control-prev")).click();
    driver.findElement(By.id("pweb-themes-coverflow-control-prev")).click();
    driver.findElement(By.id("pweb-themes-coverflow-control-prev")).click();
    driver.findElement(By.id("pweb-themes-coverflow-control-prev")).click();
    driver.findElement(By.id("pweb-themes-coverflow-control-prev")).click();
    driver.findElement(By.id("pweb-themes-coverflow-control-next")).click();
    driver.findElement(By.id("pweb-themes-coverflow-control-load")).click();
    driver.findElement(By.xpath("//div[137]/div[3]/div/button/span")).click();
    driver.findElement(By.id("pweb-save-button")).click();
    driver.findElement(By.linkText("Close")).click();
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
