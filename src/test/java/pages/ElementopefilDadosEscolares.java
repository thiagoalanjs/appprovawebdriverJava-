package pages;

import Suporte.Generator;
import Suporte.Screenshot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class ElementopefilDadosEscolares extends BaseUrlGeral{
    public ElementopefilDadosEscolares(WebDriver driverNavegador) {
        super(driverNavegador);
    }

    //caminho onde Salvo Evidencia na pasta Criacao Contas
    public String CaminhoEvidencia = "C:\\Users\\Santander\\IdeaProjects\\appprovawebdriverJava\\src\\test\\Evidencias\\Preenchimento_Dados_Escolares\\";


    public ElementopefilDadosEscolares digitarEmail(String emailCliente){

        //digita email
        driverNavegacao.findElement(By.id("user_email")).sendKeys(emailCliente);
        return this;
    }

    public ElementopefilDadosEscolares digitarSenha(String senhaCliente){
        //digita senha
        driverNavegacao.findElement(By.id("user_password")).sendKeys(senhaCliente);
        return this;
    }


    public ElementopefilDadosEscolares clicarBotaoEntrar(){
        //Tirar Evidencia 1
        String evidencia1 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia1);

        driverNavegacao.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        return this;
    }

    public ElementopefilDadosEscolares clicarMeuPerfil(){
        driverNavegacao.findElement(By.xpath("//i[@class='fa fa-user']")).click();
        return this;
    }


    public ElementopefilDadosEscolares clicaAbaDadosEscolares(){
        //Tirar Evidencia 2
        String evidencia2 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia2);

        driverNavegacao.findElement(By.linkText("Dados escolares")).click();

        return this;
    }


    public  ElementopefilDadosEscolares listaEstado(String listaEstadoMassa){

        //Tirar Evidencia 3
        String evidencia3 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia3);

        WebElement campoType = driverNavegacao.findElement(By.name("user[estado_id]"));
        new Select(campoType).selectByVisibleText(listaEstadoMassa);

        //Tirar Evidencia 4
        String evidencia4 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia4);

        return this;
    }

    public  ElementopefilDadosEscolares listaCidade(String listaCidade){



        WebElement campoType = driverNavegacao.findElement(By.name("user[cidade_id]"));
        new Select(campoType).selectByVisibleText(listaCidade);


        //Tirar Evidencia 5
        String evidencia5 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia5);

        return this;
    }

    public  ElementopefilDadosEscolares escolheComboEscola(String ComboEscolaMassa) throws InterruptedException {



        driverNavegacao.findElement(By.xpath("/html/body/section/section/section[2]/section[2]/section/section/section/section/form/div/div[3]/div/div/div/a/span[2]/b")).click();
        WebElement textCampoEscola =  driverNavegacao.findElement(By.id("s2id_autogen1_search"));
        textCampoEscola.sendKeys(ComboEscolaMassa);
        TimeUnit.SECONDS.sleep(4);
        textCampoEscola.sendKeys(Keys.TAB);

        //Tirar Evidencia 6
        String evidencia6 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia6);




        return this;
    }

    public  ElementopefilDadosEscolares listaSerieFormacao(String listaSerieFormacaoMassa){
        WebElement campoType = driverNavegacao.findElement(By.name("user[enrollment_attributes][grade_id]"));
        new Select(campoType).selectByVisibleText(listaSerieFormacaoMassa);

        //Tirar Evidencia 7
        String evidencia7 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia7);


        return this;
    }

    public  ElementopefilDadosEscolares clicaBotaoSalvar(){
        driverNavegacao.findElement(By.name("commit")).click();
        return this;
    }


    public ElementopefilDadosEscolares validaMensagemSucesso(String mensagemAlteracaoSucesso){

        //verificando elemento após click do botao salva
        WebElement textoSucesoAlteracao = driverNavegacao.findElement(By.xpath("//*[@id=\"flash-message-box\"]"));
        String BuscaTextoSucessoAlteracao = textoSucesoAlteracao.getText();
        //Retira espaçamento e compara apenas o texto até o ponto final
        String stg = mensagemAlteracaoSucesso + "  ";
        Assert.assertEquals(BuscaTextoSucessoAlteracao,BuscaTextoSucessoAlteracao.substring((BuscaTextoSucessoAlteracao.length())-stg.length()));

        //Tirar Evidencia 8
        String evidencia8 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia8);


        return this;
    }
}
