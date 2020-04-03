package com.liyuyu.art.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.liyuyu.art.web.entity.DemoDO;
import com.liyuyu.art.web.page.Page;

@Mapper
public interface DemoMapper {

	DemoDO select1();
	
	Integer countAll();
	
	List<DemoDO> selectAllByPage(Page page);
}
