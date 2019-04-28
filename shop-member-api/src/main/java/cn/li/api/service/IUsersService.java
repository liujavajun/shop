package cn.li.api.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.li.common.api.ShopResult;
import cn.li.entity.User;

@RequestMapping("/member")
public interface IUsersService {
	
	@PostMapping("/regist")
	public ShopResult regist(@RequestBody User user);
	
}
