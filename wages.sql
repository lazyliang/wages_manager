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

CREATE TABLE `wages` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT 'id',
  `num` int(11) DEFAULT NULL COMMENT '员工编号',
  `year` varchar(50) DEFAULT '' COMMENT '年份',
  `month` varchar(50) DEFAULT '' COMMENT '月份',
  `base_wages` int(11) DEFAULT '0' COMMENT '基本工资',
  `addtion` int(11) DEFAULT '0' COMMENT '津贴',
  `overtime` int(11) DEFAULT '0' COMMENT '加班工资',
  `sum` int(11) DEFAULT '0' COMMENT '总工资',
  `user_id` varchar(50) NOT NULL,
  `ycqts` int(11) DEFAULT '0' COMMENT '出勤天数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into user (id, name, age, sex, address, tel)VALUES ('test','lazyliang','20','男','武汉市','114')
