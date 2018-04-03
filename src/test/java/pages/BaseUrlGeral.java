package pages;


import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

public class BaseUrlGeral {
    protected WebDriver driverNavegacao;
    @Rule
    protected TestName ImagemDoTeste = new TestName();

    public BaseUrlGeral(WebDriver driverNavegador)
    {
        this.driverNavegacao = driverNavegador;
    }

}
