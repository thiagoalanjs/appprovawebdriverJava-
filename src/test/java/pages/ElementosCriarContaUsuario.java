package pages;

import Suporte.Generator;
import Suporte.Screenshot;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ElementosCriarContaUsuario extends BaseUrlGeral {




    public ElementosCriarContaUsuario(WebDriver driverNavegador) {
        super(driverNavegador);
    }


    //caminho onde Salvo Evidencia na pasta Criacao Contas
    public String CaminhoEvidencia = "C:\\Users\\Santander\\IdeaProjects\\appprovawebdriverJava\\src\\test\\Evidencias\\Criacao_de_Conta\\";


    public ElementosCriarContaUsuario clicarLinkCriarUsuario(){

        //Tirar Evidencia 1
        String evidencia1 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia1);

        driverNavegacao.findElement(By.linkText("Crie sua conta")).click();

        //Tirar Evidencia 2
        String evidencia2 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia2);


        WebElement telaCriarConta = driverNavegacao.findElement(By.xpath("//*[@id='login']/div[1]/div[1]/h2"));
        String informacaoTelaCriarConta = telaCriarConta.getText();
        Assert.assertEquals("Crie sua conta", informacaoTelaCriarConta);


        return this;
    }


    public ElementosCriarContaUsuario digitarNomeUsuario(String nomeUsuario) {

        driverNavegacao.findElement(By.id("user_name")).sendKeys(nomeUsuario);
        return this;
    }

    public ElementosCriarContaUsuario digitarEmailUsuario(String emailUser) {
        //digita email
        driverNavegacao.findElement(By.id("user_email")).sendKeys(emailUser);
        return this;
    }

    public ElementosCriarContaUsuario digitarSenhaUsuario(String senhaUser){
        //digita senha
        driverNavegacao.findElement(By.id("user_password")).sendKeys(senhaUser);
        return this;
    }

    public ElementosCriarContaUsuario digitarConfirmarSenhaUsuario(String confirmeSenhaUser) {
        //Confirma senha
        driverNavegacao.findElement(By.id("user_password_confirmation")).sendKeys(confirmeSenhaUser);
        return this;
    }

    public ElementosCriarContaUsuario clicarBotaoCadastrar(){

        //Tirar Evidencia 3
        String evidencia3 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia3);

        driverNavegacao.findElement(By.xpath("//input[@value='Cadastrar']")).click();
        return this;
    }

    public ElementosCriarContaUsuario validarMensagemSucessoCriarUsuario(String mensagemOkUser){

        //Tirar Evidencia 4
        String evidencia4 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia4);

        //verificando elemento após cadastro
        WebElement textoBemVindo = driverNavegacao.findElement(By.xpath("/html/body/section/section/section[1]/div"));
        String BuscaTextoBemVindo = textoBemVindo.getText();
        //Retira espaçamento e compara apenas o texto até o ponto final
        String stg = mensagemOkUser + "  ";
        Assert.assertEquals(BuscaTextoBemVindo,BuscaTextoBemVindo.substring((BuscaTextoBemVindo.length())-stg.length()));
        return this;
    }

    public ElementosCriarContaUsuario validaMensagemDeErroCriarUsuario(String mensagemUser){
        //Tirar Evidencia 5
        String evidencia5 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia5);

        Assert.assertEquals(mensagemUser, driverNavegacao.findElement(By.xpath("//span[@class='help-inline']")).getText());
        return this;
    }

    public ElementosCriarContaUsuario validaInformacaoTermoePoliticaPrivacidade(){
        //Tirar Evidencia 6
        String evidencia6 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia6);


        //valida mensamge no rodape
        WebElement textoTermo = driverNavegacao.findElement(By.xpath("//div[@class='application-terms]'"));
        String validaTextoTermo = textoTermo.getText();
        Assert.assertEquals("Ao se cadastrar, você concorda com os nossos termos de uso e política de privacidade.", validaTextoTermo);

        return this;
    }


    public ElementosCriarContaUsuario validaLinkTermosDeUso(){
        //valida abertura do link Termo de Uso
        driverNavegacao.findElement(By.linkText("termos de uso")).click();
        return this;
    }
    public ElementosCriarContaUsuario vadaliLinkPoliticaPrivacidade(){
        //valida abertura do link Politica de privacidade
        driverNavegacao.findElement(By.linkText("política de privacidade")).click();
        return this;
    }
}
