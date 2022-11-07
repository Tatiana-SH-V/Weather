import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tatiana_SH_V_Test_Lesson {

    /**
     * /TC_1_1  - Тест кейс:
     * //1. Открыть страницу https://openweathermap.org/
     * //2. Набрать в строке поиска город Paris
     * //3. Нажать пункт меню Search
     * //4. Из выпадающего списка выбрать Paris, FR
     * //5. Подтвердить, что заголовок изменился на "Paris, FR"
     */
    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/C:\\Chrom\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        //1. Открыть страницу https://openweathermap.org/
        driver.get(url);
        Thread.sleep(5000);

        //2. Набрать в строке поиска город Paris
        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        //3. Нажать пункт меню Search
        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();
        Thread.sleep(2000);

        //4. Из выпадающего списка выбрать Paris, FR
        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']//li/span[text () = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();

        //5. Подтвердить, что заголовок изменился на "Paris, FR"
        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );
        Thread.sleep(5000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(5000);
        driver.quit();


    }
}
