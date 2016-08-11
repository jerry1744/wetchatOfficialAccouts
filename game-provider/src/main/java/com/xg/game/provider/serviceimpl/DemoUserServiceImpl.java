package com.xg.game.provider.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.xg.game.common.dubbo.bean.User;
import com.xg.game.common.dubbo.service.DemoUserService;
import com.xg.game.provider.gen.IdGenerator;

/**
 *
 * @auther qikai
 * @date 2016年8月12日
 */
public class DemoUserServiceImpl implements DemoUserService {

	public List<User> getUsers() {
		return generUsers();
	}

	public String sayHello(String name) {
		return "Hello " + name + "! Welcome to invokeme !";
	}

	private List<User> generUsers() {
		int size = 1 + new Random().nextInt(5);
		List<User> lists = new ArrayList<User>(size);
		for (int i = 0; i < size; i++) {
			User user = new User();
			user.setId(IdGenerator.getInstance().getNewUserID());
			user.setName("username" + user.getId());
			lists.add(user);
		}
		return lists;
	}
}
