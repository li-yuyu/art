package com.lyle.demo.web.dto;

import javax.validation.constraints.NotBlank;

import com.lyle.demo.web.page.Page;

import lombok.Data;

@Data
public class DemoDTO {
	
	@NotBlank(message = "name can not be null")
	String name;
	
	Page page;
	
}
