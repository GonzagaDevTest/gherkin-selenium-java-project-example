package pages;

import org.openqa.selenium.By;
import java.util.HashMap;
import java.util.Map;

public class CadUsuarioPage {
    private static Map<String, By> PAGE_OBJECTS = new HashMap<>();

    static {
        PAGE_OBJECTS.put("email", By.id("email_create"));
        PAGE_OBJECTS.put("btnCreate", By.id("SubmitCreate"));
        PAGE_OBJECTS.put("formCreate", By.id("account-creation_form"));
        PAGE_OBJECTS.put("generoMasculino", By.id("id_gender1"));
        PAGE_OBJECTS.put("nome", By.id("customer_firstname"));
        PAGE_OBJECTS.put("sobrenome", By.id("customer_lastname"));
        PAGE_OBJECTS.put("senha", By.id("passwd"));
        PAGE_OBJECTS.put("endereco", By.id("address1"));
        PAGE_OBJECTS.put("cidade", By.id("city"));
        PAGE_OBJECTS.put("estado", By.id("id_state"));
        PAGE_OBJECTS.put("codigoPostal", By.id("postcode"));
        PAGE_OBJECTS.put("celular", By.id("phone_mobile"));
        PAGE_OBJECTS.put("btnSumit", By.id("submitAccount"));
    }

    public By getBy(String campo){
        return PAGE_OBJECTS.get(campo);
    }
}
