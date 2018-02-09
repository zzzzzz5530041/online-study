DROP USER 'online_education'@'localhost';
CREATE USER 'online_education'@'localhost' IDENTIFIED BY 'online_education';
GRANT INSERT,DELETE,UPDATE,SELECT ON online_education.* TO 'online_education'@'localhost' WITH GRANT OPTION;
SET PASSWORD FOR 'online_education'@'localhost' = PASSWORD('online_education');