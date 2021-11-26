
-- 创建基础数据结果表
CREATE TABLE `wbt_number_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num1` int(11) NOT NULL COMMENT '万',
  `num2` int(11) NOT NULL COMMENT '千',
  `num3` int(11) NOT NULL COMMENT '百',
  `num4` int(11) NOT NULL COMMENT '十',
  `num5` int(11) NOT NULL COMMENT '个',
  `record_key` varchar(100) NOT NULL COMMENT '记录key，唯一值',
  `ys_num` int(11) DEFAULT NULL COMMENT '求余结果，求余失败为空',
  PRIMARY KEY (`id`),
  KEY `wbt_number_record_record_key_IDX` (`record_key`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


