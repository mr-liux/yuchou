package com.youzi.yuchou.module.mvc.form;

import lombok.Data;

@Data
public class PageSearchForm {

	/**
	 * 分页页码
	 */
	private int pageNum = 1;

	/**
	 * 分页大小
	 */
	private int pageSize = 20;

}
