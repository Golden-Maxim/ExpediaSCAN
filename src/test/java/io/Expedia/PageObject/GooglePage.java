package io.Expedia.PageObject;

import core.DataBase;
import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.sql.SQLException;

public class GooglePage {
    private By searchField = By.name("q");
    private By searchButton = By.name("btnK");
    private By firstHotel = By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a");


    public GooglePage navigateTo(String url) {
        DriverManager.getChromeDriver().get(url);

        return this;
    }
    public GooglePage searchHotels() throws ClassNotFoundException, SQLException {
        DataBase dataBase = new DataBase();
        for (String hotelName:dataBase.getNameOfHotel()){
            DriverManager.getChromeDriver().findElement(searchField).sendKeys(hotelName + " expedia", Keys.ENTER);
            DriverManager.getChromeDriver().findElement(firstHotel).click();
            //DriverManager.getChromeDriver().findElement(searchField).clear();
        }


        return this;
    }
}
