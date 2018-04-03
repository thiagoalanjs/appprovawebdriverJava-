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
@DataLoader(filePaths = "massaDeDadosPerfilDadosPessoaisOk.csv")


public class perfilDadosPessoaisOkTest {
    public WebDriver driverNavegacao;

    @Before
    public void setUp(){
        driverNavegacao = Web.abrirChromeDriver();
    }

    @Test
    public void alteraDadosPessoaisInsereCpfOK(

            @Param(name = "email")String emailCliente,
            @Param(name = "senha")String senhaCliente,
            @Param(name = "cpf" )String cpfUsuarioMassa,
            @Param(name = "mensagemSuscesso")String mensagemAlteracaoSucesso) {

        //Fluxo de inserir cpf
        ElementoperfilDadosPessoais alteraDadosPessoaisInsereCpfOK = new ElementoperfilDadosPessoais(driverNavegacao)
                .digitarEmail(emailCliente)
                .digitarSenha(senhaCliente)
                .clicarBotaoEntrar()
                .clicarMeuPerfil()
                .digitaCpf(cpfUsuarioMassa)
                .clicarBotaoSalvarDados()
                .validaMensagemSucesso(mensagemAlteracaoSucesso);

    }


    @After
    public void tearDown(){
        driverNavegacao.quit();

    }
}
