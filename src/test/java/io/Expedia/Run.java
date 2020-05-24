package io.Expedia;

import io.Expedia.PageObject.GooglePage;
import org.junit.Test;

import java.sql.SQLException;

public class Run {
    @Test
    public void run() throws SQLException, ClassNotFoundException {
        new GooglePage().navigateTo("https://www.google.com/")
                .searchHotels();
    }
}
