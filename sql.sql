CREATE TABLE IF NOT EXISTS `elofy`.`people` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `height` DECIMAL(3,2) NOT NULL,
  `lactose` TINYINT NOT NULL,
  `weight` DECIMAL(5,2) NOT NULL,
  `athlete` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (name)
);

INSERT INTO people (name, height, lactose, weight, athlete) VALUES ("Joao", 1.5, 0, 80, 1);
INSERT INTO people (name, height, lactose, weight, athlete) VALUES ("Ricardo", 1.75, 0, 120.4, 1);
INSERT INTO people (name, height, lactose, weight, athlete) VALUES ("Paulo", 1.8, 0, 70, 0);
INSERT INTO people (name, height, lactose, weight, athlete) VALUES ("Márcio", 1.86, 0, 76.4, 1);
INSERT INTO people (name, height, lactose, weight, athlete) VALUES ("Agatha", 1.54, 0, 62.5, 0);
INSERT INTO people (name, height, lactose, weight, athlete) VALUES ("Stefany", 1.7, 0, 60.9, 0);
INSERT INTO people (name, height, lactose, weight, athlete) VALUES ("Nair", 1.72, 1, 97.2, 1);
INSERT INTO people (name, height, lactose, weight, athlete) VALUES ("Giovana", 1.67, 1, 80.5, 0);
