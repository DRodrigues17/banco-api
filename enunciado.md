Implementar o seguinte modelo de dados na construção do serviço de pessoa.

![download](https://user-images.githubusercontent.com/91800053/225045299-4e066c22-2a5c-4fa7-b702-045eb2dd8980.png)

Implementar o seguinte esquema bancário:

![BANCO_FUNDATEC drawio](https://user-images.githubusercontent.com/91800053/225045357-35062211-722e-4124-be29-adcd9c4fc919.png)

## Banco

### Gerenciamento administrativo:

Executado pelo funcionário do banco, inclui o gerenciamento do cadastro de clientes e da carteira de contas.
O controle de acesso a estas funcionalidades deverá ser habilitado mediante uma senha.

O gerenciamento de banco deverá permitir:

∗ criar um novo banco
∗ selecionar um banco já cadastrado para gerenciamento

Um banco deverá ter pelo menos as seguintes informações:

∗ nome do banco
∗ senha de acesso gerencial
∗ cadastro de clientes
∗ carteira de contas correntes

O gerenciamento de clientes deverá permitir

∗ navegar pela lista de clientes exibindo os seus dados cadastrais
∗ cadastrar novos clientes
∗ remover clientes, desde que que o cliente não seja titular de alguma conta

Um cliente deverá ter pelo menos as seguintes informações:

∗ nome do cliente
∗ número do cpf
∗ endereço

– O gerenciamento de contas deverá permitir

∗ navegar pela lista de contas exibindo os seus dados cadastrais
∗ abrir uma nova conta
∗ ativar uma conta
∗ desativar uma conta

• Caixa automático: executado pelos clientes do banco, permitindo a movimentação de contas. As seguintes operações devem ser suportadas:

* consulta de saldo
* consulta de extrato (DATA / OPERAÇÃO / VALOR)
* realização de depósito
* realização de saque
* realização de transferências entre contas do mesmo banco
* todas as operações realizadas devem alterar o saldo e inserir um registro no extrato da conta


Estas operações poderão ser ralizadas pelo cliente mediante o uso de uma senha de acesso, associada com a conta. A movimentação de uma conta só poderá ser realizada se a conta estiver ativa.

A aplicação deverá suportar diferentes tipos de contas corrente:

* conta simples, cujo saldo não pode ficar negativo,
* conta especial, que permite saques mesmo que o saldo não seja suficiente, dentro de um determinado limite definido pelo gerente, e conta poupança, que oferece rendimentos diários sobre o saldo, usando uma taxa de juros definida pelo gerente.

Cada conta deverá ter:

* um número, que identifica unicamente a conta no banco, e deve ser gerado automaticamente quando a conta é aberta;
* um titular, identificado por um número de cpf
* uma senha de acesso
* um saldo
* uma lista da movimentação realizada na conta

Além disto, uma conta especial deve ter um limite, e uma conta poupança deverá ter uma taxa de juros.

=======================
### Requisitos:

Utilização de banco de dados relacional
Lombok
Gradle
SpringBoot
OpenAPI - Swagger

Testes Unitários

Avaliação será baseada na qualidade do código, padrões de implementação e obviamente na solução dos problemas solicitados.
Empacotar todos códigos-fonte e enviar em formato .zip 
