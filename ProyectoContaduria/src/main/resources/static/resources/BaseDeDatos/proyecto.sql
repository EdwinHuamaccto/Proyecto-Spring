-- drop database db_contaduria;
create database db_contaduria;
use db_contaduria;

-- tabla de compremento
create table tb_mes(
cod_mes int primary key auto_increment,
nombre_mes varchar(100)
);
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
-- tabla de empresa
create table tb_empresa(
	cod_emp int primary key auto_increment,
	nombre varchar(250) not null
);

-- libro diario
create table tb_tipo(
cod_tipo int primary key auto_increment,
descripcion varchar(100) not null
);
create table tb_detalle(
cod_detalle int primary key auto_increment,
detalle varchar(250) not null
);

CREATE TABLE tb_libro_diario (
    cod_LDiario INT PRIMARY KEY AUTO_INCREMENT,
    cod_tipo INT NOT NULL,
	cod_detalle int,
    importe_parcial varchar(200) NOT NULL,
    fecha date,
    monto decimal,
    cod_emp INT NOT NULL,
    FOREIGN KEY (cod_tipo)REFERENCES tb_tipo (cod_tipo),
    FOREIGN KEY (cod_emp)REFERENCES tb_empresa (cod_emp),
    foreign key (cod_detalle) references tb_detalle(cod_detalle)
);
-- Movimiento tributario
create table tb_tipo_afecto(
cod_tipo_afecto int primary key auto_increment,
tipo_afecto varchar(100) not null
);
create table tb_compra(
cod_com int primary key auto_increment,
cod_tipo_afecto int not null,
AFECTO double,
INAF double,
TOTAL_VC double,
IGV_COMPRA double,
precio_compra double,
foreign key (cod_tipo_afecto) references tb_tipo_afecto(cod_tipo_afecto)
);
create table tb_venta(
cod_ven int primary key auto_increment,
valor_venta double not null,
descuento_cred double,
valor_neto double not null,
igv_venta double not null,
precio_V double not null
);
create table tb_movimiento_tributario(
cod_MTributario int primary key auto_increment,
cod_ven int not null,
cod_com int not null,
pago_Impuesto_Rta double,
compensacion_Rta double,
cod_mes int not null,
cod_emp int not null,
FOREIGN KEY (cod_ven)REFERENCES tb_venta(cod_ven),
FOREIGN KEY (cod_com)REFERENCES tb_compra(cod_com),
FOREIGN KEY (cod_mes)REFERENCES tb_mes(cod_mes),
FOREIGN KEY (cod_emp)REFERENCES tb_empresa(cod_emp)
);

create table tb_saldo(
cod_saldo int primary key auto_increment,
saldo double not null
-- Falta completar pipipipi --
);


-- Insercion de datos
insert into tb_enlace values (0,"Libro diario","/LibroDiario/lista");
insert into tb_enlace values (0,"Compra","#");
insert into tb_enlace values (0,"Añadir empresa","#");
insert into tb_enlace values (0,"Cerrar sesión","#");

insert into tb_rol values (0,'Visitante');
insert into tb_rol values (0,'Administrador');

insert into tb_rol_enlace values (1,1);
insert into tb_rol_enlace values (2,1);
insert into tb_rol_enlace values (2,2);
insert into tb_rol_enlace values (2,3);
insert into tb_rol_enlace values (2,4);

-- hay que meter a más usuarios
insert into tb_usuario values (0,'efe','$2a$10$B5Ki8qm9yez5k7mlHBLU5udVO9BMLAgxw3qbwfyjm/CyMTmKzvNUu',2,'Franklin','Robles Utcañe');

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

-- SP: EMPRESAS
delimiter @@
create procedure usp_empresas()
BEGIN
  select* from tb_empresa;
END @@
delimiter ;
-- SP: DETALLES
delimiter @@
create procedure usp_detalles()
BEGIN
  select* from tb_detalle;
END @@
delimiter ;
-- SP: TIPOS
delimiter @@
create procedure usp_tipos()
BEGIN
  select* from tb_tipo;
END @@
delimiter ;
-- SP: LISTAR LIBRO DIARIO
delimiter @@
create procedure usp_listaDiario()
BEGIN
  select l.cod_LDiario,e.nombre,d.detalle,importe_parcial,fecha,monto
  from tb_libro_diario l join tb_empresa e
  on l.cod_emp=e.cod_emp join tb_detalle d
  on l.cod_detalle=d.cod_detalle join tb_tipo t
  on l.cod_tipo=t.cod_tipo;
END @@
delimiter ;
-- SP: LISTAR LIBRO DIARIO X FECHA
delimiter @@
create procedure usp_listaDiarioXFecha(fec date)
BEGIN
  select l.cod_LDiario,e.nombre,d.detalle,importe_parcial,fecha,monto
  from tb_libro_diario l join tb_empresa e
  on l.cod_emp=e.cod_emp join tb_detalle d
  on l.cod_detalle=d.cod_detalle join tb_tipo t
  on l.cod_tipo=t.cod_tipo
  where l.fecha=fec;
END @@
delimiter ;
-- SP: REGISTRAR LIBRO DIARIO
delimiter @@
create procedure usp_registroDiario(codemp int,fec date,coddet int,
							        importe varchar(200),monto decimal,codtip int)
BEGIN
  insert into tb_libro_diario values (codtip,coddet,importe,fec,monto,codemp);
END @@
delimiter ;