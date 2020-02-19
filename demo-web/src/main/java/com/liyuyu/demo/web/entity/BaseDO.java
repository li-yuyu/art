package com.liyuyu.demo.web.entity;

import java.util.Date;

/**
 * @Description:
 * @author Lyle
 * @date 2019-06-13
 */
public class BaseDO {

	private Long id;
	
    private Date createTime;

    private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
}
