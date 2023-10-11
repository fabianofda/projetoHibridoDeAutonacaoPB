package projetoHibridoDeAutonacaoPB.web.tests;


import org.junit.Test;

import org.openqa.selenium.WebElement;
import projetoHibridoDeAutonacaoPB.web.pages.ChallengingPage;
import java.util.List;

import static org.junit.Assert.*;

public class ChallengingTest extends BaseTest{
    ChallengingPage page = new ChallengingPage(driver);

    @Test
    public void testDeveEfetuarUmCliqueNoBotaoAzulDaTela() {

        var antesDoClick = page.textoButtonAzul();
        System.out.println("Texto antes do clique no botao Azul: " + antesDoClick);

        page.buttonAzul();

        var depoisDoClick = page.textoButtonAzul();
        System.out.println("Texto depois do clique no botao Azul: " + depoisDoClick);

        assertNotEquals(antesDoClick, depoisDoClick);

    }

    @Test
    public void testDeveEfetuarUmCliqueNoBotaoVermelhoDaTela() {

        var antesDoClick = page.textoButtonVermelho();
        System.out.println("Texto antes do clique no botao vermelho: " + antesDoClick);

        page.buttonVermelho();

        var depoisDoClick = page.textoButtonVermelho();
        System.out.println("Texto depois do clique no botao vermelho: " + depoisDoClick);

        assertNotEquals(antesDoClick, depoisDoClick);
    }

    @Test
    public void testDeveEfetuarUmCliqueNoBotaoVerdeDaTela() {
        var antesDoClick = page.textoButtonVerde();
        System.out.println("Texto antes do clique no botao verde: " + antesDoClick);

        page.buttonVerde();

        var depoisDoClick = page.textoButtonVerde();
        System.out.println("Texto depois do clique no botao verde: " + depoisDoClick);

        assertNotEquals(antesDoClick, depoisDoClick);
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

        assertEquals(10, elementosEdit.size());
        assertEquals(10, elementosDelete.size());

    }
}
