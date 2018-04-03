//Caso de teste automatizado
//[TCR2-009] Validar Recuperação de Senha campo Email incorreto
//[TCR2-010] Validar Recuperação de Senha campo Email vazio

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
import pages.ElementoRecuperaSenha;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "massaDeDadosRecuperarSenhaNok.csv")

public class acessoRecuperarSenhaNokTest {
    public WebDriver driverNavegacao;

    @Before
    public void setUp() {

        driverNavegacao = Web.abrirChromeDriver();
    }

    @Test
    public void testAcessaRecuperaSenhaNok(

            @Param(name = "mensagemTitulo")String mensagemTituloRecuperaSenhaMassa,
            @Param(name = "emailCadastrado")String emailCadastradoMassa,
            @Param(name = "mensagemRecuperaSenhaNok")String mensagemRecuperaSenhaNOkMassa){


        //Efetua teste
        ElementoRecuperaSenha AcessaRecuperaSenhaNOk = new ElementoRecuperaSenha(driverNavegacao)
                .clicarLinkEsqueceuSenha()
                .mensagemTituloEsqueceuSenha(mensagemTituloRecuperaSenhaMassa)
                .digitarEmailCadastrado(emailCadastradoMassa)
                .clicarBotaoRecuperarSenha()
                .validaMensagemDeErroRecuperarSenhaNok(mensagemRecuperaSenhaNOkMassa);

    }

    @After
    public void tearDown(){
        driverNavegacao.quit();
    }
}
