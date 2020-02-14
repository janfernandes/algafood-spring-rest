alter table tbl_restaurante add ativo tinyint(1) not null;
update tbl_restaurante set ativo = true;