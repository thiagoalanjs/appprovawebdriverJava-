package tests;

import Suporte.Web;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ElementosCriarContaUsuario;

public class criarContaUsuarioTermoTest {


        public WebDriver driverNavegacao;

        @Before
        public void setUp(){
            driverNavegacao = Web.abrirChromeDriver();
        }

        @Test
        public void criarContaUsuarioTermoDeUso(){
            ElementosCriarContaUsuario criarContaUsuarioTermo = new ElementosCriarContaUsuario(driverNavegacao)
                    .clicarLinkCriarUsuario()
                    .validaLinkTermosDeUso();

            }

        @Test
        public void criarContaUsuarioTermoPoliticaPrivacidade(){
                ElementosCriarContaUsuario criarContaUsuarioTermoPoliticaPrivacidade = new ElementosCriarContaUsuario(driverNavegacao)
                    .clicarLinkCriarUsuario()
                    .vadaliLinkPoliticaPrivacidade();

        }


        @After
        public void tearDown(){
            driverNavegacao.quit();
        }
    }
