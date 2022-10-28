Teste back-end Java

Este projeto tem como objetivo testar os conhecimentos, código e a organização do candidato.

O sistema deve ser escrito em Java (Spring Boot)

 - Usar Oracle ou PostgreSQL (enviar somente os scripts de criação do modelo) 
 - Usar Git

Criar uma API de controle de estacionamento (conforme contratos abaixo):

1 - Deve registrar entrada, saída e pagamento
2 - Não deve liberar saída sem pagamento
3 - Deve fornecer um histórico por placa

Essa API deve respeitar os status http corretamente, deve aceitar requisições e responder json.

Endpoints que devem ser disponibilizados:

Registrar entrada: OK
POST /v1/parking
{ plate: 'FAA-1234' }
*Deve retornar um código de "reserva" de 6 posições e validar a máscara AAA-9999

Registrar saída:
PUT /v1/parking/{plate}/out

Registrar pagamento:
PUT /v1/parking/{plate}/pay

Consultar histórico: OK
GET /v1/parking/{plate}
[
  { id: 1, time: '30 minutes', paid: true, exit: false }
]

Sobre testes unitários:
Quanto mais melhor! :)


Passo a passo para execução : 



[==> URL swagger 
    http://localhost:8080/api/swagger-ui.html
    http://localhost:8080/api/v2/api-docs