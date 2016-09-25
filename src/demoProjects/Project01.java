package demoProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Project01 {

    public static void main(String[] args){

        String defaultURL = "http://www.livescore.com/";

        System.setProperty("webdriver.gecko.driver","libs/geckodriver");

        WebDriver driver;
        driver= new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get(defaultURL);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement premierLeagueTableIsDisplayed = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@data-type='container']/div[contains(@class, 'row-gray') and @data-stg-id='159']")
                ));

        List<WebElement> premierLeagueElements = driver.findElements(By.xpath("//div[@data-type='container']/div[contains(@class, 'row-gray') and @data-stg-id='159']"));

        System.out.println("Number of elements: " + premierLeagueElements.size() + "\n");
        for (WebElement element : premierLeagueElements) {
            WebElement teamNames = element.findElement(By.xpath("div[@class='ply name' or @class='ply tright name']"));
            System.out.println(teamNames.getText());
        }

        driver.close();
        driver.quit();
    }

}
