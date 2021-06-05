package robo;

import com.google.gson.JsonObject;
import cucumber.table.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.SetupClass;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Robo {
	public Robo() {
		}

	public Robo(SetupClass  setup) {
		try{
			setup.setup();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Robo.driver = driver;
	}

	public void iniciarAutomacao(){
		System.setProperty("webdriver.chrome.driver", getCaminhoDriver());
		setDriver(new ChromeDriver());
		getDriver().get("http://automationpractice.com");
	}

	public void fecharDriver(){
		if (getDriver() != null){
			getDriver().quit();
		}
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

	public void aguardarEstarPresente(By componente) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(componente));
	}
	
	public void scrollParaElemento(By elemento) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement((elemento)));
		((JavascriptExecutor) driver).executeScript("scrollTo(0, 800)");
	}
	
	public void clicarNoElemento(By elemento) {
		scrollParaElemento(elemento);
		driver.findElement(elemento).click();
	}

	public void clicarNoElementoPeloTitulo(String titulo) {
		driver.findElement(By.cssSelector("[title='"+titulo+"']")).click();
	}

	public void digitarNoCampo(By campo, String texto){
		driver.findElement(campo).sendKeys(texto);
	}

	public void digitarSaindoCampo(By campo, String texto){
		digitarNoCampo(campo, texto);
		driver.findElement(campo).sendKeys(Keys.TAB);
	}

	public String retornarTituloPagina(){
		return driver.getTitle();
	}

	public void limparCampo(By campo){
		driver.findElement(campo).clear();
	}

	public void aguardarElementoCarregar(By campo, int tempoEspera){
		new WebDriverWait(driver, tempoEspera);
	}

	public String retonarTextoBy(By campo){
		return driver.findElement(campo).getText();
	}

	public void selecionarCombo(String informacao, By by) {
		Select dropContry = new Select(driver.findElement(by));
		dropContry.selectByVisibleText(informacao);
	}

	public Map<String, Object> dataTableToMap(DataTable table) {
		Map<String, Object> request = new HashMap<>();
		List<String> chaves = table.raw().remove(0);
		table.raw().forEach(registro ->{
			for (int i = 0; i < chaves.size(); i++) {
				if (chaves.get(i).equalsIgnoreCase("id")) {
					request.put(chaves.get(i), Integer.parseInt(registro.get(i)));
					continue;
				}
				request.put(chaves.get(i), registro.get(i));
			}
		});
		table.raw().add(0,chaves);
		return request;
	}

	public JsonObject dataTableToJson(DataTable table) {
		JsonObject obj = new JsonObject();
		List<String> chaves = table.raw().remove(0);
		table.raw().forEach(registro ->{
			for (int i = 0; i < chaves.size(); i++) {
				if (chaves.get(i).equalsIgnoreCase("id")) {
					obj.addProperty(chaves.get(i), Integer.parseInt(registro.get(i)));
					continue;
				}
				obj.addProperty(chaves.get(i), registro.get(i));
			}
		});
		table.raw().add(0,chaves);
		return obj;
	}

}
