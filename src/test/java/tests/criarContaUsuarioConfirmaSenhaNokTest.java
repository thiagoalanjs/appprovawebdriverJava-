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


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "massaDeDadosContaUsuarioConfirmaSenhaNok.csv")
public class criarContaUsuarioConfirmaSenhaNokTest {
    public WebDriver driverNavegacao;

    @Before
    public void setUp(){
        driverNavegacao = Web.abrirChromeDriver();
    }

    @Test
    public void criarContaUsuarioConfirmaSenhaNokTest(
            @Param(name = "nome")String nomeUsuario,
            @Param(name = "email")String emailUser,
            @Param(name = "senha")String senhaUser,
            @Param(name = "confirmeSenha")String confirmeSenhaUser,
            @Param(name = "mensagem")String mensagemUser){

        //clica no link "Crie sua conta"
        driverNavegacao.findElement(By.linkText("Crie sua conta")).click();
        WebElement telaCriarConta = driverNavegacao.findElement(By.xpath("//*[@id='login']/div[1]/div[1]/h2"));
        String informacaoTelaCriarConta = telaCriarConta.getText();
        Assert.assertEquals("Crie sua conta", informacaoTelaCriarConta);

        //digita nome
        driverNavegacao.findElement(By.id("user_name")).sendKeys(nomeUsuario);

        //digita email
        driverNavegacao.findElement(By.id("user_email")).sendKeys(emailUser);

        //digita senha
        driverNavegacao.findElement(By.id("user_password")).sendKeys(senhaUser);

        //Confirma senha
        driverNavegacao.findElement(By.id("user_password_confirmation")).sendKeys(confirmeSenhaUser);

        //Clica no botão Cadastrar
        driverNavegacao.findElement(By.xpath("//input[@value='Cadastrar']")).click();

        //verificando mensagem de erro email vazio ou inválido
        Assert.assertEquals(mensagemUser, driverNavegacao.findElement(By.xpath("//span[@class='help-inline']")).getText());


    }

    @After
    public void tearDown(){
        driverNavegacao.quit();
    }
}

