package com.liyuyu.demo.web.vo;

import org.springframework.beans.BeanUtils;

import com.liyuyu.demo.web.entity.DemoDO;

import lombok.Data;

@Data
public class DemoVO {

	String name;
	
	public static DemoVO fromDO(DemoDO demoDO) {
		DemoVO demoVO = new DemoVO();
		BeanUtils.copyProperties(demoDO, demoVO);
		return demoVO;
	}
}
