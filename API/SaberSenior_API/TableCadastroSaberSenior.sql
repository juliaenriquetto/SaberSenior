CREATE TABLE CadastroSaberSenior (
	id  int IDENTITY (1, 1) NOT NULL,
	idFraseSecreta varchar(25) not null,
	nome varchar(35) not null, 
	telefone int not null
	PRIMARY KEY CLUSTERED ([id] ASC)
);

insert into CadastroSaberSenior (idFraseSecreta, nome, telefone) values ('minha filha laura', 'Maria da Paes', '123456789')
insert into CadastroSaberSenior (idFraseSecreta, nome, telefone) values ('jaiminho gato',   'Aparecida Maria',   '993456789')

SELECT * FROM CadastroSaberSenior