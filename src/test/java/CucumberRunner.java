import cucumber.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.RestAssured.baseURI;
import robo.Automacao;

@RunWith(Cucumber.class)
@Cucumber.Options(format={"pretty","html:reports/test-report"},tags= "@api")

public class CucumberRunner {
    protected static Automacao automacao = new Automacao();

    @BeforeClass
    public static void abirSistema(){
        automacao.iniciarAutomacao();
        enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "https://reqres.in";
        basePath = "/api";
    }

    @AfterClass
    public static  void fecharSistema(){
        automacao.fecharDriver();
    }
}