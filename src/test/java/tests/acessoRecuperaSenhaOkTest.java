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
import pages.ElementoAcessaLogin;
import pages.ElementoRecuperaSenha;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "massaDeDadosRecuperarSenhaOk.csv")
public class acessoRecuperaSenhaOkTest {
    public WebDriver driverNavegacao;

    @Before
    public void setUp() {
        driverNavegacao = Web.abrirChromeDriver();
    }

    @Test
    public void testAcessaRecuperaSenhaOk(

            @Param(name = "mensagemTitulo")String mensagemTituloRecuperaSenhaMassa,
            @Param(name = "emailCadastrado")String emailCadastradoMassa,
            @Param(name = "mensagemRecuperaSenhaOk")String mensagemRecuperaSenhaOKMassa){


        //Efetua teste
        ElementoRecuperaSenha AcessaRecuperaSenhaOk = new ElementoRecuperaSenha(driverNavegacao)
                .clicarLinkEsqueceuSenha()
                .mensagemTituloEsqueceuSenha(mensagemTituloRecuperaSenhaMassa)
                .digitarEmailCadastrado(emailCadastradoMassa)
                .clicarBotaoRecuperarSenha()
                .validaMensagemRecuperaSenhaOk(mensagemRecuperaSenhaOKMassa);

    }

    @After
    public void tearDown(){
        driverNavegacao.quit();
    }
}



