package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage {
    private static final int DURATION = 3;
    private WebDriver driver;
    public final By orderButton = By.xpath(".//button[text() = 'Заказать']");
    private final By faqSection = By.className("Home_FourPart__1uthg");
    private final By rentCost = By.id("accordion__heading-0");
    private final By rentCostContent = By.xpath(".//div[@aria-labelledby = 'accordion__heading-0']/p");
    private final By rentCount = By.id("accordion__heading-1");
    private final By rentCountContent = By.xpath(".//div[@aria-labelledby = 'accordion__heading-1']/p");
    private final By rentTime = By.id("accordion__heading-2");
    private final By rentTimeContent = By.xpath(".//div[@aria-labelledby = 'accordion__heading-2']/p");
    private final By rentOrderNow = By.id("accordion__heading-3");
    private final By rentOrderNowContent = By.xpath(".//div[@aria-labelledby = 'accordion__heading-3']/p");
    private final By rentPeriod = By.id("accordion__heading-4");
    private final By rentPeriodContent = By.xpath(".//div[@aria-labelledby = 'accordion__heading-4']/p");
    private final By rentCharger = By.id("accordion__heading-5");
    private final By rentChargerContent = By.xpath(".//div[@aria-labelledby = 'accordion__heading-5']/p");
    private final By rentCancelPossibility = By.id("accordion__heading-6");
    private final By rentCancelPossibilityContent = By.xpath(".//div[@aria-labelledby = 'accordion__heading-6']/p");
    private final By rentDeliveryZone = By.id("accordion__heading-7");
    private final By rentDeliveryZoneContent = By.xpath(".//div[@aria-labelledby = 'accordion__heading-7']/p");

    public HomePage(WebDriver webDriver) {
        driver = webDriver;
    }

    public void waitForLoadOrderButton() {
        new WebDriverWait(driver, DURATION)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void waitForLoadFAQ() {
        new WebDriverWait(driver, DURATION)
                .until(ExpectedConditions.visibilityOfElementLocated(faqSection));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(faqSection));
    }

    public String getRentCostContentText() {
        driver.findElement(rentCost).click();
        return driver.findElement(rentCostContent).getText();
    }

    public String getRentCountContentText() {
        driver.findElement(rentCount).click();
        return driver.findElement(rentCountContent).getText();
    }

    public String getRentTimeContentText() {
        driver.findElement(rentTime).click();
        return driver.findElement(rentTimeContent).getText();
    }

    public String getRentOrderNowContentText() {
        driver.findElement(rentOrderNow).click();
        return driver.findElement(rentOrderNowContent).getText();
    }

    public String getRentPeriodContentText() {
        driver.findElement(rentPeriod).click();
        return driver.findElement(rentPeriodContent).getText();
    }

    public String getRentChargerContentText() {
        driver.findElement(rentCharger).click();
        return driver.findElement(rentChargerContent).getText();
    }

    public String getRentCancelPossibilityContentText() {
        driver.findElement(rentCancelPossibility).click();
        return driver.findElement(rentCancelPossibilityContent).getText();
    }

    public String getRentDeliveryZoneContentText() {
        driver.findElement(rentDeliveryZone).click();
        return driver.findElement(rentDeliveryZoneContent).getText();
    }
}
