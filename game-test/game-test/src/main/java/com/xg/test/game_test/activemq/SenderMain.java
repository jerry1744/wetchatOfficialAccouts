package com.xg.test.game_test.activemq;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xg.test.game_test.activemq.bean.NoticeBean;
import com.xg.test.game_test.activemq.sender.ActivemqSender;
import com.xg.test.game_test.log.MyLoggerFactory;

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
		for (int i = 0; i < 100000; i++) {
			long now = System.currentTimeMillis();
			String messageContent = "this_is_a_message_for_test_and_no_is_" + i + "sender_time_is \t" + now;
			sender.senderNoticeBeanMsg(createBean(i, messageContent));
			if (now - start >= 10000) {
				break;
			}
			if (i % 2 == 0) {
				Thread.sleep(1);
			}
			index++;
		}
		MyLoggerFactory.commonLog.info("index is " + index);
	}

	private static NoticeBean createBean(int index, String messageContent) {
		NoticeBean bean = new NoticeBean();
		bean.setContent(messageContent);
		bean.setId(index);
		bean.setIndex(index);
		bean.setType(10);
		return bean;
	}
}
