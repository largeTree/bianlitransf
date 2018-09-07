-- 工行积分
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) VALUES (1,1,10000,'1万','不限次数',10.100,11.500,0,'2018-08-31 21:41:11',0,'2018-08-31 21:41:16');
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) VALUES (2,1,20000,'2万','不限次数',21.800,23.000,0,'2018-08-31 21:43:55',0,'2018-08-31 21:43:55');
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) VALUES (3,1,30000,'3万','不限次数',32.700,34.500,0,'2018-08-31 21:43:55',0,'2018-08-31 21:43:55');
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) VALUES (4,1,50000,'5万','不限次数',54.600,57.500,0,'2018-08-31 21:43:55',0,'2018-08-31 21:43:55');
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) VALUES (5,1,100000,'10万','不限次数',109.200,115.000,0,'2018-08-31 21:43:55',0,'2018-08-31 21:43:55');
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) VALUES (6,1,150000,'15万','不限次数',163.800,172.500,0,'2018-09-07 22:13:33',0,'2018-09-07 22:13:37');
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) VALUES (7,1,200000,'20万','不限次数',218.500,230.000,0,'2018-09-07 22:14:40',0,'2018-09-07 22:14:43');

-- 建设银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,2,5250,'10元沃尔玛','不限次数',7.4,7.8,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,2,10500,'20元沃尔玛','不限次数',14.7,15.5,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,2,15750,'30元沃尔玛','不限次数',22.1,23.3,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,2,26250,'50元沃尔玛','不限次数',7.4,38.8,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,2,52500,'100元沃尔玛','不限次数',7.4,77.5,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,2,10500,'200元沃尔玛','不限次数',7.4,155,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 中国银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,3,5000,'10京东钢蹦','2次/月',7.4,8.8,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,3,15000,'30京东钢蹦','2次/月',7.4,26.3,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,3,25000,'50京东钢蹦','2次/月',7.4,43.8,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,3,45000,'100京东钢蹦','2次/月',7.4,78.8,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,3,90000,'200京东钢蹦','2次/月',7.4,157.5,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 光大银行 
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,4,57000,'50元电子E卡','不限次数',7.4,41.6,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,4,115000,'100元电子E卡','不限次数',7.4,83.2,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 交通银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,5,21000,'中杯星巴克','不限次数',7.4,20,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 浦发银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,6,55200,'50元必胜客','10张/天',7.4,28.7,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,7,31800,'天皇堡/天椒皇堡套餐','10张/天',7.4,16.5,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 平安银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,8,10000,'20元沃尔玛','不限次数',7.4,17,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,8,25000,'50元沃尔玛','不限次数',7.4,42.5,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,8,50000,'100元沃尔玛','不限次数',7.4,85,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,8,100000,'200元沃尔玛','不限次数',7.4,170,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,8,150000,'300元沃尔玛','不限次数',7.4,255,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,8,250000,'500元沃尔玛','不限次数',7.4,425,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,8,500000,'1000元沃尔玛','不限次数',7.4,850,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 中信银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,9,85000,'小米充电宝','不限次数',7.4,51,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 华夏银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,10,80700,'50元苏宁卡','不限次数',7.4,42.45,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 北京银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,11,6000,'10元京东钢镚','6笔/月',7.4,8.5,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,11,18000,'30元京东钢镚','6笔/月',7.4,25.5,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,11,30000,'50元京东钢镚','6笔/月',7.4,42.5,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 农业银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,12,334800,'电子阅读器1个','不限次数',7.4,267.84,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 邮储银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,13,20000,'20元肯德基','不限次数',7.4,11.2,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,13,50000,'50元肯德基','每天限兑5张',7.4,28,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 民生银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,14,24400,'优酷月卡','1次/月',7.4,4.88,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,14,28000,'爱奇艺月卡','1次/月',7.4,5.6,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,14,32000,'腾讯月卡','1次/月',7.4,6.4,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 香格里拉
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,15,1000,'1千分','不限次数',7.4,140,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 地方银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,16,4000,'10元沃尔玛券','不限次数',7.4,7.8,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,16,8000,'20元沃尔玛券','不限次数',7.4,15.6,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,16,20000,'50元沃尔玛券','不限次数',7.4,39,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,16,40000,'100元沃尔玛券','不限次数',7.4,78,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,16,80000,'200元沃尔玛券','不限次数',7.4,156,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 兴业银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,17,552000,'电子阅读器1个','不限次数',7.4,267.17,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 渣打银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,18,117000,'100元京东E卡','不限次数',7.4,87.80,0,NOW(),0,NOW() FROM `score_exchange_detail`;

-- 汇丰银行
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,19,25000,'50元京东E卡','不限次数',7.4,43.50,0,NOW(),0,NOW() FROM `score_exchange_detail`;
INSERT  INTO `score_exchange_detail`(`id`,`class_id`,`score`,`name`,`count`,`price1`,`price2`,`created_by`,`created_time`,`updated_by`,`updated_time`) 
SELECT  MAX(id) + 1,19,50000,'100元京东E卡','不限次数',7.4,87.70,0,NOW(),0,NOW() FROM `score_exchange_detail`;

UPDATE score_exchange_detail SET price1 = ROUND(price2 * 0.95,2)