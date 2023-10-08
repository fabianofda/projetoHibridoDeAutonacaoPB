package projetoHibridoDeAutonacaoPB.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ChallengingPage {
    public WebDriver driver;
    public ChallengingPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> obterLinksEdit() {
        return  driver.findElements(By.xpath("//*[text()='edit']"));
    }

    public List<WebElement> obterLinksDelete() {
        return  driver.findElements(By.xpath("//*[text()='delete']"));
    }

    public void buttonAzul() {
        driver.findElement(By.xpath("(//div[@class ='large-2 columns']/a)[1]")).click();
    }

    public void buttonVermelho() {
        driver.findElement(By.xpath("(//div[@class ='large-2 columns']/a)[2]")).click();
    }

    public void buttonVerde() {
        driver.findElement(By.xpath("(//div[@class ='large-2 columns']/a)[3]")).click();
    }

    public boolean canvaAnswer() {
        return  driver.findElement(By.cssSelector("#canvas")).isDisplayed();
    }
}
