//
//Caso de teste automaziado [TCR1-002] – Validar nome do aluno inválido
//


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
import pages.ElementosCriarContaUsuario;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "massaDeDadosContaUsuarioNomeNok.csv")
public class criarContaUsuarioNomeNokTest {
    public WebDriver driverNavegacao;

    @Before
    public void setUp(){
        driverNavegacao = Web.abrirChromeDriver();
    }

    @Test
    public void criarContaUsuarioNomeNokTest(
            @Param(name = "nome")String nomeUsuario,
            @Param(name = "email")String emailUser,
            @Param(name = "senha")String senhaUser,
            @Param(name = "confirmeSenha")String confirmeSenhaUser,
            @Param(name = "mensagem")String mensagemUser){

        ElementosCriarContaUsuario criarContaUsuarioUsuarioNokTest = new ElementosCriarContaUsuario(driverNavegacao)
                .clicarLinkCriarUsuario()
                .digitarNomeUsuario(nomeUsuario)
                .digitarEmailUsuario(emailUser)
                .digitarSenhaUsuario(senhaUser)
                .digitarConfirmarSenhaUsuario(confirmeSenhaUser)
                .clicarBotaoCadastrar()
                .validaMensagemDeErroCriarUsuario(mensagemUser);

    }

    @After
    public void tearDown(){
        driverNavegacao.quit();
    }
}
