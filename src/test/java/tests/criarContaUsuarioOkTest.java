//
//Caso de teste automaziado [TCR1-001] – Validar criação de conta Aluno
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
    @DataLoader(filePaths = "massaDeDadosContaUsuarioOk.csv")
    public class criarContaUsuarioOkTest {
        public WebDriver driverNavegacao;

        @Before
        public void setUp(){
            driverNavegacao = Web.abrirChromeDriver();
        }

        @Test
        public void criarContaUsuarioOKTest(
                @Param(name = "nome")String nomeUsuario,
                @Param(name = "email")String emailUser,
                @Param(name = "senha")String senhaUser,
                @Param(name = "confirmeSenha")String confirmeSenhaUser,
                @Param(name = "mensagemOk")String mensagemOkUser){

            ElementosCriarContaUsuario criarContaUsuarioOKTest = new ElementosCriarContaUsuario(driverNavegacao)
                    .clicarLinkCriarUsuario()
                    .digitarNomeUsuario(nomeUsuario)
                    .digitarEmailUsuario(emailUser)
                    .digitarSenhaUsuario(senhaUser)
                    .digitarConfirmarSenhaUsuario(confirmeSenhaUser)
                    .clicarBotaoCadastrar()
                    .validarMensagemSucessoCriarUsuario(mensagemOkUser);

        }


        @After
        public void tearDown(){
            driverNavegacao.quit();
        }
}
