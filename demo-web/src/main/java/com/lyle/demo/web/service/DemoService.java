package com.lyle.demo.web.service;

import com.lyle.demo.web.dto.DemoDTO;
import com.lyle.demo.web.page.PageResult;
import com.lyle.demo.web.vo.DemoVO;

public interface DemoService {

	DemoVO get1();
	
	PageResult<DemoVO> listByPage(DemoDTO dto);
}
