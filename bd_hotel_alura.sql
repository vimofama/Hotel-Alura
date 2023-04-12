create database hotel_alura;

use hotel_alura;

create table huespedes(
id int auto_increment,
nombre varchar(50) not null,
apellido varchar(50) not null,
fecha_Nacimiento date not null,
nacionalidad varchar(50) not null,
telefono int not null,
id_Reserva int not null,
primary key (id))Engine=InnoDB;

create table reservas(
id int auto_increment,
fecha_Entrada date not null,
fecha_Salida date not null,
valor float,
forma_Pago varchar(50),
primary key (id))Engine=InnoDB;

alter table huespedes add foreign key (id_Reserva) references reservas(id);
