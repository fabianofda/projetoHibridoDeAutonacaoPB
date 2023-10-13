package projetoHibridoDeAutonacaoPB.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import projetoHibridoDeAutonacaoPB.api.tests.UsuarioTest;
import projetoHibridoDeAutonacaoPB.web.tests.ChallengingTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    UsuarioTest.class,
    ChallengingTest.class
})
public class RunnerTests {

}
