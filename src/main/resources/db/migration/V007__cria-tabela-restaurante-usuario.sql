create table tbl_restaurante_usuario_responsavel (
    restaurante_id bigint not null,
    usuario_id bigint not null,

    primary key (restaurante_id, usuario_id)
) engine = InnoDB default charset = utf8;

alter table tbl_restaurante_usuario_responsavel add constraint fk_rest_user
    foreign key (usuario_id) references tbl_usuario (id);

alter table tbl_restaurante_usuario_responsavel add constraint fk_rest_user_restaurante
    foreign key (restaurante_id) references tbl_restaurante (id);