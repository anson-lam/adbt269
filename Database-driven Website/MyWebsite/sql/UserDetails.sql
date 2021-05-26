DROP TABLE `UserDetails`;

CREATE TABLE `UserDetails` (
    `Username` varchar(50) NOT NULL,
    `FirstName` varchar(50) NOT NULL,
    `LastName` varchar(50) NOT NULL,
    `Email` varchar(50) NOT NULL,
    `Mobile` varchar(11) NOT NULL,
    `Password` varchar(200) NOT NULL,
    `Confirm Password` varchar(200) NOT NULL,

  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


