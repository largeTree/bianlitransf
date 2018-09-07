INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
VALUES (1,1,'/blh/imgs/yinhang/gongshang.png','工商银行',1,0,'2018-08-29 22:30:43',0,'2018-08-30 22:52:34','这是工商银行');
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
VALUES (2,1,'/blh/imgs/yinhang/zhongguo.png','中国银行',2,1,'2018-08-22 00:00:00',1,'2018-08-30 22:52:37','');
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
VALUES (3,1,'/blh/imgs/yinhang/nongye.png','农业银行',3,0,'2018-08-29 22:15:37',0,'2018-08-30 22:52:39','13sfsdfsdfsd');
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
VALUES (4,1,'/blh/imgs/yinhang/jianshe.png','建设银行',5,0,'2018-08-30 22:46:34',0,'2018-08-30 22:46:34','这是招商银行');
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
VALUES (5,1,'/blh/imgs/yinhang/guangda.png','光大银行',7,0,'2018-08-30 22:47:02',0,'2018-08-30 22:50:44','这是温州银行');
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
VALUES (6,1,'/blh/imgs/yinhang/jiaotong.png','交通银行',8,0,'2018-08-30 22:51:43',0,'2018-08-30 22:52:10','这是农商银行');
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
SELECT MAX(id) + 1,1,'/blh/imgs/yinhang/pufa.png','浦发银行',MAX(disorder)+1,0,NOW(),0,NOW(),'这是浦发银行' FROM score_exchange;
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
SELECT MAX(id) + 1,1,'/blh/imgs/yinhang/pingan.png','平安银行',MAX(disorder)+1,0,NOW(),0,NOW(),'这是平安银行' FROM score_exchange;
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
SELECT MAX(id) + 1,1,'/blh/imgs/yinhang/zhongxin.png','中信银行',MAX(disorder)+1,0,NOW(),0,NOW(),'这是中信银行' FROM score_exchange;
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
SELECT MAX(id) + 1,1,'/blh/imgs/yinhang/huaxia.png','华夏银行',MAX(disorder)+1,0,NOW(),0,NOW(),'这是华夏银行' FROM score_exchange;
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
SELECT MAX(id) + 1,1,'/blh/imgs/yinhang/beijing.png','北京银行',MAX(disorder)+1,0,NOW(),0,NOW(),'这是北京银行' FROM score_exchange;
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
SELECT MAX(id) + 1,1,'/blh/imgs/yinhang/youchu.png','邮政储蓄',MAX(disorder)+1,0,NOW(),0,NOW(),'这是邮政储蓄银行' FROM score_exchange;
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
SELECT MAX(id) + 1,1,'/blh/imgs/yinhang/minsheng.png','民生银行',MAX(disorder)+1,0,NOW(),0,NOW(),'这是民生银行' FROM score_exchange;
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
SELECT MAX(id) + 1,1,'/blh/imgs/yinhang/xgla.png','香格里拉白金',MAX(disorder)+1,0,NOW(),0,NOW(),'这是香格里拉白金卡' FROM score_exchange;
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
SELECT MAX(id) + 1,1,'/blh/imgs/yinhang/difang.png','30+地方银行',MAX(disorder)+1,0,NOW(),0,NOW(),'这是地方银行' FROM score_exchange;
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
SELECT MAX(id) + 1,1,'/blh/imgs/yinhang/xingye.png','兴业银行',MAX(disorder)+1,0,NOW(),0,NOW(),'这是兴业银行' FROM score_exchange;
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
SELECT MAX(id) + 1,1,'/blh/imgs/yinhang/zhada.png','渣打银行',MAX(disorder)+1,0,NOW(),0,NOW(),'这是渣打银行' FROM score_exchange;
INSERT  INTO `score_exchange`(`id`,`type`,`icon_url`,`name`,`disorder`,`created_by`,`created_time`,`updated_by`,`updated_time`,`mark1`) 
SELECT MAX(id) + 1,1,'/blh/imgs/yinhang/huifeng.png','汇丰银行',MAX(disorder)+1,0,NOW(),0,NOW(),'这是汇丰银行' FROM score_exchange;