create table accounts
(
	id UUID not null primary key,
	username varchar(80) not null,
	email varchar(120) not null,
	role_id int default 0
);