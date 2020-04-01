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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/demo")
@Api(tags = "示例模块")
public class DemoController {

	@Autowired
	DemoService demoService;

	@GetMapping("/get")
	@ResponseBody
	public ResponseResult<DemoVO> get() {
		return ResponseResult.success(demoService.get1());
	}

	@PostMapping("/post")
	@ApiOperation(value = "post测试")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "姓名", required = true, example = "liyuyu"), })
	public ResponseResult<PageResult<DemoVO>> post(@RequestBody @Valid DemoDTO dto, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return ResponseResult.error(ErrorCodeEnum.ILLEGAL_PARAM.getCode(),
					validResult.getFieldError().getDefaultMessage());
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
