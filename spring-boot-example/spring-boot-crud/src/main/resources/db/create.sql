CREATE TABLE if not exists  user (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(32) NOT NULL,
  age tinyint(4) DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  update_time datetime DEFAULT NULL,
  PRIMARY KEY (id)
);