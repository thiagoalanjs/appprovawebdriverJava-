//
//Caso de teste automaziado [TCR1-005] – [TCR1-005] - Validar senha vazio
//Caso de teste automaziado [TCR1-006] - Validar senha menos de 6 caracteres
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
@DataLoader(filePaths = "massaDeDadosContaUsuarioSenhaNok.csv")
public class criarContaUsuarioSenhaNokTest {
    public WebDriver driverNavegacao;

    @Before
    public void setUp(){
        driverNavegacao = Web.abrirChromeDriver();
    }

    @Test
    public void criarContaUsuarioSenhaNokTest(
            @Param(name = "nome")String nomeUsuario,
            @Param(name = "email")String emailUser,
            @Param(name = "senha")String senhaUser,
            @Param(name = "confirmeSenha")String confirmeSenhaUser,
            @Param(name = "mensagem")String mensagemUser){

        ElementosCriarContaUsuario criarContaUsuarioSenhaNokTest = new ElementosCriarContaUsuario(driverNavegacao)
                .clicarLinkCriarUsuario()
                .digitarNomeUsuario(nomeUsuario)
                .digitarEmailUsuario(emailUser)
                .digitarSenhaUsuario(senhaUser)
                .digitarConfirmarSenhaUsuario(confirmeSenhaUser)
                .clicarBotaoCadastrar()
                .validarMensagemSucessoCriarUsuario(mensagemUser);
    }

    @After
    public void tearDown(){

        driverNavegacao.quit();
    }
}
