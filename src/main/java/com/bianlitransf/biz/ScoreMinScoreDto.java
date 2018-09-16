package com.bianlitransf.biz;

import java.io.Serializable;
import java.math.BigDecimal;

public class ScoreMinScoreDto implements Serializable {

	private static final long serialVersionUID = 4363320643516962909L;

	private String name;
	private Integer userCount;
	private Integer memberCount;
	private BigDecimal minScore;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	public BigDecimal getMinScore() {
		return minScore;
	}

	public void setMinScore(BigDecimal minScore) {
		this.minScore = minScore;
	}

}
