CREATE DATABASE SDSA;
USE SDSA;

CREATE TABLE Cursos(
	id             int primary key not null AUTO_INCREMENT,
    nome           varchar(50),
    qtd_semestre   int,
	ativado		   int
);

CREATE TABLE Turmas(
    id             int primary key not null AUTO_INCREMENT,
    nome           varchar(10),
    periodo        int,
    semestre       int,
    id_curso       int,
	ativado		   int,
    foreign key (id_curso) references Cursos (id)
);

CREATE TABLE Disciplinas(
	id             int primary key not null AUTO_INCREMENT,
    nome           varchar(50),
    carga_hora     int,
	semestre       int,
	id_curso       int,
	ativado		   int,
	foreign key (id_curso) references Cursos (id)
);

CREATE TABLE Colaboradores(
	id             int primary key not null AUTO_INCREMENT,
    nome           varchar(100),
    carga_hora     int,
    restante       int,
    tipo           int,
	detalhes	   varchar(1000),
	ativado		   int
);

CREATE TABLE CD(
	id             int primary key not null AUTO_INCREMENT,
	id_colaborador int,
	id_disciplina  int,
	ativado		   int,
	foreign key (id_colaborador) references Colaboradores(id),
	foreign key (id_disciplina)	 references Disciplinas(id)
);

CREATE TABLE Coordenadores(
	id             int primary key not null AUTO_INCREMENT,
    nome           varchar(100),
    login          varchar(30),
    senha          varchar(20),
	ativado		   int
); 


CREATE TABLE Salas(
	numero         int primary key not null
); 

CREATE TABLE Aulas(
	id             	int primary key not null AUTO_INCREMENT,
    id_cursos      	int,
    id_turmas      	int,
    id_disciplina 	int,
    id_colaborador 	int,
    id_coordenador  int,
    id_sala 		int,
    dia_semana  	int,
    carga      		int,
	periodo			int,
	horario			char,
	foreign key (id_cursos)     	references Cursos (id),
    foreign key (id_turmas)     	references Turmas (id),
    foreign key (id_disciplina) 	references Disciplinas (id),
    foreign key (id_colaborador)	references Colaboradores (id),
    foreign key (id_coordenador)	references Coordenadores (id),
    foreign key (id_sala) 			references Salas (numero)
);