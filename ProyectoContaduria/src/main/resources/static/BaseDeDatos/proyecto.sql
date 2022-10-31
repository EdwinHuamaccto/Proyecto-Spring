drop database db_contaduria;
create database db_contaduria;
use db_contaduria;

-- tabla de compremento
create table tb_mes(
cod_mes int primary key auto_increment,
nombre_mes varchar(100)
);
-- Usuario para el login 
create table tb_user(
cod_user int primary key auto_increment,
username varchar(255) not null,
pass varchar(255) not null
);

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
detalle varchar(250) not null,
monto decimal
);

CREATE TABLE tb_libro_diario (
    cod_LDiario INT PRIMARY KEY AUTO_INCREMENT,
    cod_tipo INT NOT NULL,
	cod_detalle int,
    importe_parcial varchar(200) NOT NULL,
    fecha date,
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
insert into tb_tipo values (0,"debe");
insert into tb_tipo values(0,"haber");