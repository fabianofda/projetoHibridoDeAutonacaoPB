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

    public void buttonAzul()  {
        var botao=  driver.findElement(By.xpath("(//div[@class ='large-2 columns']/a)[1]"));

        if (botao.isEnabled()) {
            System.out.println("O botão é clicável.");
            botao.click();
        } else {
            System.out.println("O botão não é clicável.");
        }

    }

    public void buttonVermelho() {
        var botao=  driver.findElement(By.xpath("(//div[@class ='large-2 columns']/a)[2]"));

        if (botao.isEnabled()) {
            System.out.println("O botão é clicável.");
            botao.click();
        } else {
            System.out.println("O botão não é clicável.");
        }
    }

    public void buttonVerde() {
        var botao=  driver.findElement(By.xpath("(//div[@class ='large-2 columns']/a)[3]"));

        if (botao.isEnabled()) {
            System.out.println("O botão é clicável.");
            botao.click();
        } else {
            System.out.println("O botão não é clicável.");
        }
    }
}
