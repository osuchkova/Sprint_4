package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderForm  {

    private static final int DURATION = 3;

    private final WebDriver driver;

    public OrderForm(WebDriver webDriver) {
        driver = webDriver;
    }


    // данные клиента
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // данные аренды
    private final By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentPeriod = By.className("Dropdown-placeholder");
    private final By colorTick  = By.xpath(".//input[@class='Checkbox_Input__14A2w']");
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // кнопки флоу заказа
    private final By nextButton = By.xpath(".//button[text() = 'Далее']");
    private final By orderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    private final By confirmButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Да']");
    private final By orderConfirmationMessage = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']/div[@class = 'Order_ModalHeader__3FDaJ']");
    public void waitForLoadNextButton(){
        new WebDriverWait(driver, DURATION)
                .until(ExpectedConditions.visibilityOfElementLocated(nextButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(nextButton));
    }

    public void waitForLoadOrderButton(){
        new WebDriverWait(driver, DURATION)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButton));
    }
    public void waitForLoadConfirmButton(){
        new WebDriverWait(driver, DURATION)
                .until(ExpectedConditions.visibilityOfElementLocated(confirmButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(confirmButton));
    }
    public void waitForLoadConfirmationMessage(){
        new WebDriverWait(driver, DURATION)
                .until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationMessage));
    }
    public void setName(String clientName) {
        driver.findElement(name).sendKeys(clientName);
    }

    public void setSurname(String clientSurname) {
        driver.findElement(surname).sendKeys(clientSurname);
    }

    public void setAddress(String clientAddress) {
        driver.findElement(address).sendKeys(clientAddress);
    }

    public void setMetroStation(String clientMetroStation) {
        driver.findElement(metroStation).click();
        By metroStationOption = By.xpath(".//li[@class = 'select-search__row']/button/div[contains(text(),'" + clientMetroStation + "')]");
        driver.findElement(metroStationOption).click();
    }

    public void setPhone(String clientPhone) {
        driver.findElement(phone).sendKeys(clientPhone);
    }

    public void setDate(String orderDate) {
        driver.findElement(date).click();
        driver.findElement(date).sendKeys(orderDate);
        driver.findElement(date).sendKeys(Keys.ENTER);
    }

    public void setRentPeriod(String orderRentPeriod) {
        driver.findElement(rentPeriod).click();
        By rentPeriodOption = By.xpath(".//div[@class = 'Dropdown-menu']/div[contains(text(),'" + orderRentPeriod + "')]");
        driver.findElement(rentPeriodOption).click();
    }

    public void setColorTick(String orderColorTick) {
        driver.findElement(colorTick);
        if (orderColorTick.equals("чёрный жемчуг")) {
            driver.findElement(By.id("black")).click();
        } else driver.findElement(By.id("grey")).click();
    }

    public void setComment(String orderComment) {
        driver.findElement(comment).sendKeys(orderComment);
    }

    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }
    public void clickConfirmButton(){
        driver.findElement(confirmButton).click();
    }

    public String getOrderConfirmationMessage(){

        return driver.findElement(orderConfirmationMessage).getText();
    }

    public void fillUserDetailsForm(String clientName, String clientSurname,
                                    String clientAddress, String clientMetroStation,
                                    String clientPhone){
        setName(clientName);
        setSurname(clientSurname);
        setAddress(clientAddress);
        setMetroStation(clientMetroStation);
        setPhone(clientPhone);
    }

    public void fillRentDetailsForm(String orderDate, String orderRentPeriod,
                                    String colorTick, String orderComment){
        setDate(orderDate);
        setRentPeriod(orderRentPeriod);
        setColorTick(colorTick);
        setComment(orderComment);
    }
}