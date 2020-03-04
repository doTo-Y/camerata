create table user
(
	id int auto_increment,
	name varchar(50),
	githubId long,
	bio varchar(100),
  githubLogin varchar(50),
	token varchar(255),
constraint user_pk
primary key (id)
);