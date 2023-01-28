package ru.praktikum.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import ru.praktikum.pages.*;
import ru.praktikum.BrowserEnv;
import org.hamcrest.MatcherAssert;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class OrderFlowTestClass {
    private final BrowserEnv objBrowser = BrowserEnv.FIREFOX;
    private final WebDriver driver = objBrowser.getDriver();
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String date;
    private final String rentPeriod;
    private final String colorTick;
    private final String comment;

    public OrderFlowTestClass(String name, String surname, String address,
                              String metroStation, String phone,
                              String date, String rentPeriod,
                              String colorTick, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.rentPeriod = rentPeriod;
        this.colorTick = colorTick;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Ольга", "Сучкова", "г. Ростов-на-Дону, ул. Ерёменко 60, кв. 8", "Бульвар Рокоссовского", "+79000000000",
                        "29.11.22", "сутки", "чёрный жемчуг", "домофон не работает"},
                {"Алексей", "Корчагин", "г. Ростов-на-Дону, ул. Пацаева 16, кв. 6", "Черкизовская ", "+79993261687",
                        "30.11.22", "двое", "серая безысходность", "позвоните, я спущусь"},
        };
    }

    @Test
    public void sendOrderTest() {
        assert driver != null;
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadOrderButton();
        objHomePage.clickOrderButton();
        OrderForm objOrder = new OrderForm(driver);
        objOrder.fillUserDetailsForm(name, surname, address, metroStation, phone);
        objOrder.waitForLoadNextButton();
        objOrder.clickNextButton();
        objOrder.fillRentDetailsForm(date, rentPeriod, colorTick, comment);
        objOrder.waitForLoadOrderButton();
        objOrder.clickOrderButton();
        objOrder.waitForLoadConfirmButton();
        objOrder.clickConfirmButton();
        objOrder.waitForLoadConfirmationMessage();
        String actual = objOrder.getOrderConfirmationMessage();
        String expected = "Заказ оформлен";
        MatcherAssert.assertThat(actual, containsString(expected));
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
