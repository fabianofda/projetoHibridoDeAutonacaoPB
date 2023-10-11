package projetoHibridoDeAutonacaoPB.web.tests;


import org.junit.Test;

import org.openqa.selenium.WebElement;
import projetoHibridoDeAutonacaoPB.web.pages.ChallengingPage;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChallengingTest extends BaseTest{
    ChallengingPage page = new ChallengingPage(driver);

    @Test
    public void testDeveEfetuarUmCliqueNoBotaoAzulDaTela() {
        page.buttonAzul();
    }

    @Test
    public void testDeveEfetuarUmCliqueNoBotaoVermelhoDaTela() {
        page.buttonVermelho();
    }

    @Test
    public void testDeveEfetuarUmCliqueNoBotaoVerdeDaTela() {
        page.buttonVerde();
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

        assertEquals(10, contadorEdit);
        assertEquals(10, contadorDelete);
    }
}
