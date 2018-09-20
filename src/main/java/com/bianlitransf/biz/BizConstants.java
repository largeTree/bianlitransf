package com.bianlitransf.biz;

import com.qiuxs.cuteframework.core.basic.code.provider.ICodeTranslatable;

public class BizConstants {

	public static final int TRUE = 1;
	public static final int FALSE = 0;
	
	/** 单据状态：拒绝 */
	public static final int BILL_STATUS_REFUSED = -1;
	/** 单据状态：已创建 */
	public static final int BILL_STATUS_CREATED = 0;
	/** 单据状态：已确认 */
	public static final int BILL_STATUS_CONFRIMED = 1;
	
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
	public static final int RES_TYPE_BANK_SCORE = 1;
	/** 电信积分兑换 */
	public static final int RES_TYPE_TEL_SCORE = 2;
	/** 信用卡推广链接 */
	public static final int RES_TYPE_CREDIT_CARD_SPR = 3;
	
	public static final ICodeTranslatable<Integer> RES_TYPE_TRANSTALER = new ICodeTranslatable<Integer>() {
		@Override
		public String getCaption(Integer code) {
			if (code == null) {
				return "";
			}
			int val = code.intValue();
			String caption = null;
			switch (val) {
			case BizConstants.RES_TYPE_BANK_SCORE:
				caption = "银行积分";
				break;
			case BizConstants.RES_TYPE_TEL_SCORE:
				caption = "电信积分";
				break;
			case BizConstants.RES_TYPE_CREDIT_CARD_SPR:
				caption = "信用卡推广链接";
				break;
			default:
				caption = "";
				break;
			}
			return caption;
		}
	};
	
	public static final ICodeTranslatable<Integer> LEVEL_TRANSTALER = new ICodeTranslatable<Integer>() {
		@Override
		public String getCaption(Integer code) {
			if (code == null) {
				return "";
			}
			int val = code.intValue();
			String caption = null;
			switch (val) {
			case BizConstants.LEVEL_SA:
				caption = "超管";
				break;
			case BizConstants.LEVEL_ADMIN:
				caption = "管理员";
				break;
			case BizConstants.LEVEL_USER:
				caption = "用户";
				break;
			case BizConstants.LEVEL_MEMBER:
				caption = "会员";
				break;
			default:
				caption = "";
				break;
			}
			return caption;
		}
	};
	
	public static final ICodeTranslatable<Integer> STATUS_TRANSTLATER = new ICodeTranslatable<Integer>() {
		@Override
		public String getCaption(Integer code) {
			if (code == null) {
				return "";
			}
			int val = code.intValue();
			String caption = null;
			switch (val) {
			case BizConstants.STATUS_INVALID:
				caption = "无效";
				break;
			case BizConstants.STATUS_VALID:
				caption = "有效";
				break;
			default:
				caption = "";
				break;
			}
			return caption;
		}
	};
	
	public static final ICodeTranslatable<Integer> BILL_STATUS_TRANSTLATER = new ICodeTranslatable<Integer>() {
		@Override
		public String getCaption(Integer code) {
			if (code == null) {
				return "";
			}
			int val = code.intValue();
			String caption = null;
			switch (val) {
			case BizConstants.BILL_STATUS_CREATED:
				caption = "已创建";
				break;
			case BizConstants.BILL_STATUS_CONFRIMED:
				caption = "已通过";
				break;
			case BizConstants.BILL_STATUS_REFUSED:
				caption = "已拒绝";
				break;
			default:
				caption = "";
				break;
			}
			return caption;
		}
	};
}
