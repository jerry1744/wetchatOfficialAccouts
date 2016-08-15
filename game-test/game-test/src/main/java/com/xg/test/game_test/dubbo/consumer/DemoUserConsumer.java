package com.xg.test.game_test.dubbo.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.xg.game.common.dubbo.bean.User;
import com.xg.game.common.dubbo.service.DemoUserService;

/**
 *
 * @auther qikai
 * @date 2016年8月15日
 */
@Component
public class DemoUserConsumer {

	@Autowired
	@Qualifier("demoUserService")
	private DemoUserService demoUserSerivce;

	public String sayHello() {
		return demoUserSerivce.sayHello("DemoUserConsumer");
	}

	public List<User> getUserList() {
		return demoUserSerivce.getUsers();
	}
}
