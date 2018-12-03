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
    foto           varchar(100),
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
	numero         int primary key not null,
	descricao      varchar(100)
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
	foreign key (id_cursos)     	references Cursos (id),
    foreign key (id_turmas)     	references Turmas (id),
    foreign key (id_disciplina) 	references Disciplinas (id),
    foreign key (id_colaborador)	references Colaboradores (id),
    foreign key (id_coordenador)	references Coordenadores (id),
    foreign key (id_sala) 			references Salas (numero)
); 

CREATE TABLE Carga_horaria_restante(
	id             int primary key not null AUTO_INCREMENT,
    tempo          int,
    id_disciplina  int,
    id_turma       int,
    foreign key (id_disciplina) references Disciplinas (id),
    foreign key (id_turma) references Turmas (id)
);

INSERT INTO Cursos(nome, qtd_semestre, ativado)
		VALUES	("Técnico em informática", 4, 1);

INSERT INTO Turmas(nome, periodo, semestre, id_curso, ativado)
		VALUES	("1TI", 1, 1, 1, 1),
				("2TI", 1, 2, 1, 1),
				("3TI", 1, 3, 1, 1),
				("4TI", 1, 4, 1, 1);
				
INSERT INTO Disciplinas(nome, carga_hora, semestre, id_curso, ativado)
		VALUES	("Fundamentos de Informática", 75, 1, 1, 1),
				("Fundamentos de Hardware", 75, 1, 1, 1),
				("Comunicação Oral e Escrita", 75, 1, 1, 1),
				("Fundamentos de Programação", 75, 1, 1, 1),
				("Fundamentos de Redes", 75, 1, 1, 1),
				("Algoritimos", 75, 2, 1, 1),
				("Programação Orientada a Objetos", 150, 2, 1, 1),
				("Interfaces para Web", 75, 2, 1, 1),
				("Inglês Técnica", 75, 2, 1, 1),
				("Banco de Dados", 75, 3, 1, 1),
				("Programação para Web", 150, 3, 1, 1),
				("Programação para Dispositivos Móveis", 75, 3, 1, 1),
				("Gestão de Pessoas", 75, 4, 1, 1),
				("Projetos", 300, 4, 1, 1);
				
INSERT INTO Colaboradores(nome, carga_hora, tipo, ativado)
		VALUES	("Pansani", 20, 2, 1),
				("Anderson", 20, 2, 1),
				("Tânia Wopereis", 20, 1, 1),
				("Luiz Rodolfo", 20, 2, 1),
				("Rafael Leme", 20, 2, 1),
				("Stephanie Frasson", 40, 2, 1);
				
INSERT INTO CD(id_colaborador, id_disciplina, ativado)
		VALUES	(1,1,1),
				(2,2,1),
				(3,3,1),
				(1,4,1),
				(2,5,1),
				(5,6,1),
				(4,7,1),
				(5,8,1),
				(3,9,1),
				(4,10,1),
				(5,11,1),
				(5,12,1),
				(6,13,1),
				(5,14,1),
				(4,14,1);

INSERT INTO Coordenadores (nome,login,senha,ativado)
		VALUES	("Tarciso", 28011999, "123", 1),
				("Paraguassu", "paragua", "123", 1);
		
INSERT INTO SALAS VALUES (1, "SALA 01");
INSERT INTO SALAS VALUES (2, "SALA 02");
INSERT INTO SALAS VALUES (3, "SALA 03");
INSERT INTO SALAS VALUES (4, "SALA 04");
INSERT INTO SALAS VALUES (5, "SALA 05");
INSERT INTO SALAS VALUES (6, "SALA 06");
INSERT INTO SALAS VALUES (7, "SALA 07");
INSERT INTO SALAS VALUES (8, "SALA 08");
INSERT INTO SALAS VALUES (9, "SALA 09");
INSERT INTO SALAS VALUES (10, "SALA 10");
INSERT INTO SALAS VALUES (11, "SALA 11");
INSERT INTO SALAS VALUES (12, "SALA 12");
INSERT INTO SALAS VALUES (13, "SALA 13");
INSERT INTO SALAS VALUES (14, "SALA 14");
INSERT INTO SALAS VALUES (15, "SALA 15");
INSERT INTO SALAS VALUES (16, "SALA 16");
INSERT INTO SALAS VALUES (18, "SALA 18");
INSERT INTO SALAS VALUES (35, "SALA 35");

INSERT INTO Aulas(id_cursos, id_turmas, id_disciplina, id_colaborador, id_coordenador, id_sala, dia_semana, carga, periodo)
		VALUES	(1, 1, 3, 3, 2, 2, 1, 75, 1),
				(1, 1, 5, 2, 2, 5, 2, 75, 1),
				(1, 1, 4, 1, 2,16, 3, 75, 1),
				(1, 1, 2, 2, 2,	9, 4, 75, 1),
				(1, 1, 1, 1, 2,16, 5, 75, 1);