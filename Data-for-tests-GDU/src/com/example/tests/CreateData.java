package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CreateData {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://vm-gdu-sp-test/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/default.aspx");
    driver.findElement(By.cssSelector("span.ms-splinkbutton-text")).click();
    driver.findElement(By.cssSelector("#viewlist098f4511-2bef-4321-81f3-8fc520b8817c-image > img.ms-storefront-appiconimg")).click();
    driver.findElement(By.xpath("//a[@id='idHomePageNewItem']/span[2]")).click();
    driver.findElement(By.id("Title_fa564e0f-0c70-4ab9-b863-0177e6ddd247_$TextField")).clear();
    driver.findElement(By.id("Title_fa564e0f-0c70-4ab9-b863-0177e6ddd247_$TextField")).sendKeys("Тестовый проект");
    driver.findElement(By.id("GduNote_03c98200-3ff7-44b5-a9b9-cc0c7883c53e_$TextField")).click();
    driver.findElement(By.id("GduNote_03c98200-3ff7-44b5-a9b9-cc0c7883c53e_$TextField")).clear();
    driver.findElement(By.id("GduNote_03c98200-3ff7-44b5-a9b9-cc0c7883c53e_$TextField")).sendKeys("Нет описания");
    driver.findElement(By.id("ProjectStartDate_fd02067b-3226-4060-b659-5e79a7db4c6b_$DateTimeFieldDate")).clear();
    driver.findElement(By.id("ProjectStartDate_fd02067b-3226-4060-b659-5e79a7db4c6b_$DateTimeFieldDate")).sendKeys("21.03.2014");
    driver.findElement(By.id("ProjectFinishDate_35247208-1df3-4725-9e6b-453977e121b6_$DateTimeFieldDate")).clear();
    driver.findElement(By.id("ProjectFinishDate_35247208-1df3-4725-9e6b-453977e121b6_$DateTimeFieldDate")).sendKeys("21.12.2014");
    driver.findElement(By.id("ctl00_SPWebPartManager1_g_6ed5fc49_c2f9_4bed_b21c_674cfedda693_ctl00_toolBarTbl_RightRptControls_ctl00_ctl00_diidIOSaveItem")).click();
    driver.findElement(By.cssSelector("span.ms-splinkbutton-text")).click();
    driver.findElement(By.cssSelector("#viewlist54d1f1f3-fbf7-4934-bf26-a6a0bb07293a-image > img.ms-storefront-appiconimg")).click();
    driver.findElement(By.xpath("//a[@id='idHomePageNewItem']/span[2]")).click();
    driver.findElement(By.id("Title_fa564e0f-0c70-4ab9-b863-0177e6ddd247_$TextField")).clear();
    driver.findElement(By.id("Title_fa564e0f-0c70-4ab9-b863-0177e6ddd247_$TextField")).sendKeys("02369");
    driver.findElement(By.id("ctl00_SPWebPartManager1_g_643d025b_0043_416f_8e85_07e62e030a42_ctl00_toolBarTbl_RightRptControls_ctl00_ctl00_diidIOSaveItem")).click();
    driver.findElement(By.cssSelector("span.ms-splinkbutton-text")).click();
    driver.findElement(By.cssSelector("#viewlistf3c5c3b4-f7c3-4b7d-9cfe-94591bb298da-image > img.ms-storefront-appiconimg")).click();
    driver.findElement(By.xpath("//a[@id='idHomePageNewItem']/span[2]")).click();
    driver.findElement(By.id("Title_fa564e0f-0c70-4ab9-b863-0177e6ddd247_$TextField")).clear();
    driver.findElement(By.id("Title_fa564e0f-0c70-4ab9-b863-0177e6ddd247_$TextField")).sendKeys("Новости подразделения");
    driver.findElement(By.id("ctl00_SPWebPartManager1_g_17cc4b2e_55f6_4444_85b5_4ecb3a62dcb2_ctl00_toolBarTbl_RightRptControls_ctl00_ctl00_diidIOSaveItem")).click();
    driver.findElement(By.cssSelector("span.ms-splinkbutton-text")).click();
    driver.findElement(By.cssSelector("#viewlist3336e3dd-d01e-4379-87da-221042ad61e4-image > img.ms-storefront-appiconimg")).click();
    driver.findElement(By.xpath("//a[@id='idHomePageNewItem']/span[2]")).click();
    driver.findElement(By.id("Title_fa564e0f-0c70-4ab9-b863-0177e6ddd247_$TextField")).clear();
    driver.findElement(By.id("Title_fa564e0f-0c70-4ab9-b863-0177e6ddd247_$TextField")).sendKeys("Газпром");
    driver.findElement(By.id("ctl00_SPWebPartManager1_g_7ea34884_40b6_460f_9698_8520a6a5dd67_ctl00_toolBarTbl_RightRptControls_ctl00_ctl00_diidIOSaveItem")).click();
    driver.findElement(By.cssSelector("span.ms-splinkbutton-text")).click();
  }

  @AfterTest
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
