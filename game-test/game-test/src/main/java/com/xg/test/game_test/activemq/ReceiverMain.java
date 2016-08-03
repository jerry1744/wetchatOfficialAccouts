package com.xg.test.game_test.activemq;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 接受测试端
 * 直接启动spring容器即可实现监听
 * @auther qikai
 * @date 2016年8月2日
 */
public class ReceiverMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
	}
}
