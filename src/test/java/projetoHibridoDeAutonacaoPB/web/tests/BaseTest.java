package projetoHibridoDeAutonacaoPB.web.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;
    public static final String URL_BASE = "https://the-internet.herokuapp.com/challenging_dom";

    @BeforeClass
    public static void inicializar() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600, 1024));
        driver.get(URL_BASE);

    }

    @AfterClass
    public static void finalizar() {
        driver.quit();
    }
}
