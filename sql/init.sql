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

-- 会话持久化
CREATE TABLE `session_rec`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY,
	`session_id` VARCHAR(64) NOT NULL COMMENT'sessionId',
	`user_id` BIGINT(20) NOT NULL COMMENT'用户ID',
	`session_bean` TEXT NOT NULL COMMENT'会话对象json',
	`login_time` DATETIME NOT NULL COMMENT'登陆时间'
);
CREATE INDEX `idx_session_red_sessionId` ON `session_rec`(`session_id`);

-- 兑换单
CREATE TABLE `exchange_bill`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY,
	`owner_id` BIGINT(20) NOT NULL COMMENT'所有者',
	`status` TINYINT(3) NOT NULL COMMENT'状态',
	`exg_det_id` BIGINT(20) NOT NULL COMMENT'兑换券ID',
	`exg_det_name` VARCHAR(64) NOT NULL COMMENT'兑换券名称',
	`score` INT(11) NOT NULL COMMENT'兑换积分',
	`money` DECIMAL(16,3) NOT NULL COMMENT'兑换金',
	`created_time` DATETIME NOT NULL COMMENT'创建时间',
	`confirm_time` DATETIME NOT NULL COMMENT'确认时间',
	`confirmer_id` BIGINT(20) NOT NULL COMMENT'确认操作人',
	`desc` VARCHAR(512) NOT NULL COMMENT'描述'
);
CREATE INDEX `idx_exchange_bill_owner_id_status` ON `exchange_bill`(`owner_id`,`status`);
-- 兑换码
ALTER TABLE `exchange_bill` ADD COLUMN `voucher_code` VARCHAR(64) NOT NULL COMMENT'兑换码';
CREATE UNIQUE INDEX `UK_exchange_bill_exgDetId_voucherCode` ON `exchange_bill`(`exg_det_id`,`voucher_code`);

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
ALTER TABLE `capital_flow` ADD COLUMN `acct_id` BIGINT(20) NOT NULL COMMENT'账户ID';
ALTER TABLE `capital_flow` ADD COLUMN `sub_acct` INT(11) NOT NULL COMMENT'子账户';
ALTER TABLE `capital_flow` ADD COLUMN `bal_money` DECIMAL(16,3) NOT NULL COMMENT'余额',
	ADD COLUMN `blk_money` DECIMAL(16,3) NOT NULL COMMENT'锁定余额',
	ADD COLUMN `cashin_money` DECIMAL(16,3) NOT NULL COMMENT'已提现金额';
ALTER TABLE `capital_flow` ADD COLUMN `type` TINYINT(3) NOT NULL COMMENT'流水类型';
ALTER TABLE `capital_flow` ADD COLUMN `revoke_flag` TINYINT(3) NOT NULL COMMENT'撤销标记';

-- 资金账户
CREATE TABLE `capital_acct`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY COMMENT'资金账户',
	`owner_id` BIGINT(20) NOT NULL COMMENT'所有者',
	`bal_money` DECIMAL(16,2) NOT NULL COMMENT'账户余额',
	`blk_money` DECIMAL(16,3) NOT NULL COMMENT'已被锁定余额',
	`cashin_money` DECIMAL(16,3) NOT NULL COMMENT'已提现金额',
	`created_by` BIGINT(20) NOT NULL COMMENT'创建人',
	`created_time` DATETIME NOT NULL COMMENT'创建时间',
	`updated_by` BIGINT(20) NOT NULL COMMENT'更新人',
	`updated_time` DATETIME NOT NULL COMMENT'更新时间'
);
CREATE UNIQUE INDEX `UK_capital_acct_ownerId` ON `capital_acct`(`owner_id`);


-- 积分兑换
CREATE TABLE `score_exchange`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY COMMENT'',
	`type` TINYINT(4) NOT NULL COMMENT'积分兑换类型',
	`icon_url` VARCHAR(1024) NOT NULL COMMENT'图标地址',
	`name` VARCHAR(64) NOT NULL COMMENT'名称',
	`disorder` INTEGER NOT NULL COMMENT'排序',
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

ALTER TABLE `score_exchange_class` MODIFY `target` LONGTEXT COMMENT'具体内容，链接或具体html内容';

-- 积分兑换类目明细
CREATE TABLE `score_exchange_detail`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY,
	`class_id` BIGINT(20) NOT NULL COMMENT'积分兑换类目ID',
	`score` INT(11) NOT NULL COMMENT'所需积分数量',
	`name` VARCHAR(64) NOT NULL COMMENT'兑换券名称',
	`count` VARCHAR(32) NOT NULL COMMENT'兑换次数',
	`price1` DECIMAL(16,3) NOT NULL COMMENT'普通会员价格',
	`price2` DECIMAL(16,3) NOT NULL  COMMENT'贵宾会员价格',
	`created_by` BIGINT( 0) NOT NULL COMMENT'创建人',
	`created_time` DATETIME NOT NULL COMMENT'创建时间',
	`updated_by` BIGINT(20) NOT NULL COMMENT'更新人',
	`updated_time` DATETIME NOT NULL COMMENT'更新时间'
);
CREATE INDEX `idx_score_exchange_detail_class_id` ON score_exchange_detail(`class_id`);

-- 提现申请单
CREATE TABLE `cashin_bill`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY,
	`owner_id` BIGINT(20) NOT NULL COMMENT'所有者',
	`money` DECIMAL(16,3) NOT NULL COMMENT'金额',
	`status` TINYINT(3) NOT NULL COMMENT'状态',
	`desc` VARCHAR(512) NOT NULL COMMENT'备注',
	`created_time` DATETIME NOT NULL COMMENT'创建时间',
	`confirmer_id` BIGINT(20) NOT NULL COMMENT'审核人',
	`confirm_time` DATETIME NOT NULL COMMENT'审核时间'
);
CREATE INDEX `idx_cashin_bill_ownerId` ON `cashin_bill`(`owner_id`);

-- 信用卡推广链接
CREATE TABLE `credit_card`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY,
	`icon_url` VARCHAR(128) NOT NULL COMMENT'图标',
	`name` VARCHAR(32) NOT NULL COMMENT'银行名',
	`target_url` VARCHAR(1024) NOT NULL COMMENT'目标地址'
);

-- 附件表
CREATE TABLE `attachment`(
	`id` BIGINT(20) PRIMARY KEY,
	`path` VARCHAR(256) NOT NULL COMMENT'存储路径',
	`name` VARCHAR(64) NOT NULL COMMENT'文件名',
	`created_by` BIGINT( 0) NOT NULL COMMENT'创建人',
	`created_time` DATETIME NOT NULL COMMENT'创建时间'
)COMMENT'附件表';

-- 首页滚动图
CREATE TABLE `home_slider` (
	`id` BIGINT(20) PRIMARY KEY,
	`doc_id` BIGINT(20) NOT NULL COMMENT'图片ID',
	`target` LONGTEXT COMMENT'具体内容',
	`rem` VARCHAR(256) NOT NULL COMMENT'备注',
	`created_by` BIGINT( 0) NOT NULL COMMENT'创建人',
	`created_time` DATETIME NOT NULL COMMENT'创建时间'
)COMMENT'首页滚动图';
ALTER TABLE `home_slider` ADD COLUMN `title` VARCHAR(16) NOT NULL COMMENT'页面标题';