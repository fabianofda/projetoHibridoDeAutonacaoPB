package projetoHibridoDeAutonacaoPB.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void buttonAzul()  {
        driver.findElement(By.xpath("(//div[@class ='large-2 columns']/a)[1]")).click();
    }

    public String textoButtonAzul()  {
       return driver.findElement(By.xpath("(//div[@class ='large-2 columns']/a)[1]")).getText();
    }

    public void buttonVermelho() {
        driver.findElement(By.xpath("(//div[@class ='large-2 columns']/a)[2]")).click();
    }

    public String textoButtonVermelho()  {
        return driver.findElement(By.xpath("(//div[@class ='large-2 columns']/a)[2]")).getText();
    }

    public void buttonVerde() {
        driver.findElement(By.xpath("(//div[@class ='large-2 columns']/a)[3]")).click();
    }

    public String textoButtonVerde()  {
        return driver.findElement(By.xpath("(//div[@class ='large-2 columns']/a)[3]")).getText();
    }

    public String getStringAnswer() {
        String pageSource = driver.getPageSource();

        Pattern pattern = Pattern.compile("canvas.strokeText\\('Answer: (\\d+)',(\\d+),(\\d+)\\);");
        Matcher matcher = pattern.matcher(pageSource);

        String answer = null;
        if (matcher.find()) {
            answer = matcher.group(1);
        }
        return answer;
    }
}
