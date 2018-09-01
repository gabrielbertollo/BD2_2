create database bd;
use bd;

create table Veiculo (
	id integer unsigned not null auto_increment,
    idMarca integer unsigned not null,
    modelo varchar(45),
    ano integer(4),
    cilindrada integer,
    motor varchar(10),
    tipo varchar(5),
    primary key(id),
    foreign key(idMarca) references Marca(id)
);

create table Marca (
	id integer unsigned not null auto_increment,
    nome varchar(45),
    primary key(id)
);

select * from veiculo;
select * from marca;


