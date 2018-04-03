package tests;

import Suporte.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ElementoAcessaLogin;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "massaDeDadosLoginNOK.csv")

public class acessoLoginNokTest {
    public WebDriver driverNavegacao;

    @Before
    public void setUp() {
        driverNavegacao = Web.abrirChromeDriver();
    }

    @Test
    public void testAcessaLoginEmailSenhaNok(
            @Param(name = "email")String emailCliente,
            @Param(name = "senha")String senhaCliente,
            @Param(name = "mensagem")String mensagemLoginMassa )
    {

        ElementoAcessaLogin acessaLoginNok = new ElementoAcessaLogin(driverNavegacao)
                .digitarEmail(emailCliente)
                .digitarSenha(senhaCliente)
                .clicarBotaoEntrar()
                .validaMensagemDeErro(mensagemLoginMassa);


    }

    @After
    public void tearDown(){
        driverNavegacao.quit();
    }
}