package ru.praktikum.tests;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.praktikum.pages.HomePage;
import ru.praktikum.BrowserEnv;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FAQTestClass {
    private final BrowserEnv objBrowser = BrowserEnv.CHROME;
    private final WebDriver driver = objBrowser.getDriver();

    private final String rentCostContent;
    private final String rentCountContent;
    private final String rentTimeContent;
    private final String rentOrderNowContent;
    private final String rentPeriodContent;
    private final String rentChargerContent;
    private final String rentCancelPossibilityContent;
    private final String rentDeliveryZoneContent;

    public FAQTestClass(String rentCostContent, String rentCountContent, String rentTimeContent, String rentOrderNowContent,
                        String rentPeriodContent, String rentChargerContent, String rentCancelPossibilityContent,
                        String rentDeliveryZoneContent) {
        this.rentCostContent = rentCostContent;
        this.rentCountContent = rentCountContent;
        this.rentTimeContent = rentTimeContent;
        this.rentOrderNowContent = rentOrderNowContent;
        this.rentPeriodContent = rentPeriodContent;
        this.rentChargerContent = rentChargerContent;
        this.rentCancelPossibilityContent = rentCancelPossibilityContent;
        this.rentDeliveryZoneContent = rentDeliveryZoneContent;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getCntentData() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                                "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — " +
                                "даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        "Да, пока самокат не привезли. Штрафа не будет, " +
                                "объяснительной записки тоже не попросим. Все же свои.",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
                {null, null, null, null, null, null, null, null},
        };
    }

    @Test
    public void checkRentCostText() {
        assert driver != null;
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadFAQ();
        String actual = objHomePage.getRentCostContentText();
        assertEquals("Текст не совпадает", rentCostContent, actual);
    }

    @Test
    public void checkRentCountText() {
        assert driver != null;
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadFAQ();
        String actual = objHomePage.getRentCountContentText();
        assertEquals("Текст не совпадает", rentCountContent, actual);
    }

    @Test
    public void checkRentTimeText() {
        assert driver != null;
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadFAQ();
        String actual = objHomePage.getRentTimeContentText();
        assertEquals("Текст не совпадает", rentTimeContent, actual);
    }

    @Test
    public void checkRentOrderNowText() {
        assert driver != null;
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadFAQ();
        String actual = objHomePage.getRentOrderNowContentText();
        assertEquals("Текст не совпадает", rentOrderNowContent, actual);
    }

    @Test
    public void checkRentPeriodText() {
        assert driver != null;
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadFAQ();
        String actual = objHomePage.getRentPeriodContentText();
        assertEquals("Текст не совпадает", rentPeriodContent, actual);
    }

    @Test
    public void checkRentChargerText() {
        assert driver != null;
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadFAQ();
        String actual = objHomePage.getRentChargerContentText();
        assertEquals("Текст не совпадает", rentChargerContent, actual);
    }

    @Test
    public void checkRentCancelPossibilityText() {
        assert driver != null;
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadFAQ();
        String actual = objHomePage.getRentCancelPossibilityContentText();
        assertEquals("Текст не совпадает", rentCancelPossibilityContent, actual);
    }

    @Test
    public void checkRentDeliveryZoneText() {
        assert driver != null;
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadFAQ();
        String actual = objHomePage.getRentDeliveryZoneContentText();
        assertEquals("Текст не совпадает", rentDeliveryZoneContent, actual);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
