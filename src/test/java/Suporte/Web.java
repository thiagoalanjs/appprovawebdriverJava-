package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static  WebDriver abrirChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Santander\\IdeaProjects\\appprovawebdriverJava\\src\\test\\drive\\chromedriver.exe");
        WebDriver driverNavegacao = new ChromeDriver();
        driverNavegacao.manage().window().maximize();
        driverNavegacao.get("http://k8s.homolog.enem.appprova.com.br/");
        driverNavegacao.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);



        return driverNavegacao;

    }


}
