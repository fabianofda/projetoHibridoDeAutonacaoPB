package projetoHibridoDeAutonacaoPB.web.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import projetoHibridoDeAutonacaoPB.web.pages.ChallengingPage;
import java.util.List;

public class ChallengingTest extends BaseTest{
    ChallengingPage page = new ChallengingPage(driver);

    @Test
    public void testDeveEfetuarUmCliqueNoBotaoAzulDaTela(){
        page.buttonAzul();
        var  elemento = page.canvaAnswer();

        Assert.assertTrue("O elemento está presente!", elemento);
    }

    @Test
    public void testDeveEfetuarUmCliqueNoBotaoVermelhoDaTela(){
        page.buttonVermelho();
        var  elemento = page.canvaAnswer();

        Assert.assertTrue("O elemento está presente!", elemento);
    }

    @Test
    public void testDeveEfetuarUmCliqueNoBotaoVerdeDaTela(){
        page.buttonVerde();
        var  elemento = page.canvaAnswer();

        Assert.assertTrue("O elemento está presente!", elemento);
    }

    @Test
    public void testDeveClicarEmTodosOsBotoesEditEDeleteDaGrid(){
        List<WebElement> elementosEdit =  page.obterLinksEdit();
        List<WebElement> elementosDelete =  page.obterLinksDelete();

        int contadorEdit = 0;
        int contadorDelete = 0;

        for (WebElement linkEdit : elementosEdit) {
            linkEdit.click();
            contadorEdit++;
        }

        for (WebElement linkDelete : elementosDelete) {
            linkDelete.click();
            contadorDelete++;
        }

        Assert.assertEquals(10, contadorEdit);
        Assert.assertEquals(10, contadorDelete);
    }
}
