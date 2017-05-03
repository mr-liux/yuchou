package com.youzi.yuchou.admin.web.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.youzi.yuchou.admin.service.common.BankService;
import com.youzi.yuchou.module.model.condition.CommonKeyWordCondition;
import com.youzi.yuchou.module.model.model.Bank;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;
import com.youzi.yuchou.module.mvc.web.BaseController;

@RestController
public class BankController extends BaseController {

	@Autowired
	BankService bankService;
	
	@PostMapping("/bank")
	public RestResponse<String> add(@RequestBody Bank bank){
		bankService.add(bank);
		return buildDefaultSuccessed("新增成功");
	}
	
	@DeleteMapping("/bank/{id}")
	public RestResponse<String> delete(@PathVariable Integer id) {
		bankService.delete(id);
		return buildDefaultSuccessed("删除成功");
	}

	@PutMapping("/bank")
	public RestResponse<String> update(@RequestBody Bank bank) {
		bankService.update(bank);
		return buildDefaultSuccessed("修改成功");
	}

	@GetMapping("/bank/{id}/{name}")
	public RestResponse<Object> findById(@PathVariable Integer id,@PathVariable String name) {
		RestResponse<Object> page = bankService.findById(id);
		return page;
	}
	/**
	 * 分页查询 银行卡字典
	 * @author 背包
	 * @param pageInfo
	 * @param condition
	 * @return
	 * @throws Exception
	 * 
	 */
	@PostMapping("/banklist")
	public RestResponse<Object> findAll(@RequestBody PageInfo pageInfo, @RequestBody CommonKeyWordCondition condition) {
		RestResponse<Object> page = bankService.findPage(pageInfo ,null);
		return page;
	}
	
/*	@GetMapping("/banklist")
	public RestResponse<Object> findAll() throws Exception{
		RestResponse<Object> page = bankService.findPage(null ,null);
		return page;
	}*/
}
