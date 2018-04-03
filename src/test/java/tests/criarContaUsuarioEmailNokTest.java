//
//Caso de teste automaziado [TCR1-003] - Validar email inválido/vazio
//Caso de teste automaziado [TCR1-004] - Valida email já cadastrado
//
//

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
import pages.ElementosCriarContaUsuario;


@RunWith(DataDrivenTestRunner.class)
    @DataLoader(filePaths = "massaDeDadosContaUsuarioEmailNok.csv")
    public class criarContaUsuarioEmailNokTest {
        public WebDriver driverNavegacao;

        @Before
        public void setUp(){
            driverNavegacao = Web.abrirChromeDriver();
        }

        @Test
        public void criarContaUsuarioEmailNokTest(
                @Param(name = "nome")String nomeUsuario,
                @Param(name = "email")String emailUser,
                @Param(name = "senha")String senhaUser,
                @Param(name = "confirmeSenha")String confirmeSenhaUser,
                @Param(name = "mensagem")String mensagemUser){

            ElementosCriarContaUsuario criarContaUsuarioEmailNokTest = new ElementosCriarContaUsuario(driverNavegacao)
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
