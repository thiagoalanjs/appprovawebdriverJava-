package pages;

import Suporte.Generator;
import Suporte.Screenshot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementoRecuperaSenha extends BaseUrlGeral {
    public ElementoRecuperaSenha(WebDriver driverNavegador) {
        super(driverNavegador);
    }

    //caminho onde Salvo Evidencia na pasta Recupera Senha
    public String CaminhoEvidencia = "C:\\Users\\Santander\\IdeaProjects\\appprovawebdriverJava\\src\\test\\Evidencias\\Recupera_Senha\\";


    public ElementoRecuperaSenha clicarLinkEsqueceuSenha(){

        //Tirar Evidencia 1
        String evidencia1 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia1);

        driverNavegacao.findElement(By.linkText("Esqueci minha senha")).click();
        return this;
    }

    public ElementoRecuperaSenha mensagemTituloEsqueceuSenha(String mensagemTituloSenhaMassa){
        WebElement tituloMsg = driverNavegacao.findElement(By.xpath("//*[@id='login']/div/div/h2"));
        String validaMsg = tituloMsg.getText();
        Assert.assertEquals(mensagemTituloSenhaMassa, validaMsg);
        return this;
    }

    public ElementoRecuperaSenha digitarEmailCadastrado(String emailUser){
       driverNavegacao.findElement(By.id("user_email")).sendKeys(emailUser);
       return this;
    }

    public ElementoRecuperaSenha clicarBotaoRecuperarSenha(){
        //Tirar Evidencia 2
        String evidencia2 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia2);

        driverNavegacao.findElement(By.xpath("//input[@type='submit']")).click();
        return this;
    }

    public ElementoRecuperaSenha validaMensagemRecuperaSenhaOk(String mensagemRecuperaSenhaOkMassa){

        //Tirar Evidencia 3
        String evidencia3 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia3);


        WebElement mensagemRecuperaSenhaOk = driverNavegacao.findElement(By.xpath("//div[@class='notice']"));
        String validaMensagemRecuperaSenhaoK = mensagemRecuperaSenhaOk.getText();
        Assert.assertEquals(mensagemRecuperaSenhaOkMassa, validaMensagemRecuperaSenhaoK);
        return this;
    }

    public ElementoRecuperaSenha validaMensagemDeErroRecuperarSenhaNok(String mensagemRecuperaSenhaNOkMassa){
        Assert.assertEquals(mensagemRecuperaSenhaNOkMassa, driverNavegacao.findElement(By.xpath("//span[@class='help-inline']")).getText());
        //Tirar Evidencia 4
        String evidencia4 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia4);

        return this;
    }


}
