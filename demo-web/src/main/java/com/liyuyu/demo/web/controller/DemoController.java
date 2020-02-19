package com.liyuyu.demo.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.liyuyu.demo.web.dto.DemoDTO;
import com.liyuyu.demo.web.enums.ErrorCodeEnum;
import com.liyuyu.demo.web.page.PageResult;
import com.liyuyu.demo.web.result.ResponseResult;
import com.liyuyu.demo.web.service.DemoService;
import com.liyuyu.demo.web.vo.DemoVO;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	DemoService demoService;

	@GetMapping("/get")
	@ResponseBody
	public ResponseResult<DemoVO> get() {
		return ResponseResult.success(demoService.get1());
	}

	@PostMapping("/post")
	public ResponseResult<PageResult<DemoVO>> post(@RequestBody @Valid DemoDTO dto, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return ResponseResult.error(ErrorCodeEnum.ILLEGAL_PARAM.getCode(), validResult.getFieldError().getDefaultMessage());
		}
		PageResult<DemoVO> result = demoService.listByPage(dto);
		return ResponseResult.success(result);
	}
	
	@GetMapping("/exception")
	public ResponseResult<String> exception() {
		Integer.parseInt("abc");
		return ResponseResult.success();
	}
}
