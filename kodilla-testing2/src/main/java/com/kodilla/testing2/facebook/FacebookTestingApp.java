package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String FACEBOOK = "https://www.facebook.com/";
    public static final String XPATH_WAIT_FOR_COOKIE = "//div[contains(@class, \"_9xo5\")]";
    public static final String XPATH_WAIT_FOR_CREATING_BOX = "//div[contains(@id, \"reg_form_box\")]";
    public static final String XPATH_COOKIE = "//div[contains(@class, \"_9xo5\")]/button[1]";
    public static final String XPATH_CREATE_ACCOUNT = "//div[contains(@class, \"_6ltg\")]/a";
    public static final String XPATH_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_YEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(FACEBOOK);

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR_COOKIE)).isDisplayed());

        WebElement cookieButton = driver.findElement(By.xpath(XPATH_COOKIE));
        cookieButton.click();

        WebElement createButton = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT));
        createButton.click();

        Thread.sleep(2000);

        WebElement dayField = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(dayField);
        selectDay.selectByValue("8");

        WebElement monthField = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(monthField);
        selectMonth.selectByValue("5");

        WebElement yearField = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(yearField);
        selectYear.selectByValue("1990");
    }
}