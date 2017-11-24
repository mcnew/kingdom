CREATE DATABASE spring;

CREATE USER 'spring'@'%' IDENTIFIED WITH mysql_native_password BY 'spring';
GRANT ALL ON spring.* TO 'spring'@'%';
