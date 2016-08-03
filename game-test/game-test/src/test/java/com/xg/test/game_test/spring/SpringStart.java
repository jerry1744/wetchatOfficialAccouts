package com.xg.test.game_test.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @auther qikai
 * @date 2016年8月2日
 */
public class SpringStart {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
		System.out.println(SpringContextContainer.getApplicationContext());
		classPathXmlApplicationContext.close();
	}
}
