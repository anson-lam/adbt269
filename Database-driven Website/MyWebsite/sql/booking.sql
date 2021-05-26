DROP TABLE `Booking`;

CREATE TABLE `Booking` (
  `Username` varchar(50) NOT NULL,
  `From` varchar(50) NOT NULL,
  `To` varchar(50) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*DELETE FROM Booking WHERE `FROM`="";*/
