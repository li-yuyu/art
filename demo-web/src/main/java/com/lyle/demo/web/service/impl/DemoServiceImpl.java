package com.lyle.demo.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyle.demo.web.dao.DemoMapper;
import com.lyle.demo.web.dto.DemoDTO;
import com.lyle.demo.web.entity.DemoDO;
import com.lyle.demo.web.page.Page;
import com.lyle.demo.web.page.PageResult;
import com.lyle.demo.web.service.DemoService;
import com.lyle.demo.web.vo.DemoVO;

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
