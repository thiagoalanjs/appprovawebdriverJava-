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
import pages.ElementopefilDadosEscolares;

@RunWith(DataDrivenTestRunner.class)

@DataLoader(filePaths = "massaDeDadosPerfilDadosEscolares.csv")
public class acessaDadosEscolaresTest {
    public WebDriver driverNavegacao;

    @Before
    public void setUp(){
        driverNavegacao = Web.abrirChromeDriver();
    }

    @Test
    public void testDadosEscolares(

            @Param(name = "email")String emailCliente,
            @Param(name = "senha")String senhaCliente,
            @Param(name = "listaEstado")String listaEstadoMassa,
            @Param(name = "listaCidade")String listaCidadeMassa,
            @Param(name = "comboEscola")String ComboEscolaMassa,
            @Param(name = "comboFormacao")String listaSerieFormacaoMassa,
            @Param(name = "mensagemSucesso")String mensagemSucessoMassa)throws InterruptedException

    {

        //Fluxo de inserir cpf
        ElementopefilDadosEscolares testDadosEscolares = new ElementopefilDadosEscolares(driverNavegacao)
                .digitarEmail(emailCliente)
                .digitarSenha(senhaCliente)
                .clicarBotaoEntrar()
                .clicarMeuPerfil()
                .clicaAbaDadosEscolares()
                .listaEstado(listaEstadoMassa)
                .listaCidade(listaCidadeMassa)
                .escolheComboEscola(ComboEscolaMassa)
                .listaSerieFormacao(listaSerieFormacaoMassa)
                .clicaBotaoSalvar()
                .validaMensagemSucesso(mensagemSucessoMassa);

    }



    @After
    public void tearDown(){
        driverNavegacao.quit();

    }

}
