Feature: Realizar compra

  @roteiro @desafio @cadUsuario
  Scenario: Realizar compra para que possa vestir melhor

    Given que o usuário acessou a tela de cadastro de usuário
    And na pagina de cadastro de usuário digitar "automacao1997@email.com.br" no campo "email"
    And na pagina de cadastro de usuário clicar no elemento "btnCreate"
    And na pagina de cadastro de usuário o elemento "formCreate" está presente
    And na pagina de cadastro de usuário clicar no elemento "generoMasculino"
    And na pagina de cadastro de usuário digitar "Robot" no campo "nome"
    And na pagina de cadastro de usuário digitar "Automação" no campo "sobrenome"
    And na pagina de cadastro de usuário digitar "123456" no campo "senha"
    And na pagina de cadastro de usuário digitar "Rua dos robos, Bairro da automação Nº01010101" no campo "endereco"
    And na pagina de cadastro de usuário digitar "Digital" no campo "cidade"
    And na pagina de cadastro de usuário selecionar "Colorado" no combo "estado"
    And na pagina de cadastro de usuário digitar "32533" no campo "codigoPostal"
    And na pagina de cadastro de usuário digitar "999040000" no campo "celular"
    When na pagina de cadastro de usuário clicar no elemento "btnSumit"
    Then o usuário deve ser cadastrado com sucesso