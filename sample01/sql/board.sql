CREATE TABLE `board` (
  `bno` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `views` int(11) DEFAULT '0',
  `cre_dt` datetime NOT NULL,
  `pwd` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`bno`)
) 