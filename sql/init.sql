-- 用户表
CREATE TABLE `user`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY,
	`phone` VARCHAR(11) NOT NULL COMMENT'手机号',
	`password` VARCHAR(32) NOT NULL COMMENT'密码',
	`referee_id` BIGINT(20) NOT NULL COMMENT'推荐人ID',
	`level` TINYINT(3) NOT NULL COMMENT'等级',
	`level_code` VARCHAR(1024) NOT NULL COMMENT'等级编码',
	`status` TINYINT(3) NOT NULL COMMENT'状态',
	`name` VARCHAR(12) NOT NULL COMMENT'用户姓名',
	`alipay_no` VARCHAR(32) NOT NULL COMMENT'支付宝账号',
	`created_time` DATETIME NOT NULL COMMENT'创建时间'
);
CREATE INDEX `idx_user_referee_id` ON `user`(`referee_id`);

-- 兑换单
CREATE TABLE `exchange_bill`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY,
	`owner_id` BIGINT(20) NOT NULL COMMENT'所有者',
	`status` TINYINT(3) NOT NULL COMMENT'状态',
	`bank_id` INT(11) NOT NULL COMMENT'银行ID',
	`score` INT(11) NOT NULL COMMENT'兑换积分',
	`money` DECIMAL(16,3) NOT NULL COMMENT'兑换金',
	`created_time` DATETIME NOT NULL COMMENT'创建时间',
	`confirm_time` DATETIME NOT NULL COMMENT'确认时间',
	`confirmer_id` BIGINT(20) NOT NULL COMMENT'确认操作人',
	`desc` VARCHAR(512) NOT NULL COMMENT'描述'
);
CREATE INDEX `idx_exchange_bill_owner_id_status` ON `exchange_bill`(`owner_id`,`status`);

-- 资金流水
CREATE TABLE `capital_flow`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY,
	`src_bill` BIGINT(20) NOT NULL COMMENT'来源单据',
	`owner_id` BIGINT(20) NOT NULL COMMENT'所有者',
	`status` TINYINT(3) NOT NULL COMMENT'状态',
	`biz_type` TINYINT(3) NOT NULL COMMENT'业务类型',
	`in_out_type` TINYINT(3) NOT NULL COMMENT'收支类型',
	`money` DECIMAL(16,3) NOT NULL COMMENT'金额',
	`created_time` DATETIME NOT NULL COMMENT'创建人',
	`confirm_time` DATETIME NOT NULL COMMENT'确认时间',
	`confirmer_id` BIGINT(20) NOT NULL COMMENT'确认操作人',
	`desc` VARCHAR(512) NOT NULL COMMENT'描述'
);
CREATE INDEX `idx_capital_flow_owner_id_status` ON `capital_flow`(`owner_id`,`status`);

-- 积分兑换
CREATE TABLE `score_exchange`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY COMMENT'',
	`type` TINYINT(4) NOT NULL COMMENT'积分兑换类型',
	`icon_url` VARCHAR(1024) NOT NULL COMMENT'图标地址',
	`name` VARCHAR(64) NOT NULL COMMENT'名称',
	`disorder` Integer NOT NULL COMMENT'排序',
	`mark1` VARCHAR(512) COMMENT'描述',
	`created_by` BIGINT(20) NOT NULL COMMENT'创建人',
	`created_time` DATETIME NOT NULL COMMENT'创建时间',
	`updated_by` BIGINT(20) NOT NULL COMMENT'更新人',
	`updated_time` DATETIME NOT NULL COMMENT'更新时间'
);

-- 积分兑换类目
CREATE TABLE `score_exchange_class`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY,
	`score_exid` BIGINT(20) NOT NULL COMMENT'积分兑换ID',
	`name` VARCHAR(64) NOT NULL COMMENT'名称',
	`icon_url` VARCHAR(1024) COMMENT'图标地址',
	`res_type` TINYINT(3) NOT NULL COMMENT'资源类型，链接或html内容',
	`target` TEXT COMMENT'具体内容，链接或具体html内容',
	`created_by` BIGINT(20) NOT NULL COMMENT'创建人',
	`created_time` DATETIME NOT NULL COMMENT'创建时间',
	`updated_by` BIGINT(20) NOT NULL COMMENT'更新人',
	`updated_time` DATETIME NOT NULL COMMENT'更新时间'
);

-- 积分兑换类目明细
CREATE TABLE `score_exchange_detail`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY,
	`class_id` BIGINT(20) NOT NULL COMMENT'积分兑换类目ID',
	`score` INT(11) NOT NULL COMMENT'所需积分数量',
	`name` VARCHAR(64) NOT NULL COMMENT'兑换券名称',
	`price1` DECIMAL(16,3) NOT NULL COMMENT'普通会员价格',
	`price2` DECIMAL(16,3) NOT NULL  COMMENT'贵宾会员价格',
	`created_by` BIGINT( 0) NOT NULL COMMENT'创建人',
	`created_time` DATETIME NOT NULL COMMENT'创建时间',
	`updated_by` BIGINT(20) NOT NULL COMMENT'更新人',
	`updated_time` DATETIME NOT NULL COMMENT'更新时间'
);
CREATE INDEX `idx_score_exchange_detail_class_id` ON score_exchange_detail(`class_id`);