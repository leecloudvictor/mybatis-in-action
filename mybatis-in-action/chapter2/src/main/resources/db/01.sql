CREATE SCHEMA `mybatis-test` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `mybatis-test`.`t_role` (
  `id` INT NOT NULL,
  `role_name` VARCHAR(45) NULL,
  `note` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));