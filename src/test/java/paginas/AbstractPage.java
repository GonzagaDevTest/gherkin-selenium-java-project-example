package paginas;

import org.openqa.selenium.By;

public class AbstractPage {
    public By getMenuLogin() {
        return By.linkText("Sign in");
    }

    public By getCampoBuscaProdutos(){
        return By.id("search_query_top");
    }

    public By getBtnBuscaProdutos(){
        return By.name("submit_search");
    }

    public By getMemsagemSucesso(){
       return By.cssSelector(".center_column p[class='alert alert-success']");
    }
}
