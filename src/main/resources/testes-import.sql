insert into tbl_cozinha (id, nome) values (1, 'Francesa');
insert into tbl_cozinha (id, nome) values (2, 'Italiana');

insert into tbl_estado (nome) values ('MG');
insert into tbl_estado (nome) values ('SP');
insert into tbl_estado (nome) values ('RJ');
insert into tbl_estado (nome) values ('ES');

insert into tbl_cidade (nome, estado_id) values ('Uberlandia', 1);
insert into tbl_cidade (nome, estado_id) values ('Sao Paulo', 2);
insert into tbl_cidade (nome, estado_id) values ('Rio de Janeiro', 3);
insert into tbl_cidade (nome, estado_id) values ('Vitoria', 4);

insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (1, 'The Cypress Room', 10, 1, utc_timestamp, utc_timestamp);
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (2, 'Bodega 1900', 20, 1, utc_timestamp, utc_timestamp);
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (3, 'Ristorante Italia', 15, 2, utc_timestamp, utc_timestamp);
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (4, 'Lasai', 13, 2, utc_timestamp, utc_timestamp);
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (5, 'Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');

insert into tbl_forma_pagamento (descricao) values ('Dinheiro');
insert into tbl_forma_pagamento (descricao) values ('Cartao de Credito');
insert into tbl_forma_pagamento (descricao) values ('Cartao de Debito');
insert into tbl_forma_pagamento (descricao) values ('Vale Refeicao');

insert into tbl_permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into tbl_permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');
insert into tbl_permissao (id, nome, descricao) values (3, 'CONSULTAR_RESTAURANTES', 'Permite consultar restaurantes');
insert into tbl_permissao (id, nome, descricao) values (4, 'EDITAR_RESTAURANTES', 'Permite editar restaurantes');

insert into tbl_restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3), (4, 1), (4, 2), (4, 3);

insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Vinho Italiano', 'Vinho gourmet', 22.3, 1, 1)
insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Palha Italiana', 'Sobremesa a moda da casa', 10.5, 1, 2)
insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Sopa vegetariana', 'Prato Principal', 52.3, 1, 3)

insert into tbl_grupo(id, nome) values (1, 'VIPS')

insert into tbl_grupo_permissao(grupo_id, permissao_id) values (1, 1), (1, 2), (1, 3), (1, 4)

insert into tbl_usuario(id, nome, email, senha, data_cadastro) values (1, 'Janayna Fernandes', 'jmfernandes@ufu.com.br', '***********', utc_timestamp)

insert into tbl_usuario_grupo(usuario_id, grupo_id) values (1, 1)