CREATE TABLE `person` (
  `id`      INT(11)     NOT NULL AUTO_INCREMENT,
  `name`    VARCHAR(10) NOT NULL,
  `age`     INT(11)     NOT NULL,
  `country` VARCHAR(10)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;