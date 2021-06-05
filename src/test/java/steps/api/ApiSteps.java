package steps.api;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import com.jayway.restassured.http.ContentType;
import robo.Robo;
import java.util.Map;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class ApiSteps {
    private Robo robo;

    public ApiSteps() {
        this.robo = new Robo(new ConfigApi());
    }

    @Given("^que a consulta do usuário \"([^\"]*)\" tenha retonardo o status \"([^\"]*)\" e os atributos$")
    public void que_a_consulta_do_usuario_tenha_retonardo_o_status_e_os_atributos(int idUser, int statusEsperado, DataTable table) {
        given().
            contentType(ContentType.JSON).
        when().
            get("/users/".concat(String.valueOf(idUser))).
        then().
            statusCode(statusEsperado).
            body("data", is(robo.dataTableToMap(table)));
    }

    @Given("^a requisição de POST retornou o status \"([^\"]*)\"$")
    public void a_requisicao_de_POST_retornou_o_status(int statusEsperado, DataTable dataTable) {
        given().
            body(robo.dataTableToJson(dataTable)).
            contentType(ContentType.JSON).
        when().
            post("/users").
        then().
            statusCode(statusEsperado);
    }

    @When("^realizar a requisição de PATCH alterando os dados do usuário \"([^\"]*)\"$")
    public void realizar_a_requisicao_de_PATCH_alterando_os_dados_do_usuario(String idUsuario, DataTable dataTable) {
        Map<String, Object> bodyMap = robo.dataTableToMap(dataTable);
        given().
            body(robo.dataTableToJson(dataTable)).
            contentType(ContentType.JSON).
        when().
            patch("/users/".concat(idUsuario)).
        then().
            statusCode(200)
        .body("name", is(bodyMap.get("name")))
        .body("job", is(bodyMap.get("job")))
        .body("updatedAt", is(notNullValue()));
    }
}
