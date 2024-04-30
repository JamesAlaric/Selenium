package com.automatisation.test.pageObjects;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {

    private WebDriver driver;

    private String path = "src/test/resources/chromedriver/chromedriver.exe";

    Page(){
        System.setProperty("webdriver.chrome.driver", this.path);
        this.driver = new ChromeDriver();
        PageFactory.initElements(this.driver, this);
    }

    public void get(String url){
        this.driver.get(url);
    }
}
