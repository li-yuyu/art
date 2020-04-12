package com.liyuyu.art.web.dto;

import javax.validation.constraints.NotBlank;

import com.liyuyu.art.web.page.Page;

import lombok.Data;

@Data
public class DemoDTO {
	
	@NotBlank(message = "name can not be null")
	String name;
	
	Page page;
	
}
