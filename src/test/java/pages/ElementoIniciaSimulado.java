package pages;

import Suporte.Generator;
import Suporte.Screenshot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.xml.bind.Element;

public class ElementoIniciaSimulado extends BaseUrlGeral {
    public ElementoIniciaSimulado(WebDriver driverNavegador) {
        super(driverNavegador);
    }


    //caminho onde Salvo Evidencia na pasta Criacao Contas
    public String CaminhoEvidencia = "C:\\Users\\Santander\\IdeaProjects\\appprovawebdriverJava\\src\\test\\Evidencias\\Inicia_Simulado\\";


    public ElementoIniciaSimulado digitarEmail(String emailCliente){
        //digita email
        driverNavegacao.findElement(By.id("user_email")).sendKeys(emailCliente);
        return this;
    }

    public ElementoIniciaSimulado digitarSenha(String senhaCliente){
        //digita senha
        driverNavegacao.findElement(By.id("user_password")).sendKeys(senhaCliente);
        return this;
    }

    public ElementoIniciaSimulado clicarBotaoEntrar(){

        //Tirar Evidencia 1
        String evidencia1 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia1);

        driverNavegacao.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        return this;
    }

    public ElementoIniciaSimulado clicaLinkSimulado(){
        driverNavegacao.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
        return this;
    }

    public ElementoIniciaSimulado validaTituloPagina(String mensagemPaginaMassa){
        Assert.assertEquals(mensagemPaginaMassa,driverNavegacao.findElement(By.cssSelector("h1")).getText());
        return this;
    }

    public ElementoIniciaSimulado botaoIniciaSimulado(){
        //Tirar Evidencia 2
        String evidencia2 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia2);

        driverNavegacao.findElement(By.xpath("/html/body/section/section/section[2]/section[2]/section/section[1]/section/div[2]/table/tbody/tr[4]/td[5]/div/button")).click();

        return this;
    }

    public ElementoIniciaSimulado popUpComecarTeste(){
        //Tirar Evidencia 3
        String evidencia3 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia3);

        driverNavegacao.findElement(By.xpath("//button[@id='btn_start_mock']")).click();
        return this;
    }

    public ElementoIniciaSimulado escolheAltertiva(){
        driverNavegacao.findElement(By.xpath("//div[@class='alternative']/div[1]"));
        //Tirar Evidencia 4
        String evidencia4 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia4);

        return this;
    }

    public ElementoIniciaSimulado clicaBotaoResponderPergunta(){
        driverNavegacao.findElement(By.id("btn-simulated-answer-question")).click();
        //Tirar Evidencia 5
        String evidencia5 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia5);
        return this;
    }

    public ElementoIniciaSimulado validaMensagemAdvertencia(String mensagemAdvertencia){
           Assert.assertEquals("Não está se esquecendo de nada? Marque uma alternativa antes de seguir para a próxima pergunta.", driverNavegacao.findElement(By.xpath("//*[@id=\"form-questions-error\"]/div/ul/li/text()")).getText());
           return this;
    }
}
