package steps.e2e;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import robo.Robo;
import static org.junit.Assert.assertEquals;
import paginas.*;
import robo.Automacao;

public class E2eSteps {
    private WebDriver driver = new  Automacao().getDriver();
    private static Robo robo;
    private final MinhaContaPage minhaContaPage;
    private final LoginPage loginPage;
    private static CarrinhoPage carrinhoPage;
    private static CadUsuarioPage cadUsuarioPage;

    public E2eSteps() {
        robo = new Robo(driver);
        minhaContaPage = new MinhaContaPage();
        loginPage = new LoginPage();
        carrinhoPage = new CarrinhoPage();
        cadUsuarioPage = new CadUsuarioPage();
    }

    @Given("^que o usuário acessou a plataforma com o e-mail \"([^\"]*)\" e a senha \"([^\"]*)\"$")
    public void que_o_usuario_acessou_a_plataforma_com_o_e_mail_e_a_senha(String email,String senha){
        robo.clicarNoElemento(loginPage.getMenuLogin());
        robo.aguardarEstarPresente(loginPage.getIdPage());
        robo.digitarSaindoCampo(loginPage.getCampoEmail(), email);
        robo.digitarSaindoCampo(loginPage.getCampoSenha(), senha);
        robo.clicarNoElemento(loginPage.getBtnSubmit());
    }

    @Given("^que o usuário acessou a tela de cadastro de usuário$")
    public void que_o_usuario_acessou_a_tela_de_cadastro_de_usuario(){
        robo.clicarNoElemento(loginPage.getMenuLogin());
        robo.aguardarEstarPresente(By.id("email_create"));
    }

    @Given("^na pagina de cadastro de usuário digitar \"([^\"]*)\" no campo \"([^\"]*)\"$")
    public static void na_pagina_de_cadastro_de_usuario_digitar_no_campo(String texto, String campo) {
        robo.digitarSaindoCampo(cadUsuarioPage.getBy(campo),texto);
    }

    @Given("^na pagina de cadastro de usuário clicar no elemento \"([^\"]*)\"$")
    public void na_pagina_de_cadastro_de_usuario_clicar_no_elemento(String elemento) {
        robo.clicarNoElemento(cadUsuarioPage.getBy(elemento));
    }

    @Given("^na pagina de cadastro de usuário o elemento \"([^\"]*)\" está presente$")
    public void na_pagina_de_cadastro_de_usuario_o_elemento_esta_presente(String elemento) {
        robo.aguardarEstarPresente(cadUsuarioPage.getBy(elemento));
    }

    @Given("^na pagina de cadastro de usuário selecionar \"([^\"]*)\" no combo \"([^\"]*)\"$")
    public void na_pagina_de_cadastro_de_usuario_selecionar_no_combo(String valor, String elemento) {
        robo.selecionarCombo(valor, cadUsuarioPage.getBy(elemento));
    }

    @Given("^o usuário deve ser cadastrado com sucesso$")
    public void o_usuario_deve_ser_cadastrado_com_sucesso() {
        robo.aguardarEstarPresente(By.linkText("Robot Automação"));
        assertEquals(minhaContaPage.getTitle(), robo.retornarTituloPagina());
        robo.clicarNoElemento(By.linkText("Sign out"));
    }

    @Given("^verifica se u usuário \"([^\"]*)\" está logado na plataforma$")
    public void verifica_se_u_usuario_esta_logado_na_plataforma(String userName) {
        robo.aguardarEstarPresente(By.linkText(userName));
        assertEquals(minhaContaPage.getTitle(), robo.retornarTituloPagina());
    }

    @When("^adicionou o item ao carrinho de compras$")
    public void adicionou_o_item_ao_carrinho_de_compras(DataTable table) {
       table.raw().remove(0);
       table.raw().forEach(produto -> {
            robo.digitarSaindoCampo(carrinhoPage.getCampoBuscaProdutos(), produto.get(0));
            robo.clicarNoElemento(carrinhoPage.getBtnBuscaProdutos());
            robo.clicarNoElemento(carrinhoPage.getCardProdutoByIdProduto(produto.get(1)));
            robo.aguardarElementoCarregar(carrinhoPage.getBy("cardConfimProduto"), 3);
            robo.aguardarEstarPresente(carrinhoPage.getBy("cardConfimProduto"));
            robo.clicarNoElementoPeloTitulo("Continue shopping");
            robo.limparCampo(carrinhoPage.getCampoBuscaProdutos());
       });
    }

    @When("^realizar o check out verificando o valor total do pedido \"([^\"]*)\"$")
    public void realizar_o_check_out_verificando_o_valor_total_do_pedido(String vlTotalPedido) {
        robo.clicarNoElementoPeloTitulo("View my shopping cart");
        robo.aguardarEstarPresente(carrinhoPage.getBy("cartTitle"));
        assertEquals("Order - My Store", robo.retornarTituloPagina());
        robo.scrollParaElemento(carrinhoPage.getBy("totalPedido"));
        assertEquals(robo.retonarTextoBy(carrinhoPage.getBy("totalPedido")),vlTotalPedido);
        robo.clicarNoElemento(By.linkText("Proceed to checkout"));
        robo.clicarNoElemento(carrinhoPage.getBy("btnProcessarEndereco"));
        robo.clicarNoElemento(carrinhoPage.getBy("checkAceitarTermos"));
        robo.clicarNoElemento(carrinhoPage.getBy("btnProcessCarrier"));
        assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", robo.retonarTextoBy(By.className("page-heading")));
        robo.clicarNoElementoPeloTitulo("Pay by check.");
        robo.clicarNoElemento(carrinhoPage.getBy("btnSubmit"));
    }

    @Then("^deverá ser apresentada a notificação de sucesso \"([^\"]*)\"$")
    public void devera_ser_apresentada_a_notificacao_de_sucesso(String mensagem) {
        assertEquals(mensagem, robo.retonarTextoBy(carrinhoPage.getMemsagemSucesso()));
        robo.clicarNoElemento(By.linkText("Sign out"));
    }
}