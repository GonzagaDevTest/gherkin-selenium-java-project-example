# language: pt
Funcionalidade: Realizar compra

  @roteiro @wip
  Cenario: Realizar compra para que possa vestir melhor

    Dado que o usuário acessou a tela de cadastro de usuário
    E na pagina de cadastro de usuário digitar "automacao1998@email.com.br" no campo "email"
    E na pagina de cadastro de usuário clicar no elemento "btnCreate"
    E na pagina de cadastro de usuário o elemento "formCreate" está presente
    E na pagina de cadastro de usuário clicar no elemento "generoMasculino"
    E na pagina de cadastro de usuário digitar "Robot" no campo "nome"
    E na pagina de cadastro de usuário digitar "Automação" no campo "sobrenome"
    E na pagina de cadastro de usuário digitar "123456" no campo "senha"
    E na pagina de cadastro de usuário digitar "Rua dos robos, Bairro da automação Nº01010101" no campo "endereco"
    E na pagina de cadastro de usuário digitar "Digital" no campo "cidade"
    E na pagina de cadastro de usuário selecionar "Colorado" no combo "estado"
    E na pagina de cadastro de usuário digitar "32533" no campo "codigoPostal"
    E na pagina de cadastro de usuário digitar "999040000" no campo "celular"
    E na pagina de cadastro de usuário clicar no elemento "btnSumit"
    E o usuário deve ser cadastrado com sucesso