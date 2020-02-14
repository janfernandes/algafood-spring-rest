set foreign_key_checks = 0;

delete from tbl_cidade;
delete from tbl_cozinha;
delete from tbl_estado;
delete from tbl_forma_pagamento;
delete from tbl_grupo;
delete from tbl_grupo_permissao;
delete from tbl_permissao;
delete from tbl_produto;
delete from tbl_restaurante;
delete from tbl_restaurante_forma_pagamento;
delete from tbl_usuario;
delete from tbl_usuario_grupo;

set foreign_key_checks = 1;

alter table tbl_cidade auto_increment = 1;
alter table tbl_cozinha auto_increment = 1;
alter table tbl_estado auto_increment = 1;
alter table tbl_forma_pagamento auto_increment = 1;
alter table tbl_grupo auto_increment = 1;
alter table tbl_permissao auto_increment = 1;
alter table tbl_produto auto_increment = 1;
alter table tbl_restaurante auto_increment = 1;
alter table tbl_usuario auto_increment = 1;

insert into tbl_cozinha (id, nome) values (1, 'Tailandesa');
insert into tbl_cozinha (id, nome) values (2, 'Indiana');
insert into tbl_cozinha (id, nome) values (3, 'Argentina');
insert into tbl_cozinha (id, nome) values (4, 'Brasileira');

insert into tbl_estado (id, nome) values (1, 'Minas Gerais');
insert into tbl_estado (id, nome) values (2, 'São Paulo');
insert into tbl_estado (id, nome) values (3, 'Ceará');

insert into tbl_cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into tbl_cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into tbl_cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into tbl_cidade (id, nome, estado_id) values (4, 'Campinas', 2);
insert into tbl_cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, ativo, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (1, 'Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp, true, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, ativo) values (2, 'Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp, true);
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, ativo) values (3, 'Tuk Tuk Comida Indiana', 15, 2, utc_timestamp, utc_timestamp, true);
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, ativo) values (4, 'Java Steakhouse', 12, 3, utc_timestamp, utc_timestamp, true);
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, ativo) values (5, 'Lanchonete do Tio Sam', 11, 4, utc_timestamp, utc_timestamp, true);
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, ativo) values (6, 'Bar da Maria', 6, 4, utc_timestamp, utc_timestamp, true);

insert into tbl_forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into tbl_forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into tbl_forma_pagamento (id, descricao) values (3, 'Dinheiro');

insert into tbl_permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into tbl_permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into tbl_restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3), (4, 1), (4, 2), (5, 1), (5, 2), (6, 3);

insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 1);
insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1);

insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, 2);

insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 3);
insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 3);

insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 4);
insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, 4);

insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, 5);

insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, 6);
