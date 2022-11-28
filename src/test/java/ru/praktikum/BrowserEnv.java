package ru.praktikum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum BrowserEnv {
            CHROME("chrome"), FIREFOX("firefox");
             private final String browser;
             BrowserEnv(String browserName){
                this.browser = browserName;
             }

            public WebDriver getDriver() {
                switch(this) {
                    case CHROME:
                        return new ChromeDriver();
                    case FIREFOX:
                        return new FirefoxDriver();
                    default:
                        break;
                }
                return null;
            }

}
