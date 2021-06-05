Feature: Realizar compra

  @roteiro @api
  Scenario: Realizar compra para que possa vestir melhor

    Given que a consulta do usuário "2" tenha retonardo o status "200" e os atributos
      |id|email                 |first_name|last_name |avatar                                 |
      |2 |janet.weaver@reqres.in|Janet     |Weaver    |https://reqres.in/img/faces/2-image.jpg|
    When a requisição de POST retornou o status "201"
      |name     |job                       |
      |Cristiano|Test Automation Developer |
    Then realizar a requisição de PATCH alterando os dados do usuário "2"
      |name         |job         |
      |Nome alterado|job alterado|













