package com.liyuyu.demo.web.service;

import com.liyuyu.demo.web.dto.DemoDTO;
import com.liyuyu.demo.web.page.PageResult;
import com.liyuyu.demo.web.vo.DemoVO;

public interface DemoService {

	DemoVO get1();
	
	PageResult<DemoVO> listByPage(DemoDTO dto);
}
