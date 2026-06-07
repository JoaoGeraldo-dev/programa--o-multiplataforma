create database empresa_db;
use empresa_db;

create table empresa(
id int auto_increment primary key,
nome varchar(100),
qtd_func int,
local varchar(100)
);

create table funcionario(
id int auto_increment primary key, 
nome varchar(100),
data_nascimento DATE,
cod_emp int,
foreign key (cod_emp) references empresa(id)
);