package com.youzi.yuchou.admin.web;

import com.youzi.yuchou.module.redis.config.RedisKey;
import com.youzi.yuchou.module.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.youzi.yuchou.admin.service.UserService;
import com.youzi.yuchou.module.model.model.TbUser;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageSearchForm;
import com.youzi.yuchou.module.mvc.web.BaseController;

@RestController
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private RedisService redisService;

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

	@GetMapping("/setRedis")
	public void setRedis(){
		try {
			redisService.put(RedisKey.TEST_AAAA, "aaaaaa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/getRedis")
	public void getRedis(){
		logger.info(redisService.findByKey(RedisKey.TEST_AAAA).toString());
	}

}
