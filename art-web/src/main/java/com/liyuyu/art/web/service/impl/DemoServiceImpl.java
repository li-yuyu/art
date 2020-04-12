package com.liyuyu.art.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liyuyu.art.web.dao.DemoMapper;
import com.liyuyu.art.web.dto.DemoDTO;
import com.liyuyu.art.web.entity.DemoDO;
import com.liyuyu.art.web.page.Page;
import com.liyuyu.art.web.page.PageResult;
import com.liyuyu.art.web.service.DemoService;
import com.liyuyu.art.web.vo.DemoVO;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	DemoMapper demoMapper;

	@Override
	public DemoVO get1() {
		DemoDO select1 = demoMapper.select1();
		return DemoVO.fromDO(select1);
	}

	@Override
	public PageResult<DemoVO> listByPage(DemoDTO dto) {
		Page page = dto.getPage() == null ? new Page() : dto.getPage();
		Integer toltal = demoMapper.countAll();
		List<DemoDO> doList = demoMapper.selectAllByPage(page);
		List<DemoVO> voList = doList.stream().map(DemoVO :: fromDO).collect(Collectors.toList());
		return page.toPageResult(toltal, voList);
	}

}
