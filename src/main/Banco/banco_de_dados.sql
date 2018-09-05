CREATE DATABASE SDSA;
USE SDSA;

CREATE TABLE Cursos(
	id             int primary key not null,
    nome           varchar(100),
    qtd_semestre   int
);

CREATE TABLE Turmas(
    id             int primary key not null,
    nome           varchar(10),
    qtd_alunos     int,
    divisao        int,
    periodo        int,
    semestre       int,
    id_curso       int,
    foreign key (id_curso) references Cursos (id)
);

CREATE TABLE Disciplinas(
	id             int primary key not null,
    nome           varchar(100),
    carga_hora     int,
    id_turma       int,
	foreign key (id_turma) references Turmas (id)
); 

CREATE TABLE Colaboradores(
	id             int primary key not null,
    nome           varchar(100),
    disciplina_le  varchar(100),
    carga_hora     int,
    restante       int,
    tipo           varchar(100),
    login          int,
    senha          varchar(20),
    foto           int,
    id_disciplina  int,
	foreign key (id_disciplina) references Disciplinas (id)
);

CREATE TABLE Coordenadores(
	id             int primary key not null,
    nome           varchar(100),
    login          int,
    senha          varchar(20)
); 

CREATE TABLE Aulas(
	id             int primary key not null,
    id_cursos      int,
    id_turmas      int,
    id_disciplina int,
    id_colaborador int,
    id_coordenador  int,
	foreign key (id_cursos)      references Cursos (id),
    foreign key (id_turmas)      references Turmas (id),
    foreign key (id_disciplina)  references Disciplinas (id),
    foreign key (id_colaborador) references Colaboradores (id),
    foreign key (id_coordenador) references Coordenadores (id)
); 

CREATE TABLE Salas(
	id             int primary key not null,
    numero         int,
    id_aula        int,
    foreign key (id_aula) references Aulas (id)
); 

CREATE TABLE Carga_horaria_restante(
	id             int primary key not null,
    tempo          int,
    id_disciplina  int,
    id_turma       int,
    foreign key (id_disciplina) references Disciplinas (id),
    foreign key (id_turma) references Turmas (id)
);