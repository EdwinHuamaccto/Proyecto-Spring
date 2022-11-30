-- drop database db_contaduria;
create database db_contaduria;
use db_contaduria;

-- Tablas para el login 
create table tb_rol(
idrol int primary key auto_increment,
descripcion varchar(45)
);
create table tb_enlace(
idenlace int primary key auto_increment,
descripcion varchar(45),
ruta varchar(45)
);
create table tb_rol_enlace(
idrol int,
idenlace int,
foreign key(idrol) references tb_rol(idrol),
foreign key(idenlace) references tb_enlace(idenlace),
primary key(idrol,idenlace)
);
create table tb_usuario(
cod_usu int primary key auto_increment,
login varchar(45),
pasword varchar(500),
idrol int,
nom_usu varchar(45),
ape_usu varchar(45),
foreign key(idrol) references tb_rol(idrol)
);

-- Tablas de mantenimiento
create table tb_empresa(
	cod_emp int primary key auto_increment,
	nombre varchar(250) not null
);
create table tb_tipo(
cod_tipo int primary key auto_increment,
descripcion varchar(100) not null
);
create table tb_detalle(
cod_detalle int primary key auto_increment,
detalle varchar(250) not null
);
create table tb_libro_diario (
    cod_LDiario int primary key auto_increment,
    cod_tipo int not null,
	cod_detalle int not null,
    importe_parcial varchar(200) not null,
    fecha date,
    monto decimal,
    cod_emp INT not null,
    foreign key (cod_tipo) references tb_tipo (cod_tipo),
    foreign key (cod_emp) references tb_empresa (cod_emp),
    foreign key (cod_detalle) references tb_detalle(cod_detalle)
);

-- INSERCIÓN DE DATOS
insert into tb_enlace values (0,"Libro diario","/LibroDiario/lista");
insert into tb_enlace values (0,"Empresa","/mantenimiento/empresaLis");
insert into tb_enlace values (0,"Detalle","/mantenimiento/detalleLis");
insert into tb_enlace values (0,"Reporte","/reporte/libro");

insert into tb_rol values (0,'USUARIO');
insert into tb_rol values (0,'ADMINISTRADOR');

insert into tb_rol_enlace values (1,1);
insert into tb_rol_enlace values (2,1);
insert into tb_rol_enlace values (2,2);
insert into tb_rol_enlace values (2,3);
insert into tb_rol_enlace values (2,4);

insert into tb_usuario values (0,'efe','$2a$10$B5Ki8qm9yez5k7mlHBLU5udVO9BMLAgxw3qbwfyjm/CyMTmKzvNUu',2,'Franklin','Robles Utcañe');
insert into tb_usuario values (0,'edh','$2a$10$B5Ki8qm9yez5k7mlHBLU5udVO9BMLAgxw3qbwfyjm/CyMTmKzvNUu',1,'Edwin','Huamaccto Chate');

insert into tb_tipo values (0,"debe");
insert into tb_tipo values(0,"haber");

insert into tb_empresa values (0,"Editorial Cuzcano");
insert into tb_empresa values (0,"Chanax S.A.C.");
insert into tb_empresa values (0,"Pizza Bear");

insert into tb_detalle values (0,'Efectivo');
insert into tb_detalle values (0,'Inmuebles');
insert into tb_detalle values (0,'Obligaciones financieras');
insert into tb_detalle values (0,'Cuentas por pagar');
insert into tb_detalle values (0,'Servicios prestados por terceros');
insert into tb_detalle values (0,'Ventas');

insert into tb_libro_diario values (0,1,3,'IGV - Régimen de percepciones','2022-01-01',181,3);
insert into tb_libro_diario values (0,2,5,'Otras cuentas','2022-05-04',543,1);
insert into tb_libro_diario values (0,1,6,'Facturas','2022-04-04',157,2);
insert into tb_libro_diario values (0,2,2,'Impresoras','2022-04-04',457,1);

select* from tb_rol;
select* from tb_usuario;