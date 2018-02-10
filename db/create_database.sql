DROP USER 'online_education'@'localhost';
CREATE USER 'online_education'@'localhost' IDENTIFIED BY 'online_education';
grant all privileges on `online_education`.* to 'online_education'@'localhost' identified by 'online_education';
SET PASSWORD FOR 'online_education'@'localhost' = PASSWORD('online_education');