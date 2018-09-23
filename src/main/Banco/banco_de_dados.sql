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
    id_turma       int,
	foreign key (id_turma) references Turmas (id)
); 

CREATE TABLE Colaboradores(
	id             int primary key not null AUTO_INCREMENT,
    nome           varchar(100),
    disciplina_le  varchar(100),
    carga_hora     int,
    restante       int,
    tipo           varchar(100),
    foto           int,
    id_disciplina  int,
	foreign key (id_disciplina) references Disciplinas (id)
);

CREATE TABLE Coordenadores(
	id             int primary key not null AUTO_INCREMENT,
    nome           varchar(100),
    login          int,
    senha          varchar(20)
); 

CREATE TABLE Salas(
	id             int primary key not null AUTO_INCREMENT,
    numero         int
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
    foreign key (id_sala) 		 references Salas (id)
); 



CREATE TABLE Carga_horaria_restante(
	id             int primary key not null AUTO_INCREMENT,
    tempo          int,
    id_disciplina  int,
    id_turma       int,
    foreign key (id_disciplina) references Disciplinas (id),
    foreign key (id_turma) references Turmas (id)
);

INSERT INTO Coordenadores (nome,login,senha)
		VALUES ("Tarciso", 28011999, "123");
