INSERT  INTO `credit_card`(`id`,`icon_url`,`name`,`target_url`) VALUES 
(1,'/blh/imgs/yinhang/gongshang.png','工商银行','http://m.icbc.com.cn/ICBC/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%BD%91%E4%B8%8A%E5%8A%9E%E5%8D%A1/bk.htm');

INSERT INTO `credit_card`(`id`,`icon_url`,`name`,`target_url`)
SELECT MAX(id) + 1,'/blh/imgs/yinhang/zhongguo.png','中国银行','https://apply.mcard.boc.cn/apply/mobile/product/familyProductList/family' FROM `credit_card`;

INSERT INTO `credit_card`(`id`,`icon_url`,`name`,`target_url`)
SELECT MAX(id) + 1,'/blh/imgs/yinhang/nongye.png','农业银行','http://www.abchina.com/cn/CreditCard/' FROM `credit_card`;

INSERT INTO `credit_card`(`id`,`icon_url`,`name`,`target_url`)
SELECT MAX(id) + 1,'/blh/imgs/yinhang/jianshe.png','建设银行','http://www.ccb.com/cn/creditcard/mobilev3/index.html' FROM `credit_card`;

INSERT INTO `credit_card`(`id`,`icon_url`,`name`,`target_url`)
SELECT MAX(id) + 1,'/blh/imgs/yinhang/guangda.png','光大银行银行','https://xyk.cebbank.com/cebmms/apply/ps/card-list.htm' FROM `credit_card`;

INSERT INTO `credit_card`(`id`,`icon_url`,`name`,`target_url`)
SELECT MAX(id) + 1,'/blh/imgs/yinhang/zhongxin.png','中信银行','https://creditcard.ecitic.com/h5/shenqing/index.html#/home/popularity' FROM `credit_card`;

INSERT INTO `credit_card`(`id`,`icon_url`,`name`,`target_url`)
SELECT MAX(id) + 1,'/blh/imgs/yinhang/huaxia.png','华夏银行','https://creditapply.hxb.com.cn/sanfang/cardChoice.html' FROM `credit_card`;

INSERT INTO `credit_card`(`id`,`icon_url`,`name`,`target_url`)
SELECT MAX(id) + 1,'/blh/imgs/yinhang/minsheng.png','民生银行','https://creditcard.cmbc.com.cn/wsv2/' FROM `credit_card`;

INSERT INTO `credit_card`(`id`,`icon_url`,`name`,`target_url`)
SELECT MAX(id) + 1,'/blh/imgs/yinhang/xingye.png','兴业银行','https://ccshop.cib.com.cn:8010/application/cardapp/newfast/ApplyCard/toSelectCard?id=78da895d41794731a0357071fc3bc74e' FROM `credit_card`;
