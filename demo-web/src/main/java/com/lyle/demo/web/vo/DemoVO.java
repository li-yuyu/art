package com.lyle.demo.web.vo;

import org.springframework.beans.BeanUtils;

import com.lyle.demo.web.entity.DemoDO;

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
