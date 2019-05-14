drop DATABASE IF EXISTS `synonym_challenge`;
CREATE DATABASE IF NOT EXISTS `synonym_challenge`;
use `synonym_challenge`;

CREATE table player (
  player_id int primary key AUTO_INCREMENT not null,
  first_name varchar(20) not null,
  last_name varchar(20) not null,
  email_id varchar(40) not null,
  user_id varchar(20) not null,
  user_password varchar(255) not null
);

CREATE table dictionary (
  word_id int primary key AUTO_INCREMENT not null,
  word varchar(50) not null,
  synonym_1 varchar(50) not null,
  synonym_2 varchar(50) not null,
  synonym_3 varchar(50) not null
);

CREATE table game (
  game_id int primary key AUTO_INCREMENT not null,
  word_id int not null,
  player_id int not null,
  response_1 varchar(50),
  response_2 varchar(50),
  response_3 varchar(50),
  score int not null,
  FOREIGN KEY (word_id) references dictionary(word_id),
  FOREIGN KEY (player_id) references player(player_id)
  );
  
  
  






