create table tbl_cidade (id bigint not null auto_increment, nome varchar(30) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table tbl_cozinha (id bigint not null auto_increment, nome varchar(30) not null, primary key (id)) engine=InnoDB
create table tbl_estado (id bigint not null auto_increment, nome varchar(30) not null, primary key (id)) engine=InnoDB
create table tbl_forma_pagamento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tbl_grupo (id bigint not null auto_increment, nome varchar(30) not null, primary key (id)) engine=InnoDB
create table tbl_grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
create table tbl_permissao (id bigint not null auto_increment, descricao varchar(255) not null, nome varchar(30) not null, primary key (id)) engine=InnoDB
create table tbl_produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(30) not null, preco decimal(19,2) not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table tbl_restaurante (id bigint not null auto_increment, data_atualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(30) not null, taxa_frete decimal(19,2) not null, cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
create table tbl_restaurante_forma_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
create table tbl_usuario (id bigint not null auto_increment, data_cadastro datetime not null, email varchar(30) not null, nome varchar(30) not null, senha varchar(30) not null, primary key (id)) engine=InnoDB
create table tbl_usuario_grupo (usuario_id bigint not null, grupo_id bigint not null) engine=InnoDB
alter table tbl_cidade add constraint FK1coxwu1qkyvlhat4sm5tdvllg foreign key (estado_id) references tbl_estado (id)
alter table tbl_grupo_permissao add constraint FK1xkx4f5vbt7nnl952pug6jycl foreign key (permissao_id) references tbl_permissao (id)
alter table tbl_grupo_permissao add constraint FKavg4sq2te2w9ofdurpa6fmtvu foreign key (grupo_id) references tbl_grupo (id)
alter table tbl_produto add constraint FKaoe23l1sf2vp6r5fwut7sbb2u foreign key (restaurante_id) references tbl_restaurante (id)
alter table tbl_restaurante add constraint FK2xmo55uprdn2lj0l4yy48pofa foreign key (cozinha_id) references tbl_cozinha (id)
alter table tbl_restaurante add constraint FKnn6m97ftpyfb204ex1ld738v4 foreign key (endereco_cidade_id) references tbl_cidade (id)
alter table tbl_restaurante_forma_pagamento add constraint FK9vww6dh9o6kg6g5vb91jcrydd foreign key (forma_pagamento_id) references tbl_forma_pagamento (id)
alter table tbl_restaurante_forma_pagamento add constraint FKdb1c3h6va7d3sawa4jvp66yu5 foreign key (restaurante_id) references tbl_restaurante (id)
alter table tbl_usuario_grupo add constraint FK9fhcafw069nvanmybs2jyrgl6 foreign key (grupo_id) references tbl_grupo (id)
alter table tbl_usuario_grupo add constraint FKe69mn2c8071iruvkv06vyx88e foreign key (usuario_id) references tbl_usuario (id)
insert into tbl_cozinha (id, nome) values (1, 'Francesa')
insert into tbl_cozinha (id, nome) values (2, 'Italiana')
insert into tbl_estado (nome) values ('MG')
insert into tbl_estado (nome) values ('SP')
insert into tbl_estado (nome) values ('RJ')
insert into tbl_estado (nome) values ('ES')
insert into tbl_cidade (nome, estado_id) values ('Uberlandia', 1)
insert into tbl_cidade (nome, estado_id) values ('Sao Paulo', 2)
insert into tbl_cidade (nome, estado_id) values ('Rio de Janeiro', 3)
insert into tbl_cidade (nome, estado_id) values ('Vitoria', 4)
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (1, 'The Cypress Room', 10, 1, utc_timestamp, utc_timestamp)
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (2, 'Bodega 1900', 20, 1, utc_timestamp, utc_timestamp)
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (3, 'Ristorante Italia', 15, 2, utc_timestamp, utc_timestamp)
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (4, 'Lasai', 13, 2, utc_timestamp, utc_timestamp)
insert into tbl_restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (5, 'Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro')
insert into tbl_forma_pagamento (descricao) values ('Dinheiro')
insert into tbl_forma_pagamento (descricao) values ('Cartao de Credito')
insert into tbl_forma_pagamento (descricao) values ('Cartao de Debito')
insert into tbl_forma_pagamento (descricao) values ('Vale Refeicao')
insert into tbl_permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas')
insert into tbl_permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas')
insert into tbl_permissao (id, nome, descricao) values (3, 'CONSULTAR_RESTAURANTES', 'Permite consultar restaurantes')
insert into tbl_permissao (id, nome, descricao) values (4, 'EDITAR_RESTAURANTES', 'Permite editar restaurantes')
insert into tbl_restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3), (4, 1), (4, 2), (4, 3)
insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Vinho Italiano', 'Vinho gourmet', 22.3, 1, 1)
insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Palha Italiana', 'Sobremesa a moda da casa', 10.5, 1, 2)
insert into tbl_produto (nome, descricao, preco, ativo, restaurante_id) values ('Sopa vegetariana', 'Prato Principal', 52.3, 1, 3)
insert into tbl_grupo(id, nome) values (1, 'VIPS')
insert into tbl_grupo_permissao(grupo_id, permissao_id) values (1, 1), (1, 2), (1, 3), (1, 4)
insert into tbl_usuario(id, nome, email, senha, data_cadastro) values (1, 'Janayna Fernandes', 'jmfernandes@ufu.com.br', '***********', utc_timestamp)
insert into tbl_usuario_grupo(usuario_id, grupo_id) values (1, 1)
