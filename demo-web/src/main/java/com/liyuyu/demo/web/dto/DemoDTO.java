package com.liyuyu.demo.web.dto;

import javax.validation.constraints.NotBlank;

import com.liyuyu.demo.web.page.Page;

import lombok.Data;

@Data
public class DemoDTO {
	
	@NotBlank(message = "name can not be null")
	String name;
	
	Page page;
	
}
