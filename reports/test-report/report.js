$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('features/api.feature');
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language: pt"
    }
  ],
  "line": 2,
  "name": "Realizar compra",
  "description": "",
  "id": "realizar-compra",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "line": 5,
  "name": "Realizar compra para que possa vestir melhor",
  "description": "",
  "id": "realizar-compra;realizar-compra-para-que-possa-vestir-melhor",
  "type": "scenario",
  "keyword": "Cenario",
  "tags": [
    {
      "line": 4,
      "name": "@roteiro"
    },
    {
      "line": 4,
      "name": "@api"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "que a consulta do usuário \"2\" tenha retonardo o status \"200\" e os atributos",
  "rows": [
    {
      "cells": [
        "id",
        "email",
        "first_name",
        "last_name",
        "avatar"
      ],
      "line": 8
    },
    {
      "cells": [
        "2",
        "janet.weaver@reqres.in",
        "Janet",
        "Weaver",
        "https://reqres.in/img/faces/2-image.jpg"
      ],
      "line": 9
    }
  ],
  "keyword": "Dado "
});
formatter.step({
  "line": 10,
  "name": "a requisição de POST retornou o status \"201\"",
  "rows": [
    {
      "cells": [
        "name",
        "job"
      ],
      "line": 11
    },
    {
      "cells": [
        "Cristiano",
        "Test Automation Developer"
      ],
      "line": 12
    }
  ],
  "keyword": "Quando "
});
formatter.step({
  "line": 13,
  "name": "realizar a requisição de PATCH alterando os dados do usuário \"2\"",
  "rows": [
    {
      "cells": [
        "name",
        "job"
      ],
      "line": 14
    },
    {
      "cells": [
        "Nome alterado",
        "job alterado"
      ],
      "line": 15
    }
  ],
  "keyword": "Então "
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 27
    },
    {
      "val": "200",
      "offset": 56
    }
  ],
  "location": "ApiSteps.que_a_consulta_do_usuario_tenha_retonardo_o_status_e_os_atributos(int,int,DataTable)"
});
formatter.result({
  "duration": 1045881415,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 40
    }
  ],
  "location": "ApiSteps.a_requisicao_de_POST_retornou_o_status(int,DataTable)"
});
formatter.result({
  "duration": 781746837,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 62
    }
  ],
  "location": "ApiSteps.realizar_a_requisicao_de_PATCH_alterando_os_dados_do_usuario(String,DataTable)"
});
formatter.result({
  "duration": 753233154,
  "status": "passed"
});
});