package pages;

import org.openqa.selenium.By;

public class LoginPage extends AbstractPage{

    public By getIdPage(){
        return By.id("login_form");
    }
    public By getCampoEmail(){
        return By.id("email");
    }
    public By getCampoSenha(){
        return By.id("passwd");
    }
    public By getBtnSubmit(){
        return By.id("SubmitLogin");
    }
}


