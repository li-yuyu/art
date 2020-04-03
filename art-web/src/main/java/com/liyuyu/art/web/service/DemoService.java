package com.liyuyu.art.web.service;

import com.liyuyu.art.web.dto.DemoDTO;
import com.liyuyu.art.web.page.PageResult;
import com.liyuyu.art.web.vo.DemoVO;

public interface DemoService {

	DemoVO get1();
	
	PageResult<DemoVO> listByPage(DemoDTO dto);
}
