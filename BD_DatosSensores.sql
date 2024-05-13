create database datossensores;
use datossensores;

create table datos(
id int auto_increment primary key,
idSensor Varchar(255) not null,
tipo_sensor VARCHAR(50) NOT NULL,
medida_humedad DECIMAL(5,2) NOT NULL,
medida_temperatura DECIMAL(5,2) NOT NULL,
fecha_hora DATETIME NOT NULL,
marca_sensor VARCHAR(100) NOT NULL
);
select * from datos;