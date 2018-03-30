CREATE TABLE `user` (
  `id` varchar(100) NOT NULL COMMENT '用户id',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(20) NOT NULL DEFAULT '' COMMENT '性别',
  `address` varchar(100) DEFAULT '' COMMENT '地址',
  `tel` int(11) DEFAULT NULL COMMENT '电话',
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '用户权限',
  `is_delete` int(11) NOT NULL DEFAULT '0' COMMENT '删除状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
