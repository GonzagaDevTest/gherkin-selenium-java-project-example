Feature: Realizar compra

  @roteiro @compras
  Scenario: Realizar compra para que possa vestir melhor

    Given que o usuário acessou a plataforma com o e-mail "datumqatest@soprock.com" e a senha "datum2021"
    And verifica se u usuário "Datum QA Test" está logado na plataforma
    When adicionou o item ao carrinho de compras
      |nomeProduto          |id|
      |Printed Chiffon Dress|7 |
      |Blouse               |2 |
    When realizar o check out verificando o valor total do pedido "$45.40"
    Then deverá ser apresentada a notificação de sucesso "Your order on My Store is complete."













