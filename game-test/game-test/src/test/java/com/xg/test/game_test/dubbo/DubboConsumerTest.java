package com.xg.test.game_test.dubbo;

import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xg.game.common.dubbo.bean.User;
import com.xg.test.game_test.dubbo.consumer.DemoUserConsumer;
import com.xg.test.game_test.spring.SpringContextContainer;

/**
 *
 * @auther qikai
 * @date 2016年8月15日
 */
public class DubboConsumerTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");

			DemoUserConsumer bean = SpringContextContainer.getBean(DemoUserConsumer.class);
			long start = System.currentTimeMillis();
			String sayHello = bean.sayHello();
			List<User> userList = bean.getUserList();
			long end = System.currentTimeMillis();
			System.out.println("两个方法耗时: " + (end - start));
			System.out.println(sayHello);
			for (User user : userList) {
				System.out.println(user.getId() + user.getName());
			}
			InputStreamReader reader = new InputStreamReader(System.in);
			int read = reader.read();
			System.out.println(read);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != context){
				context.close();
			}
		}
	}

}
