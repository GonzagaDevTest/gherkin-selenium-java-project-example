package robo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automacao {
    public static WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    public WebDriver setDriver(WebDriver driver){
        return Automacao.driver = driver;
    }

    public void iniciarAutomacao(){
        System.setProperty("webdriver.chrome.driver", getCaminhoDriver());
        setDriver(new ChromeDriver());
        getDriver().get("http://automationpractice.com");
    }

    public void fecharDriver(){
        getDriver().quit();
    }

    public String getCaminhoDriver(){
        String so =  System.getProperty("os.name");
        StringBuilder folderDrivers = new StringBuilder("drivers/");
        if(so.equals("Linux")){
            return folderDrivers.append("chromedriver-linux").toString();
        }
        System.err.println("#############################################################");
        System.err.println("# Esta automação ainda não foi homologada com outros SOs ;) #");
        System.err.println("##############################################################");
        return folderDrivers.append("chromedriver.exe").toString();

    }
}
