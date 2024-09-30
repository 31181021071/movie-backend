CREATE DATABASE projectmovie
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE TABLE `m_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pwd` varchar(500) NOT NULL,
  `role` varchar(100) NOT NULL,
  `is_enable` bit(1) NOT NULL,
  `valid_flag` bit(1) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `m_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `m_codes` (
  `code_type` varchar(10) NOT NULL,
  `code_type_name` varchar(150) NOT NULL,
  `code` varchar(10) NOT NULL,
  `code_name` varchar(45) NOT NULL,
  `valid_flag` bit(1) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `create_by` varchar(200) DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `update_by` varchar(200) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`code_type`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `m_movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(100) NOT NULL,
  `country` varchar(10) DEFAULT NULL,
  `release_year` varchar(10) DEFAULT NULL,
  `genre` varchar(10) DEFAULT NULL,
  `description` longtext DEFAULT NULL,
  `image` blob,
  `rating` decimal(1,1) DEFAULT NULL,
  `is_show` bit(1) DEFAULT b'1',
  `valid_flag` bit(1) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','1','United States','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','10','Russia','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','11','Vietnam','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','12','South Korea','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','13','Italy','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','14','Spain','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','15','Mexico','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','2','Canada','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','3','United Kingdom','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','4','Australia','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','5','Germany','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','6','France','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','7','Japan','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','8','China','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);
INSERT INTO `m_codes` (`code_type`,`code_type_name`,`code`,`code_name`,`is_show`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES ('000001','country','9','India','1','1','2024-08-29 13:46:03','admin','2024-08-29 13:46:03','admin',1);

INSERT INTO `m_user` (`user_id`,`name`,`email`,`pwd`,`role`,`is_enable`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES (1,'Administrator','happy@example.com','$2a$12$x2fLA21B4QWphy9D8OWO1.Ny7X9wjDI30eXhTMSx2dOXTbrjtQNQK','admin','1','1','2024-08-26 00:00:00','admin','2024-08-29 08:59:27','happy@example.com',1);
INSERT INTO `m_user` (`user_id`,`name`,`email`,`pwd`,`role`,`is_enable`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES (2,'tanya266@gmail.com','tanya266@gmail.com','$2a$10$rjwRoUhplz2DYWapy4kzHuGElDZWUP9DNex3TFAISKYxixRNqtHwC','user','1','1',NULL,NULL,NULL,NULL,1);
INSERT INTO `m_user` (`user_id`,`name`,`email`,`pwd`,`role`,`is_enable`,`valid_flag`,`create_dt`,`create_by`,`update_dt`,`update_by`,`version`) VALUES (3,'tranhaiquan26@gmail.com','tranhaiquan26@gmail.com','$2a$10$Q4DI1EUafO2wwbDYixc5CuqGOgGJ1o17vR9AMtAQNueE7WjdFk1OC','user','1','1','2024-08-28 09:29:05','admin','2024-08-29 13:04:47','tranhaiquan26@gmail.com',1);

INSERT INTO `authorities` (`id`,`user_id`,`name`) VALUES (1,1,'ROLE_USER');
INSERT INTO `authorities` (`id`,`user_id`,`name`) VALUES (2,1,'ROLE_ADMIN');
INSERT INTO `authorities` (`id`,`user_id`,`name`) VALUES (3,2,'ROLE_USER');
INSERT INTO `authorities` (`id`,`user_id`,`name`) VALUES (4,3,'ROLE_USER');