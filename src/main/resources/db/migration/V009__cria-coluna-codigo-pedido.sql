alter table tbl_pedido add codigo varchar(36) not null after id;
update tbl_pedido set codigo = uuid();
alter table tbl_pedido add constraint uk_pedido_codigo unique (codigo);