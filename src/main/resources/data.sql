INSERT INTO TB_BANCO (nome, senha)
	VALUES	('Banrisul', 'Banrisul'),
			('Banco do Brasil ', 'Banco do Brasil'),
			('Sicredi', 'Sicredi'),
			('Unicred', 'Unicred'),
			('Banco Inter', 'Banco Inter');

INSERT INTO conta (cpf_titular,saldo,senha,status,banco_id)
VALUES
(null, 5000, 'memes', 0, '1'),
('01616489772', 10000, 'patos',0, '2'),
('02155489704', 2000, 'carros', 0, '3'),
('01623789712', 10000, 'senhas', 1, '4'),
('01697389752', 40000, 'passwords', 1, '5');

INSERT INTO conta_simples_tb(conta_id)
VALUES
(1),
(2),
(3);

INSERT INTO conta_especial_tb(limite_gastos, conta_id)
VALUES
(5000, 4);

INSERT INTO conta_poupanca(taxa_juros, conta_id)
VALUE
(0.15, 5);

INSERT INTO tb_pessoa(cpf, data_cadastro, data_nascimento, nome, sexo)
VALUES
('01655489709','2020-05-12', '1996-07-20', 'João Cláudio Albuquerque', 'MASCULINO'),
('01616489772','2020-05-12', '2002-09-01', 'Pedro Mendes', 'MASCULINO'),
('02155489704','2020-05-12', '1990-12-23', 'Carlos Eduardo', 'MASCULINO'),
('01623789712','2020-05-12', '1968-03-10', 'Vladimir Pinto', 'MASCULINO'),
('01697389752','2020-05-12', '1995-05-12', 'Johanna Baptista', 'FEMININO');

INSERT INTO tb_cliente(profissão, pessoa_id,banco_id, conta_id)
VALUES
('Médico', 1,1,1),
('Advogado', 3,3,3),
('Barman', 4,4,4),
('Dentista', 5,5,5),
('Política', 2,2,2);

INSERT INTO tb_endereco (bairro, cidade, logradouro, uf, pessoa_id)
VALUES
('Passo da areia', 'Porto Alegre' ,'Rua Vinte e Nove, 194', 20, 1 ),
('Jardim são pedro', 'Porto Alegre',  'Rua Vinte e tres, 165', 20, 5),
('Belém Velho', 'Porto Alegre',  'Rua Vinte e quatro, 220', 20, 2 ),
('Cristal', 'Porto Alegre',  'Rua Vinte e cinco 3906', 20, 3 ),
('São Bento', 'Porto Alegre',  'Rua Vinte e seis 4040', 20, 4 );