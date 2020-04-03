package com.liyuyu.art.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DemoDO extends BaseDO{

	String name;
	
	Integer age;
}
