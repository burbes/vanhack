CREATE DATABASE `vanhack`
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_unicode_ci;

create user 'vanhack'@'%' identified by 'vanhack';

grant all privileges on vanhack.* to 'vanhack'@'%' with grant option;

use vanhack;

INSERT INTO `cousine` (`id`, `name`) VALUES ('1', 'Chinese'), ('2', 'Pizza'), ('3', 'Vietnamese'), ('4', 'Sushi');

INSERT INTO `store` (`id`, `address`, `name`, `cousine_id`) VALUES ('1', 'Av santo amaro ', 'Store 1', '1'), ('2', 'Rua Calixto Fauaz', 'Store 2', '2'), ('3', 'Rua Leontina Antonia Pereira', 'Store 3', '3'), ('4', 'Av Faria Lima', 'Store 4', '4');

INSERT INTO `customer` (`id`, `email`, `name`, `address`, `date_creation`, `password`) VALUES ('1', 'burbes@gmail.com', 'Naelson', 'Av Santo Amaro 653', '2018-03-17', '1234');

INSERT INTO `product` (`id`, `store_id`, `name`, `description`, `price`) VALUES ('1', '1', 'Sushi', 'Comida Japonesa', '1000'), ('2', '1', 'Sashimi', 'Comida Japonesa', '1200'), ('3', '2', 'Kibe', 'Comida Arabe', '2000'), ('4', '2', 'Homus', 'Comida Arabe', '2400'), ('5', '3', 'Macarrao', 'Comida italiana', '3000'), ('6', '3', 'Pizza', 'Comida Italiana', '3500');
