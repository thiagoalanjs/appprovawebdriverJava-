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
import pages.ElementoperfilDadosPessoais;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "massaDeDadosPessoaisAlteracaoSenhaOk.csv")

public class alteraDadosPessoaisAlteracaoSenhaOkTest {
    public WebDriver driverNavegacao;

    @Before
    public void setUp(){
        driverNavegacao = Web.abrirChromeDriver();
    }

    @Test
    public void alteraDadosPessoaisAlteracaoSenhaOk(


            @Param(name = "email")String emailCliente,
            @Param(name = "senha")String senhaCliente,
            @Param(name = "senhaAtual")String senhaAtualMassa,
            @Param(name = "novaSenha")String novaSenhaMassa,
            @Param(name = "confimaNovaSenha")String confirmaNovaSenhaMassa,
            @Param(name = "mensagemSuscesso")String mensagemAlteracaoSucesso) {

        //Fluxo de inserir cpf
        ElementoperfilDadosPessoais alteraDadosPessoaisAlteracaoSenhaOk = new ElementoperfilDadosPessoais(driverNavegacao)
                .digitarEmail(emailCliente)
                .digitarSenha(senhaCliente)
                .clicarBotaoEntrar()
                .clicarMeuPerfil()
                .clicaLinkAlterarSenha()
                .digitaSenhaAtual(senhaAtualMassa)
                .digitaNovaSenha(novaSenhaMassa)
                .digitaConfirmaNovaSenha(confirmaNovaSenhaMassa)
                .clicaBotaoAlteraSenha()
                .validaMensagemSucesso(mensagemAlteracaoSucesso);

    }



    @After
    public void tearDown(){
        driverNavegacao.quit();

    }

}
