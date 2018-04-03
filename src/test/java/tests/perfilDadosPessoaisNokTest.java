// Script de Teste para o cenário : [TCR3-001] Validar preenchimento nome
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
import pages.ElementoperfilDadosPessoais;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "massaDeDadosPerfilDadosPessoaisNok.csv")

public class perfilDadosPessoaisNokTest{
    public WebDriver driverNavegacao;

        @Before
        public void setUp(){
            driverNavegacao = Web.abrirChromeDriver();
        }
        @Test
        public void alteraDadosPessoaisNok(

                @Param(name = "email")String emailCliente,
                @Param(name = "senha")String senhaCliente,
                @Param(name = "mensagemErro")String mensagemAlteracaoSucesso) {


            ElementoperfilDadosPessoais alteraperfilDadosPessoais = new ElementoperfilDadosPessoais(driverNavegacao)
                    .digitarEmail(emailCliente)
                    .digitarSenha(senhaCliente)
                    .clicarBotaoEntrar()
                    .clicarMeuPerfil()
                    .apagaNome()
                    .clicarBotaoSalvarDados()
                    .validaMensagemSucesso(mensagemAlteracaoSucesso);

        }


        @After
        public void tearDown(){
            driverNavegacao.quit();

        }
}
