CREATE DATABASE SDSA;
USE SDSA;

CREATE TABLE Cursos(
	id             int primary key not null AUTO_INCREMENT,
    nome           varchar(100),
    qtd_semestre   int
);

CREATE TABLE Turmas(
    id             int primary key not null AUTO_INCREMENT,
    nome           varchar(10),
    qtd_alunos     int,
    divisao        int,
    periodo        int,
    semestre       int,
    id_curso       int,
    foreign key (id_curso) references Cursos (id)
);

CREATE TABLE Disciplinas(
	id             int primary key not null AUTO_INCREMENT,
    nome           varchar(100),
    carga_hora     int,
	semestre       int,
	id_curso       int,
	foreign key (id_curso) references Cursos (id)
);

CREATE TABLE Colaboradores(
	id             int primary key not null AUTO_INCREMENT,
    nome           varchar(100),
    carga_hora     int,
    restante       int,
    tipo           int,
    foto           varchar(100)
);

CREATE TABLE CD(
	id             int primary key not null AUTO_INCREMENT,
	id_colaborador int,
	id_disciplina  int,
	foreign key (id_colaborador) references Colaboradores(id),
	foreign key (id_disciplina)	 references Disciplinas(id)
);

CREATE TABLE Coordenadores(
	id             int primary key not null AUTO_INCREMENT,
    nome           varchar(100),
    login          varchar(11),
    senha          varchar(20)
); 


CREATE TABLE Salas(
	numero         int primary key not null,
	descricao      varchar(100)
); 

CREATE TABLE Aulas(
	id             int primary key not null AUTO_INCREMENT,
    id_cursos      int,
    id_turmas      int,
    id_disciplina int,
    id_colaborador int,
    id_coordenador  int,
    id_sala int,
	foreign key (id_cursos)      references Cursos (id),
    foreign key (id_turmas)      references Turmas (id),
    foreign key (id_disciplina)  references Disciplinas (id),
    foreign key (id_colaborador) references Colaboradores (id),
    foreign key (id_coordenador) references Coordenadores (id),
    foreign key (id_sala) 		 references Salas (numero)
); 



CREATE TABLE Carga_horaria_restante(
	id             int primary key not null AUTO_INCREMENT,
    tempo          int,
    id_disciplina  int,
    id_turma       int,
    foreign key (id_disciplina) references Disciplinas (id),
    foreign key (id_turma) references Turmas (id)
);

INSERT INTO Cursos(nome, qtd_semestre)
		VALUES	("Técnico em informática", 4),
				("Redes", 2),
				("Almoxarifado", 2),
				("Curso com 3", 3),
				("Curso com 1", 1),
				("Curso com 5", 5),
				("Curso com 20", 20);

INSERT INTO Turmas(nome, qtd_alunos, divisao, periodo, semestre, id_curso)
		VALUES	("1TI", 32, 1, 1, 1, 1),
				("2TI", 32, 1, 1, 2, 1),
				("1Rede", 16, 2, 3, 1, 2);
				
INSERT INTO Disciplinas(nome, carga_hora, semestre, id_curso)
		VALUES	("C++", 75, 1, 1),
				("Português", 60, 2, 1);
				

INSERT INTO Coordenadores (nome,login,senha)
		VALUES	("Tarciso", 28011999, "123");
		
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
