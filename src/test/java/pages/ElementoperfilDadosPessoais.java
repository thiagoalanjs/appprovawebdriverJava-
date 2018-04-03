package pages;

import Suporte.Generator;
import Suporte.Screenshot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementoperfilDadosPessoais extends BaseUrlGeral{
    public ElementoperfilDadosPessoais(WebDriver driverNavegador) {
        super(driverNavegador);
    }



    //caminho onde Salvo Evidencia na pasta Criacao Contas
    public String CaminhoEvidencia = "C:\\Users\\Santander\\IdeaProjects\\appprovawebdriverJava\\src\\test\\Evidencias\\Preenchimento_Perfil_Aluno\\";


    public ElementoperfilDadosPessoais digitarEmail(String emailCliente){
        //digita email
        driverNavegacao.findElement(By.id("user_email")).sendKeys(emailCliente);
        return this;
    }

    public ElementoperfilDadosPessoais digitarSenha(String senhaCliente){
        //digita senha
        driverNavegacao.findElement(By.id("user_password")).sendKeys(senhaCliente);
        return this;
    }

    public ElementoperfilDadosPessoais clicarBotaoEntrar(){
        //Tirar Evidencia 1
        String evidencia1 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia1);

        driverNavegacao.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        return this;
    }

    public ElementoperfilDadosPessoais clicarMeuPerfil(){
        //Tirar Evidencia 2
        String evidencia2 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia2);
        driverNavegacao.findElement(By.xpath("//i[@class='fa fa-user']")).click();

        return this;
    }


    public ElementoperfilDadosPessoais apagaNome(){
        //apagar nome cadastrado
        driverNavegacao.findElement(By.id("user_name")).clear();
        return this;
    }

    public ElementoperfilDadosPessoais digitaCpf(String cpfUsuarioMassa){
        driverNavegacao.findElement(By.id("user_cpf")).sendKeys(cpfUsuarioMassa);
        //Tirar Evidencia 3
        String evidencia3 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia3);

        return this;
    }

    public ElementoperfilDadosPessoais clicarBotaoSalvarDados(){
        driverNavegacao.findElement(By.xpath("//input[@type='submit']")).click();
        return this;
    }

    public ElementoperfilDadosPessoais validaMensagemSucesso(String mensagemAlteracaoSucesso){

        //verificando elemento após click do botao salva
        WebElement textoSucesoAlteracao = driverNavegacao.findElement(By.xpath("//*[@id=\"flash-message-box\"]"));
        String BuscaTextoSucessoAlteracao = textoSucesoAlteracao.getText();
        //Retira espaçamento e compara apenas o texto até o ponto final
        String stg = mensagemAlteracaoSucesso + "  ";
        Assert.assertEquals(BuscaTextoSucessoAlteracao,BuscaTextoSucessoAlteracao.substring((BuscaTextoSucessoAlteracao.length())-stg.length()));

        //Tirar Evidencia 4
        String evidencia4 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia4);
        return this;
    }

    public ElementoperfilDadosPessoais validaMensagemErroDeAlteracao(String mensagemErroDeAlteracao){

        //verificando elemento após click do botao salva
        WebElement textoSucesoAlteracao = driverNavegacao.findElement(By.xpath("//*[@id=\"flash-message-box\"]"));
        String BuscaTextoErroDeAlteracao = textoSucesoAlteracao.getText();
        //Retira espaçamento e compara apenas o texto até o ponto final
        String stg = mensagemErroDeAlteracao + "  ";
        Assert.assertEquals(BuscaTextoErroDeAlteracao,BuscaTextoErroDeAlteracao.substring((BuscaTextoErroDeAlteracao.length())-stg.length()));

        //Tirar Evidencia 5
        String evidencia5 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia5);
        return this;
    }

    public ElementoperfilDadosPessoais clicaLinkAlterarSenha(){
        driverNavegacao.findElement(By.linkText("Alterar senha")).click();

        //Tirar Evidencia 6
        String evidencia6 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia6);
        return  this;

    }

    public ElementoperfilDadosPessoais digitaSenhaAtual(String senhaAtualMassa){
        driverNavegacao.findElement(By.id("user_current_password")).sendKeys(senhaAtualMassa);
        //Tirar Evidencia 7
        String evidencia7 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia7);
        return this;
    }

    public ElementoperfilDadosPessoais digitaNovaSenha(String novaSenhaMassa){


        driverNavegacao.findElement(By.id("user_password")).sendKeys(novaSenhaMassa);

        //Tirar Evidencia 8
        String evidencia8 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia8);

        return this;
    }

    public ElementoperfilDadosPessoais digitaConfirmaNovaSenha(String confirmaNovaSenhaMassa){


        driverNavegacao.findElement(By.id("user_password_confirmation")).sendKeys(confirmaNovaSenhaMassa);
        //Tirar Evidencia 9
        String evidencia9 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia9);

        return this;


    }

    public ElementoperfilDadosPessoais clicaBotaoAlteraSenha(){
        driverNavegacao.findElement(By.xpath("//input[@type='submit']")).click();
        //Tirar Evidencia 10
        String evidencia10 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia10);

        return this;
    }

    public ElementoperfilDadosPessoais clicaBotaoCancela(String mensagemSucessoPaginaMeuPerfil){
        driverNavegacao.findElement(By.linkText("Cancelar")).click();
        Assert.assertEquals("Meu Perfil", driverNavegacao.findElement(By.xpath("/html/body/section/section/section[2]/section[2]/section/section/section/header/h1")).getText());

        //Tirar Evidencia 11
        String evidencia11 = CaminhoEvidencia + Generator.dataHoraParaArquivo() + ImagemDoTeste.getMethodName() +  ".png";
        Screenshot.tirar(driverNavegacao, evidencia11);

        return this;
    }

}
