package tests;

import Suporte.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.ElementoIniciaSimulado;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "massaDeDadosIniciaSimulacaoSemResponderPerguntaTest.csv")

public class IniciaSimuladoSemResponderPerguntaNokTest {

    public WebDriver driverNavegacao;

    @Before
    public void setUp(){
        driverNavegacao = Web.abrirChromeDriver();
    }

    @Test
    public void iniciarSimuladoSemResponderPerguntaTest(


            @Param(name = "email")String emailCliente,
            @Param(name = "senha")String senhaCliente,
            @Param(name = "mensagemPagina")String mensagemPaginaMassa
    ) {

        //Fluxo de inserir cpf
        ElementoIniciaSimulado iniciarSimuladoSemResponderPerguntaTest = new ElementoIniciaSimulado(driverNavegacao)
                .digitarEmail(emailCliente)
                .digitarSenha(senhaCliente)
                .clicarBotaoEntrar()
                .clicaLinkSimulado()
                .validaTituloPagina(mensagemPaginaMassa)
                .botaoIniciaSimulado()
                .clicaBotaoResponderPergunta();

    }

    @After
    public void tearDown(){
        driverNavegacao.quit();
    }
}
