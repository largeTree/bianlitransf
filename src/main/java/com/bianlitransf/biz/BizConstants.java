package com.bianlitransf.biz;

public class BizConstants {

	/** 业务类型：积分兑换 */
	public static final int BIZ_TYPE_SCORE_TRANSF = 1;
	/** 业务类型：提现 */
	public static final int BIZ_TYPE_CASHIN = 2;
	/** 业务类型：提现确认 */
	public static final int BIZ_TYPE_CASHIN_CONFIRM = 3;
	/** 业务类型：分润 */
	public static final int BIZ_TYPE_SHARE_PROFIT = 4;

	/** 状态：无效 */
	public static final int STATUS_INVALID = 0;
	/** 状态：有效 */
	public static final int STATUS_VALID = 1;

	/** 用户等级：超级管理 */
	public static final int LEVEL_SA = -1;
	/** 用户等级：管理员 */
	public static final int LEVEL_ADMIN = 0;
	/** 用户等级：普通用户 */
	public static final int LEVEL_USER = 1;
	/** 用户等级：会员 */
	public static final int LEVEL_MEMBER = 2;
	/** 用户等级：代理商 */
	public static final int LEVEL_AGENT = 3;

	/** 积分兑换 */
	public static final int RES_TYPE_CAT_SCORE_TRANSF = 1;
	/** 信用卡推广 */
	public static final int RES_TYPE_CAT_CREDIT_CARD_SPR = 2;

	/** 银行积分 */
	public static final int RES_TYPE_BANK_SCORE = 101;
	/** 电信积分兑换 */
	public static final int RES_TYPE_TEL_SCORE = 102;
	/** 信用卡推广链接 */
	public static final int RES_TYPE_CREDIT_CARD_SPR = 201;
}
