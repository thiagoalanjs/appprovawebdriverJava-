package pages;

import Suporte.Generator;
import Suporte.Screenshot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementoAcessaLogin extends BaseUrlGeral {

    //caminho onde Salvo Evidencia na pasta Criacao Contas
    public String CaminhoEvidencia = "C:\\Users\\Santander\\IdeaProjects\\appprovawebdriverJava\\src\\test\\Evidencias\\Acesso_Portal\\";


    public ElementoAcessaLogin(WebDriver driverNavegador) {
        super(driverNavegador);
    }

    public ElementoAcessaLogin digitarEmail(String emailCliente){
        //digita email
        driverNavegacao.findElement(By.id("user_email")).sendKeys(emailCliente);
        return this;
    }

    public ElementoAcessaLogin digitarSenha(String senhaCliente){
        //digita senha
        driverNavegacao.findElement(By.id("user_password")).sendKeys(senhaCliente);
        return this;
    }

    public ElementoAcessaLogin clicarBotaoEntrar(){

        //Tirar Evidencia 1
        String evidencia1 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia1);

        driverNavegacao.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        return this;
    }
    public ElementoAcessaLogin validaMensagemDeErro(String mensagemLoginMassa){
        //valida mensagem login com dados incorretos
        WebElement  textoEmailLogin = driverNavegacao.findElement(By.className("alert"));
        String mensagemLoginNok = textoEmailLogin.getText();
        Assert.assertEquals(mensagemLoginMassa, mensagemLoginNok);

        //Tirar Evidencia 2
        String evidencia2 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia2);


        return this;
    }



    public ElementoAcessaLogin validaMensgemLogin(String mensagemLoginMassa){
        //valida mensagem login com dados incorretos
        WebElement textoEmailLogin = driverNavegacao.findElement(By.xpath("/html/body/section/section/section[2]/section[2]/section/section[1]/section/header/h1"));
        String mensagemLoginOk = textoEmailLogin.getText();
        Assert.assertEquals(mensagemLoginMassa, mensagemLoginOk);

        //Tirar Evidencia 3
        String evidencia3 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia3);

        return  this;
    }

}
