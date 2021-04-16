package com.lyle.demo.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lyle.demo.web.entity.DemoDO;
import com.lyle.demo.web.page.Page;

@Mapper
public interface DemoMapper {

	DemoDO select1();
	
	Integer countAll();
	
	List<DemoDO> selectAllByPage(Page page);
}
