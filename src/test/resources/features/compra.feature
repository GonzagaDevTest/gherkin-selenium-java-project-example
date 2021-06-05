# language: pt
Funcionalidade: : Realizar compra

  @roteiro @wip
  Cenario: : Realizar compra para que possa vestir melhor

    Dado que o usuário acessou a plataforma com o e-mail "datumqatest@soprock.com" e a senha "datum2021"
    E verifica se u usuário "Datum QA Test" está logado na plataforma
    E adicionou o item ao carrinho de compras
      |nomeProduto          |id|
      |Printed Chiffon Dress|7 |
      |Blouse               |2 |
    Quando realizar o check out verificando o valor total do pedido "$45.40"
    Então deverá ser apresentada a notificação de sucesso "Your order on My Store is complete."













