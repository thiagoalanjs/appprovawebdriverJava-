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
@DataLoader(filePaths = "massaDeDadosPerfilAlteraSenhaBotaoCancela.csv")
public class alteraDadosPessoaisAlteracaoSenhaBotaoCancelaTest {
    public WebDriver driverNavegacao;

    @Before
    public void setUp(){
        driverNavegacao = Web.abrirChromeDriver();
    }

    @Test
    public void alteraDadosPessoaisAlteracaoBotaoCancelar(
            @Param(name = "email")String emailCliente,
            @Param(name = "senha")String senhaCliente,
            @Param(name = "senhaAtual")String senhaAtualMassa,
            @Param(name = "novaSenha")String novaSenhaMassa,
            @Param(name = "confimaNovaSenha")String confirmaNovaSenhaMassa,
            @Param(name = "mensagemSuscessoVoltaPagina")String mensagemSucessoPaginaMeuPerfil) {

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
                .clicaBotaoCancela(mensagemSucessoPaginaMeuPerfil);

    }


    @After
    public void tearDown(){
        driverNavegacao.quit();
    }


}
