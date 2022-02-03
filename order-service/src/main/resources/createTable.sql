CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderSerial` varchar(100) DEFAULT NULL,
  `orderOwner` varchar(100) DEFAULT NULL,
  `orderAmount` decimal(10,2) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

