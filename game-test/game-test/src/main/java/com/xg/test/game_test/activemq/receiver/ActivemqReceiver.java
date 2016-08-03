package com.xg.test.game_test.activemq.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;

import com.xg.test.game_test.log.MyLoggerFactory;

/**
 * 消费者端 
 * 使用spring继承 直接 实现MessageListener即可
 * @auther qikai
 * @date 2016年8月2日
 */
public class ActivemqReceiver implements MessageListener {
	private final Logger errorlog = MyLoggerFactory.errorlog;

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				long now = System.currentTimeMillis();
				TextMessage textMessage = (TextMessage) message;
				errorlog.info("接收到消息:" + textMessage.getText() + "\t" + "当前时间为:" + "\t"  + now);
			} catch (JMSException e) {
				errorlog.error("", e);
			}
		} else {
			errorlog.error("error message : " + message);
		}
	}
}
