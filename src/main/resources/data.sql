insert into tb_banco (id, contas, nome , clientes, senha)
values(1, null, 'bancoso', null, '1234');

--insert into tb_movimentacoes (id, cliente, contaOrigem,contaDestino,valor, dataMovimentacao)
--values (1, 1, null, null, 20, '2001-03-20 12:00:00')

insert into tb_conta_simples(id,cfpTitular,saldo,status,senhaAcesso)
values (1, null, 2000, 'INATIVA', '1234');

insert into tb_endereco(id ,uf, cidade, bairro) values (1 ,'RS', 'PortoAlegre','AssisBrasil');

--insert into tb_pessoa(id,nome, cpf, endereco, sexo, dataNascimento, dataCadastro)
--values(1, 'maico', '01664551229', 1, 'M','2000-03-20','2005-05-20');

insert into tb_cliente(id,nome, cpf, endereco, sexo, dataNascimento, dataCadastro, profissao, conta, banco)
values (1, 'maico', '01664551229', 1, 'M','2000-03-20','2005-05-20', 'massagista', 1, 1);