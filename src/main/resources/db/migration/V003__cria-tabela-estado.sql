create table tbl_estado (
	id bigint not null auto_increment,
	nome varchar(80) not null,

	primary key (id)
) engine=InnoDB default charset=utf8;

insert into tbl_estado (nome) select distinct nome_estado from tbl_cidade;

alter table tbl_cidade add column estado_id bigint not null;

update tbl_cidade c set c.estado_id = (select e.id from tbl_estado e where e.nome = c.nome_estado);

alter table tbl_cidade add constraint fk_cidade_estado
foreign key (estado_id) references tbl_estado (id);

alter table tbl_cidade drop column nome_estado;

alter table tbl_cidade change nome_cidade nome varchar(80) not null;