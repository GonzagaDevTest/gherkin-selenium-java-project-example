import cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import robo.Robo;

@RunWith(Cucumber.class)
@Cucumber.Options(format={"pretty","html:reports/test-report"},  tags = "@roteiro")

public class CucumberRunner {
    protected static Robo robo = new Robo();

    @AfterClass
    public static  void fecharSistema(){
        robo.fecharDriver();
    }
}