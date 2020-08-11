CREATE DATABASE IF NOT EXISTS assign;

ALTER DATABASE assign
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;


GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';

ALTER USER root@'%' IDENTIFIED WITH mysql_native_password BY 'rlagkswh3';

use assign;