package ru.job4j.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
      System.setProperty("webdriver.chrome.driver", "selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://ru.chabad.org/calendar/candlelighting_cdo/locationid/681/locationtype/1");
        System.out.println(webDriver.getPageSource());
        webDriver.quit();
    }
}
