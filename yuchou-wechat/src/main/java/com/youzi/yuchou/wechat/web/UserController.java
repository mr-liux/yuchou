package com.youzi.yuchou.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.youzi.yuchou.module.model.model.TbUser;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageSearchForm;
import com.youzi.yuchou.module.mvc.web.BaseController;
import com.youzi.yuchou.wechat.service.UserService;

@RestController
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public RestResponse<String> add(@RequestBody TbUser user) {
		userService.add(user);
		return buildDefaultSuccessed("新增成功");
	}

	@DeleteMapping("/user/{id}")
	public RestResponse<String> delete(@PathVariable Integer id) {
		userService.delete(id);
		return buildDefaultSuccessed("删除成功");
	}

	@PutMapping("/user")
	public RestResponse<String> update(@RequestBody TbUser user) {
		userService.update(user);
		return buildDefaultSuccessed("修改成功");
	}

	@GetMapping("/user/{id}")
	public RestResponse<TbUser> findById(@PathVariable Integer id) {
		TbUser user = userService.findById(id);
		return buildSuccessed(user);
	}

	@GetMapping("/user")
	public RestResponse<PageInfo<TbUser>> findById(PageSearchForm searchForm) {
		PageInfo<TbUser> page = userService.findAll(searchForm);
		return buildSuccessed(page);
	}

}
