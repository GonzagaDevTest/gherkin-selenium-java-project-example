package pages;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoPage extends AbstractPage{
    private static Map<String, By> PAGE_OBJECTS = new HashMap<>();

    static {
        PAGE_OBJECTS.put("cardConfimProduto", By.id("layer_cart"));
        PAGE_OBJECTS.put("checkAceitarTermos",  By.id("cgv"));
        PAGE_OBJECTS.put("cartTitle",By.id("cart_title"));
        PAGE_OBJECTS.put("generoMasculino", By.id("id_gender1"));
        PAGE_OBJECTS.put("totalPedido", By.id("total_price_container"));
        PAGE_OBJECTS.put("btnSubmit", By.cssSelector(".cart_navigation button[type='submit']"));
        PAGE_OBJECTS.put("btnProcessarEndereco", By.name("processAddress"));
        PAGE_OBJECTS.put("btnProcessCarrier", By.name("processCarrier"));
    }

    public By getBy(String campo){
        return PAGE_OBJECTS.get(campo);
    }

    public By getCardProdutoByIdProduto(String id){
        return By.cssSelector("a[data-id-product=\""+id+"\"]");
    }
}
