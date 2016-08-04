package com.xg.test.game_test.activemq;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xg.test.game_test.activemq.sender.ActivemqSender;

/**
 * 发送测试端
 * 无间隔发送...发送N条测试信息
 * @auther qikai
 * @date 2016年8月2日
 */
public class SenderMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
		ActivemqSender sender = ActivemqSender.getInstance();
		int index = 0;
		long start = System.currentTimeMillis();
		;
		for (int i = 0; i < 100000; i++) {
			long now = System.currentTimeMillis();
			sender.senderMsg("this_is_a_message_for_test_and_no_is_" + i + "sender_time_is \t" + now);
			if (now - start >= 1000) {
				break;
			}
			Thread.sleep(1);
			index++;
		}
		System.out.println(index);
	}

}
