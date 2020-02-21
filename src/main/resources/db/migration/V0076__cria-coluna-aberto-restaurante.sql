alter table tbl_restaurante add aberto tinyint(1) not null;
update tbl_restaurante set aberto = true;