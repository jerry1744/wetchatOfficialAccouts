package com.xg.game.common.dubbo.service;

import java.util.List;

import com.xg.game.common.dubbo.bean.User;

/**
 *
 * @auther qikai
 * @date 2016年8月12日
 */
public interface DemoUserService {

	public String sayHello(String name);

	public List<User> getUsers();
}
