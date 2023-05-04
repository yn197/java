#            Mysql生成百万测试数据

```mysql
DROP TABLE IF EXISTS `users`;
CREATE TABLE users  (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  name varchar(222) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  age int(11) NULL DEFAULT NULL COMMENT '年龄',
  addr varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '地址',
  create_date datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP PROCEDURE IF EXISTS pro_users ;
CREATE PROCEDURE pro_users()
BEGIN
    DECLARE count int  DEFAULT 0 ; -- 计数
	DECLARE max int ; -- 插入数据条数
	SET max = 1000000 ;
	
	-- 开始执行循环
	WHILE count < max  DO
		INSERT INTO `users` ( `name`, `age`, `addr`, `create_date` )
		VALUES	(CONCAT('小明',(LAST_INSERT_ID()+1)), 18, CONCAT('北京市',(LAST_INSERT_ID()+1)), NOW() );			
    	SET count = count + 1; 
	END WHILE;
	
END ;

call pro_users();

```

